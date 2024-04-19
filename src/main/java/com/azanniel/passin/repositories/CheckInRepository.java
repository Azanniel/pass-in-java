package com.azanniel.passin.repositories;

import com.azanniel.passin.domain.checkin.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {
}
