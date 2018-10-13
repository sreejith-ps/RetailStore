package com.store.rws.helper;

import java.util.List;

import com.store.rws.constants.UserTypes;
import com.store.rws.entity.Product;
import com.store.rws.entity.Product.ProductCategory;
import com.store.rws.entity.User;


/**
 * Class to calculate the discount of user type Affiliate
 * 
 * @author Sreejith
 *
 */
public class AffliliateDiscountCalculationStrategy implements DiscountCalculationStrategy {
	private static final double DISCOUNT_PERCENTAGE = 10;
	
	@Override
	public double calculateDiscountedTotal(List<Product> items, User user) {
		double totalDisPrice = 0;
		

		System.out.println(" ***************************** ");
		System.out.println(" User Type - " + UserTypes.AFFLIATE);
		System.out.println(" ***************************** ");
		
		for (Product product : items) {
			System.out.println("Item Name - " + product.getName());
			System.out.println("Item category - " + product.getCategory());
			System.out.println("Item price - " + product.getPrice());
			
			if(ProductCategory.GROCERY.name().equals(product.getCategory())) {
				totalDisPrice += product.getPrice();
			} else {
				double disPrice = product.getPrice() * (100 - DISCOUNT_PERCENTAGE) / 100 ;
				System.out.println("Item discounted price - " + disPrice);
				totalDisPrice += disPrice;
			}

			System.out.println("-----------------------------------------");
		}
		System.out.println("Net payable - " + totalDisPrice);
		System.out.println("\n");
		return totalDisPrice;
	}

}
