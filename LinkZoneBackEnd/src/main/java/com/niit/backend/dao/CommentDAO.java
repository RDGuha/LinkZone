package com.niit.backend.dao;

import com.niit.backend.entity.Comment;

public interface CommentDAO {
	void saveOrUpdate(Comment comment);
}

