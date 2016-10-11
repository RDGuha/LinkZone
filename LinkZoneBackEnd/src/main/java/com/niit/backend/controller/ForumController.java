package com.niit.collaboration.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

@RestController
public class ForumController {
	@Autowired 
	ForumDAO forumDAO;
	
	@Autowired
	Forum forum;
	
	@GetMapping("/forums")
	public ResponseEntity<List<Forum>> listForum(){
		//List<Forum> listOfForums = forumDAO.listForumByCreatedAt();
		List<Forum> listOfForums = forumDAO.list();
		if(listOfForums.isEmpty()){
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(listOfForums,HttpStatus.OK);
	}
	
	@PostMapping("/forums")
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum,UriComponentsBuilder ucBuilder){
		/*forum.setForumId(IdGenerator.generateId("FRM"));*/
		/*if (forumDAO.isForumExist(forum)) {
	          System.out.println("A forum with title " + forum.getTitle() + " already exist");
	          return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	          }*/
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		forum.setDate_created(date);
		forum.setTime_modified(timestamp);
		forum.setStatus('P');
		forum.setUserid("U001");
		forumDAO.saveOrUpdateForum(forum);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ucBuilder.path("/forums/{id}").buildAndExpand(forum.getForum_id()).toUri());
		return new ResponseEntity<Forum>(forum,httpHeaders,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/forums/{forum_id}")
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum,@PathVariable("forum_id")String forum_id){
		this.forum=forumDAO.getForum(forum_id);
		if(this.forum == null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		this.forum.setForumtitle(forum.getForumtitle());
		this.forum.setForum_description(forum.getForum_description());
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		this.forum.setTime_modified(timestamp);
		forumDAO.saveOrUpdateForum(this.forum);
		return new ResponseEntity<Forum>(this.forum,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/forums/{forum_id}")
	public ResponseEntity<Forum> deleteforum(@PathVariable("forum_id")String forum_id){
		if(forumDAO.getForum(forum_id)==null)
		{
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		
		forumDAO.delete(forum_id);
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/forums/{forum_id}")
	public ResponseEntity<Forum> getForum(@PathVariable("forum_id")String forum_id){
		forum=forumDAO.getForum(forum_id);
		if(forum==null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	
}
