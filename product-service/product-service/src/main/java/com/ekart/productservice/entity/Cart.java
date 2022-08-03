package com.ekart.productservice.entity;


import com.ekart.productservice.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ekart_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    private Integer price;
    private Integer quantity;
    private String category;
    /*
    https://www.youtube.com/watch?v=ZkCokUMqy9c
    OneToMany mapping
     */
    @OneToMany(
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "prod_id")
    private List<Product> productList;

    public Cart(CartDTO cartDTO){

        this.price = cartDTO.getPrice();
        this.quantity = cartDTO.getQuantity();
        this.category = cartDTO.getCategory();
        this.productList = cartDTO.getProductList();


    }

}
