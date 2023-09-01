package saucedemotests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import utils.SauceDemoUtils;
import utils.CheckoutUtils;
import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductsTests extends BaseTest {

    private static final Logger logger = LogManager.getLogger(ProductsTests.class);

    @Order(1)
    @Test
    public void productAddedToShoppingCart_when_addToCart() {
        logger.info("Test initiated: productAddedToShoppingCart_when_addToCart");

        logger.info("Logging in and adding products...");
        CheckoutUtils.loginAndAddProducts(driver, wait);

        logger.info("Navigating to cart...");
        CheckoutUtils.navigateToCart(driver);

        logger.info("Validating product prices...");
        boolean pricesAreValid = CheckoutUtils.validateProductPrices(
                driver,
                SauceDemoUtils.EXPECTED_PRICE_BACKPACK,
                SauceDemoUtils.EXPECTED_PRICE_BOLT_TSHIRT,
                SauceDemoUtils.XPATH_BACKPACK,
                SauceDemoUtils.XPATH_BOLT_TSHIRT
        );
        assertTrue(pricesAreValid, "Prices do not match expected values");

        logger.info("Test completed: Product successfully added to shopping cart");
    }

    @Order(2)
    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        logger.info("Test initiated: userDetailsAdded_when_checkoutWithValidInformation");

        logger.info("Logging in and adding products");
        CheckoutUtils.loginAndAddProducts(driver, wait);

        logger.info("Navigating to cart");
        CheckoutUtils.navigateToCart(driver);

        logger.info("Going to checkout");
        CheckoutUtils.goToCheckout(driver);

        logger.info("Filling user info and proceeding");
        CheckoutUtils.fillUserInfoAndProceed(driver);

        assertEquals("https://www.saucedemo.com/checkout-step-two.html",
                driver.getCurrentUrl(), "URL does not match expected value");

        logger.info("Test completed: User details successfully added");
    }

    @Order(3)
    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        logger.info("Test initiated: orderCompleted_when_addProduct_and_checkout_withConfirm");

        logger.info("Logging in and adding products");
        CheckoutUtils.loginAndAddProducts(driver, wait);

        logger.info("Navigating to cart");
        CheckoutUtils.navigateToCart(driver);

        logger.info("Going to checkout");
        CheckoutUtils.goToCheckout(driver);

        logger.info("Filling user info and proceeding");
        CheckoutUtils.fillUserInfoAndProceed(driver);

        logger.info("Completing order");
        CheckoutUtils.completeOrder(driver);

        assertEquals(SauceDemoUtils.FINAL_CHECKOUT_URL,
                driver.getCurrentUrl(), "Final URL does not match expected value");
        assertEquals(SauceDemoUtils.CONFIRMATION_TEXT,
                driver.findElement(By.xpath(SauceDemoUtils.XPATH_CONFIRMATION_TEXT))
                        .getText(), "Confirmation text does not match expected value");

        logger.info("Validating cart is empty");

        List<WebElement> cartItems = driver.findElements(By.xpath(SauceDemoUtils.CART_ITEM_LABEL_XPATH));
        assertEquals(0, cartItems.size(), "Cart is not empty after completing the order");

        List<WebElement> cartBadges = driver.findElements(By.xpath(SauceDemoUtils.SHOPPING_CART_BADGE_XPATH));
        assertEquals(0, cartBadges.size(), "Cart badge is still visible, indicating the cart is not empty");

        logger.info("Test completed: Order successfully completed");
    }
}
