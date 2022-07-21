package com.ekart.productservice.controller;


import com.ekart.productservice.entity.ProductErrorResponse;
import com.ekart.productservice.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> productException(ProductException productExceptionMessage){
        ProductErrorResponse prodException = new ProductErrorResponse();
        prodException.setStatus(HttpStatus.NOT_FOUND.value());
        prodException.setMessage(productExceptionMessage.getMessage());
        prodException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(prodException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> productException(Exception e){
        ProductErrorResponse prodException = new ProductErrorResponse();
        prodException.setStatus(HttpStatus.BAD_REQUEST.value());
        prodException.setMessage((e.getMessage()));
        prodException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(prodException, HttpStatus.BAD_REQUEST);
    }
}
