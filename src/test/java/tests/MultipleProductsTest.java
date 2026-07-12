package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class MultipleProductsTest extends BaseTest {

    @Test
    public void addMultipleProductsToCart() {

        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);

        login.login("standard_user", "secret_sauce");

        inventory.addBackpackToCart();
        inventory.addBikeLightToCart();

        Assert.assertEquals(inventory.getCartCount(), "2");
    }
}