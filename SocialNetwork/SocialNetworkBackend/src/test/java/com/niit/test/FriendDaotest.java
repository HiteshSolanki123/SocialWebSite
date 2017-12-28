/*package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.FriendsDao;
import com.niit.SocialNetworkBackend.Model.Friend;
import com.niit.SocialNetworkBackend.Model.Friends;

public class FriendDaotest {
	static FriendsDao friendsDAO;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		friendsDAO = (FriendsDao) annotationConfigApplicationContext.getBean("friendsDAO");
	}

	@Ignore
	@Test
	public void saveFriend() {
		Friends friend = new Friends();
		friend.setStatus("R");
		friend.setFriendId(1);
		friend.setFriendname("hitesh");
		friend.setUsername("sunny");
		assertTrue("problem in friend", friendsDAO.createFriend(friend));
	}

	
	@Test
	public void getAllFriendRequest() {
		List<Friends> listFriends = friendsDAO.getAllFriendRequest("hitesh");
		assertNotNull("problem in list friends", listFriends);
		for (Friends friend : listFriends) {
			System.out.println("current username:::" + friend.getUsername());
			System.out.println("friend name::::" + friend.getFriendname());
			System.out.println("status::::" + friend.getStatus());
		}

	}

	@Ignore
	@Test
	public void getFriendId() {
		Friends friend = (Friends) friendsDAO.getFriend(3);
		assertNotNull("error", friend);
		System.out.println("friend status::::" + friend.getStatus());
	}
	@Ignore
	@Test
	public void getAllApprovedFriendTest() {
		List<Friends> listFriends = friendsDAO.getApprovedFriends("hitesh");
		assertNotNull("problem in listFriends", listFriends);
		for (Friends friend : listFriends) {
			System.out.println("current user name:::" + friend.getUsername());
			System.out.println("current friend name:" + friend.getFriendname());
			System.out.println("status:::" + friend.getStatus());
		}
	}
	@Ignore
	@Test
	public void approveFriendRequest()
	{
		Friends friend=friendsDAO.getFriend(5);
		assertTrue("problem in approving",friendsDAO.approveFriendRequest(friend));
	}
	@Ignore
	@Test
	public void rejectFriendRequest()
	{
		Friends friend=friendsDAO.getFriend(5);
		assertTrue("problem in approving",friendsDAO.rejectFriendRequest(friend));
	}
}
*/