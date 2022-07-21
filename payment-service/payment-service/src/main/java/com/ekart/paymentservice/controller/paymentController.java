package com.ekart.paymentservice.controller;


import com.ekart.paymentservice.dto.PaymentDTO;
import com.ekart.paymentservice.entity.Payment;
import com.ekart.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ekart")
public class paymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment")
    public ResponseEntity<?> getAllPayment(){
     List<PaymentDTO> paymentDTOList =  paymentService.getAllPayment();
     return new ResponseEntity<>(paymentDTOList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<?> getPaymentById(@PathVariable Integer paymentId){
        PaymentDTO paymentDTO = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(paymentDTO,HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO){
        PaymentDTO payment = paymentService.addPayment(paymentDTO);
        return new ResponseEntity<>(payment,HttpStatus.CREATED);
    }

    @PutMapping("/payment")
    public ResponseEntity<PaymentDTO> updatePayment(@RequestBody Payment payment){
        PaymentDTO paymentDTO = paymentService.updatePaymentById(payment);
        return new ResponseEntity<>(paymentDTO,HttpStatus.ACCEPTED);

    }
}
