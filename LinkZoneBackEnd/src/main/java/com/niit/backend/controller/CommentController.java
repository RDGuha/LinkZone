package com.niit.backend.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.dao.BlogCommentDAO;
import com.niit.backend.dao.BlogDAO;
import com.niit.backend.entity.Blog;
import com.niit.backend.entity.BlogComment;
import com.niit.backend.model.BlogModel;
import com.niitbackend.utitlity.IdGenerator;



@RestController
public class CommentController {

	@Autowired
	BlogComment blogComment;

	@Autowired
	BlogCommentDAO blogCommentDAO;
	
	@Autowired
	BlogDAO blogDAO;
	
	@Autowired
	Blog blog;



	@PostMapping("/blogcomments/")
	public ResponseEntity<BlogComment> createBlogComment(@RequestBody BlogModel blogModel,
			UriComponentsBuilder ucBuilder) {
		blogComment.setBlogCommentId(IdGenerator.generateId("BLGCOM"));
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		blogComment.setCommentedAt(timestamp);
		blogComment.setUserId(blogModel.getUserId());
		blogComment.setBlogCommentContent(blogModel.getBlogComment());
		blogComment.setBlog(blogDAO.getBlog(blogModel.getBlogId()));
		blogCommentDAO.saveOrUpdateBlogComment(blogComment);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders
				.setLocation(ucBuilder.path("/blogcomments/{blogCommentId}").buildAndExpand(blogComment.getBlogCommentId()).toUri());
		return new ResponseEntity<BlogComment>(blogComment,httpHeaders, HttpStatus.CREATED);

	}

}
