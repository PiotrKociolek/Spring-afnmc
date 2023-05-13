package com.afnmc.afnmc.services.impl;

import com.afnmc.afnmc.exceptions.FlightNotFoundException;
import com.afnmc.afnmc.models.documets.FlightDocument;
import com.afnmc.afnmc.models.dtos.request.ChangeFlightStatusDto;
import com.afnmc.afnmc.models.dtos.request.CreateFlightRequestDto;
import com.afnmc.afnmc.models.dtos.response.FlightResponseDto;
import com.afnmc.afnmc.repositories.FlightRepository;
import com.afnmc.afnmc.services.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<FlightResponseDto> browseFlightList(final Pageable pageable) {
        return flightRepository.findAll(pageable).map(x -> modelMapper.map(x, FlightResponseDto.class));
    }

    @Override
    public void changeFlightStatus(@Valid final ChangeFlightStatusDto changeFlightStatusDto) {
        flightRepository.findById(changeFlightStatusDto.getId()).ifPresentOrElse(x -> {
            x.setFlightStatus(changeFlightStatusDto.getFlightStatus());
            flightRepository.save(x);
        }, FlightNotFoundException::new);
    }

    @Override
    public void addFlight(@Valid final CreateFlightRequestDto createFlightRequestDto) {
        final FlightDocument flightDocument = modelMapper.map(createFlightRequestDto, FlightDocument.class);
        flightDocument.setId(null);
        flightRepository.save(flightDocument);
    }

    @Override
    public void removeFlight(final String flightId) {
        flightRepository.deleteById(flightId);
    }
}
