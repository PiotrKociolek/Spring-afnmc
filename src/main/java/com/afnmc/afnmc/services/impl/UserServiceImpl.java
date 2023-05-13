package com.afnmc.afnmc.services.impl;

import com.afnmc.afnmc.components.PasswordEncoder;
import com.afnmc.afnmc.exceptions.PasswordDoesNotMatchException;
import com.afnmc.afnmc.exceptions.UserAlreadyExistException;
import com.afnmc.afnmc.exceptions.UserNotFoundException;
import com.afnmc.afnmc.models.documets.UserDocument;
import com.afnmc.afnmc.models.dtos.request.UserRequestDto;
import com.afnmc.afnmc.models.dtos.response.UserJWT;
import com.afnmc.afnmc.models.dtos.response.UserLoginResponseDto;
import com.afnmc.afnmc.repositories.UserRepository;
import com.afnmc.afnmc.services.UserService;
import com.afnmc.afnmc.utilities.jwt.JwtTokenEncoder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenEncoder tokenEncoder;

    @Override
    public void registerUser(@Valid final UserRequestDto userRequestDto) {
        final UserDocument userDocument = modelMapper.map(userRequestDto, UserDocument.class);
        userDocument.setId(null);
        userDocument.setPassword(passwordEncoder.encryptPassword(userRequestDto.getPassword()));
        userRepository
                .findByEmail(userRequestDto.getEmail())
                .ifPresentOrElse(
                        x -> {
                            throw new UserAlreadyExistException();
                        },
                        () -> userRepository.save(userDocument));
    }

    @Override
    public UserLoginResponseDto loginUser(final String email, final String password) {
        return userRepository.findByEmail(email)
                .map(x -> loginUserAndReturnBearerToken(x, password))
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteUser(final String id) {
        userRepository.findById(id)
                .ifPresentOrElse(userRepository::delete, UserNotFoundException::new);

    }

    private UserLoginResponseDto loginUserAndReturnBearerToken(final UserDocument document, final String password) {
        if (!passwordEncoder.matchPassword(document.getPassword(), password))
            throw new PasswordDoesNotMatchException();

        final UserJWT jwt = new UserJWT();
        jwt.setId(document.getId());
        jwt.setEmail(document.getEmail());

        final String encodedJwt = tokenEncoder.generateBearerJwtTokenFromModel(jwt);
        final UserLoginResponseDto responseObject = new UserLoginResponseDto();
        responseObject.setEmail(document.getEmail());
        responseObject.setToken(encodedJwt);

        return responseObject;
    }
}
