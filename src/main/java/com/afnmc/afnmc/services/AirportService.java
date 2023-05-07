package com.afnmc.afnmc.services;


import com.afnmc.afnmc.models.dtos.request.AirportRequestDto;
import com.afnmc.afnmc.models.dtos.response.AirportResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AirportService {
    void createAirport(AirportRequestDto airportRequestDto);
    void removeAirport(String id);
    AirportResponseDto getAirportById(String id);
    Page<AirportResponseDto> getAirportsList(Pageable pageable);
}
