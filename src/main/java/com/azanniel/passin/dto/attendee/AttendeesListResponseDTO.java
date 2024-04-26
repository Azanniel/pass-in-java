package com.azanniel.passin.dto.attendee;

import lombok.Getter;

import java.util.List;

@Getter
public class AttendeesListResponseDTO {
    List<AttendeeDetails> attendees;
}
