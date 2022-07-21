package com.ekart.paymentservice.service;

import com.ekart.paymentservice.dto.PaymentDTO;
import com.ekart.paymentservice.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<PaymentDTO> getAllPayment();

    PaymentDTO getPaymentById(Integer paymentId);

    PaymentDTO addPayment(PaymentDTO paymentDTO);

    PaymentDTO updatePaymentById(Payment payment);

    void deleteById(Integer paymentId);


}
