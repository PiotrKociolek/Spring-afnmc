package com.afnmc.afnmc.models.documets;

import com.afnmc.afnmc.models.flags.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "flights")
public class FlightDocument {
    @Id
    private String id;
    private String aircraftId;
    private String departureAirportId;
    private String arrivalAirportId;
    private Instant departureTime;
    private Instant arrivalTime;
    private Instant approximateArrivalTime;
    private FlightStatus flightStatus;
}
/*Loty
Każdy lot powinien posiadać następujące informacje:
• model samolotu +
• lotnisko wylotu+
• lotnisko przylotu+
• godzina wylotu?
• godzina przylotu?
• numer lotu +
*/