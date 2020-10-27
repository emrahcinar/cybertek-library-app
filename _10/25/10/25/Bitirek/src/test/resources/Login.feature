Feature: Login
  As a user, I want to be able to access  with username and password

 #Background: Truck driver is on the vyTrack login page
    Given User is on the login page

  @positiveLogin
  Scenario: Login  with correct credentials and verify by the name
    Given User is on the login page
    When User enters correct username
    And User enters correct password
    And User clicks login button
    Then User name should be displayed
