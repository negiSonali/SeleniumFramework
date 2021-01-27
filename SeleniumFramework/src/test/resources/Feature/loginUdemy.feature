Feature: feature to test the login functionality

  Scenario: Check login is successful with valid credentials
    Given user is no udemy page
    When user clicks on login
    And user in on login page
    When user enters email and password
    And clicks on submit button
    Then user is navigated to the home page
