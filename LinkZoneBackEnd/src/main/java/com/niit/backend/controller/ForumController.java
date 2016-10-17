package com.niit.backend.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.dao.ForumDAO;
import com.niit.backend.entity.Forum;
import com.niitbackend.utitlity.IdGenerator;



@RestController
@RequestMapping("/user")
public class ForumController {
	
	@Autowired 
	ForumDAO forumDAO;
	@Autowired
	Forum forum;
	
	@GetMapping("/forums/")
	public ResponseEntity<List<Forum>> listForum(){
		List<Forum> listOfForums = forumDAO.listForumByCreatedAt('A');
		//List<Forum> listOfForums = forumDAO.listForums();
		if(listOfForums==null && listOfForums.isEmpty()){
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(listOfForums,HttpStatus.OK);
	}
	
	@PostMapping("/forums/")
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum,UriComponentsBuilder ucBuilder){
		forum.setForumId(IdGenerator.generateId("FRM"));
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		forum.setCreatedAt(timestamp);
		forum.setModifiedAt(timestamp);
		forum.setStatus('P');
		//forum.setUserId("USR001");
		forumDAO.saveOrUpdateForum(forum);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ucBuilder.path("/forums/{id}").buildAndExpand(forum.getForumId()).toUri());
		return new ResponseEntity<Forum>(forum,httpHeaders,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/forums/{forumId}")
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum,@PathVariable("forumId")String forumId){
		this.forum=forumDAO.getForum(forumId);
		if(this.forum == null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		this.forum.setForumTitle(forum.getForumTitle());
		this.forum.setForumDescription(forum.getForumDescription());
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		this.forum.setModifiedAt(timestamp);
		forumDAO.saveOrUpdateForum(this.forum);
		return new ResponseEntity<Forum>(this.forum,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/forums/{forumId}")
	public ResponseEntity<Forum> deleteforum(@PathVariable("forumId")String forumId){
		if(forumDAO.getForum(forumId)==null)
		{
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		
		forumDAO.deleteForum(forumId);
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/forums/{forumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumId")String forumId){
		forum=forumDAO.getForum(forumId);
		if(forum==null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	
}
