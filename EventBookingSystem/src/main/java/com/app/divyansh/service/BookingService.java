package com.app.divyansh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.divyansh.model.Booking;
import com.app.divyansh.model.Event;
import com.app.divyansh.model.User;
import com.app.divyansh.repository.BookingRepository;
import com.app.divyansh.repository.EventRepository;

@Service
public class BookingService {

    @Autowired
    private EventRepository eventRepositoryA;

    @Autowired
    private BookingRepository bookingRepositoryA;

    public ResponseEntity<?> bookEvent_A(Long event_Id_A, User user) {
        Optional<Event> optionalEventToBeShown= eventRepositoryA.findById(event_Id_A);
        if (optionalEventToBeShown.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
        Event eventDetails=optionalEventToBeShown.get();
        if (eventDetails.getRemainingSeatsForEvents()<=0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No seats available");
        }
        eventDetails.setRemainingSeatsForEvents(eventDetails.getRemainingSeatsForEvents()-1);
        eventRepositoryA.save(eventDetails);

        Booking booking=new Booking();
        booking.setEventType(eventDetails);
        booking.setUserType(user);
        booking.setBookingTimeForEvent(LocalDateTime.now());
        bookingRepositoryA.save(booking);
        return ResponseEntity.ok("Booking successful");
    }

    public List<Booking> getBookingsForUser_A(User user) {
        return bookingRepositoryA.findByUserType(user);
    }
    public void cancelBookingByEventName(String eventName, User user) {
        Booking booking=bookingRepositoryA.findByEventType_TitleForEventAndUserType_IdPk(eventName,user.getIdPk())
            .orElseThrow(()->new NoSuchElementException("Booking was not found for event specified: "+eventName));
        Event event = booking.getEventType();
        event.setRemainingSeatsForEvents(event.getRemainingSeatsForEvents() + 1);
        eventRepositoryA.save(event);
        bookingRepositoryA.delete(booking);
    }

}
