package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.JobOpportunitiesDao;
import com.niit.backend.model.JobOpportunities;
@Repository("jobOpportunitiesDao")
@Transactional
public class JobOpportunitiesDaoImpl implements JobOpportunitiesDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(JobOpportunities jobOpportunities) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(jobOpportunities);

	}

	@Override
	public void editJobOpportunities(JobOpportunities jobOpportunities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteJobOpportunities(JobOpportunities jobOpportunities) {
		// TODO Auto-generated method stub

	}

	@Override
	public JobOpportunities get(String jobOpportunities_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobOpportunities> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobOpportunities> listAllJobOpportunitiess() {
		// TODO Auto-generated method stub
		String hql="from JobOpportunities";
	    Query query=sessionFactory.getCurrentSession().createQuery(hql);
	    List<JobOpportunities> listJobOpportunities=query.getResultList();
	    return listJobOpportunities;
	}

	@Override
	public boolean isJobOpportunitiesExist(JobOpportunities jobOpportunities) {
		// TODO Auto-generated method stub
		return findByName(jobOpportunities.getTitle())!=null;
	}

	@Override
	public JobOpportunities findByName(String title) {
		// TODO Auto-generated method stub
		String hql = "from JobOpportunities where title=" + "'" + title + "'";
        Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
        List<JobOpportunities> listJobOpportunities = (List<JobOpportunities>) query.getResultList();
        if (listJobOpportunities  != null && !listJobOpportunities .isEmpty()) {
            return listJobOpportunities.get(0);
        }
        return null;
	}

	@Override
	public JobOpportunities findById(String jobOportunities_id) {
		// TODO Auto-generated method stub
		String hql = "from JobOpportunities where jobOportunities_id=" + "'" + jobOportunities_id + "'";
        Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
        List<JobOpportunities> listJobOpportunities = (List<JobOpportunities>) query.getResultList();
        if (listJobOpportunities  != null && !listJobOpportunities .isEmpty()) {
            return listJobOpportunities.get(0);
        }
		return null;
	}

	@Override
	public void deleteJobOpportunitiesById(String jobOportunities_id) {
		// TODO Auto-generated method stub
		JobOpportunities jobOportunitiesToDelete = new JobOpportunities();
        jobOportunitiesToDelete.setJobOportunities_id(jobOportunities_id);
        sessionFactory.getCurrentSession().delete(jobOportunitiesToDelete);
	}

}
