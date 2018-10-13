package com.store.rws.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.store.rws.constants.UserTypes;
import com.store.rws.entity.Product;
import com.store.rws.entity.Product.ProductCategory;
import com.store.rws.starter.TotalPriceCalculator;
import com.store.rws.entity.User;

public class TotalPriceCalculatorTest {

	TotalPriceCalculator totalPriceCalculator;
	List<Product> items;
	
	@Before
    public void setUp() {
		totalPriceCalculator = new TotalPriceCalculator();
		items = new ArrayList<Product>();
		
		Product p = new Product();
		p.setCategory(ProductCategory.OTHER.name());
		p.setPrice(200);		
		p.setName("Toy");
		items.add(p);
		
		p = new Product();
		p.setCategory(ProductCategory.GROCERY.name());
		p.setPrice(400);			
		p.setName("Vegetable Kit");
		items.add(p);
		
		p = new Product();
		p.setCategory(ProductCategory.OTHER.name());
		p.setPrice(1000);	
		p.setName("Mobile");		
		items.add(p);
		
    }
	
	@Test
	public void testCalculateDiscountedTotalEmployee() {
		
		User user = new User(UserTypes.EMPLOYEE);
//		user.setRegistrationDate(new DateTime());
		user.setNumberOfYearsSinceRgistered(1);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1240));
		
		total = totalPriceCalculator.calculateDiscountedTotal(null, null);
		assertEquals(total , new Double(1240));
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullInput() {	
		fail(String.valueOf(totalPriceCalculator.calculateDiscountedTotal(null, null)));
	}

	@Test
	public void testCalculateDiscountedTotalAffiliate() {

		User user = new User(UserTypes.AFFLIATE);
//		user.setRegistrationDate(new DateTime());
		user.setNumberOfYearsSinceRgistered(1);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1480));
	}
	
	@Test
	public void testCalculateDiscountedTotalCustomer() {
		User user = new User(UserTypes.CUSTOMER);
//		user.setRegistrationDate(new DateTime());
		user.setNumberOfYearsSinceRgistered(2);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1525));
	}
	

	
	@Test
	public void testCalculateDiscountedTotalCustomerWithoutRegDate() {
		User user = new User(UserTypes.CUSTOMER);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1525));
	}
	

	
	@Test
	public void testCalculateDiscountedTotalCustomerOlderthan2Years() {
		User user = new User(UserTypes.CUSTOMER);
//		user.setRegistrationDate(new DateTime().minusYears(3));
		user.setNumberOfYearsSinceRgistered(3);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1525));
	}
	

}
