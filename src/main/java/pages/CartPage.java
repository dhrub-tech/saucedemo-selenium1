package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
    WebDriver driver;

    By cartIcon = By.className("shopping_cart_link");
    By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void openCart() 
    {
    	driver.findElement(cartIcon).click();
    }

    public void clickCheckout() 
    {
    	driver.findElement(checkoutBtn).click();
    }
}
