package com.azanniel.passin.services;

import com.azanniel.passin.domain.attendee.Attendee;
import com.azanniel.passin.domain.event.Event;
import com.azanniel.passin.dto.event.EventResponseDTO;
import com.azanniel.passin.repositories.AttendeeRepository;
import com.azanniel.passin.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventResponseDTO getEventDetails(String eventId) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);

        return new EventResponseDTO(event, attendeeList.size());
    }
}
