package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.Friend;

@Repository("friendDAO")
public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	@Override
	public boolean saveFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;
	}
	@Transactional
	@Override
	public boolean deleteFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;
	}
	@Transactional
	@Override
	public boolean updateFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;
	}
	@Transactional
	@Override
	public Friend getFriend(int friendId) {
		Session session = sessionFactory.openSession();
		Friend friend = (Friend) session.get(Friend.class, new Integer(friendId));
		return friend;
		
	}
	@Transactional
	@Override
	public List<Friend> getAllFriend() {
		return sessionFactory.getCurrentSession().createQuery("from Friend").list();
	}

}
