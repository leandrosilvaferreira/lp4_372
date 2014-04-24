package com.myimage.business;

import com.myimage.dao.UserDao;
import com.myimage.dao.utils.DAOFactory;
import com.myimage.model.User;

public class UserBusiness {

	private UserDao userDao;
	
	
	public void save(User user){
		userDao.save(user);
	}
	
	public boolean existsLogin(String login){
		return userDao.existsLogin(login);
	}
}
