package com.stepDefinitions;

//import com.Config.ReadConfig;

import com.baseClass.BasePage;
import com.pages.ConnectionsPage;
//import com.pages.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConnectionsStepDefs {
    BasePage bsPage;
    public ConnectionsPage connectionspage;

    public ConnectionsStepDefs() {
        bsPage = new BasePage();
        connectionspage = bsPage.getConnectionspage();
    }

    @Given("Navigate to the DQG login page")
    public void navigate_to_the_dqg_login_page() {
        connectionspage.navigateToDashBoardPage();
    }

    @When("Update {string} in Email address field and {string} in password field")
    public void update_in_email_address_field_and_in_password_field(String email, String pass) {
        connectionspage.enterEmail(email);
        connectionspage.enterPassword(pass);
    }

    @When("Click on Sign In button")
    public void click_on_sign_in_button() throws InterruptedException {
        connectionspage.clickOnSignInBtn();
    }

    @Then("Validate {string} dashboard page is displayed")
    public void validate_dashboard_page_is_displayed(String pageHeader) throws InterruptedException {
        connectionspage.verifyDashboardPageisDislayed(pageHeader);
    }

    @And("Select {string} database from connections page")
    public void select_database_from_connections_page(String databaseName) throws InterruptedException {
        connectionspage.selectdatabaseConnection(databaseName);
    }

    @When("Click on Add New button on selected DB")
    public void click_on_add_new_button_on_selected_db() {
        connectionspage.clickOnAddNewConnectionBtn();
    }

    @And("Validate {string} page is displayed")
    public void validate_page_is_displayed(String pgHeader) throws InterruptedException {
        connectionspage.validateNewConnPageHeader(pgHeader);
    }

    @And("Update {string} in Connection name field")
    public void update_in_connection_name_field(String conntName) throws InterruptedException {
        connectionspage.enterConnectionName(conntName);
    }

    @And("Update server in Server field")
    public void update_server_in_server_field() throws InterruptedException {
        connectionspage.enterServer();
    }

    @And("Update database in Database field")
    public void update_database_in_database_field() throws InterruptedException {
        connectionspage.enterDatabaseName();
    }

    @And("Select type auth from Authentication type dropdown")
    public void select_type_auth_from_authentication_type_dropdown() {
        connectionspage.selectAuthenticationType();
    }

    @And("Update user in User field")
    public void update_user_in_user_field() {
        connectionspage.enterUserName();
    }

    @And("Update password in Password field")
    public void update_password_in_password_field() throws InterruptedException {
        connectionspage.enterPasswordInNewConnectionPage();

    }

    @And("Select schema from Schema dropdown")
    public void select_schema_from_schema_dropdown() throws InterruptedException {
        connectionspage.selectSchemafromDropDown();
    }

    @And("Click on Test & Create button")
    public void click_on_test_create_button() throws InterruptedException {
        connectionspage.clickOnTestAndCreateButton();

    }

    @Then("Validate {string} popup message is displaying")
    public void validate_popup_message_is_displaying(String popUpMsgFromFeature) throws InterruptedException {
        connectionspage.verifyPopUpMessage(popUpMsgFromFeature);
    }

    @And("Click on close icon to display created connections")
    public void click_on_close_icon_to_display_created_connections() {
        connectionspage.clickOnCancelIcon();
    }

    @Then("Validate created connection is present in the Connection name column")
    public void validate_created_connection_is_present_in_the_connection_name_column() throws InterruptedException {
        connectionspage.validateConnectionNameIsPresentInAllConnectionsTable();
    }

    @And("Click on {string} connection to edit")
    public void click_on_connection_to_edit(String connectName) throws InterruptedException {
        connectionspage.clickOnConnection(connectName);
    }

    @And("Click on edit button")
    public void click_on_edit_button() {
        connectionspage.clickOnEditButton();
    }

    @And("Click on Test & Update button")
    public void click_on_test_update_button() {
        connectionspage.clickOnTestAndUpdate();
    }

    @And("Check the {string} checkbox to delete")
    public void check_the_checkbox_to_delete(String contNameToDel) throws InterruptedException {
        connectionspage.selectConnectionToDelete(contNameToDel);
    }

    @And("Click on delete icon to delete connection")
    public void click_on_delete_icon_to_delete_connection() {
        connectionspage.clickOnDeleteButton();
    }

    @And("Click on yes button on delete confirmation popup")
    public void click_on_yes_button_on_delete_confirmation_popup() throws InterruptedException {
        connectionspage.clickOnYesButtonOnConfirmationPopUp();
    }

    @Then("Validate deleted connection is present in the Connection name column")
    public void validate_deleted_connection_is_present_in_the_connection_name_column() throws InterruptedException {
        connectionspage.validateDeletedConnectionNameIsPresentInAllConnectionsTable();
    }

    @When("Click on {string} connection preview icon")
    public void click_on_connection_preview_icon(String cntNameToPreview) throws InterruptedException {
        connectionspage.clickOnPreviewButtonOfSelectedConnection(cntNameToPreview);
    }

    @And("Validate selected connection database tables are displayed on new Page")
    public void validate_selected_connection_database_tables_are_displayed_on_new_page() throws InterruptedException {
        connectionspage.verifySelectedConnectionDetailsAreDisplayed();
    }

    @And("Click on {string} table in the tables list")
    public void click_on_table_in_the_tables_list(String table) throws InterruptedException {
        connectionspage.selectTableFromTablesList(table);
    }

    @And("Validate selected table data is displayed")
    public void validate_selected_table_data_is_displayed() throws InterruptedException {
        connectionspage.verifySelectedTableDetailsAreDisplayed();
    }

    @And("Click on Validate button")
    public void click_on_validate_button() {
        connectionspage.clickOnValidateButton();
    }

    @Then("Validate fields displays {string} border color with empty data and display empty field names which are manditory")
    public void validate_fields_displays_border_color_with_empty_data_and_display_empty_field_names_which_are_manditory(String style) throws InterruptedException {
        connectionspage.validateRedColorIsHighLightingOnEmptyFields(style);
    }

    @And("Validate connection name field displays error help text with invalid data")
    public void validate_connection_name_field_displays_error_help_text_with_invalid_data() {
        connectionspage.verifyHelpTextIsDisplayed();
    }

    @And("Update {string} rule name in rule name field")
    public void update_rule_name_in_rule_name_field(String ruleName) throws InterruptedException {
        connectionspage.enterRuleName(ruleName);
    }

    @And("Click on {string} row add column button")
    public void click_on_row_add_column_button(String rowNum) throws InterruptedException {
        connectionspage.clickOnAddColumnButton(rowNum);
    }

    @And("Select {string} column from the table by checking checkbox in column table popUp")
    public void select_column_from_the_table_by_checking_checkbox_in_column_table_pop_up(String columnName) {
        connectionspage.selectColumnsFromTableList(columnName);
    }

    @And("Click on cancel Icon on column table popUp")
    public void click_on_cancel_icon_on_column_table_pop_up() {
        connectionspage.clickOnCancelIconOnAddColumPopUp();
    }

    @And("validate selected column is added")
    public void validate_selected_column_is_added() {
        connectionspage.validateSelectedColumnIsPresentInColumnSection();
    }

    @And("Select {string} from checks and drop it to {string} row drop here under rule")
    public void select_from_checks_and_drop_it_to_row_drop_here_under_rule(String checkName, String droprow) throws InterruptedException {
        connectionspage.selectChecksInValCheck(checkName, droprow);
    }

    @And("Validate selected rule is added")
    public void validate_selected_rule_is_added() {
        connectionspage.validateSelectedCheckIsPresentInRuleSection();
    }

    @And("Click on Create Rule button")
    public void click_on_create_rule_button() throws InterruptedException {
        connectionspage.clickOnCreateRuleButton();
    }

    @Then("Validate created rule is present in Rule list in DQ Rules page")
    public void validate_created_rule_is_present_in_rule_list_in_dq_rules_page() throws InterruptedException {
        connectionspage.validateRuleIsCreatedInRuleListForSelectedConnection();
    }

    @And("Leave Rule name field empty and validate field displays {string} border color")
    public void leave_rule_name_field_empty_and_validate_field_displays_border_color(String borderColor) {
        connectionspage.checkAndValidateRuleNameFieldIsAcceptingEmptyValues(borderColor);
    }

}
