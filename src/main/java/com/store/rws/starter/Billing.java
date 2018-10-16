package com.store.rws.starter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.store.rws.constants.UserTypes;
import com.store.rws.entity.Affiliate;
import com.store.rws.entity.Customer;
import com.store.rws.entity.Employee;
import com.store.rws.entity.Product;
import com.store.rws.entity.Product.ProductCategory;
import com.store.rws.entity.User;

public class Billing {

	static Logger logger = Logger.getLogger("Billing");
	TotalPriceCalculator totalPriceCalculator = new TotalPriceCalculator();
	
	public static void main(String[] a) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter your name : ");
		String name = reader.next();

		System.out.println("Enter user type[1-Employee/2-Affiliate/3-Normal Cusomer] :");
		int userType = reader.nextInt();
		User user = null;
		switch (userType) {
		case 1: user = new Employee();
		break;
		case 2: user = new Affiliate();
		break;
		case 3: user = new Customer();
		break;
		default: user = new Customer();
		
		}
		System.out.println("Enter number of years since you registered : ");
		int years = reader.nextInt();		
//		user.setRegistrationDate(new DateTime().minusYears(years));
		user.setNumberOfYearsSinceRgistered(years);
		
		user.setName(name);
		
		System.out.println("Item details");
		System.out.println("*************");
		boolean flag = true;
		List<Product> items = new ArrayList<Product>();
		while (flag) {
			Product p = new Product();
			System.out.println("Enter Item Name :");
			String itemName = reader.next();
			System.out.println("Is it a grocery Item (Y-yes/N-No) ?");
			String isGrocery = reader.next();
			System.out.println("Enter Item Price :");
			Double itemPrice = reader.nextDouble();			
			p.setCategory("Y".equalsIgnoreCase(isGrocery) ? ProductCategory.GROCERY.name() : ProductCategory.OTHER.name());
			p.setPrice(itemPrice);
			p.setName(itemName);
			items.add(p);
			

			System.out.println("Want to add more item (Y-yes/N-No) ?");
			String addMore = reader.next();
			
			if (!"Y".equalsIgnoreCase(addMore)) {
				flag = false;
			}
			
		}
		
		reader.close();
		
		try {
			new Billing().totalPriceCalculator.calculateDiscountedTotal(items, user);
		} catch (Exception e) {
			
			logger.log(logger.getLevel().SEVERE, e.getMessage());
		}
		
		
		
		
		
	}
//	public static void main(String[] a) {
//		Billing billing = new Billing();
//		
//		//get the list of items purchased 
//		List<Product> items = new ArrayList<Product>();
//		
//		Product p = new Product();
//		p.setCategory(ProductCategory.OTHER.name());
//		p.setPrice(200);		
//		p.setName("Toy");
//		items.add(p);
//		
//		p = new Product();
//		p.setCategory(ProductCategory.GROCERY.name());
//		p.setPrice(400);			
//		p.setName("Vegetable Kit");
//		items.add(p);
//		
//		p = new Product();
//		p.setCategory(ProductCategory.OTHER.name());
//		p.setPrice(1000);	
//		p.setName("Mobile");		
//		items.add(p);
//		
//
//		
//		//logged in as employee
//		User user = new User(UserTypes.EMPLOYEE);
//		user.setRegistrationDate(new DateTime());
//		billing.totalPriceCalculator.calculateDiscountedTotal(items, user);
//		//logged in as Affiliate
//		user = new User(UserTypes.AFFLIATE);
//		user.setRegistrationDate(new DateTime());
//		billing.totalPriceCalculator.calculateDiscountedTotal(items, user);
//		
//		//logged in as Customer
//		user = new User(UserTypes.CUSTOMER);
//		user.setRegistrationDate(new DateTime());
//		billing.totalPriceCalculator.calculateDiscountedTotal(items, user);
//		
//		
//		
//	}

}
