# SauceDemo Selenium Automation Framework

A Java-based Selenium WebDriver automation framework for testing key end-to-end workflows of the **SauceDemo** web application.

The framework follows the **Page Object Model (POM)** and uses **TestNG** for test execution and **Maven** for dependency and build management.

---

## Project Overview

**Application Under Test:** SauceDemo
**Testing Type:** Web UI Automation / Functional Regression Testing

The project focuses on automating critical user journeys across authentication, inventory, cart, checkout, and logout workflows.

### Key Objectives

* Automate critical end-to-end user journeys
* Validate positive and negative test scenarios
* Apply Page Object Model for maintainability
* Separate page interactions from test logic
* Execute tests using TestNG
* Manage dependencies and builds using Maven
* Maintain reusable test setup and teardown

---

## Tech Stack

| Technology                | Purpose                         |
| ------------------------- | ------------------------------- |
| Java 17                   | Programming language            |
| Selenium WebDriver 4.18.1 | Browser automation              |
| TestNG 7.10.2             | Test execution                  |
| Maven                     | Build and dependency management |
| WebDriverManager 5.8.0    | WebDriver dependency            |
| Chrome                    | Browser under test              |
| Page Object Model         | Framework design pattern        |

---

## Framework Structure

The framework separates test logic from page-level interactions using the Page Object Model.

```text
Test Classes
     │
     ▼
Page Objects
     │
     ▼
Selenium WebDriver
     │
     ▼
SauceDemo Application
```

This structure helps reduce duplication and keeps page-specific locators and actions separate from test scenarios.

---

## Project Structure

```text
saucedemo-selenium1
│
├── src
│   ├── main
│   │   └── java
│   │       └── pages
│   │           ├── CartPage.java
│   │           ├── CheckoutOverviewPage.java
│   │           ├── CheckoutPage.java
│   │           ├── InventoryPage.java
│   │           └── LoginPage.java
│   │
│   └── test
│       └── java
│           ├── base
│           │   └── BaseTest.java
│           │
│           └── tests
│               ├── AddtoCartTest.java
│               ├── BusinessFlowTest.java
│               ├── CheckoutTest.java
│               ├── LoginTest.java
│               ├── LogoutTest.java
│               ├── MultipleProductsTest.java
│               └── NegativeLoginTest.java
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## Automated Test Coverage

### Authentication

* Valid user login
* Invalid username/password
* Locked user login
* Empty username validation
* Empty password validation

### Inventory & Cart

* Add Backpack to cart
* Add multiple products
* Verify cart badge count
* Remove product from cart
* Verify product selection workflow

### Checkout

* Complete checkout workflow
* Checkout without first name
* Checkout without last name
* Checkout without postal code
* Verify order completion

### End-to-End Business Flow

The framework also validates a complete customer journey:

```text
Login
  ↓
Browse Products
  ↓
Add Product to Cart
  ↓
Open Cart
  ↓
Checkout
  ↓
Enter Customer Information
  ↓
Complete Order
  ↓
Verify Order Confirmation
  ↓
Logout
```

---

## TestNG Suite

Test execution is controlled through `testng.xml`.

The current suite includes:

* `LoginTest`
* `NegativeLoginTest`
* `AddtoCartTest`
* `MultipleProductsTest`
* `CheckoutTest`
* `LogoutTest`
* `BusinessFlowTest`

This provides a single entry point for executing the configured automation suite.

---

## Page Object Model

Page classes encapsulate locators and page-level actions, while test classes focus on business scenarios and validations.

Example structure:

```text
LoginPage
 ├── enterUsername()
 ├── enterPassword()
 └── clickLogin()

InventoryPage
 ├── addProductToCart()
 ├── removeProduct()
 └── openCart()

CheckoutPage
 ├── enterCustomerInformation()
 └── continueCheckout()

CheckoutOverviewPage
 └── completeOrder()
```

This approach improves readability, reduces duplication, and makes UI changes easier to maintain.

---

## Test Design

The suite contains both positive and negative scenarios.

### Positive Scenarios

* Successful login
* Adding products to cart
* Successful checkout
* Successful order completion
* Successful logout

### Negative Scenarios

* Invalid credentials
* Locked user
* Missing username
* Missing password
* Missing checkout information

The combination of positive and negative scenarios provides coverage of both expected user behavior and application validation.

---

## Test Setup & Teardown

`BaseTest` provides the common WebDriver setup and cleanup used by the test classes.

The setup:

* Creates a Chrome WebDriver instance
* Configures Chrome options
* Maximizes the browser window
* Navigates to the SauceDemo application

After each test method, the WebDriver instance is closed to ensure test isolation.

---

## Maven Configuration

Maven manages the project's dependencies and build lifecycle.

The project is configured with:

* Java 17
* Selenium WebDriver
* TestNG
* WebDriverManager
* SLF4J
* Maven Compiler Plugin
* Maven Surefire Plugin

The Surefire plugin is configured to execute the TestNG suite through `testng.xml`.

---

## How to Run

### Prerequisites

Install:

* Java 17 or higher
* Maven
* Google Chrome
* Git

Verify the installation:

```bash
java -version
mvn -version
git --version
```

### Clone the Repository

```bash
git clone https://github.com/dhrub-tech/saucedemo-selenium1.git
```

Navigate to the project:

```bash
cd saucedemo-selenium1
```

### Run the Complete Test Suite

```bash
mvn clean test
```

Maven will compile the project and execute the configured TestNG suite.

### Run Through an IDE

The test suite can also be executed using `testng.xml` from Eclipse or IntelliJ IDEA.

---

## Current Scope

The framework currently focuses on **web UI functional automation** using Selenium WebDriver.

Current implementation includes:

* Java-based Selenium automation
* Page Object Model
* TestNG execution
* Maven dependency management
* Chrome browser automation
* Positive and negative testing
* End-to-end business flows
* Reusable test setup and teardown


---

## Author

**Dhrubjyoti Chattopadhyay**

QA Engineer | Manual & Automation Testing

Focused on building maintainable Selenium automation frameworks and improving software quality through functional and regression testing.
