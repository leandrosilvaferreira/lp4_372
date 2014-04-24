package com.myimage.dao.utils;

import com.myimage.dao.ProfileDao;
import com.myimage.dao.ProfileImpl;

public class DAOFactory {


	public static ProfileDao createProfile(){
		ProfileImpl profileImpl = new ProfileImpl();
		profileImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return profileImpl;
	}
}
