package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Forum;

public interface ForumDAO {
	
	void saveOrUpdateForum(Forum forum);
	
	void delete(String forum_id);
	
	Forum getForum(String forum_id);
	
	List<Forum> list();
	
}
