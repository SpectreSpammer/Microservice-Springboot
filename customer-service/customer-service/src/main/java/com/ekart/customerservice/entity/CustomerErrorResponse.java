package com.ekart.customerservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerErrorResponse {

    private Integer status;
    private String message;
    private Long timeStamp;
}
