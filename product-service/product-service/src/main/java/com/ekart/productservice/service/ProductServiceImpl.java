package com.ekart.productservice.service;


import com.ekart.productservice.dto.ProductDTO;
import com.ekart.productservice.entity.Product;
import com.ekart.productservice.exception.CartAndProductException;
import com.ekart.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    /*
    https://www.youtube.com/watch?v=w9c4vz-QprI
    CRUD with annotation code decode
     */
    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
        return productDTOList;
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        //       List <Product> prod = (List<Product>) productRepository.save(new Product(productDTO));
        Product prod = productRepository.save(new Product(productDTO));
       /*
       if(prod.size() >= 10){
          new ProductException("You reach the maximum orders");
       }
       */
        return new ProductDTO(prod);
    }

    @Override
    public ProductDTO getProductById(Integer productId) {
        Product product =  productRepository.findById(productId).orElseThrow(() -> new CartAndProductException("Product Id " +  productId + " not found"));
        return  new ProductDTO(product);
        /*
        if(productId >= productList.size() || productId < 0){
            throw new ProductException("Product id not found : " + productId);
        }
        return productList.get(productId);
        */
    }

    @Override
    public ProductDTO updateProductById(Product product) {
        Product updateProd = productRepository.save(product);

        return new ProductDTO(updateProd);
    }

    @Override
    public void deleteById(Integer productId) {
        productRepository.deleteById(productId);

    }

}
