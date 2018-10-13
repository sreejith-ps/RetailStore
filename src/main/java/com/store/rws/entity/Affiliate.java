package com.store.rws.entity;

import com.store.rws.constants.UserTypes;

public class Affiliate extends User {
	
	private static final double DISCOUNT_PERCENTAGE = 10;
	
	public Affiliate() {
		super(UserTypes.AFFLIATE);
	}
}
