package com.afnmc.afnmc.repositories;

import com.afnmc.afnmc.models.documets.FlightDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FlightRepository extends MongoRepository<FlightDocument, String> {
    Optional<FlightDocument> filterFLightListASC();
}
