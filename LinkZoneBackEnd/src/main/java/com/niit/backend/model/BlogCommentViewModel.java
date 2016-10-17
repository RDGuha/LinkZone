package com.niit.backend.model;

import com.niit.backend.entity.Blog;
import com.niit.backend.entity.BlogComment;

public class BlogCommentViewModel {

	private Blog blog;
	private BlogComment blogComment;
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public BlogComment getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(BlogComment blogComment) {
		this.blogComment = blogComment;
	}
	
	
	
	
}
