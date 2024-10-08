package com.debuggeandoideas.domain.tour_domain.domain.services;

import com.debuggeandoideas.domain.tour_domain.domain.models.Tour;
import com.debuggeandoideas.domain.tour_domain.infraestructure.dtos.FlightDTO;
import com.debuggeandoideas.domain.tour_domain.infraestructure.dtos.HotelBookingDTO;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Log
//@Component @Service
public class TourDomainServiceImpl implements TourDomainService {

    //@Autowired clientHttpHotel
    //@Autowired clientHttpFlight


    @Override
    public Tour createTour(String tourName) {
        final var id = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;

        //http call
        final var flights = this.createDummyFlights();

        //http call
        final var hotels = this.createDummyHotelBookings();

        final var tour = Tour.builder()
                .id(id)
                .tourName(tourName)
                .flights(flights)
                .hotelBookings(hotels)
                .build();

        log.info("Tour created with id" + id);
        return tour;
    }

    @Override
    public void addFlightToTour(Tour tour, String flightId) {
        final var flight = getFlight(flightId);
        tour.addFlight(flight);
        log.info("Added flight: " + flightId + " in tour: " + tour.getTourName());
    }

    @Override
    public void addHotelBookingToTour(Tour tour, String hotelId) {
        final var hotel = getHotel(hotelId);
        tour.addHotelBooking(hotel);
        log.info("Added flight: " + hotelId + " in tour: " + tour.getTourName());
    }

    @Override
    public void removeFlightFromTour(Tour tour, String flightId) {
        final var flightToRemove = tour.getFlights()
                .stream()
                .filter(f -> f.getId().equals(Long.parseLong(flightId)))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(flightToRemove)) {
            tour.removeFlight(flightToRemove);
            log.info("Flight removed with id: " + flightId);
        } else {
            log.warning("Flight not exist in tour");
        }
    }

    @Override
    public void removeHotelBookingFromTour(Tour tour, String hotelId) {
        final var bookingToRemove = tour.getHotelBookings()
                .stream()
                .filter(b -> b.getId().equals(Long.parseLong(hotelId)))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(bookingToRemove)) {
            tour.removeHotelBooking(bookingToRemove);
            log.info("Hotel removed with id: " + hotelId);
        } else {
            log.warning("Hotel booking not exist in tour");
        }

    }


    /**
     * HTTP call to Hotel domain
     */
    private HotelBookingDTO getHotel(String hotelId) {
        return HotelBookingDTO.builder()
                .id(Long.parseLong(hotelId))
                .hotelName("Grand Plaza " + hotelId) // Añadiendo el ID para distinguir
                .address("123 Main Street, City " + hotelId)
                .price(150.0 + Integer.parseInt(hotelId) * 10) // Precios diferentes por ID
                .rating(4)
                .build();
    }


    /**
     * HTTP call to Flight domain
     */

    private FlightDTO getFlight(String flightId) {
        return FlightDTO.builder()
                .id(Long.parseLong(flightId))
                .flightNumber("FL" + flightId)
                .origin("New York")
                .destination("Paris")
                .price(500.0 + Integer.parseInt(flightId) * 20) // Precios diferentes por ID
                .airline("Airways International")
                .build();
    }


    /**
     * HTTP call to Flight domain
     */
    private List<FlightDTO> createDummyFlights() {
        List<FlightDTO> flights = new ArrayList<>();

        flights.add(FlightDTO.builder()
                .id(1L)
                .flightNumber("FL123")
                .origin("New York")
                .destination("Paris")
                .price(500.0)
                .airline("Airways International")
                .build());

        flights.add(FlightDTO.builder()
                .id(2L)
                .flightNumber("FL456")
                .origin("Los Angeles")
                .destination("London")
                .price(600.0)
                .airline("British Airways")
                .build());

        return flights;
    }

    /**
     * HTTP call to Hotel domain
     */
    private List<HotelBookingDTO> createDummyHotelBookings() {
        List<HotelBookingDTO> hotelBookings = new ArrayList<>();

        hotelBookings.add(HotelBookingDTO.builder()
                .id(101L)
                .hotelName("Grand Plaza")
                .address("123 Main Street")
                .price(200.0)
                .rating(5)
                .build());

        hotelBookings.add(HotelBookingDTO.builder()
                .id(102L)
                .hotelName("Royal Suites")
                .address("456 Broadway")
                .price(300.0)
                .rating(4)
                .build());

        return hotelBookings;
    }
}
