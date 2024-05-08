package com.azanniel.passin.services;

import com.azanniel.passin.domain.attendee.Attendee;
import com.azanniel.passin.domain.checkin.CheckIn;
import com.azanniel.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import com.azanniel.passin.repositories.CheckInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CheckInService {
    private final CheckInRepository checkInRepository;

    public void registerCheckInAttendee(Attendee attendee) {
        this.verifyCheckInExists(attendee.getId());

        CheckIn checkIn = new CheckIn();
        checkIn.setAttendee(attendee);
        checkIn.setCreatedAt(LocalDateTime.now());

        this.checkInRepository.save(checkIn);
    }

    public Optional<CheckIn> getCheckIn(String attendeeId) {
        return this.checkInRepository.findByAttendeeId(attendeeId);
    }

    private void verifyCheckInExists(String attendeeId) {
        Optional<CheckIn> isCheckedIn = this.getCheckIn(attendeeId);

        if(isCheckedIn.isPresent()) {
            throw new CheckInAlreadyExistsException();
        }
    }
}
