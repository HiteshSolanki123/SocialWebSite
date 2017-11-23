package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.ForumCommentsDao;
import com.niit.SocialNetworkBackend.Model.ForumComments;

public class ForumCommentsTest {
	static ForumCommentsDao forumCommentsDAO;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		forumCommentsDAO = (ForumCommentsDao) annotationConfigApplicationContext.getBean("forumCommentsDAO");
	}

	@Ignore
	@Test
	public void saveForumCommentstest() {
		ForumComments forumComments = new ForumComments();
		forumComments.setComment("liked");
		forumComments.setfComment(101);
		forumComments.setForumId(102);
		forumComments.setUserId(103);
		forumComments.setUsername("comments");
		assertTrue("", forumCommentsDAO.saveForumComments(forumComments));
	}

	@Ignore
	@Test
	public void deleteForumComments() {
		ForumComments forumComments = (ForumComments) forumCommentsDAO.getForumComments(1);
		assertTrue("", forumCommentsDAO.deleteForumComments(forumComments));

	}

	@Ignore
	@Test
	public void updatesForumComment() {
		ForumComments forumComments = (ForumComments) forumCommentsDAO.getForumComments(2);
		forumComments.setComment("nice");
		forumComments.setUserId(501);
		assertTrue("forum is updated", forumCommentsDAO.updateForumComments(forumComments));
	}

	@Ignore
	@Test
	public void getAllForumComments() {
		List<ForumComments> forumCommentsList = (List<ForumComments>) forumCommentsDAO.getAllForumComments();
		assertNotNull("", forumCommentsList.get(0));
		for (ForumComments forumComments : forumCommentsList) {
			System.out.println("forumcomment:::=" + forumComments.getComment());
		}
	}

	@Test
	public void getForumComments() {
		ForumComments forumComments = (ForumComments) forumCommentsDAO.getForumComments(2);
		assertNotNull("error", forumComments);
		System.out.println("forum usernameis:: " + forumComments.getUsername());
		System.out.println("forumcomment::" + forumComments.getComment());
	}
}
