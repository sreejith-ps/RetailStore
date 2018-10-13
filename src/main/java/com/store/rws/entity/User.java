package com.store.rws.entity;

import org.joda.time.DateTime;

import com.store.rws.constants.UserTypes;

public class User {
	private String name;
	private DateTime registrationDate;
	private Integer numberOfYearsSinceRgistered; // this is used to accept input easily
	private UserTypes userType;
	private double discountPercentage;

	public User(UserTypes userType) {
		this.userType = userType;
	}
	
	public DateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(DateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public UserTypes getUserType() {
		return userType;
	}

	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfYearsSinceRgistered() {
		return numberOfYearsSinceRgistered;
	}

	public void setNumberOfYearsSinceRgistered(Integer numberOfYearsSinceRgistered) {
		this.numberOfYearsSinceRgistered = numberOfYearsSinceRgistered;
	}

}


