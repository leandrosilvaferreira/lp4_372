package com.myimage.dao;

import com.myimage.model.Profile;

public interface ProfileDao {

	public void save(Profile profile);
	
	public boolean existsEmail(String email);
}
