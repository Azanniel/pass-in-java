package com.azanniel.passin.domain.attendee.exceptions;

public class AttendeeNotFoundException extends RuntimeException {
    public AttendeeNotFoundException(String attendeeId) {
        super("Attendee not found with ID: " + attendeeId);
    }
}
