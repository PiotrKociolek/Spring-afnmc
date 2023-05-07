package com.afnmc.afnmc.services;

import com.afnmc.afnmc.exceptions.DocumentNotFoundException;
import com.afnmc.afnmc.models.documets.AircraftDocument;
import com.afnmc.afnmc.models.dtos.request.AircraftRequestDto;
import com.afnmc.afnmc.models.dtos.response.AircraftResponseDto;
import com.afnmc.afnmc.repositories.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    private final ModelMapper modelMapper;
    private final AircraftRepository aircraftRepository;

    @Override
    public void addAircraft(final AircraftRequestDto aircraftRequestDto) {
        AircraftDocument aircraftDocument = modelMapper.map(aircraftRequestDto, AircraftDocument.class);
        aircraftDocument.setId(null);
        aircraftRepository.save(aircraftDocument);
    }

    @Override
    public void removeAircraft(final String id) {
        aircraftRepository.deleteById(id);
    }

    @Override
    public AircraftResponseDto getAircraftById(final String id) {
        return aircraftRepository.findById(id).map(x -> modelMapper.map(x, AircraftResponseDto.class)).orElseThrow(DocumentNotFoundException::new);
    }

    @Override
    public Page<AircraftResponseDto> getAircraftList(final Pageable pageable) {
        return aircraftRepository.findAll(pageable).map(x -> modelMapper.map(x, AircraftResponseDto.class));
    }
}
