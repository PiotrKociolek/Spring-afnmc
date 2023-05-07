package com.afnmc.afnmc.models.documets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("airports")
public class AirportDocument {
    @Id
    private String id;
    private String airportName;
    private String country;
    private String city;

}
