package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ForumPost;

public interface ForumPostDAO {
	
	void saveOrUpdate(ForumPost forumpost);
	
	void delete(String forumpost_id);
	
	ForumPost getPost(String forumpost_id);
	
	List<ForumPost> list();
	
}
