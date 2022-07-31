@addNewUser
Feature: Add new user

  Background: login to the system
    Given login with following credentials as admin:
      | userName | password      |
      | jwk31    | Samsung103110 |

  Scenario: Add new user
    When admin clicks on Add user button
    Then admin should see Add user page
    When admin fills input fields with following new user info:
      | firstName | lastName  | email           | username | password | bio       | usertype     | timeZone            | language |
      | Asan      | Daniyarov | asan1@gmail.com | asan     | Aa123544 | Some text | Learner-Type | (GMT +06:00) Almaty | English  |
    Then user should see confirmation alert with text "Success! Do you want to add another user?"
    And admin clicks info button
    Then admin should see user's info
    And admin clicks on user button
    When admin chooses all courses
    And admin clicks Users button on header
    Then admin should see information of new user (with email "asan@gmail.com")