Feature: Verify the functionalities of DQ Rules page

  Background:
    Given Navigate to the DQG login page
#    When Update "praneeth.k@kairostech.com" in Email address field and "Password@1" in password field
#    And Click on Sign In button
    Then Validate "Connections" dashboard page is displayed

  @DQRules-Create
  Scenario: Validate DQ Rule is able to create from DQ Rules page
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on Create DQ Rule button
    And Click on Database Image
    And Update "rule9" rule name in rule name field
    And Select "SNOW" from select connection dropdown
    And Select "BULKTABLE1200" from select table dropdown
    And Click on "1" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And validate selected column is added
    And Select "No empty/null values" from checks and drop it to "1" row drop here under rule
    And Validate selected rule is added
    And Click on Create Rule button
    Then Validate "Created Successfully" popup message is displaying
    And Validate created rule is present in Rule list in DQ Rules page

  @DQRules-Delete
  Scenario: Validate selected DQ Rule is able to delete from Rules list
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Check "SNOW" connection name with "ru" DQ Rule checkbox to delete
    And Click on delete icon to delete connection
    And Click on yes button on delete confirmation popup
    Then Validate deleted rule with connection name is present in the DQ Rules table

  @DQRules-MultipleValueChecks
  Scenario: Validate multiple checks are able to add for a single rule
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on Create DQ Rule button
    And Click on Database Image
    And Update "rule6" rule name in rule name field
    And Select "SNOW" from select connection dropdown
    And Select "BULKTABLE1200" from select table dropdown
    And Click on "1" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And validate selected column is added
    And Select "Custom Pattern" from checks and drop it to "1" row drop here under rule
    And Validate selected rule is added
    And Select "No empty/null values" from checks and drop it to "1" row drop here under rule
    And Validate selected rule is added
    And Select "Equals" from checks and drop it to "1" row drop here under rule
    And Validate selected rule is added
    And Select "Contains" from checks and drop it to "1" row drop here under rule
    And Validate selected rule is added
    And Update "a" in "Contains" value Check field
    And Update "abc" in "Custom Pattern" value Check field
    And Update "india" in "Equals" value Check field
    And Click on Create Rule button
    And Validate "Created Successfully" popup message is displaying
    Then Validate created rule is present in Rule list in DQ Rules page

  @DQRules-MultipleColumns
  Scenario: Validate multiple columns are able to add for a single rule
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on Create DQ Rule button
    And Click on Database Image
    And Update "ru11" rule name in rule name field
    And Select "SNOW" from select connection dropdown
    And Select "BULKTABLE1200" from select table dropdown
    And Click on "1" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And validate selected column is added
    And Click on "1" row add column button
    And Select "ITEMTYPE" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And validate selected column is added
    And Select "No empty/null values" from checks and drop it to "1" row drop here under rule
    And Validate selected rule is added
    And Click on Create Rule button
    Then Validate "Created Successfully" popup message is displaying
    And Validate created rule is present in Rule list in DQ Rules page

  @DQRules-MultipleRules
  Scenario: Validate multiple row is able to add with multiple columns and checks
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on Create DQ Rule button
    And Click on Database Image
    And Update "rul2" rule name in rule name field
    And Select "SNOW" from select connection dropdown
    And Select "BULKTABLE1200" from select table dropdown
    And Click on "1" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And Click on "1" row add column button
    And Select "ITEMTYPE" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And Select "Custom Pattern" from checks and drop it to "1" row drop here under rule
    And Update "abc" in "Custom Pattern" value Check field
    And Click on Add row to add other rule
    And Click on "2" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And Select "Custom Pattern" from checks and drop it to "2" row drop here under rule
    And Update "abc" in "Custom Pattern" value Check field
    And Select "Equals" from checks and drop it to "2" row drop here under rule
    And Update "india" in "Equals" value Check field
    And Select "Contains" from checks and drop it to "2" row drop here under rule
    And Update "a" in "Contains" value Check field
    And Click on Create Rule button
    Then Validate "Created Successfully" popup message is displaying
    And Validate created rule is present in Rule list in DQ Rules page


  @DQRules-EditUpdateRule
  Scenario: Validate DQ rule is able to Edit and Update
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on "SNOW" connection name with "rul4" DQ Rule edit icon
    And Click on "1" row add column button
    And Select "ITEMTYPE" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And Click on Update button
    Then Validate "Updated Successfully" popup message is displaying
    And Validate created rule is present in Rule list in DQ Rules page

  @DQRules-DeleteRow
  Scenario: Validate existing Add columns & rules row is able to delete
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on "SNOW" connection name with "rul4" DQ Rule edit icon
    And Click on "1" row delete icon to delete Add columns & rules
    And Click on Add row to add other rule
    And Click on "1" row add column button
    And Select "COUNTRY" column from the table by checking checkbox in column table popUp
    And Select "ITEMTYPE" column from the table by checking checkbox in column table popUp
    And Click on cancel Icon on column table popUp
    And Select "No empty/null values" from checks and drop it to "1" row drop here under rule
    And Click on Update button
    Then Validate "Updated Successfully" popup message is displaying
    And Validate created rule is present in Rule list in DQ Rules page

  @DQRules-PreviewExecution
  Scenario: Validate DQ Rule execution result is able to preview with selected Rule
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on "SNOW" connection name with "rul4" DQ Rule edit icon
    And Click on Preview button
    Then Validate "Data Quality Rule Execution Result" page title is displayed
   And Validate selected Rule is displayed with execution results

  @DQRules-Preview
  Scenario: Validate selected DQ Rule preview details are displaying
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on "SNOW" connection name with "rul4" DQ Rule preview icon
    And Validate "PREVIEW" details are displayed
    Then Validate selected rule preview details are displayed

  @DQRules-NoExecResult
  Scenario: Validate execution results are able to display for non executed rule
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Click on "SNOW" connection name with "rul1" DQ Rule results icon
    Then Validate "NO EXECUTIONS FOUND" text is displayed

  @DQRules-ExecResult
  Scenario: Validate execution results are able to display for executed rule
    When Click on "DQ Rules" module
    And Validate "DQ Rules" dashboard page is displayed
    And Check execution is performed on "SNOW" connection name with "rul1" DQ Rule
    And Click on results icon of "SNOW" connection name with "rul1" DQ Rule if executed
    Then Validate execution results is displayed

