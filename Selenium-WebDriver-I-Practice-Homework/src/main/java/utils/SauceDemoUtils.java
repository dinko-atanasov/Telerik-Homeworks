package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceDemoUtils {

    public static final String EXPECTED_PRICE_BACKPACK = "$29.99";
    public static final String EXPECTED_PRICE_BOLT_TSHIRT = "$15.99";
    public static final String XPATH_BACKPACK = "//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div";
    public static final String XPATH_BOLT_TSHIRT = "//*[@id='cart_contents_container']/div/div[1]/div[4]/div[2]/div[2]/div";
    public static final String FINAL_CHECKOUT_URL = "https://www.saucedemo.com/checkout-complete.html";
    public static final String CONFIRMATION_TEXT = "Thank you for your order!";
    public static final String XPATH_CONFIRMATION_TEXT = "//*[@id='checkout_complete_container']/h2";
    public static final String CART_ICON_LINK_XPATH = "//a[@class='shopping_cart_link']";
    public static final String CART_ITEM_LABEL_XPATH = "//div[@class='cart_item_label']";
    public static final String SHOPPING_CART_BADGE_XPATH = "//span[@class='shopping_cart_badge']";




    public static void login(WebDriver driver, WebDriverWait wait) {
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
        loginButton.click();

        WebElement inventoryPageTitle = driver.findElement(By.xpath("//div[@class='app_logo']"));
        wait.until(ExpectedConditions.visibilityOf(inventoryPageTitle));
    }
}
