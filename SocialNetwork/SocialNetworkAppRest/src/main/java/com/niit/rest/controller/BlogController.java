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

import com.niit.SocialNetworkBackend.Dao.BlogDao;
import com.niit.SocialNetworkBackend.Model.Blog;

@RestController
public class BlogController {

		@Autowired
		BlogDao blogDAO;
		
		@PostMapping(value="/insertBlog")
		public ResponseEntity<String> insertBlog(@RequestBody Blog blog)
		
		{
			if(blogDAO.addBlog(blog))
			
				return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
			
			else
			
				return new ResponseEntity<String>("exception arised",HttpStatus.METHOD_FAILURE);
			
		}
		@RequestMapping(value="/getAllBlogs",method=RequestMethod.GET,headers="Accept=application/json")
		public List<Blog> getAllBLogs(){
			return blogDAO.getAllBlogs();
		}
		
		@DeleteMapping("/deleteBlog/{blogId}")
		public ResponseEntity<Blog> deleteBlog(@PathVariable int blogId)
		{
			Blog blog=blogDAO.getBlog(blogId);
			blogDAO.deleteBlog(blog);
			return new ResponseEntity<Blog>(HttpStatus.OK);
		}
}
