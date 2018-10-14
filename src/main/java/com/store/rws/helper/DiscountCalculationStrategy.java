package com.store.rws.helper;

import java.util.List;
import java.util.logging.Logger;

import com.store.rws.entity.Product;
import com.store.rws.entity.User;

public interface DiscountCalculationStrategy {
	public static final double DISCOUNT_FOR_100 = 5;
	Logger logger = Logger.getLogger("DiscountCalculation");
	double calculateDiscountedTotal(List<Product> items, User user);
}
