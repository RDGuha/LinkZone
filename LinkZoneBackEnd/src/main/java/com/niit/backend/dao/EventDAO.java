package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Event;

public interface EventDAO {
	
	void saveOrUpdate(Event event);

	void deleteEvent(String event_id);

	Event getEvent(String event_id);
	
	List <Event> list();
	
	boolean isEventExist(Event event);
	
	public Event findByTitle(String eventTitle);
	
}
