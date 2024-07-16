Feature: Verify the Connections module functionalities

  Background:
    Given Navigate to the DQG login page
    When Update "praneeth.k@kairostech.com" in Email address field and "Password@1" in password field
    And Click on Sign In button
    Then Validate "Connections" dashboard page is displayed

#Scenario: Validate new connection is able to create on selected database
#  And Select "snowflake" database from connections page
#  When Click on Add New button on selected DB
# Then Validate "Add Snowflake Connection" page is displayed
#  And Update "Pran" in Connection name field
#  And Update server in Server field
#  And Update database in Database field
#  And Select type auth from Authentication type dropdown
#  And Update user in User field
#  And Update password in Password field
#  And Click on Test & Create button
#  Then Validate "Connection test succeeded. New data source created." popup message is displaying
#  And Click on close icon to display created connections
#  Then Validate created connection is present in the Connection name column
#
#  Scenario: Validate added connection is able to modify
#    And Select "snowflake" database from connections page
#    And Click on "Pran" connection to edit
#    Then Validate "View Snowflake Connection" page is displayed
#    And Click on edit button
#    Then Validate "Edit Snowflake Connection" page is displayed
#    And Update "Pran1" in Connection name field
#    And Click on Test & Update button
#    Then Validate "Connection test succeeded. Data source updated." popup message is displaying
#    And Validate created connection is present in the Connection name column

  Scenario: Validate added connection name is able to delete
    And Select "snowflake" database from connections page
  And Check the "demo1" checkbox to delete
  And Click on delete icon to delete connection
  And Click on yes button on delete confirmation popup
  Then Validate deleted connection is present in the Connection name column



#
#    Scenario: Validate DQ Rule page is navigated from Connections
#      And Click on "SnowFlake" connection preview icon
#      Then Validate selected connection database tables are displayed on new Page
#      And Click on "BULKTABLE1200" table in the tables list
#      Then Validate selected table data is displayed
#      And Click on Validate button
#      Then Validate "DQ Rules" dashboard page is displayed









