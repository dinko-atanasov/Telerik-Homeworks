# Jira Automated Testing Framework

## Test Cases

### Selenium WebDriver Tests

- **Test**: loginToJira
- **Test**: createNewProject
- **Test**: createNewStory
- **Test**: createNewBug
- **Test**: linkBugToStory

### Postman API Tests

The `postman` folder contains a Postman collection and environment for testing Jira's API.

#### Collection: Web Services Postman - Homework.postman_collection.json

1. **Create Story**
    - **Method**: POST
    - **URL**: `{{BASE_URI}}{{API_VERSION}}{{CREATE_ISSUE_ENDPOINT}}`
    - **Tests**:
        - Status code is 201
        - Response includes id
        - Response includes key
        - Response includes self

2. **Create Bug**
    - **Method**: POST
    - **URL**: `{{BASE_URI}}{{API_VERSION}}{{CREATE_ISSUE_ENDPOINT}}`
    - **Tests**:
        - Status code is 201
        - Response includes id
        - Response includes key
        - Response includes self

3. **Link Story and Bug**
    - **Method**: POST
    - **URL**: `{{BASE_URI}}{{API_VERSION}}{{ISSUE_LINK_ENDPOINT}}`
    - **Tests**:
        - Status code is 201
        - Response body is empty

4. **Attach Image**
    - **Method**: POST
    - **URL**: `{{BASE_URI}}{{API_VERSION}}{{CREATE_ISSUE_ENDPOINT}}{{INWARD_ISSUE_KEY}}{{ATTACHMENTS_ENDPOINT}}`
    - **Tests**:
        - Status code is 200
        - Response includes attachment details

## Tech Stack
- Java
- Selenium WebDriver
- Maven
- Postman
- Newman

## Running the Tests

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn test` to execute the test suite.

## Note

The tests are annotated with order for execution.

## Folder Structure

/src
- main
    - java
        - com
            - trello
                - tests
                  /postman
- Web Services Postman - Homework.postman_collection.json
- Jira API.postman_environment.json

## Contributing

If you'd like to contribute, please fork the repository and submit a pull request.

