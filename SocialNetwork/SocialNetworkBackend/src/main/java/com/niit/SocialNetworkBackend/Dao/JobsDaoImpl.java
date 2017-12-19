package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialNetworkBackend.Model.Jobs;

@Repository("jobsDAO")
public class JobsDaoImpl implements JobsDao{

	@Autowired
	SessionFactory sessionFactory;
	public JobsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveJobs(Jobs jobs) {
		try{
			sessionFactory.getCurrentSession().save(jobs);
			return true;
		}catch(Exception e)
		{
			System.out.println("exception arised"+e);
		}
		return false;
		
	}
	@Transactional
	public boolean deleteJobs(Jobs jobs) {
		try{
			sessionFactory.getCurrentSession().delete(jobs);
			return true;
		}catch(Exception e)
		{
			System.out.println("exception arised"+e);
		}
		return false;
		
		
	}
	@Transactional
	public boolean updateJobs(Jobs jobs) {
		try{
			sessionFactory.getCurrentSession().update(jobs);
			return true;
		}
		catch(Exception e){
			System.out.println("exception arised"+e);
		}
		return false;
		
	}
	@Transactional
	public Jobs getJobs(int jobId) {
		Session session = sessionFactory.openSession();
		Jobs jobs = (Jobs) session.get(Jobs.class, new Integer(jobId));
		return jobs;
		
	}
	@Transactional
	public List<Jobs> getAllJobs() {
		return sessionFactory.getCurrentSession().createQuery("from Jobs").list();
	}

}
