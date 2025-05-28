package com.app.divyansh.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPk;
    @ManyToOne
    private User userType;
    @ManyToOne
    private Event eventType;
    private LocalDateTime bookingTimeForEvent;
    @PrePersist
    public void setBookingTime() {
        bookingTimeForEvent = LocalDateTime.now();
    }
}