package com.afnmc.afnmc.services.impl;

import com.afnmc.afnmc.exceptions.AirportNotFoundByIdException;
import com.afnmc.afnmc.models.documets.AirportDocument;
import com.afnmc.afnmc.models.dtos.request.AirportRequestDto;
import com.afnmc.afnmc.models.dtos.response.AirportResponseDto;
import com.afnmc.afnmc.repositories.AirportRepository;
import com.afnmc.afnmc.services.AirportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createAirport(final AirportRequestDto airportRequestDto) {
        final AirportDocument airportDocument = modelMapper.map(airportRequestDto, AirportDocument.class);
        airportDocument.setId(null);
        airportRepository.save(airportDocument);
    }

    @Override
    public void removeAirport(final String id) {
        airportRepository.deleteById(id);
    }

    @Override
    public AirportResponseDto getAirportById(final String id) {
        return airportRepository.findById(id).map(x -> modelMapper.map(x, AirportResponseDto.class)).orElseThrow(AirportNotFoundByIdException::new);
    }

    @Override
    public Page<AirportResponseDto> getAirportsList(final Pageable pageable) {
        return airportRepository.findAll(pageable).map(x -> modelMapper.map(x, AirportResponseDto.class));
    }
}
