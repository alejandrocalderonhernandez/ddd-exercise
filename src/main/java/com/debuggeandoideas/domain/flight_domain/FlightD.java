package com.debuggeandoideas.domain.flight_domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class FlightD {

    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<PlaneSeatD> seats;
    private String airline;

    public void changeDepartureTime(LocalDateTime newTime) {
        this.setDepartureTime(newTime);
    }

    public void changeArrivalTime(LocalDateTime newTime) {
        this.setArrivalTime(newTime);
    }

    public List<PlaneSeatD> getAvailableSeats() {
        final var availableSeats = new ArrayList<PlaneSeatD>();

        for (PlaneSeatD seat: this.seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }

        return availableSeats;
    }

    public void addSeat(PlaneSeatD seat) {
        if (Objects.isNull(seat)) {
            this.seats = new ArrayList<>();
        } else {
            this.seats.add(seat);
        }
    }
}
