package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.JobOpportunity;



public interface JobOpportunityDAO {

	void saveOrUpdateJobOpportunity(JobOpportunity jobOpportunity);
	
	void deleteJobOpportunity(String jobOpportunityId);
	
	JobOpportunity getJobOpportunity(String jobOpportunityId);
	
	List<JobOpportunity> listJobOpportunities();
}
