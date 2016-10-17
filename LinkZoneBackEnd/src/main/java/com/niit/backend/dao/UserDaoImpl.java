package com.niit.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.Users;


@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateUser(Users user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public void deleteUser(String email) {
		Users userToDelete = new Users();
		userToDelete.setEmail(email);
		sessionFactory.getCurrentSession().delete(userToDelete);

	}

	@Transactional
	public Users getUser(String userId) {
		String hql= "from User where userId=:userId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId",userId);
		List<Users> gotUser=query.getResultList();
		if(gotUser!=null && !gotUser.isEmpty())
			return gotUser.get(0);
		return null;
	}

}
