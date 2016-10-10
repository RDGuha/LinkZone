package com.niit.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.dao.BlogDAO;
import com.niit.backend.model.BlogListModel;

@RestController
public class BlogController {
	   @Autowired
	   private BlogDAO blogDAO;  //DAO which will do all data retrieval/manipulation work
	  
	     
	    //-------------------Retrieve All Users--------------------------------------------------------
	      
	    @GetMapping(value = "/blogs")
	    public ResponseEntity<List<BlogListModel>> listAllBlogs() {
	    	
	    	// fetch all the blogs
	    	
	        List<BlogListModel> blogs = blogDAO.findAll();
	        
	        if(blogs.isEmpty()){
	            return new ResponseEntity<List<BlogListModel>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        
	        return new ResponseEntity<List<BlogListModel>>(blogs, HttpStatus.OK);
	    }
}
