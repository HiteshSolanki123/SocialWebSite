package com.niit.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialNetworkBackend.Dao.JobsDao;
import com.niit.SocialNetworkBackend.Model.Jobs;

@RestController
public class JobController {

	@Autowired
	JobsDao jobsDAO;
	
	@PostMapping(value="/insertJobs")
	public ResponseEntity<String> insertJobs(@RequestBody Jobs jobs)
	{
		if(jobsDAO.saveJobs(jobs))
			return new ResponseEntity<String>("JObs added",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Exception arised",HttpStatus.METHOD_FAILURE);
	}
	
}
