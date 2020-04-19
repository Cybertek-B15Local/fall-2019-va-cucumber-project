@smoke @lib-100 @login
Feature: Login
  As I user, I should be able to login

  @librarian @staff
  Scenario: Login as a librarian
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed

  @student
  Scenario: Login as a student
    Given I am on the login page
    When I login as a student
    Then dashboard should be displayed

  @admin @staff
  Scenario: Login as a admin
    Given I am on the login page
    When I login as an admin
    Then dashboard should be displayed
