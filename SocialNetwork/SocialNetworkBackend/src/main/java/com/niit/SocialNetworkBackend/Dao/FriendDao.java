package com.niit.SocialNetworkBackend.Dao;

import java.util.List;

import com.niit.SocialNetworkBackend.Model.Friend;

public interface FriendDao {
public boolean saveFriend(Friend friend);
public boolean deleteFriend(Friend friend);
public boolean updateFriend(Friend friend);
public Friend getFriend(int friendId);
public List<Friend> getAllFriend();

}
