package com.afnmc.afnmc.services;

import com.afnmc.afnmc.models.dtos.request.UserRequestDto;
import com.afnmc.afnmc.models.dtos.response.UserJWT;

public interface UserService {
    void registerUser(UserRequestDto userRequestDto);
    UserJWT loginUser(String email, String password);

    void deleteUser(String id);
}
