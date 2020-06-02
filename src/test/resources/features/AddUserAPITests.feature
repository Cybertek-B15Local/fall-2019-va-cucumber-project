Feature: Add user end point test

  @wip
  Scenario: add student using add user service
    Given new student is added using the add_user endpoint
    And I am on the login page
    When I login as the new user created using add_user endpoint
    Then "Books" page should be displayed