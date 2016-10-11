package com.niit.collaboration.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Event {
	@Id
	private String eventid;
	private String userid;
	private String event_title;
	private String event_description;
	private Date event_created;
	public String getUserid() {
		return userid;
	}
	public Date getEvent_created() {
		return event_created;
	}
	public void setEvent_created(Date event_created) {
		this.event_created = event_created;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUsername(String userid) {
		this.userid = userid;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_description() {
		return event_description;
	}
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	public Event(){
		this.setEventid("E" + UUID.randomUUID().toString().substring(24).toUpperCase());
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
}