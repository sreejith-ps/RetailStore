package com.store.rws.helper;

import java.util.List;

import com.store.rws.constants.UserTypes;
import com.store.rws.entity.Product;
import com.store.rws.entity.Product.ProductCategory;
import com.store.rws.entity.User;

/**
 * Class to calculate the discount of user type Employee
 * 
 * @author Sreejith
 *
 */
public class EmployeeDiscountCalculationStrategy implements DiscountCalculationStrategy {
	private static final double DISCOUNT_PERCENTAGE = 30;
	
	/**
	 * Overridden method to calulate the discount for user type Employee
	 * 
	 * @param List<Product> items
	 * @param User user
	 * @return Double - discountedTotal
	 */
	@Override
	public double calculateDiscountedTotal(List<Product> items, User user) {
		double totalPrice = 0;
		double totalDisPrice = 0;
		double totalGrocPrice = 0;
		
		for (Product product : items) {

			if(ProductCategory.GROCERY.name().equals(product.getCategory())) {
				totalGrocPrice += product.getPrice();
			} else {
				totalDisPrice += product.getPrice() * (100 - DISCOUNT_PERCENTAGE) / 100 ;
			}
			totalPrice += product.getPrice();
		}
		
		double discountedPriceByTotal = totalPrice - (Math.floor(totalPrice/100) * DISCOUNT_FOR_100);
		totalDisPrice = (totalDisPrice + totalGrocPrice) < discountedPriceByTotal ? (totalDisPrice + totalGrocPrice) : discountedPriceByTotal;
		
		return totalDisPrice;
	}

}
