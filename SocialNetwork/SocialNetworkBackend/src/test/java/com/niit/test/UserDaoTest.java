package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.UserDao;
import com.niit.SocialNetworkBackend.Model.UserDetail;

public class UserDaoTest {
	static UserDao userDAO;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit");
		annotationConfigApplicationContext.refresh();
		userDAO = (UserDao) annotationConfigApplicationContext.getBean("userDAO");
	}

	
	@Test
	public void saveUser() {
		UserDetail user = new UserDetail();
		user.setUsername("hitesh");
		user.setEmail("user@gmail.com");
		user.setFirstname("user");
		user.setLastname("user");
		user.setPassword("12345");
		user.setPhone("123456789");
		
		assertTrue("problem in adding CartItem", userDAO.saveUser(user));

	}
	@Ignore
	@Test
	public void checkLoginTest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("hitesh");
		user.setPassword("12345");
		assertTrue("problem in login",userDAO.checkLogin(user));
	}
}
