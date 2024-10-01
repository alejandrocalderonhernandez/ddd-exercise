package com.debuggeandoideas.domain.hotel_domain;

import lombok.Data;

@Data
public class PaymentBooking {

    private String paymentMethod; // 'Credit Card', 'Debit Card', 'PayPal', etc.
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String securityCode;

    public boolean validatePaymentDetails() {
        //TO DO
        return true;
    }
}
