package com.example.esdlabactivities.controller;

import com.example.esdlabactivities.dto.CustomerRequest;
import com.example.esdlabactivities.dto.CustomerResponse;
import com.example.esdlabactivities.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")

public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerResponse> getCustomerByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(customerService.retrieveCustomer(email));
    }

    @PutMapping("/{email}")
    public ResponseEntity<String> updateCustomer(@PathVariable("email") String email, @RequestBody @Valid CustomerRequest request){
        customerService.updateCustomer(email, request);
        return ResponseEntity.ok("Customer updated successfully");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("email") String email){
        customerService.deleteCustomer(email);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
