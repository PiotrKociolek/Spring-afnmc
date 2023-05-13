package com.afnmc.afnmc.models.dtos.response;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
