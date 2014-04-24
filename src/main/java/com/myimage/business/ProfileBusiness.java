package com.myimage.business;

import com.myimage.dao.ProfileDao;
import com.myimage.dao.utils.DAOFactory;
import com.myimage.model.Profile;

public class ProfileBusiness {

	private ProfileDao ProfileDao;
	
	
	public ProfileBusiness() {
		super();
		setProfileDao(DAOFactory.createProfile());
	}	
	
	private void setProfileDao(ProfileDao profileDao) {
		ProfileDao = profileDao;
	}

	public void save(Profile Profile){
		ProfileDao.save(Profile);
	}
	
	public boolean existsEmail(String email){
		return ProfileDao.existsEmail(email);
	}
}
