package com.debuggeandoideas.basedOnData;

import com.debuggeandoideas.commons.RoomSize;
import lombok.Data;

@Data
public class Room {
    private Long id;
    private int roomNumber;
    private double price;
    private RoomSize size;
    private boolean isAssigned;
    private int floor;
    private String bedType;
}
