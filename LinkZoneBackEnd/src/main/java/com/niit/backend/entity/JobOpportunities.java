package com.niit.backend.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="Job")
public class JobOpportunities {
	@Id
private String jobOportunities_id;
private String title;
private String description;
private Date createdAt;
public String getJobOportunities_id() {
	return jobOportunities_id;
}
public void setJobOportunities_id(String jobOportunities_id) {
	this.jobOportunities_id = jobOportunities_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public JobOpportunities(){
	this.jobOportunities_id="JOB"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
