package com.afnmc.afnmc.models.dtos.request;

import com.afnmc.afnmc.models.flags.CheckInPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetCheckInPriorityDto {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    private CheckInPriority checkInPriority;
}
