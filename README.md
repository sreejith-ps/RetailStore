# Retail web store - Discount Pricing Engine
Project to calculate the net price on items after the dicount applied based on various criterias

How to run :
In command line go the folder where jar file is located and run "java -jar RetailWebStore-0.0.1-SNAPSHOT.jar"

or import to eclipse as maven project and run Billing.java as Japa application

How to run JUnit:
java -cp .:RetailWebStore-0.0.1-SNAPSHOT.jar:lib/junit-4.10.jar org.junit.runner.JUnitCore com.store.rws.starter.TotalPriceCalculatorTest


or import to eclipse as maven project and run TotalPriceCalculatorTest.java as JUnit

Use below command in project folder to generate test report:
mvn surefire-report:report 
