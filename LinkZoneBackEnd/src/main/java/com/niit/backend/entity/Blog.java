package com.niit.backend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "blog")
public class Blog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2669625616518078597L;
	@Id
	private String id;
	private String title;
	private String content;
	@Column(name = "created_at")
	private Date createdAt;
	private String status;
	@Column(name = "user_id")
	private String userId;
	
	/*
	 * Blog Comments 
	 * */
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "blog")
	@JsonManagedReference
	private Set<Comment> comments = new HashSet<>();
	
	
	public Set<Comment> getComments() {
		return comments;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	//==============================
	

	public Blog() {
		this.id = "BLG" + UUID.randomUUID().toString().substring(24).toUpperCase();				
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt + ", status="
				+ status + ", userId=" + userId + "]";
	}
		
	
}
