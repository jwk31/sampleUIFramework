Feature: Login page

  Background:
    Given user is on login page


  @smoke
  Scenario: Verify user can login to System with valid credentials
    When user type "jwk31" in username input field
    And user type "Samsung103110" in password input field
    And user click on Login button
    Then user should successfully land to Home page

