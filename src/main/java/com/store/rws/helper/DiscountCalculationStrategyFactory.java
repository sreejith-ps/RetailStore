package com.store.rws.helper;

import com.store.rws.constants.UserTypes;
import com.store.rws.entity.Customer;
import com.store.rws.entity.Employee;
import com.store.rws.entity.User;

public class DiscountCalculationStrategyFactory {
	private final DiscountCalculationStrategy employeeDiscountCalculationStrategy = new EmployeeDiscountCalculationStrategy();
	private final DiscountCalculationStrategy affiliateDiscountCalculationStrategy = new AffliliateDiscountCalculationStrategy();
	private final DiscountCalculationStrategy customerDiscountCalculationStrategy = new CustomerDiscountCalculationStrategy();
	private final DiscountCalculationStrategy noDiscountCalculationStrategy = new NoDiscountCalculationStrategy();
	
	/**
	 * Since our interest calculation strategies are stateless,
	 * creates just a single instance of each strategy and return that whenever needed.
	 * 
	 * @param userType
	 * @return DiscountCalculationStrategy
	 */
    public DiscountCalculationStrategy getInterestCalculationStrategy(UserTypes userType) {
        switch (userType) {
            case EMPLOYEE: return employeeDiscountCalculationStrategy;
            case AFFLIATE: return affiliateDiscountCalculationStrategy;
            case CUSTOMER: return customerDiscountCalculationStrategy;
            default: return noDiscountCalculationStrategy;
        }
    }
    
    /**
     * This is just another method to get the corresponding class based on the User class instance
     * @param user
     * @return
     */
    public DiscountCalculationStrategy getInterestCalculationStrategy(User user) {
       
    	if (user instanceof Employee) {
    	   return employeeDiscountCalculationStrategy;
        } else if (user instanceof Employee) {
            return affiliateDiscountCalculationStrategy;
        } else if (user instanceof Customer) {
            return customerDiscountCalculationStrategy;
        } else {
            return noDiscountCalculationStrategy;
        }
    }

}
