package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.JobOpportunities;

public interface JobOpportunitiesDao {

	void saveOrUpdate(JobOpportunities jobOpportunities);

	void editJobOpportunities(JobOpportunities jobOpportunities);
		
	void deleteJobOpportunities(JobOpportunities jobOpportunities);
	
	JobOpportunities get(String jobOpportunities_id);
		
		List<JobOpportunities> list();

		List<JobOpportunities> listAllJobOpportunitiess();

		boolean isJobOpportunitiesExist(JobOpportunities jobOpportunities);
		
		public JobOpportunities findByName(String title);

		JobOpportunities findById(String jobOportunities_id);

		void deleteJobOpportunitiesById(String jobOportunities_id);
}
