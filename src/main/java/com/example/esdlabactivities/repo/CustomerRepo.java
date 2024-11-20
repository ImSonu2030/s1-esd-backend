package com.example.esdlabactivities.repo;

import com.example.esdlabactivities.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
