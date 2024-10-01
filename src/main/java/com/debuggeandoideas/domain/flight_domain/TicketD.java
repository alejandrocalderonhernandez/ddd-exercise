package com.debuggeandoideas.domain.flight_domain;

public class TicketD {

    private Long id;
    private Long customerId;
    private FlightD flight;
    private PlaneSeatD seat;
    private double price;
    private String status; // 'Purchased', 'Cancelled', etc.
    private String ticketNumber;
    private PaymentFlight payment;
}
