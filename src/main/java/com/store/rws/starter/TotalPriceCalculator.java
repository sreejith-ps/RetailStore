package com.store.rws.starter;

import java.util.List;

import com.store.rws.entity.Product;
import com.store.rws.entity.User;
import com.store.rws.helper.DiscountCalculationStrategy;
import com.store.rws.helper.DiscountCalculationStrategyFactory;

public class TotalPriceCalculator {

	private final DiscountCalculationStrategyFactory discountCalculationStrategyFactory = new DiscountCalculationStrategyFactory();
    
	public double calculateDiscountedTotal(List<Product> items, User user) {
		
		if (null == user) {
			throw new NullPointerException("User cannot be null");
		}
		
		if (null == items) {
			throw new NullPointerException("Items cannot be null");
		}
        DiscountCalculationStrategy discountCalculationStrategy = discountCalculationStrategyFactory.getInterestCalculationStrategy(user.getUserType());
        return discountCalculationStrategy.calculateDiscountedTotal(items, user);
    }
}
