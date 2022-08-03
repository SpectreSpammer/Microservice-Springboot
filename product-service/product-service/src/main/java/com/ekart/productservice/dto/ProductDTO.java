package com.ekart.productservice.dto;


import com.ekart.productservice.entity.Cart;
import com.ekart.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer productId; //if productId > 10, display product details in paginated format
    private String productName;
    private String image;
    private String description;
    private String category;
    private String brand;
    private Double price;



    public ProductDTO(Product product){
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.brand = product.getBrand();
        this.price = product.getPrice();





    }
}
