package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.Blogs;
import com.niit.SocialNetworkBackend.Model.ForumComment;

@Repository("forumCommentsDAO")
public class ForumCommentsDaoImpl implements ForumCommentsDao {
	@Autowired
	SessionFactory sessionFactory;
	public ForumCommentsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public boolean saveForumComments(ForumComment forumComments) {
		{
			try {
				sessionFactory.getCurrentSession().save(forumComments);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
			}
		}
		return false;
	}

	@Transactional
	public boolean deleteForumComments(ForumComment forumComments) {
		try {
			sessionFactory.getCurrentSession().delete(forumComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public boolean updateForumComments(ForumComment forumComments) {
		try{
			sessionFactory.getCurrentSession().update(forumComments);
			return true;
		}catch(Exception e){
			System.out.println("exception arised"+e);

		}
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public ForumComment getForumComments(int fComments) {
		Session session = sessionFactory.openSession();
		ForumComment forumComments = (ForumComment) session.get(ForumComment.class, new Integer(fComments));
		return forumComments;
		
	}
	@Transactional
	public List<ForumComment> getAllForumComments() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from ForumComments").list();
	}

}
