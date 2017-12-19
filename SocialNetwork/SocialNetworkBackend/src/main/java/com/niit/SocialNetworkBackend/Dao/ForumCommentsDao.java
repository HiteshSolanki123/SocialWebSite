package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend.Model.ForumComment;

public interface ForumCommentsDao {
	public boolean saveForumComments(ForumComment forumComments);

	public boolean deleteForumComments(ForumComment forumComments);

	public boolean updateForumComments(ForumComment forumComments);

	public ForumComment getForumComments(int fComments);

	public List<ForumComment> getAllForumComments();
}
