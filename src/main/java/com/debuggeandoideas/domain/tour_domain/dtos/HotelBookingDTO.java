package com.debuggeandoideas.domain.tour_domain.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelBookingDTO {

    private Long id;
    private String hotelName;
    private String address;
    private double price;
    private int rating;
}
