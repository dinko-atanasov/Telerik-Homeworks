package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserTypes;
import utils.SauceDemoUtils;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected BrowserTypes browserType = BrowserTypes.CHROME;

    @BeforeEach
    public void setUp() {
        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        resetAppState();
        driver.quit();
    }

    public void navigateToSauceDemo() {
        driver.get("https://www.saucedemo.com/");
    }

    protected void resetAppState() {
        navigateToSauceDemo();
        SauceDemoUtils.login(driver, wait); // Calling the login method here

        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='react-burger-menu-btn']")));
        menuButton.click();

        // Wait for any transitions or animations (this duration may need to be adjusted)
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement resetApp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='reset_sidebar_link']")));
        resetApp.click();
    }

}
