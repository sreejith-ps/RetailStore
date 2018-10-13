package com.store.rws.entity;

import com.store.rws.constants.UserTypes;

public class Customer extends User {

	private static final double DISCOUNT_PERCENTAGE = 5;

	public Customer() {
		super(UserTypes.CUSTOMER);
	}
}
