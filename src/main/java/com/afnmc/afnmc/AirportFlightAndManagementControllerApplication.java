package com.afnmc.afnmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class  AirportFlightAndManagementControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportFlightAndManagementControllerApplication.class, args);
	}

}
//dodanie modeli, repozytoriow,seriwsow (bilety,loty)
//serwis od lotów
//flagi do lotów on time/delay/cancelled itp +