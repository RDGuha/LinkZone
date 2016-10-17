package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.BlogComment;



public interface BlogCommentDAO {

	void saveOrUpdateBlogComment(BlogComment blogComment);

	void deleteBlogComment(String blogCommentId);

	BlogComment getBlogComment(String blogCommentId);

	List<BlogComment> listBlogComments();
	
	List<BlogComment> listBlogByCreatedAt(String blogId);
}
