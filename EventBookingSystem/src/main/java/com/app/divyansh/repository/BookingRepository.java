package com.app.divyansh.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.divyansh.model.Booking;
import com.app.divyansh.model.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByUserType(User user);
	Optional<Booking> findByEventType_TitleForEventAndUserType_IdPk(String titleForEvent, Long userIdPk);
}
