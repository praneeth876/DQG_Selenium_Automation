package com.pages;

import com.Enum.Context;
import com.pageElements.SettingsElements;
import com.utilities.JavaScriptUtils;
import com.utilities.ValidationUtils;
import com.utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Settings extends SettingsElements {
    private WebDriver driver;
    WebUtils webutils;
    JavaScriptUtils jsUtils;
    ValidationUtils valUtils;

    public Settings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webutils = new WebUtils(driver);
        jsUtils = new JavaScriptUtils(driver);
        valUtils = new ValidationUtils();
    }

    public void clickOnNotificationsIcon(){
        System.out.println("method calling");
        webutils.waitUntilElementVisible(notification);
        webutils.clickOnElement(notification);
    }
    public void clickOnViewAllLinkText(){
        webutils.waitUntilElementVisible(viewAll);
        webutils.clickOnElement(viewAll);
    }
    public void clickOnThemeModeIcon(){
        webutils.waitUntilElementVisible(mode);
        webutils.clickOnElement(mode);
    }
    public void verifyThemeIsChanged(String modeText,String color){
        boolean value=false;
        webutils.waitUntilElementVisible(mode);
        if(webutils.getElementAttribute(mode,"data-testid").contains(modeText)) {
            System.out.println(webutils.getElementCSSValue(bgColor, "background-color")+"----------------------");
            String actColor=webutils.getElementCSSValue(bgColor, "background-color");
            valUtils.validateAssertEquals(color,actColor,"Not changed to "+modeText);
        }
            }


    public void clickOnUserAccountSetting(){
        webutils.waitUntilElementVisible(account);
        webutils.clickOnElement(account);
    }

    public void clickOnLanguageDropDown(){
        webutils.waitUntilElementVisible(languageDropdown);
        webutils.clickOnElement(languageDropdown);
    }

    public void selectlanguageFromDropDown(String lang){
        Context.LANGUAGE.setValue(lang);
        for (WebElement language:languages){
            webutils.waitUntilElementVisible(language);
            if(webutils.getElementText(language).equals(lang)){
                webutils.clickOnElement(language);
                break;
            }
        }
    }
    public void verifySelectedLanguageIsDispalyed(){
        String sltLang=Context.LANGUAGE.getValue();
        webutils.clickOnElement(account);
        boolean value=false;
        if(webutils.getElementText(languageDropdown).equals(sltLang)){
            value=true;
        }
        valUtils.validateAssertTrue(value,"Not changed to "+sltLang);
    }

    public void clickOnLogoutButton(){
        webutils.waitUntilElementVisible(logout);
        webutils.clickOnElement(logout);
    }
    public void VerifyPageIsNavigatedToLoginPage(){
       boolean value=false;
       if (webutils.getCurrentURL().contains("login")){
           value=true;
       }
valUtils.validateAssertTrue(value,"Not navigated to login page");
    }

    public void clickOnServiceStatus(){
        webutils.waitUntilElementVisible(serviceStatusIcon);
        webutils.clickOnElement(serviceStatusIcon);
    }
    public void VerifyStatusServiceIsOnline(String status){
        boolean value=false;
       for (WebElement service: lstServices){
           System.out.println(webutils.getElementText(service));
           if(webutils.getElementText(service).contains(status)){
               System.out.println(webutils.getElementText(service));
               value=true;
           }
       }
        valUtils.validateAssertTrue(value,"Some service is not up and running");
    }




}
