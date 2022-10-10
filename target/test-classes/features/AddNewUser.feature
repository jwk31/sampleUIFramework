@smoke
Feature: Add new user with given info

  Background: login to the system
    Given login with following credentials as admin:
      | userNameOrEmail | password      |
      | jwk31           | Samsung103110 |

  Scenario: Add new user
    When admin clicks on Add user button
    Then admin should see Add user page
    When admin fills input fields with following new user info:
      | firstName | lastName  | emailAddress     | userName | password | bio       | userType     | timeZone            | language |
      | Asan      | Daniyarov | asan30@gmail.com | asan30   | Aa123544! | Some text | Learner-Type | (GMT +06:00) Almaty | English  |
    Then user should see user information in new Page

