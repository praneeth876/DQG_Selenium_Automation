package com.stepDefinitions;

import com.baseClass.BasePage;
import com.pages.ConnectionsPage;
import com.pages.DQ_RulesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DQRulesStepDefs {

    BasePage bsPage;
    public DQ_RulesPage dqRulesPage;
    public ConnectionsPage connectionsPage;

    public DQRulesStepDefs() {
        bsPage = new BasePage();
        dqRulesPage = bsPage.getDQRulepage();
        connectionsPage = bsPage.getConnectionspage();
    }

    @When("Click on {string} module")
    public void click_on_module(String modName) throws InterruptedException {

        dqRulesPage.clickOnModule(modName);
    }

    @And("Click on Create DQ Rule button")
    public void click_on_create_dq_rule_button() {
        dqRulesPage.clickOnCreateDQRuleButton();
    }

    @And("Click on Database Image")
    public void click_on_database_image() {
        dqRulesPage.clickOnDataBaseImage();
    }

    @And("Select {string} from select connection dropdown")
    public void select_from_select_connection_dropdown(String conntName) throws InterruptedException {
        dqRulesPage.chooseSelectConnectionFromDropDown(conntName);
    }

    @And("Select {string} from select table dropdown")
    public void select_from_select_table_dropdown(String tableName) throws InterruptedException {
        dqRulesPage.chooseTableFromDropDown(tableName);
    }

    @And("Check {string} connection name with {string} DQ Rule checkbox to delete")
    public void check_connection_name_with_dq_rule_checkbox_to_delete(String conntName, String ruleName) {
        dqRulesPage.selectRuleAndConnectNameCheckboxToDelete(conntName, ruleName);
    }

    @Then("Validate deleted rule with connection name is present in the DQ Rules table")
    public void validate_deleted_rule_with_connection_name_is_present_in_the_dq_rules_table() {
        dqRulesPage.validateDQRuleIsPresentInRulesList();
    }

    @And("Update {string} in {string} value Check field")
    public void update_in_value_check_field(String text, String ValCheck) throws InterruptedException {
        dqRulesPage.EnterTextInCheckFields(text, ValCheck);
    }

    @And("Click on Add row to add other rule")
    public void click_on_add_row_to_add_other_rule() {
        dqRulesPage.clickOnAddRowButton();
    }

    @And("Click on {string} connection name with {string} DQ Rule edit icon")
    public void click_on_connection_name_with_dq_rule_edit_icon(String conntname, String rulename) {
        dqRulesPage.clickOnEditButton(conntname, rulename);
    }

    @And("Click on Update button")
    public void click_on_update_button() {
        dqRulesPage.clickOnUpdateButton();
    }

    @And("Click on {string} row delete icon to delete Add columns & rules")
    public void click_on_row_delete_icon_to_delete_add_columns_rules(String rowDel) throws InterruptedException {
        dqRulesPage.clickOnDeleteSymbol(rowDel);
    }

    @And("Click on Preview button")
    public void click_on_preview_button() throws InterruptedException {
        dqRulesPage.clickOnPreviewButton();
    }

    @And("Validate {string} page title is displayed")
    public void validate_page_title_is_displayed(String pageheaderTitle) throws InterruptedException {
        dqRulesPage.verifyPageHeader(pageheaderTitle);
    }

    @And("Validate selected Rule is displayed with execution results")
    public void validate_selected_rule_is_displayed_with_execution_results() {
        dqRulesPage.validateSltChecksAndColumnsArePresentWithExeRults();
    }

    @And("Click on {string} connection name with {string} DQ Rule preview icon")
    public void click_on_connection_name_with_dq_rule_preview_icon(String conntname, String rulename) {
        dqRulesPage.clickOnPreviewButton(conntname, rulename);
    }

    @And("Validate {string} details are displayed")
    public void validate_details_are_displayed(String pagHdTitle) {
        dqRulesPage.verifyPreviewPageIsDisplayed(pagHdTitle);
    }

    @Then("Validate selected rule preview details are displayed")
    public void validate_selected_rule_preview_details_are_displayed() {
        dqRulesPage.verifySelectedRulePreviewDetailsAreDisplayed();
    }

    @And("Click on {string} connection name with {string} DQ Rule results icon")
    public void click_on_connection_name_with_dq_rule_results_icon(String conntname, String rulename) {
        dqRulesPage.clickOnResultsIcon(conntname, rulename);
    }

    @Then("Validate {string} text is displayed")
    public void validate_text_is_displayed(String expText) {
        dqRulesPage.VerifyTextIsPresentInResultsWithoutExecution(expText);
    }

    @And("Check execution is performed on {string} connection name with {string} DQ Rule")
    public void check_execution_is_performed_on_connection_name_with_dq_rule(String conntname, String rulename) {
        dqRulesPage.verifyLastExecutionOfRule(conntname, rulename);
    }

    @And("Click on results icon of {string} connection name with {string} DQ Rule if executed")
    public void click_on_results_icon_of_connection_name_with_dq_rule_if_executed(String conntname, String rulename) throws InterruptedException {
        dqRulesPage.clickOnResultsIconIfAlreadyExecutionIsDone(conntname, rulename);
    }

    @Then("Validate execution results is displayed")
    public void validate_execution_results_is_displayed() {
        dqRulesPage.verifyExecutionResultsAreDisplayed();
    }
}
