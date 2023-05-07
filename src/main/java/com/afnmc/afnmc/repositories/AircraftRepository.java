package com.afnmc.afnmc.repositories;

import com.afnmc.afnmc.models.documets.AircraftDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AircraftRepository extends MongoRepository<AircraftDocument, String> {
}
