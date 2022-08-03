package com.ekart.productservice.controller;


import com.ekart.productservice.entity.CartAndProductErrorResponse;
import com.ekart.productservice.exception.CartAndProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CartAndProductErrorResponse> productException(CartAndProductException cartAndProductExceptionMessage){
        CartAndProductErrorResponse prodException = new CartAndProductErrorResponse();
        prodException.setStatus(HttpStatus.NOT_FOUND.value());
        prodException.setMessage(cartAndProductExceptionMessage.getMessage());
        prodException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(prodException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CartAndProductErrorResponse> productException(Exception e){
        CartAndProductErrorResponse prodException = new CartAndProductErrorResponse();
        prodException.setStatus(HttpStatus.BAD_REQUEST.value());
        prodException.setMessage((e.getMessage()));
        prodException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(prodException, HttpStatus.BAD_REQUEST);
    }
}
