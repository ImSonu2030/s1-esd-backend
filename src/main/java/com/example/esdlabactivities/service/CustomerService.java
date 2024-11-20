package com.example.esdlabactivities.service;

import com.example.esdlabactivities.dto.CustomerRequest;
import com.example.esdlabactivities.entity.Customer;
import com.example.esdlabactivities.mapper.CustomerMapper;
import com.example.esdlabactivities.repo.CustomerRepo;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request){
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Customer Created Sucessfully";
    }
}
