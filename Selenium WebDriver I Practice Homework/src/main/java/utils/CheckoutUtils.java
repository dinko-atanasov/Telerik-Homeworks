package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutUtils {

    public static void loginAndAddProducts(WebDriver driver, WebDriverWait wait) {
        SauceDemoUtils.login(driver, wait);
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
    }

    public static void navigateToCart(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    public static void goToCheckout(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    public static void fillUserInfoAndProceed(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("Dinko");
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Atanasov");
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("6000");
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    public static void completeOrder(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    public static boolean validateProductPrices(WebDriver driver, String expectedPriceBackpack, String expectedPriceBoltTShirt, String xpathBackpack, String xpathBoltTShirt) {
        String actualPriceBackpack = driver.findElement(By.xpath(xpathBackpack)).getText();
        String actualPriceBoltTShirt = driver.findElement(By.xpath(xpathBoltTShirt)).getText();

        return expectedPriceBackpack.equals(actualPriceBackpack) && expectedPriceBoltTShirt.equals(actualPriceBoltTShirt);
    }

}
