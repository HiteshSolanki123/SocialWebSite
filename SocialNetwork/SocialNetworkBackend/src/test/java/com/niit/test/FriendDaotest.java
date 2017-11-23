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
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		friendDAO = (FriendDao) annotationConfigApplicationContext.getBean("friendDAO");
	}
	@Ignore
	@Test
	public void saveFriend() {
		Friend friend=new Friend();
		friend.setStatus("friends");
		friend.setFriendId(1);
		friend.setUserId(1);
		assertTrue("problem in friend",friendDAO.saveFriend(friend));		
	}
	@Ignore
	@Test
	public void deleteFriend()
	{
		Friend friend=(Friend)friendDAO.getFriend(1);
		assertTrue("problem in deleting ",friendDAO.deleteFriend(friend));
	}
	@Ignore
	@Test
	public void updateFriend()
	{
		Friend friend=(Friend)friendDAO.getFriend(2);
		friend.setStatus("unfriend");
		assertTrue("problem in updating",friendDAO.updateFriend(friend));
	}
	@Ignore
	@Test
	public void getAllFriend()
	{
		List<Friend> friendList = (List<Friend>) friendDAO.getAllFriend();
		assertNotNull("blog is null", friendList.get(0));
		for (Friend friend : friendList) {
			System.out.println("Friend is" + friend.getStatus());
		}
	}
	@Test
	public void getFriendId()
	{
		Friend friend=(Friend)friendDAO.getFriend(2);
		assertNotNull("error",friend);
		System.out.println("friend status::::"+friend.getStatus());
	}
}
