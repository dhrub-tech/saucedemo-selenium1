package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Map;
public class BaseTest 
{
    protected WebDriver driver;
    
    
    @BeforeMethod
    public void setup() 
    {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--guest");
        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordCheck");
        options.addArguments("--disable-notifications");
        options.addArguments("--no-first-run");
        options.addArguments("--disable-default-apps");

        options.setExperimentalOption("excludeSwitches",
                new String[]{"enable-automation"});

        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}