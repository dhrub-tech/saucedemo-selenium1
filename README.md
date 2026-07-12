# SauceDemo Selenium Automation

A simple Selenium automation framework built using Java, TestNG, and Maven to automate key user journeys on the SauceDemo application. 
The project follows the Page Object Model (POM) to keep the code organized and easy to maintain.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

## What is Covered

### Login
- Valid Login
- Invalid Login
- Locked User Login
- Empty Username Validation
- Empty Password Validation

### Inventory
- Add Backpack to Cart
- Add Multiple Products
- Verify Cart Badge Count
- Verify Remove Button After Adding Product

### Checkout
- Complete Checkout
- Checkout Without First Name
- Checkout Without Last Name
- Checkout Without Postal Code

### User Flow
- Login
- Add Product to Cart
- Checkout
- Order Confirmation
- Logout

## How to Run

Clone the repository and run:

```bash
mvn clean test
```
Or run the suite using:
testng.xml
```

## About

This project was created as a hands-on Selenium automation framework to practice end-to-end web application testing, improve Java coding skills 
and demonstrate a clean automation structure using the Page Object Model.