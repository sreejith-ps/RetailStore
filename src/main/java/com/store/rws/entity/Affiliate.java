package com.store.rws.entity;

import com.store.rws.constants.UserTypes;

/**
 * Affiliate class for the user logged in as usertype Affiliate
 * @author Sreejith
 *
 */
public class Affiliate extends User {
	
	private static final double DISCOUNT_PERCENTAGE = 10;
	
	public Affiliate() {
		super(UserTypes.AFFLIATE);
	}
}
