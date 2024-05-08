package com.azanniel.passin.domain.checkin.exceptions;

public class CheckInAlreadyExistsException extends RuntimeException {
    public CheckInAlreadyExistsException() {
        super("Attendee already checked in");
    }
}
