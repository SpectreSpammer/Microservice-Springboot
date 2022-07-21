package com.ekart.productservice.entity;


import com.ekart.productservice.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ekart_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId; //if productId > 10, display product details in paginated format
    private String productName;
    private String image;
    private String description;
    private String category;
    private String brand;
    private Double price;


    public Product(ProductDTO productDTO){
        this.productId = productDTO.getProductId();
        this.productName = productDTO.getProductName();
        this.image = productDTO.getImage();
        this.description = productDTO.getDescription();
        this.category = productDTO.getCategory();
        this.brand = productDTO.getBrand();
        this.price = productDTO.getPrice();
    }
}
