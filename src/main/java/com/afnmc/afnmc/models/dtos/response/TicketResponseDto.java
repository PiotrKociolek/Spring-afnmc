package com.afnmc.afnmc.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {
    private String id;
    private String userId;
    private Float ticketPrice;
    private String flightId;
    private String aircraftModel;
    private Integer seatNumber;
    private Integer premiumSeat;
    private Boolean checkingPriority;
}
