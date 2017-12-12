package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialNetworkBackend.Dao.UserDao;
import com.niit.SocialNetworkBackend.Model.User;

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

	@Ignore
	@Test
	public void saveUser() {
		User user = new User();
		user.setEmail("user@gmail.com");
		user.setFirstname("user");
		user.setLastname("user");
		user.setPassword("user");
		user.setPhone("123456789");
		user.setUid(123);
		assertTrue("problem in adding CartItem", userDAO.saveUser(user));

	}
	@Test
	public void checkLoginTest()
	{
		User user=new User();
		user.setUsername("hitesh");
		user.setPassword("12345");
		assertTrue("problem in login",userDAO.checkLogin(user));
	}
}
