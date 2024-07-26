package com.pages;

import com.Config.NewConnectionsDataConfig;
import com.Config.ReadConfig;
import com.DriverManagers.LoggerManager;
import com.Enum.ChecksAndColumns;
import com.Enum.Context;
import com.Enum.URL;
import com.pageElements.ConnectionsElements;
import com.utilities.JavaScriptUtils;
import com.utilities.ValidationUtils;
import com.utilities.WebUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.flogger.Flogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConnectionsPage extends ConnectionsElements {
    private WebDriver driver;
    WebUtils webutils;
    JavaScriptUtils jsUtils;
    ValidationUtils valUtils;
    NewConnectionsDataConfig newConnData;
    LoggerManager logger;

    public ConnectionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webutils = new WebUtils(driver);
        jsUtils = new JavaScriptUtils(driver);
        valUtils = new ValidationUtils();
        newConnData = new NewConnectionsDataConfig();

    }

    public void navigateToURL() {
        //driver.navigate().to("https://dqg.kairostech.com/login");
        driver.navigate().to("http://localhost:81/login");
        webutils.waitUntilElementVisible(login);
        webutils.clickOnElement(login);
        webutils.waitUntilElementVisible(user);
        webutils.clickOnElement(user);


        try{
            webutils.waitUntilElementVisible(confirmPopup);
        if(confirmPopup.isDisplayed()){
            webutils.clickOnElement(confirm);
        }}catch (NoSuchElementException e){
            e.getMessage();
        }
    }

    public void enterEmail(String email) {
        webutils.waitUntilElementVisible(emailField);
        // webutils.updateElementValue(emailField,email);
        emailField.sendKeys(email);




    }

    public void enterPassword(String password) {
        webutils.waitUntilElementVisible(passwordField);
        //webutils.updateElementValue(passwordField,password);
        passwordField.sendKeys(password);

    }

    public void clickOnSignInBtn() throws InterruptedException {
        Thread.sleep(5000);
        webutils.waitUntilElementVisible(signInBtn);
        webutils.clickOnElement(signInBtn);
        Thread.sleep(3000);
//        if (sessionConfirmPopUp.isDisplayed()) {
//            webutils.clickOnElement(confirmBtn);
//        }
    }

    public void verifyDashboardPageisDislayed(String exptitle) throws InterruptedException {
        Thread.sleep(5000);
        webutils.waitUntilElementVisible(dashBoardPageHeader);
        boolean value = false;
        if (webutils.getElementText(dashBoardPageHeader).equalsIgnoreCase(exptitle)) {
            value = true;
        }
        valUtils.validateAssertTrue(value, exptitle + " dashboard page is not displayed");
    }

    public void selectdatabaseConnection(String databaseName) throws InterruptedException {
//        Thread.sleep(15000);
//        webutils.
        for (WebElement imgs : lstConnectionImages) {
            webutils.waitUntilElementVisible(imgs);
            //System.out.println(imgs.getAttribute("src"));
            if (imgs.getAttribute("src").contains(databaseName)) {
                webutils.waitUntilElementVisible(imgs);
                webutils.clickOnElement(imgs);
                break;
            }
        }
    }

    public void clickOnAddNewConnectionBtn() {
        webutils.waitUntilElementVisible(addNewBtn);
        jsUtils.clickOnElement(addNewBtn);
    }

    public void validateNewConnPageHeader(String expHeader) throws InterruptedException {
        Thread.sleep(3000);
        boolean value = false;
        if (expHeader.equals(webutils.getElementText(PgHeader))) {
            value = true;
        }
        valUtils.validateAssertTrue(value, expHeader + " page is not displayed");

    }

    public void enterConnectionName(String connectname) {
        Context.CONNECTION_NAME.setValue(connectname);
        webutils.updateElementText(conectNameEle, connectname);
    }

    public void enterServer() throws InterruptedException {

        String server = newConnData.getServer();
        Thread.sleep(2000);
        webutils.sendText(serverELe, server);
        //webutils.sendText(serverELe,"");
    }

    public void enterDatabaseName() throws InterruptedException {

        String database = newConnData.getDatabase();
        Thread.sleep(2000);
        webutils.sendText(datBaseEle, database);
        //webutils.sendText(datBaseEle,"");
    }

    public void selectAuthenticationType() {
        String authType = newConnData.getAuthType();
        System.out.println(authType);
        for (WebElement drpDwnVal : AuthTypeDrpdwn) {
            if (webutils.getElementText(drpDwnVal).equals(authType)) {
                jsUtils.clickOnElement(drpDwnVal);
                break;
            }
        }
    }

    public void enterUserName() {
        String user = newConnData.getUsername();
        webutils.sendText(userEle, user);
        //webutils.sendText(userEle,"");
    }

    public void enterPasswordInNewConnectionPage() {

        String password = newConnData.getPassword();
        webutils.sendText(passEle, password);
    }

    public  void selectSchemafromDropDown() throws InterruptedException {

        webutils.waitUntilElementVisible(schema);
        webutils.clickOnElement(schema);
        String schemaOption = newConnData.getSchema();
Thread.sleep(4000);
        for (WebElement opt : schemaOptions) {

            webutils.waitUntilElementVisible(opt);
            if (webutils.getElementText(opt).equals(schemaOption)) {
                webutils.waitUntilElementVisible(opt);
                jsUtils.clickOnElement(opt);
                break;
            }
        }
    }


    public void clickOnTestAndCreateButton() throws InterruptedException {
        Thread.sleep(3000);
        jsUtils.clickOnElement(testAndCreateBtn);
    }

    public void verifyPopUpMessage(String expPopUpMsg) throws InterruptedException {
        webutils.waitUntilElementVisible(alertPopUp);
        if (alertPopUp.isDisplayed()) {
            System.out.println(webutils.getElementText(alertPopUpMsg) + "-----------" + expPopUpMsg);
            valUtils.validateAssertEquals(expPopUpMsg, webutils.getElementText(alertPopUpMsg), expPopUpMsg + " message is not displayed");
        }
    }

    public void clickOnCancelIcon() {
        webutils.waitUntilElementVisible(cancelIcon);
        if (cancelIcon.isDisplayed()) {
            webutils.clickOnElement(cancelIcon);
        }
    }

    public void pageNation(String size) throws InterruptedException {
        Thread.sleep(4000);
        if (!webutils.getElementText(pgeComboBox).equals("100")) {
            webutils.clickOnElement(pgeComboBox);
            for (WebElement optELem : pageOptions) {
                if (webutils.getElementText(optELem).equals("100")) {
                    webutils.clickOnElement(optELem);
                    Thread.sleep(4000);
                    break;
                }
            }
        }
    }

    public void validateConnectionNameIsPresentInAllConnectionsTable() throws InterruptedException {
        pageNation("100");
        boolean value = false;
        String connectionName = Context.CONNECTION_NAME.getValue();
        for (WebElement connectionsList : lstConnectNames) {
            if (webutils.getElementText(connectionsList).equals(connectionName)) {
                value = true;
                break;
            }
        }
        valUtils.validateAssertTrue(value, connectionName + " connection is not present in Connections list");
    }


    public void clickOnConnection(String connectionName) throws InterruptedException {
        pageNation("100");
        for (WebElement connectionsList : lstConnectNames) {
            //System.out.println(webutils.getElementText(connectionsList));
            if (webutils.getElementText(connectionsList).equals(connectionName)) {
                System.out.println(webutils.getElementText(connectionsList));
                Thread.sleep(4000);
                jsUtils.clickOnElement(connectionsList);
                break;
            }
        }
    }

    public void clickOnEditButton() {
        webutils.clickOnElement(editBtn);
    }

    public void clickOnTestAndUpdate() {
        webutils.clickOnElement(testAndUpdateBtn);
    }

    public void selectConnectionToDelete(String cntNameToDelete) throws InterruptedException {
        Context.CONNECTION_NAME.setValue(cntNameToDelete);
        Thread.sleep(4000);
        for (int i = 0; i < lstConnectNames.size(); i++) {
            if (webutils.getElementText(lstConnectNames.get(i)).equals(cntNameToDelete)) {
                webutils.clickOnElement(contNameChkBoxs.get(i));
                break;
            }
        }
    }

    public void clickOnDeleteButton() {
        webutils.clickOnElement(deleteIcon);
    }

    public void clickOnYesButtonOnConfirmationPopUp() throws InterruptedException {
        Thread.sleep(4000);
        webutils.clickOnElement(yesDltBtn);
    }

    public void validateDeletedConnectionNameIsPresentInAllConnectionsTable() throws InterruptedException {
        pageNation("100");
        boolean value = true;
        String connectionName = Context.CONNECTION_NAME.getValue();
        for (WebElement connectionsList : lstConnectNames) {
            if (webutils.getElementText(connectionsList).equals(connectionName)) {
                value = false;
                break;
            }
        }
        valUtils.validateAssertTrue(value, connectionName + " connection is present in Connections list after deletion also");
    }

    public void clickOnPreviewButtonOfSelectedConnection(String ConnectionNameToPreview) throws InterruptedException {
        Context.CONNECTION_NAME.setValue(ConnectionNameToPreview);
        Thread.sleep(4000);

        for (int i = 0; i < lstConnectNames.size(); i++) {
            webutils.waitUntilElementVisible(lstConnectNames.get(i));
            if (webutils.getElementText(lstConnectNames.get(i)).equals(ConnectionNameToPreview)) {
                webutils.clickOnElement(previewIcon.get(i));
                break;
            }
        }
    }

    public void verifySelectedConnectionDetailsAreDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        webutils.waitUntilElementVisible(dbConnTitle);
        String slContName = Context.CONNECTION_NAME.getValue();
        boolean value = false;
        if (webutils.getElementText(dbConnTitle).equals(slContName)) {
            value = true;
        }
        valUtils.validateAssertTrue(value, "Db Connection is selected different one----error");

    }

    public void selectTableFromTablesList(String tableName) throws InterruptedException {
        Context.TABLE_NAME.setValue(tableName);
        Thread.sleep(3000);
        for (WebElement dbTable : tablesList) {
            if (webutils.getElementText(dbTable).equals(tableName)) {
                webutils.waitUntilElementVisible(dbTable);
                webutils.clickOnElement(dbTable);
                break;
            }
        }
    }

    public void verifySelectedTableDetailsAreDisplayed() throws InterruptedException {
        //Thread.sleep(4000);
        webutils.waitUntilElementVisible(sltdTableTitle);
        String sltTableName = Context.TABLE_NAME.getValue();
        boolean value = false;
        if (webutils.getElementText(sltdTableTitle).equals(sltTableName)) {
            value = true;
        }
        valUtils.validateAssertTrue(value, "Selected table details are not displayed");
    }

    public void clickOnValidateButton() {
        webutils.clickOnElement(validateBtn);
    }

    public void validateRedColorIsHighLightingOnEmptyFields(String style) throws InterruptedException {
        Thread.sleep(4000);
        webutils.clickOnElement(PgHeader);
        for (int i = 0; i < starIcon.size(); i++) {
            if (webutils.getElementCSSValue(starIcon.get(i),"border").equals(style)) {
                System.out.println(webutils.getElementText(listOfFields.get(i)) + " is empty, So enter" + webutils.getElementText(listOfFields.get(i)));
            }
        }
    }

    /*
     * Eqvivalent Class partitioning technique
     *
     */

    public void verifyHelpTextIsDisplayed() {
        int valLength = Context.CONNECTION_NAME.getValue().length();
        String expHelpTextMin = "Minimum length 4 char";
        String expHelpTextMax = "Maximum length 32 char";
        if (valLength < 4) {
            valUtils.validateAssertEquals(webutils.getElementText(helpText), expHelpTextMin, "Field is accepting less than minimum length");
        } else if (valLength > 32) {
            valUtils.validateAssertEquals(webutils.getElementText(helpText), expHelpTextMax, "Field is accepting more than maximum length");
        } else {
            valUtils.validateAssertTrue(true, "Error in connection name field it is not accepting valid data range");
        }
    }
    public void enterRuleName(String ruleName) {
        Context.RULE_NAME.setValue(ruleName);
        webutils.updateElementText(ruleNameEle, ruleName);
    }

    public void clickOnAddColumnButton(String rowNum) throws InterruptedException {
        Thread.sleep(5000);
        int rownumber=Integer.parseInt(rowNum);
        webutils.clickOnElement(addColumn.get(rownumber-1));
        }

    public void selectColumnsFromTableList(String colName) {
        ChecksAndColumns.COLUMN_NAME.setValue(colName);
        for (int i = 0; i < columnNameList.size(); i++) {
            if (webutils.getElementText(columnNameList.get(i)).equalsIgnoreCase(colName)) {
                webutils.clickOnElement(chkBoxColName.get(i));
                break;
            }
        }

    }




    public void clickOnCancelIconOnAddColumPopUp() {
        webutils.waitUntilElementVisible(cancelIconOnTablPopUp);
        webutils.clickOnElement(cancelIconOnTablPopUp);
    }

    public void validateSelectedColumnIsPresentInColumnSection() {

        String sltColumn = ChecksAndColumns.COLUMN_NAME.getValue();
        boolean value = false;
        if (webutils.getElementText(sltColNames).contains(sltColumn)) {
            value = true;
        }
        valUtils.validateAssertTrue(value, "Selected table column is not present in column section");
    }

    public void selectChecksInValCheck(String valCheckName,String droprow) throws InterruptedException {
        int dropRow=Integer.parseInt(droprow);
        Thread.sleep(5000);
        ChecksAndColumns.CHECK_NAME.setValue(valCheckName);
        for (WebElement valCheck : listOfDragValCks) {
            if (webutils.getElementText(valCheck).equalsIgnoreCase(valCheckName)) {
                webutils.dragAndDropElement(valCheck, dropEle.get(dropRow-1));
                break;
            }
        }

    }

    public void validateSelectedCheckIsPresentInRuleSection() {
        String sltCheck = ChecksAndColumns.CHECK_NAME.getValue();
        webutils.waitUntilElementVisible(sltChecksList);
        boolean value = false;
        if (webutils.getElementText(sltChecksList).contains(sltCheck)) {
            value = true;
        }
        valUtils.validateAssertTrue(value, "Selected check is not present in rule section");
    }

    public void clickOnCreateRuleButton() throws InterruptedException {
        webutils.waitUntilElementVisible(createRule);
        webutils.clickOnElement(createRule);
        webutils.waitUntilElementVisible(alertPopUp);
    }

    public void validateRuleIsCreatedInRuleListForSelectedConnection() throws InterruptedException {
        Thread.sleep(50000);
        String connectName = Context.CONNECTION_NAME.getValue();
        String ruleName = Context.RULE_NAME.getValue();
        boolean value = false;
        for (int i = 0; i < conntNameColList.size(); i++) {
            webutils.waitUntilElementVisible(conntNameColList.get(i));
            if (webutils.getElementText(conntNameColList.get(i)).equals(connectName)) {
                webutils.waitUntilElementVisible(dqRuleNameColList.get(i));
                if (webutils.getElementText(dqRuleNameColList.get(i)).equals(ruleName)) {
                    System.out.println("Rule is created successfully");
                    value = true;
                }
            }
        }
        valUtils.validateAssertTrue(value, "Created rule is not present in the DQ rules table");
    }


    public void checkAndValidateRuleNameFieldIsAcceptingEmptyValues(String style) {
        boolean value = false;
        System.out.println("----" + ruleNameEle.getAttribute("value") + "----");
        if (ruleNameEle.getAttribute("value").equals("")) {
            if (webutils.getElementCSSValue(ruleNameEle,"border").equals(style)) {
                value = true;
            }
            valUtils.validateAssertTrue(value, "Create rule button is enabled with empty rule name also");
        }
    }
}
