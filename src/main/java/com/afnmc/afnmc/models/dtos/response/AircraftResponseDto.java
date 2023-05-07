package com.afnmc.afnmc.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftResponseDto {
    private String id;
    private String brand;
    private String model;
    private int seatsNumber;
}
