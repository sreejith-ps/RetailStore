package com.store.rws.entity;

import com.store.rws.constants.UserTypes;

public class Employee extends User {
	
	private static final double DISCOUNT_PERCENTAGE = 30;
	
	public Employee() {
		super(UserTypes.EMPLOYEE);
	}

}
