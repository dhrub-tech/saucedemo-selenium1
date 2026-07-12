package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class AddtoCartTest extends BaseTest

{
	@Test(priority = 5)
	public void addProductToCartTest()
	
	{
	    LoginPage loginPage =new LoginPage(driver);

	    loginPage.login("standard_user", "secret_sauce");

	    InventoryPage inventoryPage = new InventoryPage(driver);

	    inventoryPage.addBackpackToCart();

	    Assert.assertEquals(inventoryPage.getCartCount(),"1");
	}
	@Test(priority=6)
	public void verifyRemoveButtonAppears() 
	{
	    LoginPage login = new LoginPage(driver);
	    InventoryPage inventory = new InventoryPage(driver);

	    login.login("standard_user", "secret_sauce");

	    inventory.addBackpackToCart();

	    Assert.assertTrue(inventory.isRemoveButtonDisplayed());
	}
}

