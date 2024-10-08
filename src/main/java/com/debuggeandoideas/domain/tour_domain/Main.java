package com.debuggeandoideas.domain.tour_domain;

import com.debuggeandoideas.domain.tour_domain.domain.models.Tour;
import com.debuggeandoideas.domain.tour_domain.domain.services.TourDomainServiceImpl;

public class Main {

    public static void main(String[] args) {
        final var tourService = new TourDomainServiceImpl();

        // Crear un nuevo tour
        Tour tour = tourService.createTour("European Adventure");

        // Añadir vuelos al tour
        tourService.addFlightToTour(tour, "1");
        tourService.addFlightToTour(tour, "2");

        // Añadir reservas de hotel al tour
        tourService.addHotelBookingToTour(tour, "101");
        tourService.addHotelBookingToTour(tour, "102");

        // Mostrar el costo total del tour
        double totalCost = tour.getTotalCost();
        System.out.println("Total cost of the tour: $" + totalCost);

        // Eliminar un vuelo del tour
        tourService.removeFlightFromTour(tour, "1");

        // Eliminar una reserva de hotel del tour
        tourService.removeHotelBookingFromTour(tour, "101");

        // Mostrar el costo total actualizado
        totalCost = tour.getTotalCost();
        System.out.println("Updated total cost of the tour: $" + totalCost);
    }
}
