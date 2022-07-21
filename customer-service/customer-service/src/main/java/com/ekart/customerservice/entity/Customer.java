package com.ekart.customerservice.entity;


import com.ekart.customerservice.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ekart_customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer custId;

    private String fname;

    private String lname;

    private Long phoneNo;

    private String email;

    private String password;

    public Customer(CustomerDTO customerDTO){
        this.custId = customerDTO.getCustId();
        this.fname = customerDTO.getFname();
        this.lname = customerDTO.getLname();
        this.phoneNo = customerDTO.getPhoneNo();
        this.email = customerDTO.getEmail();
        this.password = customerDTO.getPassword();

    }
}
