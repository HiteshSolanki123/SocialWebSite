package com.niit.rest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.SocialNetworkBackend.Dao.ProfilePictureDao;
import com.niit.SocialNetworkBackend.Model.ProfilePicture;

@RestController
public class ProfilePictureController {
	@Autowired
	ProfilePictureDao profilePictureDAO;	
	@PostMapping("/doUpload")
	public ResponseEntity<?> uploadProfilePicture(@RequestParam(value="file") CommonsMultipartFile fileUpload,HttpSession session)
	{
		System.out.println("uploading picture");
		ProfilePicture profilePicture=new ProfilePicture();
		
		System.out.println(fileUpload.getBytes());	
		System.out.println("picture uploaded");
		profilePicture.setImage(fileUpload.getBytes());
		profilePicture.setUsername("vishva");
		profilePictureDAO.save(profilePicture);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
	@GetMapping(value="/getImage/{username}")
	public @ResponseBody byte[] getProfilePic(@PathVariable("username")String username,HttpStatus session)
	{
		ProfilePicture profilePicture=profilePictureDAO.getProfilePicture(username);
		return profilePicture.getImage();
	}
}