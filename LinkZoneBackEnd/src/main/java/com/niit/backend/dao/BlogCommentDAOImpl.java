package com.niit.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.entity.BlogComment;

@Repository("blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {
	@Autowired
	SessionFactory sessionFactory;

	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateBlogComment(BlogComment blogComment) {
		sessionFactory.getCurrentSession().saveOrUpdate(blogComment);

	}

	@Transactional
	public void deleteBlogComment(String blogCommentId) {
		BlogComment blogCommentToDelete = new BlogComment();
		blogCommentToDelete.setBlogCommentId(blogCommentId);
		sessionFactory.getCurrentSession().delete(blogCommentToDelete);

	}

	@Transactional
	public BlogComment getBlogComment(String blogCommentId) {
		String hql = "from BlogComment where blogCommentId=:blogCommentId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("blogCommentId", blogCommentId);
		List<BlogComment> gotBlogComment = query.getResultList();
		if (gotBlogComment != null && !gotBlogComment.isEmpty())
			return gotBlogComment.get(0);
		return null;
	}

	@Transactional
	public List<BlogComment> listBlogComments() {
		String hql = "from BlogComment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogComment> listOfBlogComments = query.getResultList();
		return listOfBlogComments;
	}

	@Transactional
	public List<BlogComment> listBlogByCreatedAt(String blogId) {
		String hql = "from BlogComment where blog.blogId=:blogId ORDER BY commentedAt DESC ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("blogId", blogId);
		List<BlogComment> listOfBlogComments = query.getResultList();
		return listOfBlogComments;
	}

}
