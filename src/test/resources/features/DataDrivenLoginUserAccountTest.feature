Feature: User account tests

  @wip
  Scenario: Verify user information
    Given I am on the login page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then account holder name should be "Test Librarian 12"

    # name              email             password
    # Test Student 26 student26@library   JTvaF3br