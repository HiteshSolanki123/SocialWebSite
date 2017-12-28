package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.Forum;

@Repository("forumDAO")
public class ForumDaoImpl implements ForumDao {
	@Autowired
	SessionFactory sessionFactory;

	public ForumDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@Transactional
	public Forum getForum(int forumId) {
		Session session = sessionFactory.openSession();
		Forum forum = (Forum) session.get(Forum.class, new Integer(forumId));
		return forum;

	}

	@Transactional
	public List<Forum> getAllForums() {

		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}
	@Transactional
	@Override
	public boolean approveForum(Forum forum) {
		try {
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
			return false;
		}
	}
	@Transactional
	@Override
	public boolean rejectForum(Forum forum) {
		try {
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			System.out.println("exception occured" + e);
			return false;
		}
	}


}
