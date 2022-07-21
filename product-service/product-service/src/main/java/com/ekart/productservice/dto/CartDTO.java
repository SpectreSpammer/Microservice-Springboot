package com.ekart.productservice.dto;


import com.ekart.productservice.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Integer cartId;
    private String productName;
    private Double price;
    private Integer quantity;

    private String category;

    public CartDTO(Cart cart){
        this.cartId = cart.getCartId();
        this.productName = cart.getProductName();
        this.price = cart.getPrice();
        this.quantity = cart.getQuantity();
        this.category = cart.getCategory();
    }
}
