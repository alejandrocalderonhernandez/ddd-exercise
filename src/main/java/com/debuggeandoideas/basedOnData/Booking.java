package com.debuggeandoideas.basedOnData;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Booking {
    private Long id;
    private Long customerId;
    private Hotel hotel;
    private Room room;
    private double price; // Calculado como room.getPrice() + impuestos
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status;
}
