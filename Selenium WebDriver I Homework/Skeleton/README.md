# WebDriverDemoProject

This project demonstrates automated testing using Selenium WebDriver with Java. It includes two test cases that automate search functionality on Bing and Google. The tests are designed to run on different browsers, including Chrome, Firefox, and Edge.

## Test Cases

### Bing Search Test (BingSearchByTermTests)

This test automates the following steps:
1. Navigate to Bing's homepage.
2. Accept cookies (specific to the browser being used).
3. Type "Telerik Academy Alpha" in the search field.
4. Click the search button.
5. Wait for the results page to load.
6. Assert that the title of the first result is "IT Career Start in 6 Months - Telerik Academy Alpha".
7. Close the browser.

### Google Search Test (GoogleSearchByTermTests)

This test automates the following steps:
1. Navigate to Google's homepage.
2. Accept cookies (specific to the browser being used).
3. Type "Telerik Academy Alpha" in the search field.
4. Click the search button.
5. Wait for the results page to load.
6. Assert that the title of the first result is "IT Career Start in 6 Months - Telerik Academy Alpha".
7. Close the browser.

## Browser Support

The tests can be configured to run on different browsers by changing the `browserType` variable in the test classes. Supported browsers include:
- Chrome
- Firefox
- Edge

## Dependencies

The project uses the following dependencies:
- JUnit Jupiter API (for writing and running tests)
- Selenium WebDriver (for browser automation)
- Selenium Chrome Driver (for Chrome browser support)
- Selenium Firefox Driver (for Firefox browser support)
- Selenium Edge Driver (for Edge browser support)

## Maven Configuration

The project is configured with Maven, and the `pom.xml` file includes all necessary dependencies and configurations.

## Running the Tests

To run the tests, you can use your preferred IDE with JUnit support or run them from the command line using Maven.

## Note

The tests are dependent on the current structure of the Bing and Google search results pages. If these pages are updated, the tests may need to be adjusted accordingly.
