package com.stepDefinitions;

import com.baseClass.BasePage;
import com.pages.ConnectionsPage;
import com.pages.DQ_RulesPage;
import io.cucumber.java.en.Then;

public class DQRulesStepDefs {

    BasePage bsPage;
    public DQ_RulesPage dqRulesPage;
    public ConnectionsPage connectionsPage;

    public DQRulesStepDefs() {
        bsPage = new BasePage();
        dqRulesPage = bsPage.getDQRulepage();
        connectionsPage = bsPage.getConnectionspage();
    }


    @Then("Click on {string} module")
    public void click_on_module(String modName) throws InterruptedException {

        dqRulesPage.clickOnModule(modName);
    }

    @Then("Click on Create DQ Rule button")
    public void click_on_create_dq_rule_button() {
        dqRulesPage.clickOnCreateDQRuleButton();
    }

    @Then("Click on Database Image")
    public void click_on_database_image() {
        dqRulesPage.clickOnDataBaseImage();
    }

    @Then("Select {string} from select connection dropdown")
    public void select_from_select_connection_dropdown(String conntName) throws InterruptedException {
        dqRulesPage.chooseSelectConnectionFromDropDown(conntName);
    }

    @Then("Select {string} from select table dropdown")
    public void select_from_select_table_dropdown(String tableName) throws InterruptedException {
        dqRulesPage.chooseTableFromDropDown(tableName);
    }

    @Then("Check {string} connection name with {string} DQ Rule checkbox to delete")
    public void check_connection_name_with_dq_rule_checkbox_to_delete(String conntName, String ruleName) {
        dqRulesPage.selectRuleAndConnectNameCheckboxToDelete(conntName, ruleName);
    }

    @Then("Validate deleted rule with connection name is present in the DQ Rules table")
    public void validate_deleted_rule_with_connection_name_is_present_in_the_dq_rules_table() {
        dqRulesPage.validateDQRuleIsPresentInRulesList();
    }

    @Then("Update {string} in {string} value Check field")
    public void update_in_value_check_field(String text, String ValCheck) throws InterruptedException {
        dqRulesPage.EnterTextInCheckFields(text,ValCheck);
    }
    @Then("Click on Add row to add other rule")
    public void click_on_add_row_to_add_other_rule() {
        dqRulesPage.clickOnAddRowButton();
    }

}
