package com.azanniel.passin.repositories;

import com.azanniel.passin.domain.attendee.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendeeRepository extends JpaRepository<Attendee, String> {
    public List<Attendee> findByEventId(String eventId);
}
