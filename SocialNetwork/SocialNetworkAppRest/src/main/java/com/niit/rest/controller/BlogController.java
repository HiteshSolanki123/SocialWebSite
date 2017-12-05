package com.niit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping(value = "/insertBlog")
	public ResponseEntity<String> insertBlog(@RequestBody Blog blog)

	{
		blog.setCreateDate(new java.util.Date());
		if (blogDAO.addBlog(blog))

			return new ResponseEntity<String>("Blog Added", HttpStatus.OK);

		else

			return new ResponseEntity<String>("exception arised", HttpStatus.METHOD_FAILURE);

	}

	@RequestMapping(value = "/getAllBlogs", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Blog> getAllBLogs() {
		return blogDAO.getAllBlogs();
	}

	@DeleteMapping("/deleteBlog/{blogId}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		blogDAO.deleteBlog(blog);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}

	@PostMapping(value = "/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog) {
		Blog tempBlog = blogDAO.getBlog(blog.getBlogId());

		tempBlog.setBlogName(blog.getBlogName());
		tempBlog.setBlogContent(blog.getBlogContent());

		if (blogDAO.updateBlog(tempBlog)) {
			return new ResponseEntity<String>("Blog Added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("problem ipdating blog", HttpStatus.METHOD_FAILURE);
		}

	}

	@GetMapping("/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId) {
		Blog tempblog = blogDAO.getBlog(blogId);

		if (blogDAO.approveBlog(tempblog)) {
			return new ResponseEntity<String>("Blog updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("error in Blog updation", HttpStatus.METHOD_FAILURE);
		}
	}

	@GetMapping("/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId) {
		Blog tempblog = blogDAO.getBlog(blogId);
		if (blogDAO.rejectBlog(tempblog)) {
			return new ResponseEntity<String>("Blog updated", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("error in Blog updation", HttpStatus.METHOD_FAILURE);

		}
	}
}
