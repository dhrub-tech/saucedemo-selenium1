package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
    WebDriver driver;
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue"); 
    By errorMessage = By.cssSelector("h3[data-test='error']");
    
    public CheckoutPage(WebDriver driver) 
    {
        this.driver = driver;
    }
    public void enterFirstName(String fname) 
    {
        driver.findElement(firstName).sendKeys(fname);
    }
    public void enterLastName(String lname) 
    {
        driver.findElement(lastName).sendKeys(lname);
    }
    public void enterPostalCode(String zip) 
    {
        driver.findElement(postalCode).sendKeys(zip);
    }
    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
    public void fillCheckoutDetails(String fname, String lname, String zip) 
    {
        enterFirstName(fname);
        enterLastName(lname);
        enterPostalCode(zip);
        clickContinue();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
