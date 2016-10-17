package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.ForumPostComment;



public interface ForumPostCommentDAO {

	void saveOrUpdateForumPostComment(ForumPostComment forumPostComment);

	void deleteForumPostComment(String forumPostCommentId);

	ForumPostComment getForumPostComment(String forumPostCommentId);

	List<ForumPostComment> listForumPostComments();
}
