package com.debuggeandoideas.basedOnData;

import lombok.Data;
import java.util.List;

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
