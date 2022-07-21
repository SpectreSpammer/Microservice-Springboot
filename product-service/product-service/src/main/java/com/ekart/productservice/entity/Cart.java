package com.ekart.productservice.entity;


import com.ekart.productservice.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ekart_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private String productName;
    private Double price;
    private Integer quantity;

    private String category;


    public Cart(CartDTO cartDTO){
        this.cartId = cartDTO.getCartId();
        this.productName = cartDTO.getProductName();
        this.price = cartDTO.getPrice();
        this.quantity = cartDTO.getQuantity();
        this.category = cartDTO.getCategory();
    }
}
