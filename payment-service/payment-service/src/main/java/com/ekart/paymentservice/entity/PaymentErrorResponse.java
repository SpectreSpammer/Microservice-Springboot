package com.ekart.paymentservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentErrorResponse {

    private Integer status;
    private String message;
    private Long timeStamp;
}
