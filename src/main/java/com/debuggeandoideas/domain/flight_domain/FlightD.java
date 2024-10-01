package com.debuggeandoideas.domain.flight_domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FlightD {

    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<PlaneSeatD> seats;
    private String airline;

    public void changeDepartureTime(LocalDateTime newDepartureTime) {
        this.departureTime = newDepartureTime;
    }

    public void changeArrivalTime(LocalDateTime newArrivalTime) {
        this.arrivalTime = newArrivalTime;
    }

    public List<PlaneSeatD> getAvailableSeats() {
        List<PlaneSeatD> availableSeats = new ArrayList<>();
        for (PlaneSeatD seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    public void addSeat(PlaneSeatD seat) {
        if (this.seats == null) {
            this.seats = new ArrayList<>();
        }
        this.seats.add(seat);
    }
}
