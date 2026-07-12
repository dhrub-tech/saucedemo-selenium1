package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test(priority = 1)
    public void completeCheckoutTest() {

    	LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        System.out.println("After Login: " + driver.getCurrentUrl());

        inventoryPage.addBackpackToCart();
        System.out.println("After Add to Cart: " + driver.getCurrentUrl());

        cartPage.openCart();
        System.out.println("After Open Cart: " + driver.getCurrentUrl());

        cartPage.clickCheckout();
        System.out.println("After Checkout Click: " + driver.getCurrentUrl());

        checkoutPage.fillCheckoutDetails("Dhrub", "Chatterjee", "700001");
        System.out.println("After Continue: " + driver.getCurrentUrl());

        overviewPage.clickFinish();
        System.out.println("After Finish: " + driver.getCurrentUrl());

        Assert.assertEquals(
            overviewPage.getSuccessMessage(),
            "Thank you for your order!"
        );}

    @Test(priority = 2)
    public void checkoutWithoutFirstName()
    {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        cartPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutDetails("","Chatterjee","700001");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: First Name is required");
    }

    @Test(priority = 3)
public void checkoutWithoutLastName() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();

        cartPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutDetails("Dhrub","","700001");
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: Last Name is required");
    }
    @Test(priority=4)
 public void checkoutWithoutPostalCode() 
    {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        cartPage.openCart();
        cartPage.clickCheckout();

        checkoutPage.fillCheckoutDetails("Dhrub","Chatterjee","");
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required");
    }
}