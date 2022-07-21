package com.ekart.customerservice.controller;


import com.ekart.customerservice.dto.CustomerDTO;
import com.ekart.customerservice.entity.Customer;
import com.ekart.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ekart")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomers(){
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();

        return  new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }

    @GetMapping("/customer/{custId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer custId){
        CustomerDTO customerById = customerService.getCustomerById(custId);
        return new ResponseEntity<>(customerById,HttpStatus.ACCEPTED);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO addCustomer = customerService.addCustomers(customerDTO);
        return new ResponseEntity<>(addCustomer,HttpStatus.CREATED);
    }

    @DeleteMapping("/customer/{custId}")
    public void deleteByid(Integer custId){
        customerService.deleteCustomerById(custId);
    }

    @PutMapping("/customer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer){
        CustomerDTO customerDTO = customerService.updateCustomerById(customer);
        return new ResponseEntity<>(customerDTO,HttpStatus.CREATED);
    }
}
