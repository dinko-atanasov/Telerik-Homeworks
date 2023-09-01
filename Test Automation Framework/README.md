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

### Test 1: createBoardWhenCreateBoardClicked
- **Arrange**: Initialize BoardsPage object.
- **Act**: Automate the board creation process.
- **Assert**: Verify that the default list "To Do" exists on the new board.

### Test 2: createNewCardInExistingBoardWhenCreateCardClicked
- **Arrange**: Initialize BoardPage object.
- **Act**: Add a new card to the default "To Do" list.
- **Assert**: Use assertTrue to assert that the new card is present in the "To Do" list.

### Test 3: moveCardBetweenStatesWhenDragAndDropIsUsed
- **Arrange**: Initialize BoardPage object.
- **Act**: Move a card from the "To Do" list to the "Doing" list.
- **Assert**: Use a custom assertion method to verify that the card is now present under the "Doing" list.

### Test 4: deleteBoardWhenDeleteButtonIsClicked
- **Arrange**: Initialize BoardPage object.
- **Act**: Delete the board.
- **Assert**: Use a custom assertion method to verify that the board no longer exists.


## Technical Highlights

- JUnit 5 Integration: The framework uses JUnit 5 to ensure the tests run in a specific sequence, creating a logical flow.
- Optimized Browser Usage: The browser remains open across multiple tests, reducing the overhead of launching a new browser for each test.

## Tech Stack

- Java
- Selenium WebDriver
- JUnit 5
- Maven
- Log4j

## Contributing

If you'd like to contribute, please fork the repository and submit a pull request.


## Acknowledgments

- [Selenium WebDriver documentation](https://www.selenium.dev/documentation/webdriver/)
- [JUnit 5 documentation](https://junit.org/junit5/docs/current/user-guide/)

