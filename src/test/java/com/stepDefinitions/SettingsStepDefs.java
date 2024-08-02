package com.stepDefinitions;

import com.baseClass.BasePage;
import com.pages.ConnectionsPage;
import com.pages.Settings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SettingsStepDefs {

    BasePage bsPage;
    public Settings settings;

    public SettingsStepDefs (){
        bsPage=new BasePage();
        settings=bsPage.getSettings();
    }

    @And("Click on Notifications Icon")
    public void click_on_notifications_icon() {
        System.out.println("inside method");
        settings.clickOnNotificationsIcon();
    }
    @And("Click on View All notifications")
    public void click_on_view_all_notifications() {
        settings.clickOnViewAllLinkText();
    }
    @When("Click on mode Icon")
    public void click_on_mode_icon() {
        settings.clickOnThemeModeIcon();
    }
    @Then("Validate {string} theme is displayed and Check {string} bg color")
    public void validate_theme_is_displayed_and_check_bg_color(String modeText, String bgColor) {
       settings.verifyThemeIsChanged(modeText,bgColor);
    }
    @When("Click on the user account setting dropdown")
    public void click_on_the_user_account_setting_dropdown() {
        settings.clickOnUserAccountSetting();
    }
    @And("Select {string} language from lang dropdown")
    public void select_language_from_lang_dropdown(String lang) {
        settings.clickOnLanguageDropDown();
        settings.selectlanguageFromDropDown(lang);
    }
    @Then("Validate tool labels is displayed in selected language")
    public void validate_tool_labels_is_displayed_in_selected_language() {
        settings.verifySelectedLanguageIsDispalyed();
    }
    @And("Click on Logout button")
    public void click_on_logout_button() {
        settings.clickOnLogoutButton();
    }
    @Then("Validate page is navigated to login page")
    public void validate_page_is_navigated_to_login_page() {
        settings.VerifyPageIsNavigatedToLoginPage();
    }

    @When("Click on service status icon")
    public void click_on_service_status_icon() {
      settings.clickOnServiceStatus();
    }
    @Then("Validate services are in {string}")
    public void validate_services_are_in(String status) {
        settings.VerifyStatusServiceIsOnline(status);
    }


}
