package com.ekart.paymentservice.dto;


import com.ekart.paymentservice.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Integer paymentId;
    private Integer cardNo;
    private Integer cvv;
    private String expiryDate;
    private String nameOnCard;
    private boolean debit = false;
    private boolean credit = false;

    public PaymentDTO(Payment payment){
        this.paymentId = payment.getPaymentId();
        this.cardNo = payment.getCardNo();
        this.cvv = payment.getCvv();
        this.expiryDate = payment.getExpiryDate();
        this.nameOnCard = payment.getNameOnCard();
        this.debit = payment.isDebit();
        this.credit = payment.isCredit();
    }
}

