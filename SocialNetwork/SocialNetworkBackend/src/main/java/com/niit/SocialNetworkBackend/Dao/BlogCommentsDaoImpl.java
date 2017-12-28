package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.UserBlogComments;

 @Repository("blogCommentsDAO")
public class BlogCommentsDaoImpl implements BlogCommentsDao {
	@Autowired
	SessionFactory sessionFactory;
	public BlogCommentsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveBlogComments(UserBlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised"+e);
		}
		return false;
	}
	@Transactional
	public boolean deleteBlogComments(UserBlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public boolean updateBlogComments(UserBlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public UserBlogComments getBlogComments(int blogCommentsId) {

		Session session = sessionFactory.openSession();
		UserBlogComments blogComments = (UserBlogComments) session.get(UserBlogComments.class, new Integer(blogCommentsId));
		return blogComments;

	}
	@Transactional
	public List<UserBlogComments> getAllBlogComments() {

		return sessionFactory.getCurrentSession().createQuery("from BlogComments").list();
	}

}
