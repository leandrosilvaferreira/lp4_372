package com.myimage.dao;

import org.hibernate.Session;

import com.myimage.model.Profile;

public class ProfileImpl implements ProfileDao {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(Profile profile) {
		this.session.saveOrUpdate(profile);
	}
	
	public boolean existsEmail(String email){
		return  session.bySimpleNaturalId(Profile.class ).load(email) != null ? true : false;
	}

}
