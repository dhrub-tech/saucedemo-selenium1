package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class BusinessFlowTest extends BaseTest {

    @Test
    public void PurchaseProductSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

        // Add Product
        inventoryPage.addBackpackToCart();

        Assert.assertEquals(inventoryPage.getCartCount(), "1");

        // Open Cart
        cartPage.openCart();

        // Checkout
        cartPage.clickCheckout();

        checkoutPage.fillCheckoutDetails("Dhrub","Chatterjee","700001");

        // Finish Order
        overviewPage.clickFinish();
       
        
        

        Assert.assertEquals(overviewPage.getSuccessMessage(),"Thank you for your order!");
      
        // Logout
        inventoryPage.logout();
   

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}
