package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.Blog;



public interface BlogDAO {

	void saveOrUpdateBlog(Blog blog);

	void deleteBlog(String blogId);

	Blog getBlog(String blogId);

	List<Blog> listBlogs();

	List<Blog> listBlogsByCreatedAt(char status);

//	List<Blog> listofPendingBlogs(char status);
}
