Feature: Verify the functionalities of DQG tool settings

  Background:
    Given Navigate to the DQG login page
#    When Update "praneeth.k@kairostech.com" in Email address field and "Password@1" in password field
#    And Click on Sign In button
    Then Validate "Connections" dashboard page is displayed


#  Scenario: Validate user is able to view All notifications
#    And Click on Notifications Icon
#    And Click on View All notifications
#    Then Validate "All Notifications" dashboard page is displayed

  @mode
  Scenario: Validate user can able to change the theme
    And Click on mode Icon
    Then Validate "DarkMode" theme is displayed and Check "rgba(29, 36, 60, 1)" bg color
    And Click on mode Icon
    Then Validate "LightMode" theme is displayed and Check "rgba(244, 241, 255, 1)" bg color

  @language
  Scenario: Validate tool language is able to change
    And Click on the user account setting dropdown
    And Select "English" language from lang dropdown
    Then Validate tool labels is displayed in selected language

  @logout
  Scenario: Validate user is able to logout from DQG tool
    And Click on the user account setting dropdown
    And Click on Logout button
    Then Validate page is navigated to login page

  @service
  Scenario: Validate service status is up and running
    And Click on service status icon
    Then Validate services are in "Online"
