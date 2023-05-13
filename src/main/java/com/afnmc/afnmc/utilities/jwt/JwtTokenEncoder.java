package com.afnmc.afnmc.utilities.jwt;

import com.afnmc.afnmc.models.dtos.response.UserJWT;

public interface JwtTokenEncoder {

    boolean isTokenValid(String bearerTokenString);

    UserJWT getTokenModel(final String bearerTokenString);

    String generateBearerJwtTokenFromModel(UserJWT jwtToken);
}
