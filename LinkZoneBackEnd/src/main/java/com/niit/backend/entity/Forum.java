package com.niit.collaboration.model;

import java.util.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
@Table
public class Forum {
	@Id
	private String forum_id;
	private String forum_title;
	private String forum_description;
	private String userid;
	private Date date_created;
	private Timestamp time_modified;
	private char status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "forum")
	@JsonManagedReference
	private Set<ForumPost> forumPosts = new HashSet<>();
	
	public Set<ForumPost> getForumPosts() {
		return forumPosts;
	}
	public void setForumPosts(Set<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}
	public String getForumtitle() {
		return forum_title;
	}
	public void setForumtitle(String title) {
		this.forum_title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date) {
		this.date_created = date;
	}
	public Timestamp getTime_modified() {
		return time_modified;
	}
	public void setTime_modified(Timestamp date_modified) {
		this.time_modified = date_modified;
	}
	
	public Forum(){
		this.setForum_id('F' + UUID.randomUUID().toString().substring(24).toUpperCase());
	}
	public String getForum_id() {
		return forum_id;
	}
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_description() {
		return forum_description;
	}
	public void setForum_description(String forum_description) {
		this.forum_description = forum_description;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
}