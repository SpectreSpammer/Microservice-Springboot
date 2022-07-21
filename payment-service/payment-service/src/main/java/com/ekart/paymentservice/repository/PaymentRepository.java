package com.ekart.paymentservice.repository;


import com.ekart.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Integer> {
}
