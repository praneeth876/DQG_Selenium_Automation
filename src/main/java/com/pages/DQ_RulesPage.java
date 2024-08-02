package com.pages;


import com.Enum.ChecksAndColumns;
import com.Enum.Context;
import com.pageElements.DQ_RulesElements;
import com.utilities.JavaScriptUtils;
import com.utilities.ValidationUtils;
import com.utilities.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
        Thread.sleep(10000);
        Context.TABLE_NAME.setValue(table);
        webutils.waitUntilElementVisible(sltTabledrpDwn);
        webutils.clickOnElement(sltTabledrpDwn);
        webutils.updateElementText(sltTabledrpDwn, table);
        webutils.pressKeyBoardDownArrow();
        webutils.pressKeyBoardENTER();
    }

    public void clickOnModule(String moduleName) throws InterruptedException {
        for (WebElement modList : lstmoduleNames) {
            webutils.waitUntilElementVisible(modList);
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
                    break;
                }
            }
        }
        valUtils.validateAssertTrue(value, "Rule is not deleted from the table");
    }

    //
    public void EnterTextInCheckFields(String text, String valCheck) throws InterruptedException {
        Thread.sleep(5000);
        String sltCheck = ChecksAndColumns.CHECK_NAME.getValue();
        int count = 0;
        for (WebElement webElement : sltValChecksList) {
            if (sltValChecksFieldList.size() > 0) {
                for (WebElement element : sltValChecksFieldList) {
                    if ((webutils.getElementText(webElement).equalsIgnoreCase(valCheck)) && (webutils.getElementAttribute(element, "value").equals(""))) {
                        webutils.updateElementText(element, text);
                        break;
                    }
                }
            } else {
                if ((webutils.getElementText(webElement).equalsIgnoreCase(valCheck)) && (webutils.getElementAttribute(sltValChecksFieldFirst, "value").equals(""))) {
                    webutils.updateElementText(sltValChecksFieldFirst, text);
                }
            }
        }
    }


    public void clickOnAddRowButton() {
        webutils.waitUntilElementVisible(addRow);
        webutils.clickOnElement(addRow);
    }

//    public void validateLoadingText(int time) {
//
//        try {
//            if (webutils.getElementText(loading).equals("Loading")) {
//                Thread.sleep(time);
//            }
//        } catch (NoSuchElementException | InterruptedException ignored) {
//
//        }
//    }

    public void clickOnEditButton(String conntName, String ruleName) {
        Context.CONNECTION_NAME.setValue(conntName);
        Context.RULE_NAME.setValue(ruleName);
        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equalsIgnoreCase(conntName) && webutils.getElementText(lstRuleNames.get(i)).equalsIgnoreCase(ruleName)) {
                webutils.clickOnElement(lstRuleEdits.get(i));
                break;
            }
        }
    }

    public void clickOnUpdateButton() {
        webutils.waitUntilElementVisible(updateBtn);
        webutils.clickOnElement(updateBtn);
    }

    public void clickOnDeleteSymbol(String rowDel) throws InterruptedException {
        int rowNumber = Integer.parseInt(rowDel);
        if (lstDeleteSymbol.size() > 0) {
            webutils.waitUntilElementVisible(lstDeleteSymbol.get(rowNumber));
            webutils.clickOnElement(lstDeleteSymbol.get(rowNumber - 1));
        } else {
            webutils.waitUntilElementVisible(deleteSymbol);
            webutils.actionClickElement(deleteSymbol);
        }
    }

    public void verifyNumOfColAndColumnsAreSelected(String rowNum) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(lstOfColumns.size());
        int rownum = Integer.parseInt(rowNum);
        for (int i = 0; i < lstOfColumns.size(); i++) {
            if (i == rownum - 1) {
                for (WebElement colName : lstColumnNames) {
                    if (webutils.getElementText(lstOfColumns.get(rownum - 1)).contains(webutils.getElementText(colName))) {
                        System.out.println("Element name : " + webutils.getElementText(colName));
                    }
                }
                break;
            }
        }
    }

    public void verifyNumOfChecksAndChecksAreSelected(String rowNum) throws InterruptedException {
        Thread.sleep(5000);
        int rownum = Integer.parseInt(rowNum);
        for (int i = 0; i < lstChecksRows.size(); i++) {
            if (i == rownum - 1) {
                for (WebElement chkName : sltChecksList) {
                    if (webutils.getElementText(lstChecksRows.get(rownum - 1)).contains(webutils.getElementText(chkName))) {
                        System.out.println("Element name : " + webutils.getElementText(chkName));
                    }
                }
                break;
            }
        }
    }

    public void clickOnPreviewButton() {
        webutils.waitUntilElementVisible(previewBtn);
        webutils.clickOnElement(previewBtn);
    }

    public void verifyPageHeader(String pgHeadTitle) {
        webutils.waitUntilElementVisible(pgHeaderTitle);
        valUtils.validateAssertEquals(pgHeadTitle, webutils.getElementText(pgHeaderTitle), pgHeadTitle + " is not displayed");

    }

    public void validateSltChecksAndColumnsArePresentWithExeRults() {
        boolean value = false;
        ;
        for (int i = 0; i < lstrowData.size(); i++) {
            String columnName = webutils.getElementText(lstColumnNames.get(i));
            String[] colNames = columnName.split(" ");
            String colName = colNames[0];
            System.out.println(colName);

            if (webutils.getElementText(lstrowData.get(i)).contains(colName)) {
                System.out.println(webutils.getElementText(lstrowData.get(i)));
                value = true;
            } else {
                value = false;
                break;
            }
        }
        valUtils.validateAssertTrue(value, "Selected Columns is not present in Execution table");
    }

    public void clickOnPreviewButton(String conntName, String ruleName) {
        Context.CONNECTION_NAME.setValue(conntName);
        Context.RULE_NAME.setValue(ruleName);
        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equalsIgnoreCase(conntName) && webutils.getElementText(lstRuleNames.get(i)).equalsIgnoreCase(ruleName)) {
                webutils.clickOnElement(lstPreviewIcon.get(i));
                break;
            }
        }
    }

    public void verifyPreviewPageIsDisplayed(String pgHeadTitle) {
        webutils.waitUntilElementVisible(headingPreview);
        valUtils.validateAssertEquals(pgHeadTitle, webutils.getElementText(headingPreview), pgHeadTitle + " page is not displayed");
    }

    public void verifySelectedRulePreviewDetailsAreDisplayed() {
        boolean value = false;
        String conntName = Context.CONNECTION_NAME.getValue();
        String ruleName = Context.RULE_NAME.getValue();
        for (WebElement header : lstSltPrevHeaders) {
            if (webutils.getElementText(header).contains(conntName)) {
                for (WebElement headerDe : lstSltPrevHeaders) {
                    if (webutils.getElementText(headerDe).contains(ruleName)) {
                        value = true;
                        break;
                    }
                }
            }
        }
        valUtils.validateAssertTrue(value, "Selected rule preview details are not displayed");
    }

    public void clickOnResultsIcon(String conntName, String ruleName) {
        Context.CONNECTION_NAME.setValue(conntName);
        Context.RULE_NAME.setValue(ruleName);
        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equalsIgnoreCase(conntName) && webutils.getElementText(lstRuleNames.get(i)).equalsIgnoreCase(ruleName)) {
                webutils.clickOnElement(lstresultIcon.get(i));
                break;
            }
        }
    }

    public void VerifyTextIsPresentInResultsWithoutExecution(String expText) {
        webutils.waitUntilElementVisible(textMsg);
        valUtils.validateAssertEquals(expText, webutils.getElementText(textMsg), expText + " is not displayed");
    }


    public void verifyLastExecutionOfRule(String conntName, String ruleName) {
        boolean execution = false;
        Context.CONNECTION_NAME.setValue(conntName);
        Context.RULE_NAME.setValue(ruleName);
        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equalsIgnoreCase(conntName) && webutils.getElementText(lstRuleNames.get(i)).equalsIgnoreCase(ruleName)) {
                if (!(webutils.getElementText(lastExecution.get(i)).equals("--"))) {
                    execution = true;
                    break;
                }
            }
        }
        if (execution) {
            Context.EXECUTION.setValue("true");
        } else {
            Context.EXECUTION.setValue("false");
        }
    }

    public void clickOnResultsIconIfAlreadyExecutionIsDone(String conntName, String ruleName) throws InterruptedException {
        String isExecution = Context.EXECUTION.getValue();
        Context.CONNECTION_NAME.setValue(conntName);
        Context.RULE_NAME.setValue(ruleName);
        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equalsIgnoreCase(conntName) && webutils.getElementText(lstRuleNames.get(i)).equalsIgnoreCase(ruleName)) {
                if (isExecution.equals("true")) {
                    webutils.clickOnElement(lstresultIcon.get(i));
                    break;
                } else {
                    webutils.clickOnElement(lstExecuteIcon.get(i));
                    Thread.sleep(10000);
                    webutils.waitUntilElementVisible(lstresultIcon.get(i));
                    webutils.clickOnElement(lstresultIcon.get(i));
                    break;
                }


            }
        }
    }

    public void verifyExecutionResultsAreDisplayed() {
        webutils.waitUntilElementVisible(exeResult);
        boolean value = false;
        if (!(webutils.getElementText(exeResult).equals(" "))) {
            System.out.println("Execution results are displayed");
            value = true;
        }
        valUtils.validateAssertTrue(value, "No execution results are displayed");
    }

}





