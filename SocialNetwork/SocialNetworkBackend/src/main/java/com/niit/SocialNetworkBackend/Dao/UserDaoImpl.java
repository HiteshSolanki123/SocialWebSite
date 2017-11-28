package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.User;
@Repository("userDAO")
@Transactional

public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<User> getAllUser() {
		String hql ="from User";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean saveUser(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;

		}
	}


	@Override
	public User getByEmail(String email) {
		
		return (User)sessionFactory.getCurrentSession().get(User.class, email);
	}

}
