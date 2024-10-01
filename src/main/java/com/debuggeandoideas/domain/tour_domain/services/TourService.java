package com.debuggeandoideas.domain.tour_domain.services;

import com.debuggeandoideas.domain.tour_domain.domain.Tour;
import com.debuggeandoideas.domain.tour_domain.dtos.FlightDTO;
import com.debuggeandoideas.domain.tour_domain.dtos.HotelBookingDTO;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log
public class TourService {


    /**
     * Crea un nuevo tour con vuelos y reservas de hotel.
     *
     * @param tourName Nombre del tour.
     * @return El tour creado.
     */
    public Tour createTour(String tourName) {
        Long tourId = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;

        // Crear lista de vuelos dummy
        List<FlightDTO> dummyFlights = createDummyFlights();

        // Crear lista de reservas de hotel dummy
        List<HotelBookingDTO> dummyHotelBookings = createDummyHotelBookings();

        // Crear el tour con vuelos y reservas dummy
        Tour tour = Tour.builder()
                .id(tourId)
                .tourName(tourName)
                .flights(dummyFlights)  // Añadimos vuelos dummy
                .hotelBookings(dummyHotelBookings)  // Añadimos reservas dummy
                .build();

        log.info("Created new tour with ID: " + tourId + " and name: " + tourName);
        return tour;
    }

    /**
     * Genera una lista de vuelos dummy.
     *
     * @return Lista de vuelos ficticios.
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
     * Genera una lista de reservas de hotel dummy.
     *
     * @return Lista de reservas de hotel ficticias.
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

    /**
     * Simula la llamada a la API de hoteles y obtiene un hotel fake.
     *
     * @param hotelId ID del hotel.
     * @return HotelBookingDTO con datos simulados.
     */
    public HotelBookingDTO getHotel(String hotelId) {
        // Simulating API call to Hotel domain
        log.info("Calling Hotel API for hotel ID: " + hotelId);
        return HotelBookingDTO.builder()
                .id(Long.parseLong(hotelId))
                .hotelName("Grand Plaza " + hotelId) // Añadiendo el ID para distinguir
                .address("123 Main Street, City " + hotelId)
                .price(150.0 + Integer.parseInt(hotelId) * 10) // Precios diferentes por ID
                .rating(4)
                .build();
    }

    /**
     * Simula la llamada a la API de vuelos y obtiene un vuelo fake.
     *
     * @param flightId ID del vuelo.
     * @return FlightDTO con datos simulados.
     */
    public FlightDTO getFlight(String flightId) {
        // Simulating API call to Flight domain
        log.info("Calling Flight API for flight ID: " + flightId);
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
     * Añade un vuelo al tour.
     *
     * @param tour     Tour al que se añadirá el vuelo.
     * @param flightId ID del vuelo a añadir.
     */
    public void addFlightToTour(Tour tour, String flightId) {
        FlightDTO flight = getFlight(flightId);
        tour.addFlight(flight);
        log.info("Added flight " + flight.getFlightNumber() + " to tour " + tour.getTourName());
    }

    /**
     * Añade una reserva de hotel al tour.
     *
     * @param tour    Tour al que se añadirá la reserva de hotel.
     * @param hotelId ID del hotel a reservar.
     */
    public void addHotelBookingToTour(Tour tour, String hotelId) {
        HotelBookingDTO hotelBooking = getHotel(hotelId);
        tour.addHotelBooking(hotelBooking);
        log.info("Added hotel " + hotelBooking.getHotelName() + " to tour " + tour.getTourName());
    }

    /**
     * Elimina un vuelo del tour.
     *
     * @param tour     Tour del que se eliminará el vuelo.
     * @param flightId ID del vuelo a eliminar.
     */
    public void removeFlightFromTour(Tour tour, String flightId) {
        FlightDTO flightToRemove = tour.getFlights().stream()
                .filter(flight -> flight.getId().equals(Long.parseLong(flightId)))
                .findFirst()
                .orElse(null);
        if (flightToRemove != null) {
            tour.removeFlight(flightToRemove);
            log.info("Removed flight " + flightToRemove.getFlightNumber() + " from tour " + tour.getTourName());
        } else {
            log.warning("Flight ID " + flightId + " not found in tour " + tour.getTourName());
        }
    }

    /**
     * Elimina una reserva de hotel del tour.
     *
     * @param tour    Tour del que se eliminará la reserva de hotel.
     * @param hotelId ID del hotel a eliminar.
     */
    public void removeHotelBookingFromTour(Tour tour, String hotelId) {
        HotelBookingDTO bookingToRemove = tour.getHotelBookings().stream()
                .filter(booking -> booking.getId().equals(Long.parseLong(hotelId)))
                .findFirst()
                .orElse(null);
        if (bookingToRemove != null) {
            tour.removeHotelBooking(bookingToRemove);
            log.info("Removed hotel " + bookingToRemove.getHotelName() + " from tour " + tour.getTourName());
        } else {
            log.warning("Hotel ID " + hotelId + " not found in tour " + tour.getTourName());
        }
    }
}
