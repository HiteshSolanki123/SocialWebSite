package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend.Model.Forum;

public interface ForumDao {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getAllForums();
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	
}
