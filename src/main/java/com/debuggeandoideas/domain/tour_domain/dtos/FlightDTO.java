package com.debuggeandoideas.domain.tour_domain.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightDTO {
    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private double price;
    private String airline;

}
