package com.store.rws.helper;

import java.util.List;

import com.store.rws.constants.UserTypes;
import com.store.rws.entity.Product;
import com.store.rws.entity.Product.ProductCategory;
import com.store.rws.entity.User;

/**
 * Class to calculate the discount of user type normal customer
 * 
 * @author Sreejith
 *
 */
public class CustomerDiscountCalculationStrategy implements DiscountCalculationStrategy {
	private static final double DISCOUNT_PERCENTAGE = 5;
	

	/**
	 * Overridden method to calculate the discounted total 
	 * if the user is a normal customer
	 * 
	 */
	@Override
	public double calculateDiscountedTotal(List<Product> items, User user) {
		double totalPrice = 0;
		double totalDisPrice = 0;
		double totalGrocPrice = 0;
//		DateTime d = new DateTime();
		
		if (null == user.getRegistrationDate()) {
			throw new NullPointerException("User registration date cannot be null");
		}
//		Period period = new Period(user.getRegistrationDate(), d);
		
		for (Product product : items) {
			
			if(ProductCategory.GROCERY.name().equals(product.getCategory())) {
				totalGrocPrice += product.getPrice();
			} else {
				totalDisPrice += product.getPrice() * (100 - DISCOUNT_PERCENTAGE) / 100 ;
			}
			totalPrice += product.getPrice();
		}

		// below logic is implemented on an assumption user will go for option where he will get more discount 
//		if (2 < period.getYears()) {
		if (2 < user.getNumberOfYearsSinceRgistered()) {
			double discountedPriceByTotal = totalPrice - (Math.floor(totalPrice/100) * DISCOUNT_FOR_100);
			totalDisPrice = (totalDisPrice + totalGrocPrice) < discountedPriceByTotal ? (totalDisPrice + totalGrocPrice) : discountedPriceByTotal;
		} else {
			totalDisPrice = totalPrice - (Math.round(totalDisPrice/100) * DISCOUNT_FOR_100);
		}
		return totalDisPrice;
	}

}
