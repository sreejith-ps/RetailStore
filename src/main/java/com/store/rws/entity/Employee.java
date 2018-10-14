package com.store.rws.entity;

import com.store.rws.constants.UserTypes;

/**
 * Employee class for the user logged in as usertype Employee
 * @author Sreejith
 *
 */
public class Employee extends User {
	
	private static final double DISCOUNT_PERCENTAGE = 30;
	
	public Employee() {
		super(UserTypes.EMPLOYEE);
	}

}
