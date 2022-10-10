@db
Feature: Add new employee and delete via Database

  Scenario: add new employee
    Given connect to Database
    And create new employee with following credentials:
      | employeeNumber | lastName  | firstName | extension | email            | officeCode | reportsTo | jobTitle |
      | 2000           | Daniyarov | Asan      | x9900     | asan99@gmail.com | 1          | 1056      | VP Sales |
    Then check this employee in Database
      | employeeNumber | lastName  | firstName | extension | email            | officeCode | reportsTo | jobTitle |
      | 2000           | Daniyarov | Asan      | x9900     | asan99@gmail.com | 1          | 1056      | VP Sales |
    When delete employee by "email" which is "asan99@gmail.com"
    Then check it in Database by "email" which is "asan99@gmail.com"