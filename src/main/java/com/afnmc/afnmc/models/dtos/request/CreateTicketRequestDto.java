package com.afnmc.afnmc.models.dtos.request;

import com.afnmc.afnmc.models.flags.TicketType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketRequestDto {

    @NotNull
    private String userId;
    @NotNull
    private Float ticketPrice;
    @NotNull
    @NotBlank
    private String flightId;
    @NotNull
    @NotBlank
    private String aircraftId;
    @NotNull
    private Integer seatNumber;
    @NotNull
    private Integer premiumSeat;
    @NotNull
    private TicketType ticketType;
    @NotNull
    private Boolean checkingPriority;
}
