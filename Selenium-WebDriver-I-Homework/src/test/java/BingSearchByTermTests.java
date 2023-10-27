import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BingSearchByTermTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private BrowserTypes browserType = BrowserTypes.EDGE; // You can change this to the desired browser type

    private enum BrowserTypes {
        CHROME,
        FIREFOX,
        EDGE
    }

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
        driver.quit();
    }

    @Test
    public void resultFound_when_searchTermProvided() {
        navigateToBing();
        acceptCookies();
        performSearch("Telerik Academy Alpha");
        verifyFirstResultTitle("IT Career Start in 6 Months - Telerik Academy Alpha");
    }

    private void navigateToBing() {
        driver.get("https://www.bing.com");
    }

    private void acceptCookies() {
        By locator;
        switch (browserType) {
            case CHROME:
                locator = By.xpath("//*[@id=\"bnp_btn_accept\"]/a");
                break;
            case FIREFOX:
                locator = By.xpath("//*[@id=\"bnp_btn_accept\"]/a");
                break;
            case EDGE:
                locator = By.xpath("//*[@id=\"bnp_btn_accept\"]/a");
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type");
        }
        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
        agreeButton.click();
    }


    private void performSearch(String searchTerm) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        WebElement searchButton;
        switch (browserType) {
            case CHROME:
                searchButton = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
                break;
            case FIREFOX:
                searchButton = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
                break;
            case EDGE:
                searchButton = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type");
        }
        searchButton.click();
    }

    private void verifyFirstResultTitle(String expectedTitle) {
        WebElement firstResultTitle;
        switch (browserType) {
            case CHROME:
                firstResultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")));
                break;
            case FIREFOX:
                firstResultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/main/ol/li[1]/div/div[1]"))); // Not the best locator
                break;
            case EDGE:
                firstResultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"b_results\"]/li[1]/div/h2/a")));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type");
        }
        String actualTitle = firstResultTitle.getText();
        Assertions.assertEquals(expectedTitle, actualTitle, "Expected title: " + expectedTitle + " but found: " + actualTitle);
    }
}
