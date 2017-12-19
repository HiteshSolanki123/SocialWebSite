package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend.Model.BlogComment;

public interface BlogCommentsDao {
	public boolean saveBlogComments(BlogComment blogComments);

	public boolean deleteBlogComments(BlogComment blogComments);

	public boolean updateBlogComments(BlogComment blogComments);

	public BlogComment getBlogComments(int blogCommentsId);

	public List<BlogComment> getAllBlogComments();
}
