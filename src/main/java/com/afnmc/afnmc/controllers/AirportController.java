package com.afnmc.afnmc.controllers;

import com.afnmc.afnmc.models.dtos.request.AirportRequestDto;
import com.afnmc.afnmc.models.dtos.response.AirportResponseDto;
import com.afnmc.afnmc.services.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airport")
public class AirportController {
    private final AirportService airportService;

    @PutMapping(value = "/create/airport")
    @ResponseStatus(value = HttpStatus.OK)
    public void createAirport(@RequestBody final AirportRequestDto airportRequestDto) {
        airportService.createAirport(airportRequestDto);
    }

    @DeleteMapping(value = "/remove/airport/{airportId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeAirport(@PathVariable("airportId") final String airportId) {
        airportService.removeAirport(airportId);
    }
    @PreAuthorize("USER")
    @GetMapping(value = "/get/airport/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AirportResponseDto getAirportById(@PathVariable("id") final String id) {
        return airportService.getAirportById(id);
    }
    @PreAuthorize("USER")
    @GetMapping(value = "/get/airport/list/{size}/{page}")
    @ResponseStatus(value = HttpStatus.OK)
    public Page<AirportResponseDto> getAirportsList(@PathVariable("size") final int size, @PathVariable("page") final int page) {
        return airportService.getAirportsList(PageRequest.of(page, size));
    }
}
