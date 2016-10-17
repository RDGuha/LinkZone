package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.ForumPost;



public interface ForumPostDAO {

	void saveOrUpdateForumPost(ForumPost forumPost);
	
	void deleteForumPost(String forumPostId);
	
	ForumPost getForumPost(String forumPostId);
	
	List<ForumPost> listForumPosts();
}
