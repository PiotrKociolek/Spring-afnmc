package com.afnmc.afnmc.models.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportRequestDto {
    @NotNull
    @NotBlank
    private String airportName;
    @NotNull
    @NotBlank
    private String country;
    @NotNull
    @NotBlank
    private String city;
}
