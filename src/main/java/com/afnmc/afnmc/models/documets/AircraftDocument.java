package com.afnmc.afnmc.models.documets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("aircraft")
public class AircraftDocument {
    @Id
    private String id;
    private String brand;
    private String model;
    private int seatsNumber;
}
