package test.cases.jira;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;
import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

import com.telerikacademy.testframework.UserActions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.Keys;


import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JiraJourneyTest extends BaseTest {

    @Test
    @Order(1)
    public void loginToJira() {
        login();
    }

    @Test
    @Order(2)
    public void createNewProject() {
        actions.waitForElementClickable(getUIMappingByKey("jira_create_project_button"));
        actions.clickElement(getUIMappingByKey("jira_create_project_button"));

        actions.waitForElementClickable(getUIMappingByKey("jira_scrum_button"));
        actions.clickElement(getUIMappingByKey("jira_scrum_button"));

        actions.waitForElementClickable(getUIMappingByKey("jira_use_template"));
        actions.clickElement(getUIMappingByKey("jira_use_template"));

        actions.waitForElementClickable(getUIMappingByKey("jira_select_company_project"));
        actions.clickElement(getUIMappingByKey("jira_select_company_project"));

        actions.waitForElementClickable(getUIMappingByKey("jira_project_name_input"));
        actions.typeValueInField("Selenium WebDriver II Practice Homework", getUIMappingByKey("jira_project_name_input"));

        try {
            Thread.sleep(3000);  // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Ра'оти ли така? Ра'оти.

        actions.waitForElementClickable(getUIMappingByKey("jira_next_button"));
        actions.clickElement(getUIMappingByKey("jira_next_button"));

        actions.waitForElementClickable(getUIMappingByKey("jira_go_to_project"));
        actions.clickElement(getUIMappingByKey("jira_go_to_project"));

    }

    @Test
    @Order(3)
    public void createNewStory() {
        UserActions actions = new UserActions();

        // Wait for Create button and click
        actions.waitForElementClickable("createButton");
        actions.clickElement("createButton");

        // Wait for the dropdown menu and click
        actions.waitForElementClickable("dropdownMenu");
        actions.clickElement("dropdownMenu");

        // Switch and send "Story"
        actions.getDriver().switchTo().activeElement().sendKeys("Story");

        // Wait for Summary field and type in string
        actions.waitForElementClickable("summaryField");
        actions.typeValueInField(getConfigPropertyByKey("storySummaryText"), "summaryField");

        // Wait for Description field and type in string
        actions.waitForElementClickable("descriptionField");
        actions.typeValueInField(getConfigPropertyByKey("storyDescriptionText"), "descriptionField");

        // Wait for Create Issue button and click
        actions.waitForElementClickable("createIssueButton");
        actions.clickElement("createIssueButton");
    }

    @Test
    @Order(3)
    public void createNewBug() {
        UserActions actions = new UserActions();

        try {
            Thread.sleep(3000);  // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Ра'оти ли така? Ра'оти.

        // Wait for Create button and click
        actions.waitForElementClickable("createButton");
        actions.clickElement("createButton");

        // Wait for the dropdown menu and click
        actions.waitForElementClickable("dropdownMenu");
        actions.clickElement("dropdownMenu");

        // Switch and send "Story"
        actions.getDriver().switchTo().activeElement().sendKeys("Bug");

        // Wait for Summary field and type in string
        actions.waitForElementClickable("summaryField");
        actions.typeValueInField(getConfigPropertyByKey("bugSummaryText"), "summaryField");

        // Wait for Description field and type in string
        actions.waitForElementClickable("descriptionField");
        actions.typeValueInField(getConfigPropertyByKey("bugDescriptionText"), "descriptionField");

        // Wait for Create Issue button and click
        actions.waitForElementClickable("createIssueButton");
        actions.clickElement("createIssueButton");
    }

    @Test
    @Order(4)
    public void linkBugToStory() {

        try {
            Thread.sleep(1000);  // Sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Ра'оти ли така? Ра'оти.

        // Click on Issues button
        actions.waitForElementClickable("issuesButton");
        actions.clickElement(getUIMappingByKey("issuesButton"));

        // Click on side menu bug issue button
        actions.waitForElementClickable("sideMenuBugIssue");
        actions.clickElement(getUIMappingByKey("sideMenuBugIssue"));

        // Click on Link issue button
        actions.waitForElementClickable("linkIssueButton");
        actions.clickElement(getUIMappingByKey("linkIssueButton"));

        // Type in string "SWIPH-2" and hit ENTER key
        actions.waitForElementVisible("linkIssueInputField");
        actions.typeValueInField("SWIPH-2", getUIMappingByKey("linkIssueInputField"));
//        actions.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
    }

}
