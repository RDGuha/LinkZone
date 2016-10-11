package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.ForumPost;

@Repository(value="forumPostDAO")
public class ForumPostDAOImpl implements ForumPostDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumPostDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(ForumPost forumpost) {
		sessionFactory.getCurrentSession().saveOrUpdate(forumpost);		
	}

	@Transactional
	public void delete(String forumpost_id) {
		ForumPost forumPostToDelete = new ForumPost();
		forumPostToDelete.setForumpostid(forumpost_id);
		sessionFactory.getCurrentSession().delete(forumPostToDelete);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ForumPost getPost(String forumpost_id) {
		String hql = "from ForumPost where forumpost_id=" + "'" + forumpost_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPost> gotForumPost = query.list();
		if(gotForumPost!=null&&!gotForumPost.isEmpty())
			return gotForumPost.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ForumPost> list() {
		String hql = "from ForumPost";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPost> listOfForumPost = query.list();
		return listOfForumPost;
	}
	

}
