package com.afnmc.afnmc.controllers;

import com.afnmc.afnmc.models.dtos.request.ChangeFlightStatusDto;
import com.afnmc.afnmc.models.dtos.request.CreateFlightRequestDto;
import com.afnmc.afnmc.models.dtos.response.FlightResponseDto;
import com.afnmc.afnmc.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flight")

public class FlightController {
    private final FlightService flightService;

    @GetMapping(value = "/page/{size}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Page<FlightResponseDto> browseFlightList(@PathVariable("size") final int size, @PathVariable("page") final int page) {
        return flightService.browseFlightList(PageRequest.of(page, size));
    }

    @PutMapping(value = "/changeFlightStatus/{id}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void changeFLightStatus(@RequestBody final ChangeFlightStatusDto changeFlightStatusDto) {
        flightService.changeFlightStatus(changeFlightStatusDto);
    }

    @PutMapping(value = "/addFlight/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void addFlight(@RequestBody final CreateFlightRequestDto createFlightRequestDto) {
        flightService.addFlight(createFlightRequestDto);
    }

    @DeleteMapping(value = "/removeFlight/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeFLight(@PathVariable("flightId") final String flightId) {
        flightService.removeFlight(flightId);
    }
}
