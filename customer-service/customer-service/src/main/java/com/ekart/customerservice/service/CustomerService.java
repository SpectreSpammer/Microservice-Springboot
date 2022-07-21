package com.ekart.customerservice.service;

import com.ekart.customerservice.dto.CustomerDTO;
import com.ekart.customerservice.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO addCustomers(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(Integer custId);

    CustomerDTO updateCustomerById(Customer customer);

    String deleteCustomerById(Integer custId);
}
