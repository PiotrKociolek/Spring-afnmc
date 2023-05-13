package com.afnmc.afnmc.services;

import com.afnmc.afnmc.models.dtos.request.UserRequestDto;
import com.afnmc.afnmc.models.dtos.response.UserLoginResponseDto;

public interface UserService {
    void registerUser(UserRequestDto userRequestDto);

    UserLoginResponseDto loginUser(String email, String password);

    void deleteUser(String id);
}
