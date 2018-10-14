package com.store.rws.entity;

import com.store.rws.constants.UserTypes;

/**
 * Customer class for the user logged in as usertype Customer
 * @author Sreejith
 *
 */
public class Customer extends User {

	private static final double DISCOUNT_PERCENTAGE = 5;

	public Customer() {
		super(UserTypes.CUSTOMER);
	}
}
