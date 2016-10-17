package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.Forum;



public interface ForumDAO {

	void saveOrUpdateForum(Forum forum);

	void deleteForum(String forumId);

	Forum getForum(String forumId);

	List<Forum> listForums();
	
	List<Forum> listForumByCreatedAt(char status);
}
