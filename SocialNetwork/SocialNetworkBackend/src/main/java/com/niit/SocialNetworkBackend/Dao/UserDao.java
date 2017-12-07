package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend.Model.User;

public interface UserDao {

	public List<User> getAllUser();
	
	public boolean saveUser(User user);
	public User getByEmail(String email);
	public boolean updateOnlineStatus(String status,User user);
	public boolean checkLogin (User user);
	
}
