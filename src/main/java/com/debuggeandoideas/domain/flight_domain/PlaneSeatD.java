package com.debuggeandoideas.domain.flight_domain;

import lombok.Data;

@Data
public class PlaneSeatD {

    private Long id;
    private String seatNumber;
    private double price;
    private boolean isAssigned;

    public void changePrice(double newPrice) {
        this.setPrice(newPrice);
    }

    public void changeAssignmentStatus(boolean isAssigned) {
        this.setAssigned(isAssigned);
    }

    public boolean isAvailable() {
        return !this.isAssigned();
    }



}
