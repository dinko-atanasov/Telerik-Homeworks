import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class GoogleSearchByTermTests {
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
    public void pageTitleIsCorrect_when_searchingForTelerikAcademyAlpha() {
        navigateToGoogle();
        acceptCookies();
        performSearch("Telerik Academy Alpha");
        verifyFirstResultTitle("IT Career Start in 6 Months - Telerik Academy Alpha");
    }

    private void navigateToGoogle() {
        driver.get("https://www.google.com");
    }

    private void acceptCookies() {
        WebElement acceptCookiesButton;
        switch (browserType) {
            case CHROME:
                acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
                break;
            case FIREFOX:
                acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
                break;
            case EDGE:
                acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type");
        }
        acceptCookiesButton.click();
    }

    private void performSearch(String searchTerm) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        WebElement searchButton;
        switch (browserType) {
            case CHROME:
                searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='btnK' and @type='submit'])[2]")));
                break;
            case FIREFOX:
                searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='btnK' and @type='submit'])[2]")));
                break;
            case EDGE:
                searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='btnK' and @type='submit'])[2]")));
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
                firstResultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"))); // Not the best locator
                break;
            case EDGE:
                firstResultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type");
        }
        String actualTitle = firstResultTitle.getText();
        Assertions.assertEquals(expectedTitle, actualTitle, "Expected title: " + expectedTitle + " but found: " + actualTitle);
    }
}
