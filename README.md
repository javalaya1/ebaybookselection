<<<<<<< HEAD
# Running Tests with Maven and Cucumber

This guide explains how to run tests in a Maven-based Cucumber project. You can run tests for specific tags (`@eBay`, `@Coindesk`), or run both tests together using the appropriate Maven commands.

## Prerequisites

- Ensure that **Maven** is installed on your machine.
- Ensure that **Cucumber** and **TestNG** are configured in your project.
- Ensure that you have the **RunEbayTests.java** and **RunAPITests.java** classes in your project.

## Run eBay Tests

To run only the eBay tests, use the following Maven command:

```bash or cmd
mvn test -Dtest.classes=**/RunEbayTests.java -Dtest.tags="--tags @eBay"
=======
# Running Tests with Maven and Cucumber

This guide explains how to run tests in a Maven-based Cucumber project. You can run tests for specific tags (`@eBay`, `@Coindesk`), or run both tests together using the appropriate Maven commands.

## Prerequisites

- Ensure that **Maven** is installed on your machine.
- Ensure that **Cucumber** and **TestNG** are configured in your project.
- Ensure that you have the **RunEbayTests.java** and **RunAPITests.java** classes in your project.

## to Run only eBay Tests

To run only the eBay tests, use the following Maven command:

##bash or cmd
mvn clean test -Dtest=RunAPITests

##################################################################################

## To run only the eBay tests, use the following Maven command:

##bash or cmd
mvn clean test -Dtest=RunEbayTests

##################################################################################


## Run both eBay and CoinDesk Tests, use the following Maven command:

##bash or cmd
mvn clean test -Dtest=RunEbayTests,RunAPITests

##################################################################################


## Run both eBay and CoinDesk Tests, use the following Maven command:

##bash or cmd
mvn clean test
>>>>>>> 70b8d288e11c39f1ecdd6943db809e7293b80b8c
