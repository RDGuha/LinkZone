package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.Blog;
import com.niit.backend.model.BlogListModel;

public interface BlogDAO {
	
   Blog find(String id);
   List<BlogListModel> findAll();
   void saveOrUpdate(Blog blog);
   void delete(String id);
	
/*	public abstract Blog find(String id);
	public abstract List<Blog> findAll();
	public abstract void saveOrUpdate(Blog blog);
	public abstract void delete(String id);*/
}
