package pages.jira;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;

public class LoginPage extends BaseJiraPage {

    public LoginPage(WebDriver driver) {
        super(driver, getConfigPropertyByKey("jira.loginPage"));
    }

    public void loginUser(String userKey) {
        // Navigate to the initial Jira page
        navigateToPage();

        // Fetch email and password from properties
        String email = getConfigPropertyByKey("jira.users." + userKey + ".email");
        String password = getConfigPropertyByKey("jira.users." + userKey + ".password");

        // Login sequence
        actions.waitForElementClickable("jira_signin_button");
        actions.clickElement("jira_signin_button");

        actions.getDriver().switchTo().activeElement().sendKeys(email, Keys.ENTER);

        actions.waitForElementClickable("jira_continue_button");
        actions.clickElement("jira_continue_button");

        actions.waitForElementClickable("jira_continue_button");
        actions.getDriver().switchTo().activeElement().sendKeys(password, Keys.ENTER);

        actions.waitForElementClickable("jira_continue_button");
        actions.clickElement("jira_continue_button");

        actions.waitForElementVisible("jira_create_project_button");

        // Validate the URL
        assertPageNavigated();
    }
}
