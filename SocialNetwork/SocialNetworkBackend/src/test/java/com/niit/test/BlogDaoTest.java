package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.BlogDao;
import com.niit.SocialNetworkBackend.Model.Blog;

public class BlogDaoTest {
	static BlogDao blogDAO;
	@BeforeClass
	public static void initialize(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		blogDAO=(BlogDao) annotationConfigApplicationContext.getBean("blogDAO");
		}


	@Test
	public void addBlog() {
		Blog blog = new Blog();
		blog.setBlogContent("blog");
		blog.setBlogId(123);
		blog.setBlogName("blog");
		blog.setLikes(100);
		blog.setStatus("online");
		blog.setUserId(123);
		assertTrue("problem in adding CartItem",blogDAO.addBlog(blog));

	}

}
