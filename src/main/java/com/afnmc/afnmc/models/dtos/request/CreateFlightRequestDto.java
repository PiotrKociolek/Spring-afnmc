package com.afnmc.afnmc.models.dtos.request;

import com.afnmc.afnmc.models.flags.FlightStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFlightRequestDto {
    @NotNull
    @NotBlank
    private String aircraftId;
    @NotNull
    @NotBlank
    private String departureAirportId;
    @NotNull
    @NotBlank//tylko do stringów
    private String arrivalAirportId;
    @NotNull
    private Instant departureTime;
    @NotNull
    private Instant arrivalTime;
    @NotNull
    private FlightStatus flightStatus;
}
