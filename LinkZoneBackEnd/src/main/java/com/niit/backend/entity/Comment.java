package com.niit.backend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2606370369553591529L;

	@Id
	private String id;
	@Column(name = "user_id")
	private String userId;
	private String comment;
	private Date commentedAt;
			
	public Comment() {
		this.id = "CMT" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommentedAt() {
		return commentedAt;
	}
	public void setCommentedAt(Date commentedAt) {
		this.commentedAt = commentedAt;
	}

	/*
	 * Use of mapping to blog
	 * */
	
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
	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", comment=" + comment + ", commentedAt=" + commentedAt
				+ "]";
	}
	
	//==========================
	
	

	
	
}
