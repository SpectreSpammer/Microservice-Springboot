package com.ekart.paymentservice.controller;


import com.ekart.paymentservice.entity.PaymentErrorResponse;
import com.ekart.paymentservice.exception.PaymentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PaymentErrorResponse> paymentException(PaymentException paymentException){
        PaymentErrorResponse paymentErrorResponse = new PaymentErrorResponse();
        paymentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        paymentErrorResponse.setMessage(paymentException.getMessage());
        paymentErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(paymentErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PaymentErrorResponse> paymentException(Exception exception){
        PaymentErrorResponse paymentErrorResponse = new PaymentErrorResponse();
        paymentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        paymentErrorResponse.setMessage(exception.getMessage());
        paymentErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(paymentErrorResponse,HttpStatus.BAD_REQUEST);
    }




}
