# Trello Automated Testing Framework

## Introduction

This project provides an automated testing framework for the Trello web application. Built using Selenium WebDriver and Java, the framework includes a set of test cases that validate board creation, card management, and board deletion in Trello.

## Getting Started

To get started, you'll need to clone this repository to your local machine. Here's how you can set up the framework for development and testing:

### Prerequisites

- Java JDK 11
- Maven
- IntelliJ IDEA or similar IDE
- Trello account

## Installation

1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA or another IDE of your choice.
3. Place your Trello credentials in the config.properties file.

## Running the Tests

1. Open your terminal and navigate to the project directory.
2. Run `mvn clean test` to execute the test suite.

## Test Cases

### Selenium WebDriver Tests

#### Test 1: createBoardWhenCreateBoardClicked
- **Arrange**: Initialize BoardsPage object.
- **Act**: Automate the board creation process.
- **Assert**: Verify that the default list "To Do" exists on the new board.

#### Test 2: createNewCardInExistingBoardWhenCreateCardClicked
- **Arrange**: Initialize BoardPage object.
- **Act**: Add a new card to the default "To Do" list.
- **Assert**: Use assertTrue to assert that the new card is present in the "To Do" list.

#### Test 3: moveCardBetweenStatesWhenDragAndDropIsUsed
- **Arrange**: Initialize BoardPage object.
- **Act**: Move a card from the "To Do" list to the "Doing" list.
- **Assert**: Use a custom assertion method to verify that the card is now present under the "Doing" list.

#### Test 4: deleteBoardWhenDeleteButtonIsClicked
- **Arrange**: Initialize BoardPage object.
- **Act**: Delete the board.
- **Assert**: Use a custom assertion method to verify that the board no longer exists.

### Postman API Tests

The `postman` folder contains a Postman collection and environment for testing Trello's API.

#### Collection: Web Services Exam.postman_collection.json
1. **Step 1: Validate Setup**
    - **Method**: GET
    - **URL**: `{{TRELLO_BASE_URL}}{{TRELLO_MEMBERS_ENDPOINT}}?key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}`
    - **Tests**:
        - Status code is 200
        - Response contains username field
        - Username is correct

2. **Step 2: Create New Board**
    - **Method**: POST
    - **URL**: `{{TRELLO_BASE_URL}}/boards?key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}&name={{TRELLO_BOARD_NAME}}`
    - **Tests**:
        - Status code is 200
        - Response contains board ID
        - Board name is correct

3. **Task 3: Create List on Trello Board**
    - **Method**: POST
    - **URL**: `{{TRELLO_BASE_URL}}/boards/{{TRELLO_BOARD_ID}}/lists?name={{TRELLO_LIST_NAME}}&key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}`
    - **Tests**:
        - Status code is 200
        - Response contains list ID
        - List name is correct

4. **Task 4: Create Trello Card**
    - **Method**: POST
    - **URL**: `{{TRELLO_BASE_URL}}/cards?idList={{TRELLO_LIST_ID}}&name=CardName&key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}`
    - **Tests**:
        - Status code is 200
        - Response contains card ID
        - Response contains card name
        - Card name is correct
        - Card is created in the correct list

5. **Task 5: Update a Card in Trello**
    - **Method**: PUT
    - **URL**: `{{TRELLO_BASE_URL}}/cards/{{TRELLO_CARD_ID}}?name={{TRELLO_UPDATED_CARD_NAME}}&desc={{TRELLO_UPDATED_CARD_DESC}}&key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}`
    - **Tests**:
        - Status code is 200
        - Card name is updated correctly
        - Card description is updated correctly

6. **Advanced Task: Update Trello Card Cover Color**
    - **Method**: PUT
    - **URL**: `{{TRELLO_BASE_URL}}/cards/{{TRELLO_CARD_ID}}?key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}`
    - **Body**: `{"cover": {"color": "{{TRELLO_CARD_COVER_COLOR}}"}}`
    - **Tests**:
        - Status code is 200
        - Cover color is updated correctly

7. **Get All Boards**
    - **Method**: GET
    - **URL**: `{{TRELLO_BASE_URL}}/members/me/boards?key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}`
    - **Tests**:
        - Retrieve and manage the user's Trello boards
        - If there are more than 10 boards, delete the oldest ones

8. **Delete Unnecessary Boards**
    - **Method**: DELETE
    - **URL**: `{{TRELLO_BASE_URL}}/boards/{{TRELLO_BOARD_ID}}?key={{TRELLO_API_KEY}}&token={{TRELLO_API_TOKEN}}`
    - **Tests**:
        - Status code is 200
        - Response contains 'ok' field
        - Response 'ok' field is true

## Technical Highlights

- JUnit 5 Integration: The framework uses JUnit 5 to ensure the tests run in a specific sequence, creating a logical flow.
- Optimized Browser Usage: The browser remains open across multiple tests, reducing the overhead of launching a new browser for each test.

## Tech Stack

- Java
- Selenium WebDriver
- JUnit 5
- Maven
- Log4j
- Postman
- Newman

## Contributing

If you'd like to contribute, please fork the repository and submit a pull request.

## Acknowledgments

- [Selenium WebDriver documentation](https://www.selenium.dev/documentation/webdriver/)
- [JUnit 5 documentation](https://junit.org/junit5/docs/current/user-guide/)