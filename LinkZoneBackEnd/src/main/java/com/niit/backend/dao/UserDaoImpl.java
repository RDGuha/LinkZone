package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.UserDao;
import com.niit.backend.model.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Transactional
	public void editUsers(User user) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public User get(String user_id) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().get(User.class, user_id);
	}

	@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> listUsers= (List<User>) sessionFactory.getCurrentSession()
		.createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUsers;
	}

	@Transactional
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
