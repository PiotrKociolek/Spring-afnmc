package com.afnmc.afnmc.services;

import com.afnmc.afnmc.models.dtos.request.ChangeFlightStatusDto;
import com.afnmc.afnmc.models.dtos.request.CreateFlightRequestDto;
import com.afnmc.afnmc.models.dtos.response.FlightResponseDto;
import com.afnmc.afnmc.models.flags.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    Page<FlightResponseDto> browseFlightList(Pageable pageable);
   // void filterFlightList(CreateFlightRequestDto createFlightRequestDto);

    void changeFlightStatus(ChangeFlightStatusDto changeFlightStatusDto);
    void addFlight(CreateFlightRequestDto createFlightRequestDto);
    void removeFlight(String flightId);


}
