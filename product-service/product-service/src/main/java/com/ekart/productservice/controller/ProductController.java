package com.ekart.productservice.controller;


import com.ekart.productservice.dto.ProductDTO;
import com.ekart.productservice.entity.Product;
import com.ekart.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ekart")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct(){
        List<ProductDTO> productList =  productService.getAllProducts();
        return new ResponseEntity<>(productList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer prodId){
        ProductDTO productList =  productService.getProductById(prodId);
        return new ResponseEntity<>(productList,HttpStatus.OK);

    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createdCustomer(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult ){

        return new ResponseEntity<>(productService.addProduct(productDTO), HttpStatus.CREATED);
        /*
//        Map<String,String> errorMap = validatorService.validate(bindingResult);
//        if(errorMap.isEmpty()){
//            return new ResponseEntity<>(customerService.saveCustomer(customerDTO), HttpStatus.CREATED);
//        }else{
//            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        */
    }

    @DeleteMapping("/product/{prodId}")
    public void deleteById(@PathVariable Integer prodId){
        productService.deleteById(prodId);
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product){
        ProductDTO prod = productService.updateProductById(product);

        return new ResponseEntity<>(prod,HttpStatus.CREATED);
    }


}
