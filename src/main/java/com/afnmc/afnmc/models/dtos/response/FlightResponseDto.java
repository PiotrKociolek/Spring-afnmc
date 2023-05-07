package com.afnmc.afnmc.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponseDto {
    @Id
    private String id;
    private String aircraftId;
    private String departureAirportId;
    private String arrivalAirportId;
    private Instant departureTime;
    private Instant arrivalTime;
}
