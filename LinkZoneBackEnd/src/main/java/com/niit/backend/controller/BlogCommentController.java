package com.niit.backend.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.Dao.BlogCommentDao;
import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;

@RestController
public class BlogCommentController {
	@Autowired
	BlogDao blogDao;
	@Autowired
	BlogCommentDao blogCommentDao;
	 Date date=new Date();
     long time = date.getTime();
     Timestamp timeStamp=new Timestamp(time);
	
//----------------fetchall comments--------------------------
	
	@RequestMapping(value = "/blogComments", method = RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> listAllBlogComment(){
		List<BlogComment> blogComments = blogCommentDao.listAllComments();
		if(blogComments.isEmpty()){
            return new ResponseEntity<List<BlogComment>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BlogComment>>(blogComments, HttpStatus.OK);
	}
	//-------------------------------------fetchall comments--------------------------------------

	@RequestMapping(value = "/blogs/blogView/", method = RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> listAllBlogComme(){
		List<BlogComment> blogComments = blogCommentDao.listAllComments();
		if(blogComments.isEmpty()){
            return new ResponseEntity<List<BlogComment>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BlogComment>>(blogComments, HttpStatus.OK);
	}
	
	//-------------------Create a BlogComments--------------------------------------------------------
    
	  @RequestMapping(value = "/blogComments", method = RequestMethod.POST)
	  public ResponseEntity<Void> createBlogComments(@RequestBody BlogComment blogComment,Blog blog,UriComponentsBuilder ucBuilder) {
	      System.out.println("Creating BlogComments " + blogComment.getDescription());
	     blogComment.setBlogComment_id("BLG"+UUID.randomUUID().toString().substring(30).toUpperCase());
	    blogComment.setCom_createdAt(timeStamp);
	       blogComment.setUserDetails_id("USR012");
	       blogComment.setBlog(blog);
             blogCommentDao.saveOrUpdate(blogComment);
	      HttpHeaders headers = new HttpHeaders();
	      headers.setLocation(ucBuilder.path("/blogs/{blogComment_id}").buildAndExpand(blogComment.getBlogComment_id()).toUri());
	      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }

}
