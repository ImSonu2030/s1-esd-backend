package com.example.esdlabactivities.service;

import com.example.esdlabactivities.dto.CustomerRequest;
import com.example.esdlabactivities.dto.CustomerResponse;
import com.example.esdlabactivities.dto.LoginRequest;
import com.example.esdlabactivities.entity.Customer;
import com.example.esdlabactivities.mapper.CustomerMapper;
import com.example.esdlabactivities.repo.CustomerRepo;
import com.example.esdlabactivities.exception.CustomerNotFoundException;
import com.example.esdlabactivities.helper.JWTHelper;
import com.example.esdlabactivities.helper.RequestInterceptor;
import com.example.esdlabactivities.helper.EncryptionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class CustomerService {

    private final CustomerMapper mapper;
    private final CustomerRepo customerRepo;
    private final JWTHelper jwtHelper;
    private final EncryptionService encryptionService;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request){
        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Sucessfully";
    }

    public Customer getCustomer(String email){
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Customer with email %s not found", email)
                ));
    }

    public String login(LoginRequest request){
        Customer customer = getCustomer(request.email());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }

        return jwtHelper.generateToken(request.email());
    }

    public CustomerResponse retrieveCustomer(String email){
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }

    //Customer Update through email Service
    @Transactional
    public void updateCustomer(String email, CustomerRequest request){
        Customer customer = customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());

        customerRepo.save(customer);

    }

    //Deleting Customer Service
    public void deleteCustomer(String email){
        Customer customer = customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customerRepo.delete(customer);
    }

}
