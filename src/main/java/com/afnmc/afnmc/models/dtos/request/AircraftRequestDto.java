package com.afnmc.afnmc.models.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AircraftRequestDto {

    @NotNull
    @NotBlank
    private String brand;
    @NotNull
    @NotBlank
    private String model;
    @NotNull
    private int seatsNumber;
}
