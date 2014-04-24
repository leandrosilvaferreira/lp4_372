package com.myimage.dao;

import com.myimage.model.User;

public interface UserDao {

	public void save(User user);
	
	public boolean existsLogin(String login);
}
