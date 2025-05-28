package com.app.divyansh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.divyansh.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	Optional<Event> findByTitleForEvent(String titleForEvent);
	void deleteByTitleForEvent(String titleForEvent);
}
