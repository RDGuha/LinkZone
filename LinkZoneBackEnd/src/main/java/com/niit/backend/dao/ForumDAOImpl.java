package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Forum;

@Repository(value="forumDAO")
public class ForumDAOImpl implements ForumDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateForum(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
	}

	@Transactional
	public void delete(String forum_id) {
		Forum forumToDelete = new Forum();
		forumToDelete.setForum_id(forum_id);
		sessionFactory.getCurrentSession().delete(forumToDelete);
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Forum getForum(String forum_id) {
		String hql = "from Forum where forumId=" + "'"+ forum_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> gotForum = (List<Forum>) query.list();
		if (gotForum != null && !gotForum.isEmpty())
			return gotForum.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Forum> list() {
		String hql = "from Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Forum> listOfForums = (List<Forum>) query.list();
		return listOfForums;
	}

}
