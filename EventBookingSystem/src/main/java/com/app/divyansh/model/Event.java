package com.app.divyansh.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(access=Access.READ_ONLY)
    @Column(name="eid")
	private Long idPk;
	@Column(name="etitle")
	private String titleForEvent;
	@Column(name="edescription")
	private String descriptionForEvent;
	@Column(name="elocation")
	private String locationForEvent;
	@Column(name="eTotalSeats")
	private Integer totalSeatsForEvent;
	@Column(name="eRemainingSeats")
	private Integer remainingSeatsForEvents;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private ZonedDateTime eventLaunchAt;
	@PrePersist
	public void prePersist() {
		if (eventLaunchAt == null) {
	        eventLaunchAt = ZonedDateTime.now();
	    }
	    if (remainingSeatsForEvents == null) {
	        remainingSeatsForEvents = totalSeatsForEvent;
	    }
	}
}
