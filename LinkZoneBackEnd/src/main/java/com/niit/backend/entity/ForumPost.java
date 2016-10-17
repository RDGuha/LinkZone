package com.niit.backend.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.niitbackend.utitlity.IdGenerator;

@Entity
@Component
public class ForumPost {
	@Id
	private String forumPostId;
	
	private String userId;
	private String forumPostContent;
	
	private Timestamp postedAt;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="forumId",nullable=false)
	private Forum forum;
	
	
	
	
	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public String getForumPostId() {
		return forumPostId;
	}

	public void setForumPostId(String forumPostId) {
		this.forumPostId = forumPostId;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getForumPostContent() {
		return forumPostContent;
	}

	public void setForumPostContent(String forumPostContent) {
		this.forumPostContent = forumPostContent;
	}

	public Timestamp getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Timestamp postedAt) {
		this.postedAt = postedAt;
	}
	
	public ForumPost(){
		this.forumPostId=IdGenerator.generateId("FRMPOST");
	}

}
