package com.azanniel.passin.dto.attendee;

import java.time.LocalDateTime;

public record AttendeeDetails(
        String Id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime checkedInAt
) {}
