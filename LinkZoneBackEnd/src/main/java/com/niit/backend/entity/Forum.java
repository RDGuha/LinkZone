
package com.niit.backend.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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
public class Forum {
	@Id
	private String forumId;
	private String userId;
	private String forumTitle;
	private String forumDescription;
	
	private Timestamp createdAt;
	
	private Timestamp modifiedAt;
	private char status;// Will include A,P,R as keyword for Approved,Pending
						// and Rejected respectively

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "forum")
	@JsonManagedReference
	private Set<ForumPost> forumPosts = new HashSet<>();

	public Set<ForumPost> getForumPosts() {
		return forumPosts;
	}

	public void setForumPosts(Set<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public String getForumDescription() {
		return forumDescription;
	}

	public void setForumDescription(String forumDescription) {
		this.forumDescription = forumDescription;
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Forum [forumId=" + forumId + ", userId=" + userId + ", forumTitle=" + forumTitle + ", forumDescription="
				+ forumDescription + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", status=" + status
				+ ", forumPosts=" + forumPosts + "]";
	}
	
	

}
