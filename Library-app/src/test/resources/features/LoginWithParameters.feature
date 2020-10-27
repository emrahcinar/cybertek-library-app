Feature: Login with parameters

  @librarianParam
  Scenario: Login as librarian 43
    Given I am on the login page
    When I enter username "librarian43@library"
    And I enter password 'np6AxVIh'
    And click the sign in button
    And there should be 766 users
    Then dashboard should be displayed
    #number can be whatever you have there

  @studentParam
  Scenario: Login as student 12
    Given I am on the login page
    When I enter username "student12@library"
    And I enter password 'UC0LC9Hj'
    And click the sign in button
    Then books should be displayed


  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian43@library" and "np6AxVIh"
    Then dashboard should be displayed

