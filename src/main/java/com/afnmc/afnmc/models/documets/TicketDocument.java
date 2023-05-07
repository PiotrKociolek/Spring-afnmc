package com.afnmc.afnmc.models.documets;

import com.afnmc.afnmc.models.flags.CheckInPriority;
import com.afnmc.afnmc.models.flags.LuggageType;
import com.afnmc.afnmc.models.flags.TicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tickets")
public class TicketDocument {
    @Id
    private String id;
    private String userId;
    private Float ticketPrice;
    private String flightId;
    private String aircraftId;
    private Integer seatNumber;
    private Integer premiumSeat;
    private LuggageType luggageType;
    private TicketType ticketType;
    private CheckInPriority checkingPriority;
}
