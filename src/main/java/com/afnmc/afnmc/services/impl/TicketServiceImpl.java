package com.afnmc.afnmc.services.impl;

import com.afnmc.afnmc.exceptions.InvalidCheckInPriorityException;
import com.afnmc.afnmc.exceptions.InvalidLuggageTypeException;
import com.afnmc.afnmc.exceptions.InvalidTicketIdException;
import com.afnmc.afnmc.models.documets.TicketDocument;
import com.afnmc.afnmc.models.dtos.request.CreateTicketRequestDto;
import com.afnmc.afnmc.models.dtos.request.SetCheckInPriorityDto;
import com.afnmc.afnmc.models.dtos.request.SetLuggageTypeDto;
import com.afnmc.afnmc.models.dtos.request.SetTicketTypeDto;
import com.afnmc.afnmc.models.dtos.response.TicketResponseDto;
import com.afnmc.afnmc.repositories.TicketRepository;
import com.afnmc.afnmc.services.TicketService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addTicket(@Valid final CreateTicketRequestDto createTicketRequestDto) {
        final TicketDocument ticketDocument = modelMapper.map(createTicketRequestDto, TicketDocument.class);
        ticketDocument.setId(null);
        ticketRepository.save(ticketDocument);
    }

    @Override
    public void removeTicket(@Valid final String id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void setTicketType(@Valid final SetTicketTypeDto setTicketTypeDto) {
        ticketRepository.findById(setTicketTypeDto.getId()).ifPresentOrElse(x -> {
                    x.setTicketType(setTicketTypeDto.getTicketType());
                    ticketRepository.save(x);
                }, InvalidTicketIdException::new
        );
    }

    @Override
    public void setCheckInPriority(@Valid final SetCheckInPriorityDto setCheckInPriorityDto) {
        ticketRepository.findById(setCheckInPriorityDto.getId()).ifPresentOrElse(x -> {
                    x.setCheckingPriority(setCheckInPriorityDto.getCheckInPriority());
                    ticketRepository.save(x);
                }, InvalidCheckInPriorityException::new
        );
    }

    @Override
    public void setLuggageType(@Valid final SetLuggageTypeDto setLuggageTypeDto) {
        ticketRepository.findById(setLuggageTypeDto.getId()).ifPresentOrElse(x -> {
                    x.setLuggageType(setLuggageTypeDto.getLuggageType());
                    ticketRepository.save(x);
                }, InvalidLuggageTypeException::new
        );
    }

    @Override
    public List<TicketResponseDto> getListOfTickets(final String flightId) {
        return ticketRepository.findByFlightId(flightId).stream().map(x -> modelMapper.map(x, TicketResponseDto.class)).toList();
    }

    @Override
    public Page<TicketResponseDto> getPageOfTickets(final String flightId, final Pageable pageable) {
        return ticketRepository.findAllByFlightId(flightId, pageable).map(x -> modelMapper.map(x, TicketResponseDto.class));
    }
}
