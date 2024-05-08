package com.azanniel.passin.config;

import com.azanniel.passin.domain.attendee.exceptions.AttendeeAlreadyExistsException;
import com.azanniel.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import com.azanniel.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.azanniel.passin.domain.event.exceptions.EventIsFullException;
import com.azanniel.passin.domain.event.exceptions.EventNotFoundException;
import com.azanniel.passin.dto.general.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyExistsException.class)
    public ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity handleCheckInAlreadyExists(CheckInAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(EventIsFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEventIsFull(EventIsFullException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }
}
