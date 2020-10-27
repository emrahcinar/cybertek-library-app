Feature: Login with parameters

    @librarianParam
    Scenario: Login as librarian 43
      Given I am on the login page
      When I enter user name "librarian43@library"
      And I enter password "np6AxVIh"
      And click the sign in button
      And there should be 1398 users
      Then dashboard should be displayed

      @studentParam
    Scenario: Login as student
    Given I am on the login page
    When I enter user name "student30@library"
    And I enter password "IaT9YI0I"
    And click the sign in button
    Then books should be displayed


        @wip
        Scenario: Login as a librarian same line
          Given I am on the login page
          When I login using "librarian43@library" and "np6AxVIh"
          Then dashboard should be displayed
