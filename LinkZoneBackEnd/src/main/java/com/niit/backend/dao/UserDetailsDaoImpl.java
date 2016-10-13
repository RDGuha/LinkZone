package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.UserDetailsDao;
import com.niit.backend.model.UserDetails;
@Repository("userDetailsDao")
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}
	@Override
	public void saveOrUpdate(UserDetails userDetails) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
	}

	@Override
	public UserDetails get(String userDetails_id) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().get(UserDetails.class, userDetails_id);
	}

	@Override
	public List<UserDetails> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails= (List<UserDetails>) sessionFactory.getCurrentSession()
		.createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserDetails;
		
	}

	@Override
	public UserDetails getUserDetailsByUserName(String email) {
		// TODO Auto-generated method stub
		String hql = "from UserDetails where email=" + "'" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> listOfUserDetails = query.getResultList();
		if (listOfUserDetails != null && !listOfUserDetails.isEmpty()){
			return  listOfUserDetails.get(0);
		}
			
		
		return null;
	}
	@Override
	public List<UserDetails> listAllUserDetails() {
		// TODO Auto-generated method stub
		List<UserDetails> listUserDetails= (List<UserDetails>) sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				return listUserDetails;
	}
	@Override
	public boolean isUserDetailsExist(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return getUserDetailsByUserName(userDetails.getEmail())!=null;
	}
	@Override
	public UserDetails checkUser(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from UserDetails where email=" + "'" + username + "'and password=" + "'" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> listOfUserDetails = query.getResultList();
		if (listOfUserDetails != null && !listOfUserDetails.isEmpty()){
			return  listOfUserDetails.get(0);
		}
			
		return null;
	}

}
