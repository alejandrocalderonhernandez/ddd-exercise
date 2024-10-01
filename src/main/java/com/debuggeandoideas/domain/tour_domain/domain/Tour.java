package com.debuggeandoideas.domain.tour_domain.domain;

import com.debuggeandoideas.domain.tour_domain.dtos.FlightDTO;
import com.debuggeandoideas.domain.tour_domain.dtos.HotelBookingDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tour {

    private Long id;
    private String tourName;
    private List<FlightDTO> flights = new ArrayList<>();  // Inicialización de la lista
    private List<HotelBookingDTO> hotelBookings = new ArrayList<>();  // Inicialización de la lista

    public void addFlight(FlightDTO flight) {
        flights.add(flight);  // No habrá NullPointerException porque la lista está inicializada
    }

    public void removeFlight(FlightDTO flight) {
        flights.remove(flight);
    }

    public void addHotelBooking(HotelBookingDTO booking) {
        hotelBookings.add(booking);  // No habrá NullPointerException
    }

    public void removeHotelBooking(HotelBookingDTO booking) {
        hotelBookings.remove(booking);
    }

    public double getTotalCost() {
        double total = 0;
        for (FlightDTO flight : flights) {
            total += flight.getPrice();
        }
        for (HotelBookingDTO booking : hotelBookings) {
            total += booking.getPrice();
        }
        return total;
    }

}
