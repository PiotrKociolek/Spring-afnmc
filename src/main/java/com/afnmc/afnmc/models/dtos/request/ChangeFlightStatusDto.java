package com.afnmc.afnmc.models.dtos.request;

import com.afnmc.afnmc.models.flags.FlightStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeFlightStatusDto {
  @Id
  @NotNull
  @NotBlank
  private String id;
  @NotNull
  private FlightStatus flightStatus;

}
