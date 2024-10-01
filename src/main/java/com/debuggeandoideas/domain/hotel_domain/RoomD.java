package com.debuggeandoideas.domain.hotel_domain;

import com.debuggeandoideas.basedOnData.RoomSize;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomD {

    private Long id;
    private int roomNumber;
    private double price;
    private boolean isAssigned;
    private String bedType;
    private List<String> amenities;

    public void changePrice(double newPrice) {
        this.price = newPrice;
    }

    public void addAmenities(List<String> newAmenities) {
        if (this.amenities == null) {
            this.amenities = new ArrayList<>();
        }
        this.amenities.addAll(newAmenities);
    }

    public boolean isAvailable() {
        return !this.isAssigned;
    }
}
