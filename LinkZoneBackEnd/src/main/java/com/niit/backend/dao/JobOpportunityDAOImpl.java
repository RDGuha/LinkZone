package com.niit.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.JobOpportunity;



public class JobOpportunityDAOImpl implements JobOpportunityDAO {
	@Autowired
	SessionFactory sessionFactory;

	public JobOpportunityDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateJobOpportunity(JobOpportunity jobOpportunity) {
		sessionFactory.getCurrentSession().saveOrUpdate(jobOpportunity);

	}

	@Transactional
	public void deleteJobOpportunity(String jobOpportunityId) {
		JobOpportunity jobOpportunityToDelete = new JobOpportunity();
		jobOpportunityToDelete.setJobOpportunityId(jobOpportunityId);
		sessionFactory.getCurrentSession().delete(jobOpportunityToDelete);
	}

	@Transactional
	public JobOpportunity getJobOpportunity(String jobOpportunityId) {
		String hql = "from JobOpportunity where jobOpportunityId=:jobOpportunityId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("jobOpportunityId",
				jobOpportunityId);
		List<JobOpportunity> gotJobOpportunity = query.getResultList();
		if (gotJobOpportunity != null && !gotJobOpportunity.isEmpty())
			return gotJobOpportunity.get(0);
		return null;
	}

	@Transactional
	public List<JobOpportunity> listJobOpportunities() {
		String hql = "from JobOpportunity";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<JobOpportunity> listOfJobOpportunities = query.getResultList();
		return listOfJobOpportunities;
	}

}
