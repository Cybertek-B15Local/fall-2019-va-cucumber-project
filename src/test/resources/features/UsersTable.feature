Feature: Users table

  Scenario: unique user ids
    Given I am on the login page
    And I login as a librarian
    When I click on "Users" link
    Then Each user id should be unique