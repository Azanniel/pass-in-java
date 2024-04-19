package com.azanniel.passin.repositories;

import com.azanniel.passin.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
