package com.stepDefinitions;

import com.Config.ReadConfig;
import com.baseClass.BasePage;
import com.pages.ConnectionsPage;
import com.pages.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConnectionsStepDefs {
    BasePage bsPage;
  public ConnectionsPage connectionspage;

    public ConnectionsStepDefs (){
        bsPage=new BasePage();
        connectionspage=bsPage.getConnectionspage();
    }

    @Given("Navigate to the DQG login page")
    public void navigate_to_the_dqg_login_page() {
//        if(Hooks.driver!=null) {
//            connectionspage = new ConnectionsPage(Hooks.driver);
//        }else{
//            System.out.println("driver is Null");
//        }
        connectionspage.navigateToURL();
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
    @Then("Validate {string} page is displayed")
    public void validate_page_is_displayed(String pgHeader) throws InterruptedException {
        connectionspage.validateNewConnPageHeader(pgHeader);
    }
    @Then("Update {string} in Connection name field")
    public void update_in_connection_name_field(String conntName) {
        connectionspage.enterConnectionName(conntName);
    }
    @Then("Update server in Server field")
    public void update_server_in_server_field() throws InterruptedException {
       connectionspage.enterServer();
    }
    @Then("Update database in Database field")
    public void update_database_in_database_field() throws InterruptedException {
        connectionspage.enterDatabaseName();
    }
    @Then("Select type auth from Authentication type dropdown")
    public void select_type_auth_from_authentication_type_dropdown() {
        connectionspage.selectAuthenticationType();
    }
    @Then("Update user in User field")
    public void update_user_in_user_field() {
        connectionspage.enterUserName();
    }
    @Then("Update password in Password field")
    public void update_password_in_password_field() {
        connectionspage.enterPasswordInNewConnectionPage();
    }
    @Then("Click on Test & Create button")
    public void click_on_test_create_button() throws InterruptedException {
      connectionspage.clickOnTestAndCreateButton();

    }
    @Then("Validate {string} popup message is displaying")
    public void validate_popup_message_is_displaying(String popUpMsg) throws InterruptedException {
connectionspage.verifyPopUpMessage(popUpMsg);
    }
    @Then("Click on close icon to display created connections")
    public void click_on_close_icon_to_display_created_connections() {
connectionspage.clickOnCancelIcon();
    }
    @Then("Validate created connection is present in the Connection name column")
    public void validate_created_connection_is_present_in_the_connection_name_column() throws InterruptedException {
        connectionspage.validateConnectionNameIsPresentInAllConnectionsTable();
    }
    @Then("Click on {string} connection to edit")
    public void click_on_connection_to_edit(String connectName) throws InterruptedException {
        connectionspage.clickOnConnection(connectName);
    }

    @Then("Click on edit button")
    public void click_on_edit_button() {
        connectionspage.clickOnEditButton();
    }

    @Then("Click on Test & Update button")
    public void click_on_test_update_button() {
connectionspage.clickOnTestAndUpdate();
    }
    @Then("Check the {string} checkbox to delete")
    public void check_the_checkbox_to_delete(String contNameToDel) throws InterruptedException {
       connectionspage.selectConnectionToDelete(contNameToDel);
    }
    @Then("Click on delete icon to delete connection")
    public void click_on_delete_icon_to_delete_connection() {
       connectionspage.clickOnDeleteButton();
    }
    @Then("Click on yes button on delete confirmation popup")
    public void click_on_yes_button_on_delete_confirmation_popup() throws InterruptedException {
        connectionspage.clickOnYesButtonOnConfirmationPopUp();
    }
    @Then("Validate deleted connection is present in the Connection name column")
    public void validate_deleted_connection_is_present_in_the_connection_name_column() throws InterruptedException {
        connectionspage.validateDeletedConnectionNameIsPresentInAllConnectionsTable();
    }







    @Then("Click on {string} connection preview icon")
    public void click_on_connection_preview_icon(String string) {

    }
    @Then("Validate selected connection database tables are displayed on new Page")
    public void validate_selected_connection_database_tables_are_displayed_on_new_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Click on {string} table in the tables list")
    public void click_on_table_in_the_tables_list(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Validate selected table data is displayed")
    public void validate_selected_table_data_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Click on Validate button")
    public void click_on_validate_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
