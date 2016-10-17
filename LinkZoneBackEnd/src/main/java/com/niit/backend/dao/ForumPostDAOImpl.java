package com.niit.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.ForumPost;



@Repository("forumPostDAO")
public class ForumPostDAOImpl implements ForumPostDAO {

	@Autowired
	SessionFactory sessionFactory;

	public ForumPostDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateForumPost(ForumPost forumPost) {
		sessionFactory.getCurrentSession().saveOrUpdate(forumPost);

	}

	@Transactional
	public void deleteForumPost(String forumPostId) {
		ForumPost forumPostToDelete = new ForumPost();
		forumPostToDelete.setForumPostId(forumPostId);
		sessionFactory.getCurrentSession().delete(forumPostToDelete);
	}

	@Transactional
	public ForumPost getForumPost(String forumPostId) {
		String hql = "from ForumPost where forumPostId=:forumPostId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("forumPostId",forumPostId);
		List<ForumPost> gotForumPost = query.getResultList();
		if(gotForumPost!=null&&!gotForumPost.isEmpty())
			return gotForumPost.get(0);
		return null;
	}

	@Transactional
	public List<ForumPost> listForumPosts() {
		String hql = "from ForumPost";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPost> listOfForumPost = query.getResultList();
		return listOfForumPost;
	}

}
