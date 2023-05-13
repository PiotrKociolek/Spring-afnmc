package com.afnmc.afnmc.repositories;

import com.afnmc.afnmc.models.documets.TicketDocument;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<TicketDocument, String> {
    List<TicketDocument> findByFlightId(String flightId);

    Page<TicketDocument> findAllByFlightId(String flightId, Pageable pageable);
}

