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
	
	@Override
	public double calculateDiscountedTotal(List<Product> items, User user) {
		double totalDisPrice = 0;
		

		System.out.println(" ***************************** ");
		System.out.println(" User Type - " + UserTypes.CUSTOMER);
		System.out.println(" ***************************** ");
		
		for (Product product : items) {
			System.out.println("Item Name - " + product.getName());
			System.out.println("Item category - " + product.getCategory());
			System.out.println("Item price - " + product.getPrice());
			
			totalDisPrice += product.getPrice();
			
			System.out.println("-----------------------------------------");
		}
		System.out.println("Net payable - " + totalDisPrice);
		System.out.println("\n");
		return totalDisPrice;
	}

}
