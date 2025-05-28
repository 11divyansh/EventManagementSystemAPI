package com.app.divyansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.divyansh.model.Booking;
import com.app.divyansh.model.User;
import com.app.divyansh.service.BookingService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/event_bookings")
public class BookingController {

    @Autowired
    private BookingService bookingServiceA;

    @PostMapping("/book/{eventIdPk}")
    public ResponseEntity<?> bookEvent(@PathVariable Long eventIdPk,HttpSession session){
        User user=(User)session.getAttribute("loggedInUser");
        if(user==null)return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return bookingServiceA.bookEvent_A(eventIdPk, user);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getUserBookings_A(HttpSession session) {
        User user=(User) session.getAttribute("loggedInUser");
        if(user==null)return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.ok(bookingServiceA.getBookingsForUser_A(user));
    }
    @DeleteMapping("/byEventName/{eventNameA}")
    public ResponseEntity<Void> cancelBookingByEventName(@PathVariable String eventNameA,HttpSession session) {
        User user=(User)session.getAttribute("loggedInUser");
        if(user==null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        bookingServiceA.cancelBookingByEventName(eventNameA,user);
        return ResponseEntity.noContent().build();
    }

}