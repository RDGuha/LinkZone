package com.niit.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.Blog;
import com.niit.backend.model.BlogListModel;

@Repository ("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
		
	@Override
	public Blog find(String id) {		
		return this.sessionFactory.getCurrentSession().get(Blog.class, id);
	}

	@Override
	public List<BlogListModel> findAll() {
		String queryStr = "SELECT NEW com.niit.backend.model.BlogListModel("
				+ "b.id, b.title, b.content, b.createdAt, count(c)"
				+ ")"
				+ " FROM Blog as b LEFT JOIN b.comments as c"
				+ " GROUP BY b.id"
				+ " ORDER BY b.createdAt";
//		Session session = this.sessionFactory.getCurrentSession();
//		Criteria crit = session.createCriteria(Blog.class);
//		ProjectionList projList = Projections.projectionList();
//		projList.add(Projections.property("title"),"title");
//		projList.add(Projections.property("createdAt"), "createdAt");
//		projList.add(Projections.property("content"), "content");
//		crit.setResultTransformer(Transformers.aliasToBean(Blog.class));
//		crit.addOrder(Order.asc("createdAt"));
//		List<Blog> results = crit.list();
//		return results;
		return this.sessionFactory.getCurrentSession().createQuery(queryStr).list();
		
	}

	@Override
	public void saveOrUpdate(Blog blog) {		
		this.sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
