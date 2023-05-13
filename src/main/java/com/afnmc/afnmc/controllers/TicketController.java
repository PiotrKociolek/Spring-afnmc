package com.afnmc.afnmc.controllers;

import com.afnmc.afnmc.models.dtos.request.CreateTicketRequestDto;
import com.afnmc.afnmc.models.dtos.request.SetCheckInPriorityDto;
import com.afnmc.afnmc.models.dtos.request.SetLuggageTypeDto;
import com.afnmc.afnmc.models.dtos.request.SetTicketTypeDto;
import com.afnmc.afnmc.models.dtos.response.TicketResponseDto;
import com.afnmc.afnmc.services.TicketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")

public class TicketController {
    private final TicketService ticketService;
    @PreAuthorize("USER")
    @PutMapping(value = "/addTicket", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void addTicket(@RequestBody final CreateTicketRequestDto createTicketRequestDto) {
        ticketService.addTicket(createTicketRequestDto);
    }

    @DeleteMapping(value = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeTicket(@PathVariable("id") final String id) {
        ticketService.removeTicket(id);
    }
    @PutMapping(value = "/set/type", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void setTicketType(@RequestBody final SetTicketTypeDto setTicketTypeDto) {
        ticketService.setTicketType(setTicketTypeDto);
    }
    @PreAuthorize("USER")
    @PutMapping(value = "/set/priority", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void setCheckInPriority(@RequestBody final SetCheckInPriorityDto setCheckInPriorityDto) {
        ticketService.setCheckInPriority(setCheckInPriorityDto);
    }
    @PreAuthorize("USER")
    @PutMapping(value = "/set/luggage", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void setLuggageType(@RequestBody final SetLuggageTypeDto setLuggageTypeDto) {
        ticketService.setLuggageType(setLuggageTypeDto);
    }

    @GetMapping(value = "/get/list/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TicketResponseDto> getListOfTickets(@PathVariable("flightId") final String flightId) {
        return ticketService.getListOfTickets(flightId);
    }
    @PreAuthorize("USER")
    @PutMapping(value = "/get/page/{flightId}/{size}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Page<TicketResponseDto> getPageOfTickets(@PathVariable("flightId") final String flightId, @PathVariable("size") final int size, @PathVariable("page") final int page) {
        return ticketService.getPageOfTickets(flightId, PageRequest.of(page, size));
    }
}
