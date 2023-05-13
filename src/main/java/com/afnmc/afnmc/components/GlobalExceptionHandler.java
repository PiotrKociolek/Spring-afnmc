package com.afnmc.afnmc.components;

import com.afnmc.afnmc.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = PasswordDoesNotMatchException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public void handlePasswordDoesNotMatchException() {
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public void handleUSerAlreadyExistException() {
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleUserNotFoundException() {
    }

    @ExceptionHandler(value = FlightNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleFLightNotFoundException() {
    }

    @ExceptionHandler(value = InvalidTicketIdException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleInvalidTicketIdException() {
    }

    @ExceptionHandler(value = InvalidCheckInPriorityException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleInvalidCheckInPriorityException() {
    }

    @ExceptionHandler(value = InvalidLuggageTypeException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleInvalidLuggageTypeException() {
    }

    @ExceptionHandler(value = AirportNotFoundByIdException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleAirportNotFoundByIdException() {
    }

    @ExceptionHandler(value = DocumentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleDocumentNotFoundException() {
    }
}
