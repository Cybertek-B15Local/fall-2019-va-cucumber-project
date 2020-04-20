@lib-2423
Feature: Search functionality on the users page

  Background:
    Given I am on the login page
    And I login as a librarian
    And I click on "Users" link

  Scenario: Search accuracy
    When I search for "test"
    Then table should contain rows with "test"

  @wip
  Scenario: Table columns names
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |