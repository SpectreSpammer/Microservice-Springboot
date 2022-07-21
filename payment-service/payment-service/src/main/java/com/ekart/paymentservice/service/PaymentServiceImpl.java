package com.ekart.paymentservice.service;

import com.ekart.paymentservice.dto.PaymentDTO;
import com.ekart.paymentservice.entity.Payment;
import com.ekart.paymentservice.exception.PaymentException;
import com.ekart.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentRepository paymentRepository;


    @Override
    public List<PaymentDTO> getAllPayment() {
        List<PaymentDTO> paymentDTOList = paymentRepository.findAll().stream().map(PaymentDTO::new).collect(Collectors.toList());
        return paymentDTOList;
    }

    @Override
    public PaymentDTO getPaymentById(Integer paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new PaymentException("Payment Id " + paymentId + " not found"));
        return new PaymentDTO(payment);
    }

    @Override
    public PaymentDTO addPayment(PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.save(new Payment(paymentDTO));
        return new PaymentDTO(payment);
    }

    @Override
    public PaymentDTO updatePaymentById(Payment payment) {
        Payment payment1 = paymentRepository.save(payment);
        return new PaymentDTO(payment1);
    }

    @Override
    public void deleteById(Integer paymentId) {
        paymentRepository.deleteById(paymentId);
    }

}

