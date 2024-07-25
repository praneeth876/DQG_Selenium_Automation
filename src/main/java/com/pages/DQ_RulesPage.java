package com.pages;

import com.Config.NewConnectionsDataConfig;
import com.DriverManagers.LoggerManager;
import com.Enum.ChecksAndColumns;
import com.Enum.Context;
import com.pageElements.DQ_RulesElements;
import com.utilities.JavaScriptUtils;
import com.utilities.ValidationUtils;
import com.utilities.WebUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DQ_RulesPage extends DQ_RulesElements {

    private WebDriver driver;
    WebUtils webutils;
    JavaScriptUtils jsUtils;
    ValidationUtils valUtils;

    public DQ_RulesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webutils = new WebUtils(driver);
        jsUtils = new JavaScriptUtils(driver);
        valUtils = new ValidationUtils();

    }


    public void clickOnCreateDQRuleButton() {
        webutils.waitUntilElementVisible(createDQRuleBtn);
        webutils.clickOnElement(createDQRuleBtn);
    }

    public void clickOnDataBaseImage() {
        webutils.waitUntilElementVisible(databaseIcon);
        webutils.clickOnElement(databaseIcon);
    }


    public void chooseSelectConnectionFromDropDown(String connt) throws InterruptedException {
        Context.CONNECTION_NAME.setValue(connt);
        webutils.waitUntilElementVisible(sltContDrpDwn);
        webutils.clickOnElement(sltContDrpDwn);
        webutils.updateElementText(sltContDrpDwn, connt);
        Thread.sleep(4000);
        webutils.pressKeyBoardDownArrow();
        webutils.pressKeyBoardENTER();
    }

    public void chooseTableFromDropDown(String table) throws InterruptedException {
        Thread.sleep(20000);
        Context.TABLE_NAME.setValue(table);
        webutils.waitUntilElementVisible(sltTabledrpDwn);
        webutils.clickOnElement(sltTabledrpDwn);
        webutils.updateElementText(sltTabledrpDwn, table);
        webutils.pressKeyBoardDownArrow();
        webutils.pressKeyBoardENTER();
        //Thread.sleep(10000);
    }

    public void clickOnModule(String moduleName) {
        for (WebElement modList : lstmoduleNames) {
            if (webutils.getElementText(modList).equals(moduleName)) {
                webutils.clickOnElement(modList);
                break;
            }
        }

    }

    public void selectRuleAndConnectNameCheckboxToDelete(String conntName, String ruleName) {
        Context.CONNECTION_NAME.setValue(conntName);
        Context.RULE_NAME.setValue(ruleName);
        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equalsIgnoreCase(conntName)) {
                if (webutils.getElementText(lstRuleNames.get(i)).equalsIgnoreCase(ruleName)) {
                    webutils.clickOnElement(contNameChkBoxs.get(i));
                    break;
                }
            }
        }
    }


    public void validateDQRuleIsPresentInRulesList() {
        boolean value = false;
        String conntName = Context.CONNECTION_NAME.getValue();
        String ruleName = Context.RULE_NAME.getValue();

        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equalsIgnoreCase(conntName)) {
                if (webutils.getElementText(lstRuleNames.get(i)).equalsIgnoreCase(ruleName)) {
                    value = true;
                    System.out.println("------------------------Rule is not present----------------------------");
                    break;
                }
            }
        }
        valUtils.validateAssertTrue(value, "Rule is not deleted from the table");
    }

    public void EnterTextInCheckFields(String text,String valCheck) throws InterruptedException {
        Thread.sleep(5000);
        //ChecksAndColumns.CHECK_NAME.setValue(valCheckName);
        String sltCheck = ChecksAndColumns.CHECK_NAME.getValue();
        // webutils.waitUntilElementVisible(sltValChecksList);

        for(WebElement valChecks:sltValChecksList){
            webutils.waitUntilElementVisible(valChecks);
           if( webutils.getElementText(valChecks).contains(valCheck)){

               if((webutils.getElementAttribute(sltValChecksFieldList,"value").equals(""))){
                   webutils.updateElementText(sltValChecksFieldList,text);
                   break;
               }
            }
        }

//        boolean value = false;
//        if (webutils.getElementText(sltValChecksList).contains(sltCheck)) {
//            if(sltValChecksFieldList.isDisplayed() || (webutils.getElementAttribute(sltValChecksFieldList,"value").equals(""))){
//                webutils.updateElementText(sltValChecksFieldList,text);
//            }else if(!(webutils.getElementAttribute(sltValChecksFieldList,"value").equals(""))){
//                webutils.updateElementText(sltValChecksFieldList,text);
//            }
//        }
        }

        public void validateLoadingText(int time){

        try{
            if(webutils.getElementText(loading).equals("Loading")){
                     Thread.sleep(time);
            }
        }catch(NoSuchElementException | InterruptedException ignored){

        }
        }


}
