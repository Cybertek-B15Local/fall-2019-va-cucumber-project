Feature: books table

  @wip
  Scenario: Verify search results
    Given I am on the login page
    And I login to application as a student
    When I navigate to "Books" page
    And I search for "1984"
    Then books table should contain results matching 1984

