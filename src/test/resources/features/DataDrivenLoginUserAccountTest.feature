Feature: User account tests

  @wip
  Scenario: Verify user information
    Given I am on the login page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then account holder name should be "Test Librarian 12"