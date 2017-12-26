package com.niit.SocialNetworkBackend.Dao;

import com.niit.SocialNetworkBackend.Model.ProfilePicture;

public interface ProfilePictureDao 
{
	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
