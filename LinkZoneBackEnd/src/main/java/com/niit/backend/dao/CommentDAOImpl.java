package com.niit.backend.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.Comment;

@Repository("commentDAO")
@Transactional
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdate(Comment comment) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(comment);		
	}

}
