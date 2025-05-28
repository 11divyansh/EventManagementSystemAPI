package com.app.divyansh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.divyansh.model.Event;
import com.app.divyansh.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepositoryA;
	public Event saveEventsForThisApp(Event event123){
        return eventRepositoryA.save(event123);
    }
	 public List<Event> getAllTheEvents(){
	        return eventRepositoryA.findAll();
	 }
	    public Event updateEventsForThisApp(String titleForEvent,Event updatedNewEvent){
	    	Event event123=eventRepositoryA.findByTitleForEvent(titleForEvent)
	                .orElseThrow(()->new RuntimeException("Error occured. Event not found for this title"));
	        event123.setTitleForEvent(updatedNewEvent.getTitleForEvent());
	        event123.setDescriptionForEvent(updatedNewEvent.getDescriptionForEvent());
	        event123.setLocationForEvent(updatedNewEvent.getLocationForEvent());
	        event123.setEventLaunchAt(updatedNewEvent.getEventLaunchAt());
	        event123.setTotalSeatsForEvent(updatedNewEvent.getTotalSeatsForEvent());
	        event123.setRemainingSeatsForEvents(updatedNewEvent.getRemainingSeatsForEvents());
	        
	        return eventRepositoryA.save(event123);
	    }
	    @Transactional
	    public void deleteEventsForThisApp(String titleForEvent){
	    	eventRepositoryA.deleteByTitleForEvent(titleForEvent);
	    }
	    public List<Event> getAllEvents() {
	        return eventRepositoryA.findAll();
	    }
}
