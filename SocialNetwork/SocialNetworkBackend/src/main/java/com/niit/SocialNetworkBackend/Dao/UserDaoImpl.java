package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.UserDetail;

@Repository("userDAO")
@Transactional

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<UserDetail> getAllUser() {
		String hql = "from UserDetail";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean saveUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;

		}
	}

	@Transactional
	public UserDetail getUser(String username) {

		return (UserDetail) sessionFactory.getCurrentSession().get(UserDetail.class, username);
	}

	@Transactional
	public boolean updateOnlineStatus(String status, UserDetail user) {
		try {
			user.setIsOnline(status);
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised:::" + e);
			return false;
		}

	}

	public boolean checkLogin(UserDetail user) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from UserDetail where username=:uname and password=:paswrd");
			query.setParameter("uname", user.getUsername());
			query.setParameter("paswrd", user.getPassword());
			UserDetail tempuser = (UserDetail) query.list().get(0);
			if (tempuser == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

}
