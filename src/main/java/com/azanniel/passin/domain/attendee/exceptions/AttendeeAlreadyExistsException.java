package com.azanniel.passin.domain.attendee.exceptions;

public class AttendeeAlreadyExistsException extends RuntimeException {
    public AttendeeAlreadyExistsException() {
        super("Attendee is already register");
    }
}
