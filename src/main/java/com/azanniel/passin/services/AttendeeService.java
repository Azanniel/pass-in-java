package com.azanniel.passin.services;

import com.azanniel.passin.domain.attendee.Attendee;
import com.azanniel.passin.dto.attendee.AttendeesListResponseDTO;
import com.azanniel.passin.repositories.AttendeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeService {
    private AttendeeRepository attendeeRepository;

    public List<Attendee> getAllAttendeesFromEvent(String eventId) {
        return this.attendeeRepository.findByEventId(eventId);
    }

//    public AttendeesListResponseDTO getEventsAttendee(String eventId) {
//        List<Attendee> attendeeList = this.getAllAttendeesFromEvent(eventId);
//
//    }
}
