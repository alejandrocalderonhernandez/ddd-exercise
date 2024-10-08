package com.debuggeandoideas.domain.tour_domain.infraestructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private double price;
    private String airline;
}
