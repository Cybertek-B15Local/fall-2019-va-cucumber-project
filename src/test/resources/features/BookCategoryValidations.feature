Feature: book categories

  @wip
  Scenario: verify book categories
    Given I am on the login page
    And I login as a librarian
    When I navigate to "Books" page
    Then book categories must match api and db