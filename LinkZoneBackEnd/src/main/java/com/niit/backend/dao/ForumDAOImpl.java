package com.niit.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.Forum;



@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {
	@Autowired
	SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateForum(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);

	}

	@Transactional
	public void deleteForum(String forumId) {
		Forum forumToDelete = new Forum();
		forumToDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(forumToDelete);
	}

	@Transactional
	public Forum getForum(String forumId) {
		String hql = "from Forum where forumId=:forumId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("forumId", forumId);
		List<Forum> gotForum = query.getResultList();
		if (gotForum != null && !gotForum.isEmpty())
			return gotForum.get(0);
		return null;
	}

	@Transactional
	public List<Forum> listForums() {
		String hql = "from Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listOfForums = query.getResultList();
		return listOfForums;
	}
	
	@Transactional
	public List<Forum> listForumByCreatedAt(char status){
		String hql = "from Forum where status=:status order by createdAt desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("status", status);
		List<Forum> listOfForums = query.getResultList();
		return listOfForums;
	}
	

}
