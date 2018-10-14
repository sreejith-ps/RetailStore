# Retail web store - Discount Pricing Engine
Project to calculate the net price after the dicount applied on items  based on various criterias

Used factory pattern and inheritance as these are found to be more appropriate in this case though there are other ways of implementation by applying other object oriented concepts

Product represents each purchase item. price is calculated for item purchased not the unit price

## How to run :
In command line, go to the folder where jar file is located and run "java -jar RetailWebStore-0.0.1-SNAPSHOT.jar"

or import to eclipse as maven project and run Billing.java as Java application
Input values as per the directions given and the result will be printed in console.

## How to run JUnit:
java -cp .:RetailWebStore-0.0.1-SNAPSHOT.jar:lib/junit-4.10.jar org.junit.runner.JUnitCore com.store.rws.starter.TotalPriceCalculatorTest

or import to eclipse as maven project and run TotalPriceCalculatorTest.java as JUnit


## How to generate test report: 

Use below command in project folder to generate test report:
mvn surefire-report:report 


## Note
Across output classes, System.out.println is used for purpose of output illustration which will not be the case in acutal implementation
