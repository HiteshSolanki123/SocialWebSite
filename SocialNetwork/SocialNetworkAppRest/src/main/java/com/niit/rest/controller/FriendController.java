package com.niit.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend.Dao.FriendDao;
import com.niit.SocialNetworkBackend.Model.Friend;

@RestController
public class FriendController {
@Autowired
FriendDao friendDAO;

@PostMapping(value="/createFriendRequest")
public ResponseEntity<String> createFriendRequest(@RequestBody Friend friend)
{
	friend.setStatus("R");
	if(friendDAO.createFriend(friend))
	{
		return new ResponseEntity<String>("Sucess",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
