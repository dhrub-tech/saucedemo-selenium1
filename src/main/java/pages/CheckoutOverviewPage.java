package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {

    WebDriver driver;

    By finishBtn = By.id("finish");

    By successMessage = By.className("complete-header");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickFinish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }
    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}
