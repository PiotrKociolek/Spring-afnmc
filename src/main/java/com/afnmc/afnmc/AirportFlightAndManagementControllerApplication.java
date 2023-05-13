package com.afnmc.afnmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class AirportFlightAndManagementControllerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AirportFlightAndManagementControllerApplication.class, args);
    }

}
