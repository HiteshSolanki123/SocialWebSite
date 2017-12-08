package com.niit.rest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend.Dao.UserDao;
import com.niit.SocialNetworkBackend.Model.User;

@RestController
public class UserController {

	@Autowired
	private UserDao userDAO;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUser() {
		return userDAO.getAllUser();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user.setIsOnline("N");
		user.setRole("User");
		boolean isSaved = userDAO.saveUser(user);
		if (isSaved)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.METHOD_FAILURE);
	}

	@PostMapping("/login")
	public ResponseEntity<User> checkLogin(@RequestBody User user, HttpSession session) {
		if (userDAO.checkLogin(user)) {
			System.out.println("logging");
			User tempUser = userDAO.getUser(user.getUsername());
			userDAO.updateOnlineStatus("Y", tempUser);
			session.setAttribute("username", user.getUsername());
			return new ResponseEntity<User>(tempUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.METHOD_FAILURE);
		}
	}

	@GetMapping(value = "/logout/{username}")
	public ResponseEntity<String> loggingout(@PathVariable("username") String username) {
		User user = userDAO.getUser(username);
		if (userDAO.updateOnlineStatus("N", user)) {
			return new ResponseEntity<String>("Successful logout", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("error in logout", HttpStatus.METHOD_FAILURE);
		}
	}

}
