package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.FriendDao;
import com.niit.SocialNetworkBackend.Model.Friend;
import com.niit.SocialNetworkBackend.Model.Jobs;

public class FriendDaotest {
	static FriendDao friendDAO;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		friendDAO = (FriendDao) annotationConfigApplicationContext.getBean("friendDAO");
	}

	@Ignore
	@Test
	public void saveFriend() {
		Friend friend = new Friend();
		friend.setStatus("R");
		friend.setFriendId(1);
		friend.setFriendname("hitesh");
		friend.setUsername("sunny");
		assertTrue("problem in friend", friendDAO.createFriend(friend));
	}

	@Ignore
	@Test
	public void getAllFriendRequest() {
		List<Friend> listFriends = friendDAO.getAllFriendRequest("hitesh");
		assertNotNull("problem in list friends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current username" + friend.getUsername());
			System.out.println("friend name" + friend.getFriendname());
			System.out.println("status" + friend.getStatus());
		}

	}

	@Ignore
	@Test
	public void getFriendId() {
		Friend friend = (Friend) friendDAO.getFriend(3);
		assertNotNull("error", friend);
		System.out.println("friend status::::" + friend.getStatus());
	}
	@Ignore
	@Test
	public void getAllApprovedFriendTest() {
		List<Friend> listFriends = friendDAO.getApprovedFriends("hitesh");
		assertNotNull("problem in listFriends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current user name:::" + friend.getUsername());
			System.out.println("current friend name:" + friend.getFriendname());
			System.out.println("status:::" + friend.getStatus());
		}
	}
	@Ignore
	@Test
	public void approveFriendRequest()
	{
		Friend friend=friendDAO.getFriend(5);
		assertTrue("problem in approving",friendDAO.approveFriendRequest(friend));
	}
	@Test
	public void rejectFriendRequest()
	{
		Friend friend=friendDAO.getFriend(5);
		assertTrue("problem in approving",friendDAO.rejectFriendRequest(friend));
	}
}
