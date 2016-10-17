package com.niit.backend.dao;

import java.util.Date;
import java.util.List;

import com.niit.backend.entity.Event;



public interface EventDAO {

	void saveOrUpdateEvent(Event event);
	
	void deleteEvent(String eventId);
	
	Event getEvent(String eventId);
	
	List<Event> listEvents();
	
	List<Event> listEventByEventAt();
}
