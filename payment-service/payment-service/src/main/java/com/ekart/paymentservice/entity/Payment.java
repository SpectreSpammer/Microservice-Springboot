package com.ekart.paymentservice.entity;


import com.ekart.paymentservice.dto.PaymentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ekart_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private Integer cardNo;
    private Integer cvv;
    private String expiryDate;
    private String nameOnCard;
    private boolean debit = false;
    private boolean credit = false;

    public Payment(PaymentDTO paymentDTO){
        this.paymentId = paymentDTO.getPaymentId();
        this.cardNo = paymentDTO.getCardNo();
        this.cvv = paymentDTO.getCvv();
        this.expiryDate = paymentDTO.getExpiryDate();
        this.nameOnCard = paymentDTO.getNameOnCard();
        this.debit = paymentDTO.isDebit();
        this.credit = paymentDTO.isCredit();
    }
}
