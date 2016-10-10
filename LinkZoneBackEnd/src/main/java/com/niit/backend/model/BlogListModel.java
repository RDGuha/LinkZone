package com.niit.backend.model;

import java.io.Serializable;
import java.util.Date;

public class BlogListModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2934578478357763402L;
	
	private String id;
	private String title;
	private String content;	
	private Date createdAt;
	private long noOfComments;

	public long getNoOfComments() {
		return noOfComments;
	}
	public void setNoOfComments(long noOfComments) {
		this.noOfComments = noOfComments;
	}
	public BlogListModel(String id, String title, String content, Date createdAt, long noOfComments) {		
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.noOfComments = noOfComments;
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
	
}
