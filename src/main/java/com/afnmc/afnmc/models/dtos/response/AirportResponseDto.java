package com.afnmc.afnmc.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirportResponseDto {

    private String id;
    private String airportName;
    private String country;
    private String city;
}
