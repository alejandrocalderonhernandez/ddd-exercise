package com.debuggeandoideas.domain.flight_domain;

import com.debuggeandoideas.domain.hotel_domain.HotelD;
import lombok.Data;

@Data
public class PaymentFlight {

    private String paymentMethod; // 'Credit Card', 'Debit Card', 'PayPal', etc.
    private String accountNumber;
    private String accountHolderName;
    private String expirationDate;
    private String securityCode;

    public boolean validatePaymentDetails() {
        // TO DO
        return true;
    }


}
