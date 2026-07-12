
package pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class InventoryPage 
{
WebDriver driver;
By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
 By cartBadge =By.className("shopping_cart_badge");
By menuButton = By.id("react-burger-menu-btn");
By logoutLink =By.id("logout_sidebar_link");
By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
By removeBackpack = By.id("remove-sauce-labs-backpack");

public InventoryPage(WebDriver driver) 
{this.driver = driver;
    }
public void addBackpackToCart() 
{driver.findElement(addToCartBtn).click();
    }
public String getCartCount() 
{
        return driver.findElement(cartBadge).getText();
    }

//Added  methods

public void addBikeLightToCart() 
{
    driver.findElement(bikeLight).click();
}

public boolean isRemoveButtonDisplayed() 
{
    return driver.findElement(removeBackpack).isDisplayed();
}

public void logout() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));

    wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
}
}