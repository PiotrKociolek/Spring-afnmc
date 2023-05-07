package com.afnmc.afnmc.repositories;

import com.afnmc.afnmc.models.documets.TicketDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends MongoRepository<TicketDocument, String> {

    Optional <TicketDocument> findByPassengerName(String passengerName);
    List<TicketDocument> findByFlightId(String flightId);
    Page<TicketDocument> findAllByFlightId(String flightId, Pageable pageable);
}

