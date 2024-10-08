package com.debuggeandoideas.domain.tour_domain.domain.models;

import com.debuggeandoideas.domain.tour_domain.infraestructure.dtos.FlightDTO;
import com.debuggeandoideas.domain.tour_domain.infraestructure.dtos.HotelBookingDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tour {

    private Long id;
    private String tourName;
    private List<FlightDTO> flights = new ArrayList<>();
    private List<HotelBookingDTO> hotelBookings = new ArrayList<>();


    public void addFlight(FlightDTO flight) {
        flights.add(flight);
    }

    public void removeFlight(FlightDTO flight) {
        flights.remove(flight);
    }

    public void addHotelBooking(HotelBookingDTO booking) {
        hotelBookings.add(booking);
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
