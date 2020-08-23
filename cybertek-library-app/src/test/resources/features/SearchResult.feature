Feature: Search Functionality on the users page

  As a user, When I login as a librarian and I go to Users page, then table should have following columns
  •Actions
  •UserID
  •Full Name
  •Email
  •Group
  •Status
  @wip
  Scenario: Table Columns names
    Given I am on the login page
    And I login as a librarian
    And I click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |