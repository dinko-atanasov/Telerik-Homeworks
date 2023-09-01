package saucedemotests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.SauceDemoUtils;

public class LoginTests extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTests.class);

    @Test
    public void userAuthenticated_when_validCredentialsProvided() {
        logger.info("Test initiated: userAuthenticated_when_validCredentialsProvided");

        logger.info("Logging in with valid credentials");
        SauceDemoUtils.login(driver, wait);

        logger.info("Test completed: User successfully authenticated");
    }
}
