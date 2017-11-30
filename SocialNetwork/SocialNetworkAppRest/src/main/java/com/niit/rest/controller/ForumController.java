package com.niit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend.Dao.ForumDao;
import com.niit.SocialNetworkBackend.Model.Blog;
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
	@RequestMapping(value="/getAllForums",method=RequestMethod.GET,headers="Accept=application/json")
	public List<Forum> getAllForums(){
		return forumDAO.getAllForums();
	}
	@DeleteMapping("/deleteForum/{forumId}")
	public ResponseEntity<Forum> deleteForum(@PathVariable int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		forumDAO.deleteForum(forum);
		return new ResponseEntity<Forum>(HttpStatus.OK);
	}
	@PostMapping(value="/updateForum")
	public ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		Forum tempForum=forumDAO.getForum(forum.getForumId());
		
		tempForum.setForumName(forum.getForumName());
		tempForum.setForumContent(forum.getForumContent());
		
		if(forumDAO.updateForum(tempForum))	
		{
			return new ResponseEntity<String>("forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("problem ipdating forum",HttpStatus.METHOD_FAILURE);
		}
		
	}
}
