package com.niit.collaboration.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

@RestController
public class EventController {

	@Autowired
	EventDAO eventDAO;

	@Autowired
	Event event;

	@GetMapping("/events")
	public ResponseEntity<List<Event>> listAllEvents() {
		List<Event> eventlist = eventDAO.list();
		if (eventlist.isEmpty()) {
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		} // You many decide to return HttpStatus.NOT_FOUND
		return new ResponseEntity<List<Event>>(eventlist, HttpStatus.OK);
	}

	@PostMapping(value = "/events")
	public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Event " + event.getEvent_title());

		if (eventDAO.isEventExist(event)) {
			System.out.println("A Event with name " + event.getEvent_title() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		event.setEventid("EVT" + UUID.randomUUID().toString().substring(30).toUpperCase());
		event.setEvent_created(new Date());
		eventDAO.saveOrUpdate(event);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/events/{eventid}").buildAndExpand(event.getEventid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping(value = "/events/{event_id}")
	public ResponseEntity<Event> updateUser(@PathVariable("event_id") String event_id, @RequestBody Event event) {
		System.out.println("Updating event " + event_id);

		Event currentEvent = eventDAO.getEvent(event_id);

		if (currentEvent == null) {
			System.out.println("event with id " + event_id + " not found");
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		currentEvent.setEvent_title(event.getEvent_title());
		currentEvent.setEvent_description(event.getEvent_description());
		currentEvent.setEvent_created(new Date());

		eventDAO.saveOrUpdate(currentEvent);
		return new ResponseEntity<Event>(currentEvent, HttpStatus.OK);
	}

	@DeleteMapping(value = "/events/{event_id}")
	public ResponseEntity<Event> deleteUser(@PathVariable("event_id") String event_id) {
		System.out.println("Fetching & Deleting event with event_id " + event_id);

		Event event = eventDAO.getEvent(event_id);
		if (event == null) {
			System.out.println("Unable to delete. Event with event_id " + event_id + " not found");
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}

		eventDAO.deleteEvent(event_id);
		return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
	}

}
