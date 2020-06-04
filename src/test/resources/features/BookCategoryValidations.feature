Feature: book categories

  @db
  Scenario: verify book categories
    Given I am on the login page
    And I login as a librarian
    When I navigate to "Books" page
    Then book categories must match api and db

  @wip
  Scenario: verify user groups
    Given I get information for each user using get_user_by_id endpoint
    When I get the available groups using the get_user_groups endpoint
    Then groups of non admin users should match the groups from get_user_groups
