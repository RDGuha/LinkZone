package com.niit.backend.model;

import com.niit.backend.entity.Blog;

public class BlogAdminModel {

	private Blog blog;
	private String email;
	private String name;
	private String role;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "BlogAdminModel [blog=" + blog + ", email=" + email + ", name=" + name + ", role=" + role + "]";
	}
	
	
	

}
