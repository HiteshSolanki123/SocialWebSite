package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.Blogs;

@Repository("blogDAO")
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addBlog(Blogs blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean updateBlog(Blogs blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean deleteBlog(Blogs blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public Blogs getBlog(int blogId) {
		Session session = sessionFactory.openSession();
		Blogs blog = (Blogs) session.get(Blogs.class, new Integer(blogId));
		return blog;
	}

	@Transactional
	public List<Blogs> getAllBlogs() {

		return sessionFactory.getCurrentSession().createQuery("from Blogs").list();
	}

	@Transactional
	public boolean approveBlog(Blogs blog) {
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
			return false;
		}
	}

	@Transactional
	public boolean rejectBlog(Blogs blog) {
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
			return false;
		}
	}
	@Transactional
	public boolean incrementLike(Blogs blog) {
		try {
			blog.setLikes(blog.getLikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

}
