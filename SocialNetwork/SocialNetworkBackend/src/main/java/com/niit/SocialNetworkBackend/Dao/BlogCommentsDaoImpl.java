package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.BlogComments;
@Repository("blogCommentsDAO")
public class BlogCommentsDaoImpl implements BlogCommentsDao {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean saveBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised"+e);
		}
		return false;
	}
	@Transactional
	@Override
	public boolean deleteBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	@Override
	public boolean updateBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	@Override
	public BlogComments getBlogComments(int blogCommentsId) {

		Session session = sessionFactory.openSession();
		BlogComments blogComments = (BlogComments) session.get(BlogComments.class, new Integer(blogCommentsId));
		return blogComments;

	}
	@Transactional
	@Override
	public List<BlogComments> getAllBlogComments() {

		return sessionFactory.getCurrentSession().createQuery("from BlogComments").list();
	}

}
