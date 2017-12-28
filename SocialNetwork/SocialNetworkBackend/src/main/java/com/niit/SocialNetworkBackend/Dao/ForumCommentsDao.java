package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend.Model.UserForumComments;

public interface ForumCommentsDao {
	public boolean saveForumComments(UserForumComments forumComments);

	public boolean deleteForumComments(UserForumComments forumComments);

	public boolean updateForumComments(UserForumComments forumComments);

	public UserForumComments getForumComments(int comments);

	public List<UserForumComments> getAllForumComments();
}
