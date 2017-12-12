package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.Friend;

@Repository("friendDAO")
public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;

	public FriendDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public boolean createFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised " + e);
			return false;
		}
	}

	@Override
	public List<Friend> getAllFriendRequest(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where username=:uname");
		query.setParameter("uname", username);
		List<Friend> listFriends = query.list();
		return listFriends;
	}

	@Override
	public List<Friend> getApprovedFriends(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where username=:uname and status='A'");
		query.setParameter("uname", username);
		List<Friend> listFriends = query.list();
		return listFriends;
	}

	@Override
	public Friend getFriend(int friendId) {
		Session session = sessionFactory.openSession();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		return friend;
	}

	@Transactional
	@Override
	public boolean rejectFriendRequest(Friend friend) {
		try {
			friend.setStatus("R");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean approveFriendRequest(Friend friend) {
		try {
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

}
