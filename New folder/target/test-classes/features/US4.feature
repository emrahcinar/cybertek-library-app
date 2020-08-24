#1. User should be able to click on upload files icon to upload files and pictures from local disks,
# download from
# external drive, select documents from bixtrix24, and create files to upload.
#2. User should be able to add users from selecting contact from E-mail user,
# Employees and Departments and Recent contact lists.
#3. User should be able to attach link by clicking on the link icon.
#4. User should be able to insert videos by clicking on the video icon and entering the video URL.
#5. User should be able to create a quote by clicking on the Comma icon.
#6. User should be able to add mention by clicking on the Add mention icon and select contacts
# from the lists provided in dropdown.
#7. User should be able to click on Visual Editor and see the editor text-bar displays on
# top of the message box.
#8. User should be able to click on the Topic icon to see the poll Topic text box displays on
# top of the message box.
#9. User should be able to click on "Record Video" tab to record a video and attach it with the
# message.
#10. User should be able to Add questions and multiple answers; user can provide multiple choice
# to attendees by selecting the Allow multiple choice checkbox.

@bitrix
Feature: As a user, I should be able to create a
  poll by clicking on Poll tab under Active Stream.

  Background:
    Given User is on the Login page
    Then User logs in as marketing credential
    Then User should be able to see dashboard

  @acOne
  Scenario: Uploading files scenario
    Then user click to file under more dropdown
    Then user should be able to see uploads file and images icon
    Then user should be able to see download from external drive icon
    And user should be able to see select document from Bixtrix24 icon
    And user should be able to see create files to upload icon

    @acthree
    Scenario: attaching link by clicking on the link icon.
      Then user clicks to send message empty space
      And user clicks to link icon button
      And user should send link to link URL space and hit enter button
      And user should click send button

  @acfour
  Scenario: Inserting videos by clicking video icon and entering the video URL
    Then user clicking to send message empty space
    And user clicks to video icon button
    And user should entering video URL and hit enter button
    And user clickin to send button