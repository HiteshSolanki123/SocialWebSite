package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend.Model.UserBlogComments;

public interface BlogCommentsDao {
	public boolean saveBlogComments(UserBlogComments blogComments);

	public boolean deleteBlogComments(UserBlogComments blogComments);

	public boolean updateBlogComments(UserBlogComments blogComments);

	public UserBlogComments getBlogComments(int blogCommentsId);

	public List<UserBlogComments> getAllBlogComments();
}
