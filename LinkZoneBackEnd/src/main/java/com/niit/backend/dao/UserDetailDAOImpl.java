package com.niit.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.UserDetail;



@Repository("userDetailDAO")
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDetailDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateUserDetail(UserDetail userDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetail);

	}

	@Transactional
	public void deleteUserDetail(String userId) {
		UserDetail userDetailToDelete = new UserDetail();
		userDetailToDelete.setUserId(userId);
		sessionFactory.getCurrentSession().delete(userDetailToDelete);

	}

	@Transactional
	public UserDetail getUserDetail(String userId) {
		String hql = "from UserDetail where userId=:userId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId);
		List<UserDetail> gotUserDetail = query.getResultList();
		if (gotUserDetail != null && !gotUserDetail.isEmpty())
			return gotUserDetail.get(0);
		return null;
	}

	@Transactional
	public List<UserDetail> listUserDetails() {
		String hql = "from UserDetail";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetail> listOfUserDetails = query.getResultList();
		return listOfUserDetails;
	}

	@Transactional
	public UserDetail getUserByEmail(String email) {
		String hql = "from UserDetail where email=:email";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("email", email);
		List<UserDetail> gotUserDetail = query.getResultList();
		if (gotUserDetail != null && !gotUserDetail.isEmpty())
			return gotUserDetail.get(0);
		return null;
		
	}

	@Transactional
	public UserDetail checkUser(String email, String password) {
		String hql = "from UserDetail where email=:email and password=:password";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("email", email).setParameter("password", password);
		List<UserDetail> gotUserDetail = query.getResultList();
		if (gotUserDetail != null && !gotUserDetail.isEmpty())
			return gotUserDetail.get(0);
		return null;
	}

}
