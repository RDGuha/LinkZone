package com.niit.backend.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.Dao.JobOpportunitiesDao;
import com.niit.backend.model.JobOpportunities;
@RestController
public class JobController {
@Autowired
JobOpportunities jobOpportunities;
@Autowired
JobOpportunitiesDao jobOpportunitiesDao;

Date date=new Date();
long time = date.getTime();
Timestamp timeStamp=new Timestamp(time);

	//------------------------------fetchAllJobOpportunities---------------------------
    @RequestMapping(value = "/jobOportunities", method = RequestMethod.GET)
 public ResponseEntity<List<JobOpportunities>> listAllBlog(){
   List<JobOpportunities> jobOpportunities = jobOpportunitiesDao.listAllJobOpportunitiess();
   if(jobOpportunities.isEmpty()){
            return new ResponseEntity<List<JobOpportunities>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<JobOpportunities>>(jobOpportunities, HttpStatus.OK);
 }
    
  //-------------------Create a JobOpportunities--------------------------------------------------------
    
    @RequestMapping(value = "/jobOportunities", method = RequestMethod.POST)
    public ResponseEntity<Void> createJobOpportunities(@RequestBody JobOpportunities jobOpportunities,UriComponentsBuilder ucBuilder) {
        System.out.println("Creating jobOpportunities " + jobOpportunities.getTitle());

        if (jobOpportunitiesDao.isJobOpportunitiesExist(jobOpportunities)) {
            System.out.println("A jobOpportunities with title " + jobOpportunities.getTitle() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            }
        
            jobOpportunities.setJobOportunities_id("FRM"+UUID.randomUUID().toString().substring(30).toUpperCase());
            jobOpportunities.setCreatedAt(timeStamp);
            jobOpportunitiesDao.saveOrUpdate(jobOpportunities);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/jobOportunities/{jobOportunities_id}").buildAndExpand(jobOpportunities.getJobOportunities_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
     
  //------------------- Update a JobOpportunities--------------------------------------------------------
    
    @RequestMapping(value = "/jobOportunities/{jobOportunities_id}", method = RequestMethod.PUT)
    public ResponseEntity<JobOpportunities> updateJobOpportunities(@PathVariable("jobOportunities_id") String jobOportunities_id, @RequestBody JobOpportunities jobOpportunities) {
        System.out.println("Updating JobOpportunities " + jobOportunities_id);
          
        
        
        JobOpportunities currentJobOpportunities=jobOpportunitiesDao.findById(jobOportunities_id);
          
        if (currentJobOpportunities==null) {
            System.out.println("jobOpportunities with jobOportunities_id " + jobOportunities_id + " not found");
            return new ResponseEntity<JobOpportunities>(HttpStatus.NOT_FOUND);
        }
        currentJobOpportunities.setCreatedAt(timeStamp);
        currentJobOpportunities.setDescription(jobOpportunities.getDescription());
        currentJobOpportunities.setTitle(jobOpportunities.getTitle());
        jobOpportunitiesDao.saveOrUpdate(currentJobOpportunities);
        return new ResponseEntity<JobOpportunities>(currentJobOpportunities, HttpStatus.OK);

    } 
    
//------------------- Delete a JobOpportunities --------------------------------------------------------
    
    @RequestMapping(value = "/jobOportunities/{jobOportunities_id}", method = RequestMethod.DELETE)
    public ResponseEntity<JobOpportunities> deleteUser(@PathVariable("jobOportunities_id") String jobOportunities_id) {
        System.out.println("Fetching & Deleting jobOpportunities with jobOportunities_id " + jobOportunities_id);

        JobOpportunities jobOpportunities = jobOpportunitiesDao.findById(jobOportunities_id);
        if (jobOpportunities == null) {
            System.out.println("Unable to delete. jobOpportunities with jobOportunities_id " + jobOportunities_id + " not found");
            return new ResponseEntity<JobOpportunities>(HttpStatus.NOT_FOUND);
        }

       jobOpportunitiesDao.deleteJobOpportunitiesById(jobOportunities_id);
        return new ResponseEntity<JobOpportunities>(HttpStatus.NO_CONTENT);
    }
      
    

}
