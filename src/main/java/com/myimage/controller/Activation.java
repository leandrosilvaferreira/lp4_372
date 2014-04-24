package com.myimage.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="activation")
@RequestScoped
public class Activation {

	@ManagedProperty(value = "#{param.key}")
	private String key;

	private boolean valid;

	@PostConstruct
	public void init() {
		System.out.println("passou");
		setValid(false); // deve ser setado depois da consulta no banco
		// Get User based on activation key.
		// Delete activation key from database.
		// Login user.
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}	
}
