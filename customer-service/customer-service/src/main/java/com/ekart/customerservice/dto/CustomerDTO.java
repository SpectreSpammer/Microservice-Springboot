package com.ekart.customerservice.dto;


import com.ekart.customerservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Integer custId;

    private String fname;

    private String lname;

    private Long phoneNo;

    private String email;

    private String password;

    public CustomerDTO(Customer customer){
        this.custId = customer.getCustId();
        this.fname = customer.getFname();
        this.lname = customer.getLname();
        this.phoneNo = customer.getPhoneNo();
        this.email = customer.getEmail();
        this.password = customer.getPassword();

    }
}
