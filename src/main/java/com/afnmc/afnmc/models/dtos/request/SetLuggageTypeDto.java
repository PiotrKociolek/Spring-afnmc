package com.afnmc.afnmc.models.dtos.request;

import com.afnmc.afnmc.models.flags.LuggageType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetLuggageTypeDto {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    private LuggageType luggageType;
}
