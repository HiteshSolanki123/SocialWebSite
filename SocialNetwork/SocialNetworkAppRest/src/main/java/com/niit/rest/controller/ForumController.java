package com.niit.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend.Dao.ForumDao;
import com.niit.SocialNetworkBackend.Model.Forum;

@RestController
public class ForumController {
	@Autowired
	ForumDao forumDAO;
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<String> insertForum(@RequestBody Forum forum)
	{
		if(forumDAO.addForum(forum))
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Exception arised",HttpStatus.METHOD_FAILURE);
	}
}
