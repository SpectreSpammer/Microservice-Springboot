package com.ekart.productservice.service;

import com.ekart.productservice.dto.ProductDTO;
import com.ekart.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();
    ProductDTO addProduct(ProductDTO product);

    ProductDTO getProductById(Integer productId);

    ProductDTO updateProductById(Product product);

    void deleteById(Integer productId);
}
