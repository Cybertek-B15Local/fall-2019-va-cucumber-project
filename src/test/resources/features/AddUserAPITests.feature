@smoke
Feature: Add user end point test

#this test case specifically for testing the add user service
  @add_user @api
  Scenario: add student using add user service
    Given new student is added using the add_user endpoint
    And I am on the login page
    When I login as the new user created using add_user endpoint
    Then "Books" page should be displayed

    #in this test case we test the books table
    # for this test we want to use API to generate new user information
    # so we are using api for test data generation

  @wip
    Scenario: books table
    Given new student is added using the add_user endpoint
    And I am on the login page
    When I login as the new user created using add_user endpoint
    And I navigate to "Books" page
    When I edit book The kite runner
    Then I verify book information
      | name            | author          | year |
      | The kite runner | Khaled Hosseini | 2003 |