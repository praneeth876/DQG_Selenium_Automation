Feature: Verify the Connections module functionalities

  Background:
    Given Navigate to the DQG login page
#    When Update "praneeth.k@kairostech.com" in Email address field and "Password@1" in password field
#    And Click on Sign In button
    Then Validate "Connections" dashboard page is displayed

  @Smoke @Connections
  Scenario: Validate new connection is able to create on selected database
    And Select "snowflake" database from connections page
    When Click on Add New button on selected DB
    Then Validate "Add Snowflake Connection" page is displayed
    And Update "SNOW" in Connection name field
    And Update server in Server field
    And Update database in Database field
    And Select type auth from Authentication type dropdown
    And Update user in User field
    And Update password in Password field
    And Select schema from Schema dropdown
    And Click on Test & Create button
    Then Validate "Connection test succeeded. New data source created." popup message is displaying
    And Click on close icon to display created connections
    Then Validate created connection is present in the Connection name column

  @Regression @Connections
  Scenario: Validate duplicate connection is able to create
    And Select "snowflake" database from connections page
    When Click on Add New button on selected DB
    Then Validate "Add Snowflake Connection" page is displayed
    And Update "SNOW" in Connection name field
    And Update server in Server field
    And Update database in Database field
    And Select type auth from Authentication type dropdown
    And Update user in User field
    And Update password in Password field
    And Select schema from Schema dropdown
    And Click on Test & Create button
    Then Validate "Data Source name already existed, Please provide another name" popup message is displaying

  @Smoke @Connections
  Scenario: Validate new connection is able to create on selected database by leaving fields blank
    And Select "snowflake" database from connections page
    When Click on Add New button on selected DB
    Then Validate "Add Snowflake Connection" page is displayed
    And Update "" in Connection name field
    And Update server in Server field
    And Update database in Database field
    And Select type auth from Authentication type dropdown
    And Update user in User field
    And Update password in Password field
    And Select schema from Schema dropdown
    And Click on Test & Create button
    Then Validate fields displays "0px rgb(211, 47, 47)" border color with empty data and display empty field names which are manditory

  @Regression @Connections
  Scenario: Validate added connection is able to modify
    And Select "snowflake" database from connections page
    And Click on "SNOW" connection to edit
    Then Validate "View Snowflake Connection" page is displayed
    And Click on edit button
    Then Validate "Edit Snowflake Connection" page is displayed
    And Update "demo" in Connection name field
    And Update password in Password field
    And Select schema from Schema dropdown
    And Click on Test & Update button
    Then Validate "Connection test succeeded. Data source updated." popup message is displaying
    And Validate created connection is present in the Connection name column

  @Regression @Connections
  Scenario: Validate added connection name is able to delete
    And Select "snowflake" database from connections page
    And Check the "SNOWFLAKE" checkbox to delete
    And Click on delete icon to delete connection
    And Click on yes button on delete confirmation popup
    Then Validate deleted connection is present in the Connection name column

  @Smoke @Connections-1
  Scenario: Validate connection name field accepts invalid data range
    And Select "snowflake" database from connections page
    When Click on Add New button on selected DB
    Then Validate "Add Snowflake Connection" page is displayed
    And Update "Pr" in Connection name field
    And Update server in Server field
    And Update database in Database field
    And Select type auth from Authentication type dropdown
    And Update user in User field
    And Update password in Password field
    And Select schema from Schema dropdown
    And Click on Test & Create button
    Then Validate connection name field displays error help text with invalid data

  @Connections-DQRule
  Scenario: Validate DQ Rule page is navigated from Connections
    And Select "snowflake" database from connections page
    And Click on "SNOW" connection preview icon
    Then Validate selected connection database tables are displayed on new Page
    And Click on "BULKTABLE1200" table in the tables list
    Then Validate selected table data is displayed
    And Click on Validate button
    Then Validate "DQ Rules" dashboard page is displayed

  @@Connections-DQRule
  Scenario: Validate DQ Rule is able to create for selected database
    And Select "snowflake" database from connections page
    And Click on "SNOW" connection preview icon
    Then Validate selected connection database tables are displayed on new Page
    And Click on "BULKTABLE1200" table in the tables list
    Then Validate selected table data is displayed
    And Click on Validate button
    Then Validate "DQ Rules" dashboard page is displayed
    And Update "rule7" rule name in rule name field
    And Click on "1" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    Then validate selected column is added
    And Select "No empty/null values" from checks and drop it to "1" row drop here under rule
    Then Validate selected rule is added
    And Click on Create Rule button
    Then Validate "Created Successfully" popup message is displaying
    And Validate created rule is present in Rule list in DQ Rules page

  @Connections-DQRule
  Scenario: Validate duplicate DQ Rule is able to create for selected database
    And Select "snowflake" database from connections page
    And Click on "SNOW" connection preview icon
    Then Validate selected connection database tables are displayed on new Page
    And Click on "BULKTABLE1200" table in the tables list
    Then Validate selected table data is displayed
    And Click on Validate button
    Then Validate "DQ Rules" dashboard page is displayed
    And Update "rule7" rule name in rule name field
    And Click on "1" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    Then validate selected column is added
    And Select "No empty/null values" from checks and drop it to "1" row drop here under rule
    Then Validate selected rule is added
    And Click on Create Rule button
    Then Validate "Validation name already existed, Please provide another name" popup message is displaying

  @Connections-DQRule
  Scenario: Validate Rule name manditory field accepts empty data
    And Select "snowflake" database from connections page
    And Click on "SNOW" connection preview icon
    Then Validate selected connection database tables are displayed on new Page
    And Click on "BULKTABLE1200" table in the tables list
    Then Validate selected table data is displayed
    And Click on Validate button
    Then Validate "DQ Rules" dashboard page is displayed
    Then Leave Rule name field empty and validate field displays "0px rgb(211, 47, 4)" border color






