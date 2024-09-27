package com.debuggeandoideas.basedOnData;

import lombok.Data;

@Data
public class PlaneSeat {
    private Long id;
    private String seatNumber;
    private double price;
    private SeatSize size;
    private boolean isAssigned;
    private boolean isWindowSeat;
    private boolean isAisleSeat;
}