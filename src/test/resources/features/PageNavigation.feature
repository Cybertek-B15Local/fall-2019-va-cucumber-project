Feature: Page navigation links

  # login as librarian
  # click on the users link
  # verify page Users

  # login as librarian
  # click on the Books link
  # verify page Books

  Scenario: Go to users page
    Given I am on the login page
    And I login as a librarian
    When I click on "Users" link
    Then "Users" page should be displayed

  @wip
  Scenario: Go to books page
    Given I am on the login page
    And I login as a librarian
    When I click on "Books" link
    Then "Books" page should be displayed