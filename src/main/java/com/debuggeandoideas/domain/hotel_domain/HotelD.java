package com.debuggeandoideas.domain.hotel_domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HotelD {

    private Long id;
    private String name;
    private String address;
    private int rating;
    private List<RoomD> rooms;

    public void changeRating(int newRating) {
        this.rating = newRating;
    }

    public List<RoomD> getAvailableRooms() {
        List<RoomD> availableRooms = new ArrayList<>();
        for (RoomD room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

}
