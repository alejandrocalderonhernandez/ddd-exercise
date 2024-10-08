package com.debuggeandoideas.domain.flight_domain;

import lombok.Data;

@Data
public class PaymentFlights {

    private String paymentMethod;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String SecurityCode;
    private String visaId;
    private boolean flightDiscount;

    public boolean validPaymentDetails() {
        // TO DO valid business logic based on domain of flights
        return true;
    }
}
