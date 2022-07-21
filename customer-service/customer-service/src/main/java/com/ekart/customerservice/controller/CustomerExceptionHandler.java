package com.ekart.customerservice.controller;


import com.ekart.customerservice.entity.CustomerErrorResponse;
import com.ekart.customerservice.exception.CustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> productException(CustomerException customerException){
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();
        customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customerErrorResponse.setMessage((customerException.getMessage()));
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> productException(Exception e){
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();
        customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customerErrorResponse.setMessage((e.getMessage()));
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
