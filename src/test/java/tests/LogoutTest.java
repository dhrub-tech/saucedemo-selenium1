package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest 
{
@Test(priority = 6)
public void logoutTest() 
{
LoginPage loginPage =new LoginPage(driver);
loginPage.login("standard_user","secret_sauce");


System.out.println("Before logout: " + driver.getCurrentUrl());



InventoryPage inventoryPage =new InventoryPage(driver);
inventoryPage.logout();

Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
}
}
