package com.azanniel.passin.controllers;

import com.azanniel.passin.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/{eventId}")
    public ResponseEntity<String> getEvent(@PathVariable String eventId) {
        this.eventService.getEventDetails(eventId);
        return ResponseEntity.ok("success!");
    }
}
