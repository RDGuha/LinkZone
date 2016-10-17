package com.niit.backend.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ForumPostComment {
	@Id
	private String forumPostCommentId;
	private String forumPostId;
	private String forumId;
	private String userId;
	private String forumPostCommentContent;
	private Timestamp commentedAt;

	public String getForumPostCommentId() {
		return forumPostCommentId;
	}

	public void setForumPostCommentId(String forumPostCommentId) {
		this.forumPostCommentId = forumPostCommentId;
	}

	public String getForumPostId() {
		return forumPostId;
	}

	public void setForumPostId(String forumPostId) {
		this.forumPostId = forumPostId;
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

	public String getForumPostCommentContent() {
		return forumPostCommentContent;
	}

	public void setForumPostCommentContent(String forumPostCommentContent) {
		this.forumPostCommentContent = forumPostCommentContent;
	}

	public Timestamp getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(Timestamp commentedAt) {
		this.commentedAt = commentedAt;
	}

}
