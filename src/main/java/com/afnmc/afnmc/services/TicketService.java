package com.afnmc.afnmc.services;

import com.afnmc.afnmc.models.dtos.request.CreateTicketRequestDto;
import com.afnmc.afnmc.models.dtos.request.SetCheckInPriorityDto;
import com.afnmc.afnmc.models.dtos.request.SetLuggageTypeDto;
import com.afnmc.afnmc.models.dtos.request.SetTicketTypeDto;
import com.afnmc.afnmc.models.dtos.response.TicketResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    void addTicket(CreateTicketRequestDto createTicketRequestDto);

    void removeTicket(String id);

    void setTicketType(SetTicketTypeDto setTicketTypeDto);

    void setCheckInPriority(SetCheckInPriorityDto setCheckInPriorityDto);

    void setLuggageType(SetLuggageTypeDto setLuggageTypeDto);

    List<TicketResponseDto> getListOfTickets(String flightId);

    Page<TicketResponseDto> getPageOfTickets(String FlightId, Pageable pageable);

}
