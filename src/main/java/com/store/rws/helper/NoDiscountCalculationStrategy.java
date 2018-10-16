package com.store.rws.helper;

import java.util.List;

import com.store.rws.constants.UserTypes;
import com.store.rws.entity.Product;
import com.store.rws.entity.User;


/**
 * Class to calculate the total price without discount for user types not defined
 * 
 * @author Sreejith
 *
 */
public class NoDiscountCalculationStrategy implements DiscountCalculationStrategy {
	private static final double DISCOUNT_PERCENTAGE = 0;
	
	/**
	 * Overridden method to calulate the discount for user type Employee
	 * 
	 * @param List<Product> items
	 * @param User user
	 * @return Double - totalPrice
	 * 
	 */
	@Override
	public double calculateDiscountedTotal(List<Product> items, User user) {
		double totalDisPrice = 0;

		for (Product product : items) {
			totalDisPrice += product.getPrice();
		}
		return totalDisPrice;
	}

}
