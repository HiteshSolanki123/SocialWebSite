package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.BlogComment;
@Repository("blogCommentsDAO")
public class BlogCommentsDaoImpl implements BlogCommentsDao {
	@Autowired
	SessionFactory sessionFactory;
	public BlogCommentsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveBlogComments(BlogComment blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised"+e);
		}
		return false;
	}
	@Transactional
	public boolean deleteBlogComments(BlogComment blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public boolean updateBlogComments(BlogComment blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public BlogComment getBlogComments(int blogCommentsId) {

		Session session = sessionFactory.openSession();
		BlogComment blogComments = (BlogComment) session.get(BlogComment.class, new Integer(blogCommentsId));
		return blogComments;

	}
	@Transactional
	public List<BlogComment> getAllBlogComments() {

		return sessionFactory.getCurrentSession().createQuery("from BlogComments").list();
	}

}
