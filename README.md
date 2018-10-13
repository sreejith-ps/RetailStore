# Retail web store - Discount Pricing Engine
Project to calculate the discounts applied on items based on user details or purchase price

This java application gives the discounted price of items purchased based on user category , item type and total spend

Criterias for calculating discount as follows,

1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

How to run :
In command line go the folder where jar file is located and run "java -jar RetailWebStore-0.0.1-SNAPSHOT.jar"

or import to eclipse as maven project and run Billing.java as Japa application

How to run JUnit:
java -cp .:RetailWebStore-0.0.1-SNAPSHOT.jar:lib/junit-4.10.jar org.junit.runner.JUnitCore com.store.rws.starter.TotalPriceCalculatorTest


or import to eclipse as maven project and run TotalPriceCalculatorTest.java as JUnit

Use below command in project folder to generate test report:
mvn surefire-report:report 
