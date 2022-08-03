package com.ekart.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartAndProductErrorResponse {
    private Integer status;
    private String message;
    private Long timeStamp;

}
