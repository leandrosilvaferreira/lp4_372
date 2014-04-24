package com.myimage.dao;

import org.hibernate.Session;

import com.myimage.model.User;

public class UserImpl implements UserDao {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(User user) {
		this.session.saveOrUpdate(user);
	}

	public boolean existsLogin(String login){
		return session.bySimpleNaturalId(User.class ).load(login) != null ? true : false;
	}
}
