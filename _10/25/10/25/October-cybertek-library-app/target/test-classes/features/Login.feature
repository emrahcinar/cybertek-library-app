Feature: Login feature

  @librarian
  Scenario: Login as Librarian
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed

    @student
  Scenario: Login as Student
    Given I am on the login page
    When I login as a Student
    Then books should be displayed