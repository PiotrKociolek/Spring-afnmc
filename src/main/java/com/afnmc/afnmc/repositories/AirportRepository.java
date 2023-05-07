package com.afnmc.afnmc.repositories;

import com.afnmc.afnmc.models.documets.AirportDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirportRepository extends MongoRepository<AirportDocument, String> {
}
