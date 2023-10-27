package pages.trello;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList(String cardName) {

        actions.waitForElementVisible("trello.boardPage.placeholderAddCard");
        actions.typeValueInField( cardName , "trello.boardPage.placeholderAddCard");

        actions.waitForElementClickable("trello.boardPage.clickAddCardButton");
        actions.clickElement("trello.boardPage.clickAddCardButton");
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }

    public boolean isElementPresent(String listName) {
        return actions.isElementPresent("trello.boardPage.listByName", listName);
    }

    public boolean isCardPresent(String cardName) {
        try {
            actions.waitForElementPresent("trello.boardPage.checkCardNameField", cardName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void moveCardToList(String cardName, String listName) {
        Actions action = new Actions(driver);

        String xpathDrag = actions.getLocatorValueByKey("trello.boardPage.dragElement", cardName);
        WebElement drag = driver.findElement(By.xpath(xpathDrag));

        String xpathDrop = actions.getLocatorValueByKey("trello.boardPage.dropElement", listName);
        WebElement drop = driver.findElement(By.xpath(xpathDrop));

        action.dragAndDrop(drag, drop).build().perform();
    }

    public void assertCardIsUnderList(String listName, String cardName) {
        actions.waitForElementPresent("trello.boardPage.cardUnderList", listName, cardName);
    }

    public void deleteExistingBoard() {
        actions.waitForElementClickable("trello.boardPage.showMenuButton");
        actions.clickElement("trello.boardPage.showMenuButton");

        actions.waitForElementClickable("trello.boardPage.closeBoardButton");
        actions.clickElement("trello.boardPage.closeBoardButton");

        actions.waitForElementClickable("trello.boardPage.closeButton");
        actions.clickElement("trello.boardPage.closeButton");

        actions.waitForElementClickable("trello.boardPage.permanentlyDeleteButton");
        actions.clickElement("trello.boardPage.permanentlyDeleteButton");

        actions.waitForElementClickable("trello.boardPage.deleteBoardConfirmButton");
        actions.clickElement("trello.boardPage.deleteBoardConfirmButton");
    }

    public void assertBoardIsDeleted(String boardName) {
        Assert.assertFalse("Board is not deleted", actions.isElementPresent("trello.boardPage.deleteBoardAssertions", boardName));
    }

}
