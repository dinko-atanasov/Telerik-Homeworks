package test.cases.trello;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoardTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(BoardTest.class);


    @Test
    @Order(1)
    public void createBoardWhenCreateBoardClicked() {
        logger.info("Starting test: createBoardWhenCreateBoardClicked");
        logger.info("Logging in...");
        login();
        logger.info("Navigating to BoardsPage...");
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        logger.info("Creating new board...");
        boardsPage.createBoard();
        logger.info("Navigating to BoardPage...");
        BoardPage boardPage = new BoardPage(actions.getDriver());
        logger.info("Verifying 'To Do' list exists...");
        boardPage.assertListExists("To Do");
        logger.info("Completed test: createBoardWhenCreateBoardClicked");
    }

    @Test
    @Order(2)
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        logger.info("Starting test: createNewCardInExistingBoardWhenCreateCardClicked");
        logger.info("Navigating to BoardPage...");
        BoardPage boardPage = new BoardPage(actions.getDriver());
        logger.info("Adding a new card to list...");
        boardPage.addCardToList("My First Card");
        logger.info("Verifying the new card is present...");
        assertTrue(boardPage.isCardPresent("My First Card"));
        logger.info("Completed test: createNewCardInExistingBoardWhenCreateCardClicked");
    }

    @Test
    @Order(3)
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        logger.info("Starting test: moveCardBetweenStatesWhenDragAndDropIsUsed");
        logger.info("Navigating to BoardPage...");
        BoardPage boardPage = new BoardPage(actions.getDriver());
        logger.info("Moving card to 'Doing' list...");
        boardPage.moveCardToList("My First Card", "Doing");
        logger.info("Verifying the card is under 'Doing' list...");
        boardPage.assertCardIsUnderList("Doing", "My First Card");
        logger.info("Completed test: moveCardBetweenStatesWhenDragAndDropIsUsed");
    }

    @Test
    @Order(4)
    public void deleteBoardWhenDeleteButtonIsClicked() {
        logger.info("Starting test: deleteBoardWhenDeleteButtonIsClicked");
        logger.info("Navigating to BoardPage...");
        BoardPage boardPage = new BoardPage(actions.getDriver());
        logger.info("Deleting the existing board...");
        boardPage.deleteExistingBoard();
        logger.info("Verifying the board is deleted...");
        boardPage.assertBoardIsDeleted("My First Board");
        logger.info("Completed test: deleteBoardWhenDeleteButtonIsClicked");
    }
}
