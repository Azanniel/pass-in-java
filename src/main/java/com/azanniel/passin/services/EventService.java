package com.azanniel.passin.services;

import com.azanniel.passin.domain.attendee.Attendee;
import com.azanniel.passin.domain.event.Event;
import com.azanniel.passin.domain.event.exceptions.EventIsFullException;
import com.azanniel.passin.domain.event.exceptions.EventNotFoundException;
import com.azanniel.passin.dto.attendee.AttendeeIdDTO;
import com.azanniel.passin.dto.attendee.AttendeeRequestDTO;
import com.azanniel.passin.dto.event.EventIdDTO;
import com.azanniel.passin.dto.event.EventRequestDTO;
import com.azanniel.passin.dto.event.EventResponseDTO;
import com.azanniel.passin.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeService attendeeService;

    public EventResponseDTO getEventDetails(String eventId) {
        Event event = this.getEventById(eventId);
        List<Attendee> attendeeList = this.attendeeService.getAllAttendeesFromEvent(eventId);

        return new EventResponseDTO(event, attendeeList.size());
    }

    public EventIdDTO createEvent(EventRequestDTO eventDto) {
        Event newEvent = new Event();

        newEvent.setTitle(eventDto.title());
        newEvent.setDetails(eventDto.details());
        newEvent.setMaximumAttendees(eventDto.maximumAttendees());
        newEvent.setSlug(this.createSlug(eventDto.title()));

        this.eventRepository.save(newEvent);

        return new EventIdDTO(newEvent.getId());
    }

    public AttendeeIdDTO registerAttendeeOnEvent(String eventId, AttendeeRequestDTO attendeeRequestDTO) {
        this.attendeeService.verifyAttendeeSubscription(attendeeRequestDTO.email(), eventId);

        Event event = this.getEventById(eventId);
        List<Attendee> attendeeList = this.attendeeService.getAllAttendeesFromEvent(eventId);

        if (event.getMaximumAttendees() <= attendeeList.size()) {
            throw new EventIsFullException();
        }

        Attendee newAttendee = new Attendee();
        newAttendee.setName(attendeeRequestDTO.name());
        newAttendee.setEmail(attendeeRequestDTO.email());
        newAttendee.setEvent(event);
        newAttendee.setCreatedAt(LocalDateTime.now());

        this.attendeeService.registerAttendee(newAttendee);

        return new AttendeeIdDTO(newAttendee.getId());
    }

    private Event getEventById(String eventId) {
        return this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + eventId));
    }

    private String createSlug(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);

        return normalized
                .replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS}]", "")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("\\s+", "-")
                .toLowerCase();
    }
}
