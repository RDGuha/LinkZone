package com.niit.backend.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class JobOpportunity {
	@Id
	private String jobOpportunityId;
	private String content;
	private Timestamp postedAt;
	private Timestamp modifiedAt;

	public String getJobOpportunityId() {
		return jobOpportunityId;
	}

	public void setJobOpportunityId(String jobOpportunityId) {
		this.jobOpportunityId = jobOpportunityId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Timestamp postedAt) {
		this.postedAt = postedAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
