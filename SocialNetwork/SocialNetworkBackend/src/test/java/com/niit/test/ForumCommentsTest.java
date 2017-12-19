package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.ForumCommentsDao;
import com.niit.SocialNetworkBackend.Model.ForumComment;

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
		ForumComment forumComments = new ForumComment();
		forumComments.setComment("liked");
		
		forumComments.setForumId(102);
		forumComments.setUserId(103);
		forumComments.setUsername("comments");
		assertTrue("", forumCommentsDAO.saveForumComments(forumComments));
	}

	@Ignore
	@Test
	public void deleteForumComments() {
		ForumComment forumComments = (ForumComment) forumCommentsDAO.getForumComments(1);
		assertTrue("", forumCommentsDAO.deleteForumComments(forumComments));

	}

	@Ignore
	@Test
	public void updatesForumComment() {
		ForumComment forumComments = (ForumComment) forumCommentsDAO.getForumComments(2);
		forumComments.setComment("nice");
		forumComments.setUserId(501);
		assertTrue("forum is updated", forumCommentsDAO.updateForumComments(forumComments));
	}

	@Ignore
	@Test
	public void getAllForumComments() {
		List<ForumComment> forumCommentsList = (List<ForumComment>) forumCommentsDAO.getAllForumComments();
		assertNotNull("", forumCommentsList.get(0));
		for (ForumComment forumComments : forumCommentsList) {
			System.out.println("forumcomment:::=" + forumComments.getComment());
		}
	}

	@Test
	public void getForumComments() {
		ForumComment forumComments = (ForumComment) forumCommentsDAO.getForumComments(2);
		assertNotNull("error", forumComments);
		System.out.println("forum usernameis:: " + forumComments.getUsername());
		System.out.println("forumcomment::" + forumComments.getComment());
	}
}
