package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.ForumDao;
import com.niit.SocialNetworkBackend.Model.Forum;

public class ForumDaoTest {
	static ForumDao forumDAO;
	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		forumDAO=(ForumDao) annotationConfigApplicationContext.getBean("forumDAO");
		}

	@Test
	public void addForum() {
		Forum forum=new Forum();
		forum.setForumContent("forum");
		forum.setForumId(123);
		forum.setForumName("forum");
		forum.setStatus("offline");
		forum.setUserId(123);
		assertTrue("problem in adding CartItem",forumDAO.addForum(forum));
	}

}
