package com.ekart.customerservice.service;

import com.ekart.customerservice.dto.CustomerDTO;
import com.ekart.customerservice.entity.Customer;
import com.ekart.customerservice.exception.CustomerException;
import com.ekart.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOList = customerRepository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
        return customerDTOList;
    }

    @Override
    public CustomerDTO addCustomers(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(new Customer(customerDTO));
        return new CustomerDTO(customer);
    }

    @Override
    public CustomerDTO getCustomerById(Integer custId) {
        Customer customer = customerRepository.findById(custId).orElseThrow(() -> new CustomerException("Customer Id : " + custId + " not found"));
        return new CustomerDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomerById(Customer customer) {
        Customer updateCust = customerRepository.save(customer);

        return new CustomerDTO(updateCust);
    }

    @Override
    public String deleteCustomerById(Integer custId) {
        customerRepository.deleteById(custId);
        return "Product Id " + custId + " has been deleted.";
    }
}
