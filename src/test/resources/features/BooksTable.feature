Feature: books table


  Scenario: Verify search results
    Given I am on the login page
    And I login to application as a student
    When I navigate to "Books" page
    And I search for "The Goldfinch"
    Then books table should contain results matching The Goldfinch

  @wip
  Scenario: Verify book information
    Given I am on the login page
    And I login to application as a librarian
    And I navigate to "Books" page
    When I edit book The kite runner
    Then I verify book information
      | name            | author          | year |
      | The kite runner | Khaled Hosseini | 2003 |