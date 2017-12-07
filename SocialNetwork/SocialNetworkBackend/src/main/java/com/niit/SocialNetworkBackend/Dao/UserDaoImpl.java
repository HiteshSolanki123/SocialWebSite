package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
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

	@Transactional
	@Override
	public User getByEmail(String email) {
		
		return (User)sessionFactory.getCurrentSession().get(User.class, email);
	}

	@Transactional
	@Override
	public boolean updateOnlineStatus(String status, User user) {
		try
		{
			user.setIsOnline(status);
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e)
		{
			System.out.println("exception arised"+e);
			return false;
		}
	
	}


	@Override
	public boolean checkLogin(User user) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User where email=:email and password=:paswrd");
			query.setParameter("email",user.getEmail());
			query.setParameter("paswrd",user.getPassword());
			User user1=(User)query.list().get(0);
			if(user1==null)
				return false;
			else
				return true;
		}catch(Exception e)
		{
			return false;
		}
	}

}
