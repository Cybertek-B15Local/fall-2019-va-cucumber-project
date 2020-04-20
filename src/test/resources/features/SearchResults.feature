@lib-2423
Feature: Search functionality on the users page

  @wip
  Scenario: Search accuracy
    Given I am on the login page
    And I login as a librarian
    And I click on "Users" link
    When I search for "test"
    Then table should contain rows with "test"