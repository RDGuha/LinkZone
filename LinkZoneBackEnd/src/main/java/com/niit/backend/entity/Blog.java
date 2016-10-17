package com.niit.backend.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
public class Blog implements Serializable {
	/**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;*/

	@Id
	private String blogId;
	private String blogName;
	private String userId;
	private String blogDescription;
	
	private char status; // Will include A,P,R as keyword for Approved,Pending
							// and Rejected respectively
	
	private Timestamp createdAt;
	
	private Timestamp modifiedAt;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "blog" )
	@JsonManagedReference
	private Set<BlogComment> blogComments = new HashSet<>();

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Set<BlogComment> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(Set<BlogComment> blogComments) {
		this.blogComments = blogComments;
	}

	public Blog() {
		this.blogId = "BLG" + UUID.randomUUID().toString().substring(24).toUpperCase();

	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogName=" + blogName + ", userId=" + userId + ", blogDescription="
				+ blogDescription + ", status=" + status + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", blogComments=" + blogComments + "]";
	}

	
	
	
	
	
}
