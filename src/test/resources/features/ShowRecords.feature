Feature: Show records functionality

  Background:
    Given I am on the login page
    And I login as a librarian

    @wip
  Scenario: verify default values in Users page
    When I click on "Users" link
    Then show records default value should be 10
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |
