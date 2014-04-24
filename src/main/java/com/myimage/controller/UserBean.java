package com.myimage.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpServletRequest;

import com.myimage.business.ProfileBusiness;
import com.myimage.model.Profile;
import com.myimage.model.User;
import com.myimage.utils.GenerateValidation;
//import com.myimage.utils.Mail;
import com.myimage.utils.Role;
import com.myimage.utils.ManipulateDate;
//import com.myimage.utils.ServiceFinder;
import com.myimage.utils.security.GenerateMD5;


@ManagedBean(name = "user")
@RequestScoped
public class UserBean {

	private User user = null;
	private Profile profile = null;

	private int day = 0;
	private int month = 0;
	private int year = 0;

	@PostConstruct
	public void init() {
		user = new User();
		profile = new Profile();
	}

	public String save() {

		ProfileBusiness profileBusiness = new ProfileBusiness();

		user.setPassword(GenerateMD5.generate(user.getPassword()));
		user.setValidation(GenerateValidation.keyValidation());
		user.getPermissions().add(Role.ROLE_COMMON.getValue());
		user.setActive(false);
		
		profile.setUser(user);
		profile.setBirth(ManipulateDate.getDate(year, month, day));

		profileBusiness.save(profile);
		/*Mail mail = (Mail) ServiceFinder.findBean("mail");
		mail.sendMail("MyImage.com", profile.getEmail(),
				"Validação de cadastro", "Clique em: " + getContextPath()
						+ "public/activate.xhtml?key=" + user.getValidation());
*/
		return "/public/feedback_login";
	}

	/*private String getContextPath() {

		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String url = req.getRequestURL().toString();
		return url.substring(0, url.length() - req.getRequestURI().length())
				+ req.getContextPath() + "/";
	}*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Map<String, Object> getDays() {
		return ManipulateDate.getDays();
	}

	public Map<String, Object> getMonths() {
		return ManipulateDate.getMonths();
	}

	public Map<String, Object> getYears() {
		return ManipulateDate.getYears();
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
