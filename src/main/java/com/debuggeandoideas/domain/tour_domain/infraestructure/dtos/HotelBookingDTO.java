package com.debuggeandoideas.domain.tour_domain.infraestructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelBookingDTO {

    private Long id;
    private String hotelName;
    private String address;
    private double price;
    private int rating;
}
