package com.niit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend.Dao.UserDao;
import com.niit.SocialNetworkBackend.Model.User;

@RestController
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDAO;
	
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET,headers="Accept=application/json")
	public List <User> getAllUser(){
		return userDAO.getAllUser();
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		boolean isSaved=userDAO.saveUser(user);
		if(isSaved)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		else
			return new ResponseEntity<User>(user,HttpStatus.METHOD_FAILURE);
	}
	@PostMapping("/login")
	public ResponseEntity<User> loginStatus(@RequestBody User user)
	{
		user=userDAO.getByEmail(user.getEmail());
		if((user==null))
		{
			user=new User();
			System.out.println("user email invalid");
		}
		else
		{
			System.out.println("login user");
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	

}
