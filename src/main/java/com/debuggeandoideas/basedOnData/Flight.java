package com.debuggeandoideas.basedOnData;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Flight {
    private Long id;
    private String flightNumber;
    private int numberOfSeats;
    private String origin;
    private String destination;
    private int planeId;
    private boolean isDirect;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<PlaneSeat> seats;
    private String airline;
}
