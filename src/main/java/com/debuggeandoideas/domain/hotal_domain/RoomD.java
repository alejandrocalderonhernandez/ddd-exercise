package com.debuggeandoideas.domain.hotal_domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class RoomD {

    private Long id;
    private int roomNumber;
    private double price;
    private boolean isAssigned;
    private String bedType;
    private List<String> amenities;

    public void changePrice(double newPrice) {
        this.setPrice(newPrice);
    }

    public void addAmenities(List<String> newAmenities) {
        if (Objects.isNull(this.amenities)) {
            this.amenities= new ArrayList<>();
        }

        this.amenities.addAll(newAmenities);
    }

    public boolean isAvailable() {
        return !this.isAssigned;
    }

}
