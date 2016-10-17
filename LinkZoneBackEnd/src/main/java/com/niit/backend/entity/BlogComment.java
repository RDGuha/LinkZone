package com.niit.backend.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
public class BlogComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String blogCommentId;
	private String userId;
	private String blogCommentContent;
	
	private Timestamp commentedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blogId", nullable = false)
	@JsonBackReference
	private Blog blog;

	public String getBlogCommentId() {
		return blogCommentId;
	}

	public void setBlogCommentId(String blogCommentId) {
		this.blogCommentId = blogCommentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBlogCommentContent() {
		return blogCommentContent;
	}

	public void setBlogCommentContent(String blogCommentContent) {
		this.blogCommentContent = blogCommentContent;
	}

	public Timestamp getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(Timestamp commentedAt) {
		this.commentedAt = commentedAt;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public BlogComment() {
		this.blogCommentId = "BLGCMT" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}

	@Override
	public String toString() {
		return "BlogComment [blogCommentId=" + blogCommentId + ", userId=" + userId + ", blogCommentContent="
				+ blogCommentContent + ", commentedAt=" + commentedAt + ", blog=" + blog + "]";
	}
	
	
}
