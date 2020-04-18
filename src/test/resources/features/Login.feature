Feature: Login

  Background:

  Scenario: Login as a librarian
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed

