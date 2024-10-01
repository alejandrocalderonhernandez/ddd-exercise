package com.debuggeandoideas.domain.hotel_domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingD {

    private Long id;
    private Long customerId;
    private HotelD hotel;
    private RoomD room;
    private double price;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status;
    private PaymentBooking payment;

    public void calculatePrice(double taxRate) {
        double roomPrice = room.getPrice();
        this.price = roomPrice + (roomPrice * taxRate);
    }

    public void changeCheckInDate(LocalDate newCheckInDate) {
        this.checkInDate = newCheckInDate;
    }

    public void changeCheckOutDate(LocalDate newCheckOutDate) {
        this.checkOutDate = newCheckOutDate;
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    public void addPayment(PaymentBooking payment) {
        this.payment = payment;
    }
}
