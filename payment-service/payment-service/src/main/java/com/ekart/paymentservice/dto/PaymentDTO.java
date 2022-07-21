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
    private String debit;
    private String credit;

    public PaymentDTO(Payment payment){
        this.paymentId = payment.getPaymentId();
        this.cardNo = payment.getCardNo();
        this.expiryDate = payment.getExpiryDate();
        this.nameOnCard = payment.getNameOnCard();
        this.debit = payment.getDebit();
        this.credit = payment.getCredit();
    }
}

