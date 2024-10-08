package com.debuggeandoideas.domain.hotal_domain;

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
        this.setRating(newRating);
    }

    public List<RoomD> getAvailableRooms() {
        final var availableRooms = new ArrayList<RoomD>();

        for (RoomD room : this.rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

}
