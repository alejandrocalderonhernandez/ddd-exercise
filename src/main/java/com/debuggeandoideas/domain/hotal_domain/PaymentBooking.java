package com.debuggeandoideas.domain.hotal_domain;

import lombok.Data;

@Data
public class PaymentBooking {

    private String paymentMethod;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String SecurityCode;
    private boolean bookingDiscount;


    public boolean validPaymentDetails() {
        // TO DO valid business logic based on domain of hotels
        return true;
    }

}
