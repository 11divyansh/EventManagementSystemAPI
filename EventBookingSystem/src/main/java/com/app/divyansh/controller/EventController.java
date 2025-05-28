package com.app.divyansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.divyansh.model.Event;
import com.app.divyansh.model.User;
import com.app.divyansh.service.EventService;
import com.app.divyansh.utility.Role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/events")
@Tag(name="Events",description="Event management operation's API for admins")
public class EventController {

	@Autowired
	private EventService eventServiceA;
	
	@PostMapping("/create")
    @Operation(summary="register events")
    public ResponseEntity<Event> registerUser(@RequestBody Event event,
    		HttpSession currSession){
		User loggedInUserCheck=(User) currSession.getAttribute("loggedInUser");
		if(loggedInUserCheck==null || loggedInUserCheck.getRoleOfTheUser()!=Role.ADMIN){
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
    	return ResponseEntity.ok(eventServiceA.saveEventsForThisApp(event));
    }
	@PutMapping("/{titleForEvent}")
    @Operation(summary="update the events")
    public ResponseEntity<Event> updateUser(@PathVariable String titleForEvent,@RequestBody Event event,
    		HttpSession currSession){
		User loggedInUserCheck=(User) currSession.getAttribute("loggedInUser");
		if(loggedInUserCheck==null || loggedInUserCheck.getRoleOfTheUser()!=Role.ADMIN){
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
        return ResponseEntity.ok(eventServiceA.updateEventsForThisApp(titleForEvent,event));
    }
    @DeleteMapping("/{titleForEvent}")
    @Operation(summary="delete the events")
    public ResponseEntity<Void> deleteUser(@PathVariable String titleForEvent,
    		HttpSession currSession){
    	
    	User loggedInUserCheck=(User) currSession.getAttribute("loggedInUser");
		if(loggedInUserCheck==null || loggedInUserCheck.getRoleOfTheUser()!=Role.ADMIN){
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
    	eventServiceA.deleteEventsForThisApp(titleForEvent);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/allevents")
    @Operation(summary="get all the events")
    public ResponseEntity<List<Event>> getAllEvents() {
    List<Event> events=eventServiceA.getAllEvents();
    return ResponseEntity.ok(events);
    }
}
