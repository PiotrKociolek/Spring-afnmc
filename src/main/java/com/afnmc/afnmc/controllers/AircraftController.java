package com.afnmc.afnmc.controllers;

import com.afnmc.afnmc.models.dtos.request.AircraftRequestDto;
import com.afnmc.afnmc.models.dtos.response.AircraftResponseDto;
import com.afnmc.afnmc.services.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aircraft")
public class AircraftController {
    private final AircraftService aircraftService;

    //addAircraft(dto),removeAircraft,getAircraftById,getAircraftList
    @PutMapping(value = "/add/aircraft")
    @ResponseStatus(value = HttpStatus.OK)
    public void addAircraft(@RequestBody final AircraftRequestDto aircraftRequestDto) {
        aircraftService.addAircraft(aircraftRequestDto);
    }

    @DeleteMapping(value = "/remove/aircraft/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeAircraft(@PathVariable("id") final String id) {
        aircraftService.removeAircraft(id);
    }

    @PutMapping(value = "get/aircraft/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AircraftResponseDto getAircraftById(@PathVariable("id") final String id) {
        return aircraftService.getAircraftById(id);
    }

    @PutMapping(value = "get/aircraft/list/{page}/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public Page<AircraftResponseDto> getAircraftList(@PathVariable("page") final int page, @PathVariable("size") final int size) {
        return aircraftService.getAircraftList(PageRequest.of(page, size));
    }
}
