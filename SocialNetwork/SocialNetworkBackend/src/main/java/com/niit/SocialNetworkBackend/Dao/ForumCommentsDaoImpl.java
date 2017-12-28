package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.UserForumComments;

@Repository("forumCommentsDAO")
public class ForumCommentsDaoImpl implements ForumCommentsDao {
	@Autowired
	SessionFactory sessionFactory;
	public ForumCommentsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional
	public boolean saveForumComments(UserForumComments forumComments) {
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
	public boolean deleteForumComments(UserForumComments forumComments) {
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
	public boolean updateForumComments(UserForumComments forumComments) {
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
	public UserForumComments getForumComments(int comments) {
		Session session = sessionFactory.openSession();
		UserForumComments forumComments = (UserForumComments) session.get(UserForumComments.class, new Integer(comments));
		return forumComments;
		
	}
	@Transactional
	public List<UserForumComments> getAllForumComments() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from UserForumComments").list();
	}

}
