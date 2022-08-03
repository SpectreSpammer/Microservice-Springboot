package com.ekart.productservice.dto;


import com.ekart.productservice.entity.Cart;
import com.ekart.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Integer cartId;

    private Integer price;
    private Integer quantity;
    private String category;

    private Integer totalPrice;
    private List<Product> productList;

    public CartDTO(Cart cart) {
        this.cartId = cart.getCartId();
        this.price = cart.getPrice();
        this.quantity = cart.getQuantity();
        this.category = cart.getCategory();
        this.productList = cart.getProductList();

        this.totalPrice = this.getTotalPrice(this.price, this.quantity);
    }

    public Integer getTotalPrice(Integer price, Integer quantity){
        Integer result = price * quantity;
        return  result;
    }

    }

