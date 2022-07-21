package com.ekart.customerservice.repository;

import com.ekart.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Integer> {
}
