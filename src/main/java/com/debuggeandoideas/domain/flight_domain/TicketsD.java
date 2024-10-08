package com.debuggeandoideas.domain.flight_domain;

import com.debuggeandoideas.basedOnData.Flight;
import com.debuggeandoideas.basedOnData.PlaneSeat;
import lombok.Data;

@Data
public class TicketsD {

    private Long id;
    private Long customerId;
    private Flight flight;
    private PlaneSeat seat;
    private double price; //  seat.getPrice() + impuestos
    private String ticketNumber;
}
