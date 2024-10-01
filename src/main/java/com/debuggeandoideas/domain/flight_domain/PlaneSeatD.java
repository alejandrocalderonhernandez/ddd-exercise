package com.debuggeandoideas.domain.flight_domain;

import lombok.Data;

@Data
public class PlaneSeatD {
    private Long id;
    private String seatNumber;
    private double price;
    private boolean isAssigned;

    public void changePrice(double newPrice) {
        this.price = newPrice;
    }

    public void changeAssignmentStatus(boolean assigned) {
        this.isAssigned = assigned;
    }

    public boolean isAvailable() {
        return !this.isAssigned;
    }

}
