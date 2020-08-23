Feature:
  1. As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  Scenario: "1.1. User should be able to click on upload files icon to upload files and pictures from local disks

    Given User is on the login page
    Then User logs in as "hr"
    And user navigates to "Activity Stream"
    When User clicks "message" button
    And User clicks "upload files" icon
    And User upload files and images
    And User clicks send button
    Then User should able to see the picture on page

  Scenario: "1.2 User should be able to click on upload files icon to download from external drive, select documents from bixtrix24,
  and create files to upload.


  Scenario: "1.3 User should be able to click on upload files icon to select documents from bixtrix24, and create files to upload.
