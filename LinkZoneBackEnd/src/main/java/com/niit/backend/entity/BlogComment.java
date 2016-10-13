package com.niit.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name ="BlogComment")
@Component
public class BlogComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String blogComment_id;
	private String description;
	private String userDetails_id;
	private Date com_createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blog_id" , nullable = false)
	@JsonBackReference
	private Blog blog;
	public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}


	
	
	public String getBlogComment_id() {
		return blogComment_id;
	}


	public void setBlogComment_id(String blogComment_id) {
		this.blogComment_id = blogComment_id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUserDetails_id() {
		return userDetails_id;
	}


	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
	}


	public Date getCom_createdAt() {
		return com_createdAt;
	}


	public void setCom_createdAt(Date com_createdAt) {
		this.com_createdAt = com_createdAt;
	}


	
	

	public BlogComment() {
		this.blogComment_id = "BLCMT"+ UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	

	
	
}
