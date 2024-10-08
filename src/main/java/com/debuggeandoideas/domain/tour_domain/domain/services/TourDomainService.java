package com.debuggeandoideas.domain.tour_domain.domain.services;

import com.debuggeandoideas.domain.tour_domain.domain.models.Tour;
import com.debuggeandoideas.domain.tour_domain.infraestructure.dtos.FlightDTO;
import com.debuggeandoideas.domain.tour_domain.infraestructure.dtos.HotelBookingDTO;

public interface TourDomainService {

    Tour createTour(String tourName);

    void addFlightToTour(Tour tour, String flightId);

    void addHotelBookingToTour(Tour tour, String hotelId);

    void removeFlightFromTour(Tour tour, String flightId);

    void removeHotelBookingFromTour(Tour tour, String hotelId);

}
