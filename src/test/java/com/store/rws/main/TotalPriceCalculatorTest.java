package com.store.rws.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.store.rws.entity.Affiliate;
import com.store.rws.entity.Customer;
import com.store.rws.entity.Employee;
import com.store.rws.entity.Product;
import com.store.rws.entity.Product.ProductCategory;
import com.store.rws.entity.User;
import com.store.rws.starter.TotalPriceCalculator;
/**
 * Class for JUnit test cases
 * 
 * @author Sreejith
 *
 */
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
		
		User user = new Employee();
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

		User user = new Affiliate();
//		user.setRegistrationDate(new DateTime());
		user.setNumberOfYearsSinceRgistered(1);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1480));
	}
	
	@Test
	public void testCalculateDiscountedTotalCustomer() {
		User user = new Customer();
//		user.setRegistrationDate(new DateTime());
		user.setNumberOfYearsSinceRgistered(2);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1525));
	}
	

	
	@Test
	public void testCalculateDiscountedTotalCustomerWithoutRegDate() {
		User user = new Customer();
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1525));
	}
	

	
	@Test
	public void testCalculateDiscountedTotalCustomerOlderthan2Years() {
		User user = new Customer();
//		user.setRegistrationDate(new DateTime().minusYears(3));
		user.setNumberOfYearsSinceRgistered(3);
		
		Double total = totalPriceCalculator.calculateDiscountedTotal(items, user);
		assertEquals(total , new Double(1525));
	}
	
	@After
    public void clear() {
		totalPriceCalculator = null;
		items = null;
	}
	

}
