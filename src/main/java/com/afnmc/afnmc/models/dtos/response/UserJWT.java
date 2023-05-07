package com.afnmc.afnmc.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJWT {
    private String id;
    private String email;
    private Instant expirationDate;
}
