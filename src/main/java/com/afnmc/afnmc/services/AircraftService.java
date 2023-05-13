package com.afnmc.afnmc.services;

import com.afnmc.afnmc.models.dtos.request.AircraftRequestDto;
import com.afnmc.afnmc.models.dtos.response.AircraftResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AircraftService {
    void addAircraft(AircraftRequestDto aircraftRequestDto);

    void removeAircraft(String id);

    AircraftResponseDto getAircraftById(String id);

    Page<AircraftResponseDto> getAircraftList(Pageable pageable);
}
