Feature: Verify the Connections module functionalities

  Background:
    Given Navigate to the DQG login page
    When Update "" in Email address field and "" in password field
    And Click on Sign In button
    Then Validate Connections homepage is displayed

Scenario: Validate new connection is able to create on selected database
  And Select "snowflake" database from connections page
  When Click on Add New button on selected DB
  Then Verify "Add Snowflake Connection" page is displayed
  And Update "SnowFlake" in Connection name field
  And Update server in Server field
  And Update database in Database field
  And Select type auth from Authentication type dropdown
  And Update user in User field
  And Update password in Password field
  And Click on Test & Create button
  And Click on close icon



