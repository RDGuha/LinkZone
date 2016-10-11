package com.niit.collaboration.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Component
@Table
public class ForumPost {
	@Id
	private String forumpostid;
	private String userid;
	private String post_content;
	private Timestamp time_created;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="forum_id",nullable=false)
	@JsonBackReference
	private Forum forum;
	public String getForumpostid() {
		return forumpostid;
	}
	public void setForumpostid(String forumpostid) {
		this.forumpostid = forumpostid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Timestamp getTime_created() {
		return time_created;
	}
	public void setTime_created(Timestamp time_created) {
		this.time_created = time_created;
	}
	public ForumPost(){
		this.forumpostid = "FP" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
}
