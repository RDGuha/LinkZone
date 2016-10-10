package com.niit.backend.application;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.BlogDAO;
import com.niit.backend.dao.CommentDAO;
import com.niit.backend.entity.Blog;
import com.niit.backend.entity.Comment;

public class BlogTest {
 
	public static void main(String...args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		// get the blogDAO
		BlogDAO blogDAO = (BlogDAO)context.getBean("blogDAO");
		
		// get the commentDAO
		CommentDAO commentDAO = (CommentDAO)context.getBean("commentDAO");
		
		// create a new instance of blog
		Blog blog = new Blog();		
		blog.setTitle("This is a new blog!");
		blog.setContent("This is my first blog");
		blog.setCreatedAt(new Date());
		blog.setStatus("APPROVED");
		blog.setUserId("USR001");	
		
		blogDAO.saveOrUpdate(blog);		
		
		Comment comment = new Comment();		
		comment.setUserId("USR002");
		comment.setComment("This is comment to blog one");
		comment.setCommentedAt(new Date());
		
		comment.setBlog(blog);		
		
		commentDAO.saveOrUpdate(comment);
		
		comment = new Comment();		
		comment.setUserId("USR003");
		comment.setComment(" Some comment for blog one");
		comment.setCommentedAt(new Date());
		comment.setBlog(blog);		
		commentDAO.saveOrUpdate(comment);
		
		blog = new Blog();		
		blog.setTitle("This is my second blog!");
		blog.setContent("This is my second blog.");
		blog.setCreatedAt(new Date());
		blog.setStatus("APPROVED");
		blog.setUserId("USR002");	
		blogDAO.saveOrUpdate(blog);
		
		
		context.close();		
	}
	
}
