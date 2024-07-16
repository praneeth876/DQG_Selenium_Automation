package com.pages;

import com.Config.NewConnectionsDataConfig;
import com.Config.ReadConfig;
import com.Enum.Context;
import com.Enum.URL;
import com.pageElements.ConnectionsElements;
import com.utilities.JavaScriptUtils;
import com.utilities.ValidationUtils;
import com.utilities.WebUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConnectionsPage extends ConnectionsElements {
    private WebDriver driver;
    WebUtils webutils;
    JavaScriptUtils jsUtils;
    ValidationUtils valUtils;
    NewConnectionsDataConfig newConnData;
    public ConnectionsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        webutils = new WebUtils(driver);
        jsUtils = new JavaScriptUtils(driver);
        valUtils = new ValidationUtils();
        newConnData=new NewConnectionsDataConfig();
    }

    public void navigateToURL() {
        driver.navigate().to("https://dqg.kairostech.com/login");
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
        jsUtils.clickOnElement(signInBtn);
        Thread.sleep(3000);
        if (sessionConfirmPopUp.isDisplayed()) {
            jsUtils.clickOnElement(confirmBtn);
        }
    }

    public void verifyDashboardPageisDislayed(String exptitle) throws InterruptedException {
        Thread.sleep(5000);
        webutils.waitUntilElementVisible(dashBoardPageHeader);
        boolean value=false;
        if(webutils.getElementText(dashBoardPageHeader).equalsIgnoreCase(exptitle)){
        value=true;
        }
        valUtils.validateAssertTrue(value,exptitle+" dashboard page is not displayed");
    }

    public void selectdatabaseConnection(String databaseName) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Inside selectdatabaseConnection method");
        for(WebElement imgs:lstConnectionImages){
            System.out.println(imgs.getAttribute("src"));
            if(imgs.getAttribute("src").contains(databaseName)){
                webutils.waitUntilElementVisible(imgs);
                jsUtils.clickOnElement(imgs);
                break;
            }
        }
    }

public void clickOnAddNewConnectionBtn(){
        webutils.waitUntilElementVisible(addNewBtn);
        jsUtils.clickOnElement(addNewBtn);
}

public void validateNewConnPageHeader(String expHeader) throws InterruptedException {
        Thread.sleep(3000);
boolean value=false;
        if(expHeader.equals(webutils.getElementText(PgHeader))){
            value=true;
        }
valUtils.validateAssertTrue(value,expHeader+" page is not displayed");

}
public void enterConnectionName(String connectname){
    Context.CONNECTION_NAME.setValue(connectname);
    webutils.updateElementText(conectNameEle,connectname);
}
 public void enterServer() throws InterruptedException {

        String server=newConnData.getServer();
        Thread.sleep(2000);
        webutils.sendText(serverELe,server);
    }
    public void enterDatabaseName() throws InterruptedException {

        String database=newConnData.getDatabase();
        Thread.sleep(2000);
        webutils.sendText(datBaseEle,database);
    }

    public void selectAuthenticationType(){
        String authType=newConnData.getAuthType();
        System.out.println(authType);
for(WebElement drpDwnVal: AuthTypeDrpdwn){
    if(webutils.getElementText(drpDwnVal).equals(authType)){
        jsUtils.clickOnElement(drpDwnVal);
        break;
    }
}
    }
    public void enterUserName(){
        String user=newConnData.getUsername();
        webutils.sendText(userEle,user);
    }
    public void enterPasswordInNewConnectionPage(){

        String password=newConnData.getPassword();
        webutils.sendText(passEle,password);
    }
    public void clickOnTestAndCreateButton() throws InterruptedException {
        Thread.sleep(3000);
        jsUtils.clickOnElement(testAndCreateBtn);
    }
public void verifyPopUpMessage(String expPopUpMsg) throws InterruptedException {
        Thread.sleep(3000);
webutils.waitUntilElementVisible(alertPopUp);
boolean value=false;
        if(alertPopUp.isDisplayed()){
            if(webutils.getElementText(alertPopUpMsg).equals(expPopUpMsg)){
                value=true;
            }
        }
        valUtils.validateAssertTrue(value,expPopUpMsg+" messeage is not displayed");
}

public void clickOnCancelIcon(){
        webutils.waitUntilElementVisible(cancelIcon);
        if(cancelIcon.isDisplayed()){
        webutils.clickOnElement(cancelIcon);
        }
}

    public void pageNation(String size) throws InterruptedException {
        Thread.sleep(4000);
        if(!webutils.getElementText(pgeComboBox).equals("100")){
            webutils.clickOnElement(pgeComboBox);
            for(WebElement optELem : pageOptions){
                if(webutils.getElementText(optELem).equals("100")){
                    webutils.clickOnElement(optELem);
                    Thread.sleep(4000);
                    break;
                }
            }
        }
    }
public void validateConnectionNameIsPresentInAllConnectionsTable() throws InterruptedException {
    pageNation("100");
boolean value=false;
    String connectionName=Context.CONNECTION_NAME.getValue();
        for(WebElement connectionsList : lstConnectNames){
            if(webutils.getElementText(connectionsList).equals(connectionName)){
               value=true;
                break;
            }
        }
        valUtils.validateAssertTrue(value,connectionName+" connection is not present in Connections list");
    }


public void clickOnConnection(String connectionName) throws InterruptedException {
    pageNation("100");
    for(WebElement connectionsList : lstConnectNames){
        //System.out.println(webutils.getElementText(connectionsList));
        if(webutils.getElementText(connectionsList).equals(connectionName)){
            System.out.println(webutils.getElementText(connectionsList));
            Thread.sleep(4000);
            jsUtils.clickOnElement(connectionsList);
            break;
        }
    }
}

public void clickOnEditButton(){
        webutils.clickOnElement(editBtn);
}

public void clickOnTestAndUpdate(){
webutils.clickOnElement(testAndUpdateBtn);
}

public void selectConnectionToDelete(String cntNameToDelete) throws InterruptedException {
        Context.CONNECTION_NAME.setValue(cntNameToDelete);
        Thread.sleep(4000);
for (int i=0;i<lstConnectNames.size();i++){
    if(webutils.getElementText(lstConnectNames.get(i)).equals(cntNameToDelete)){
      webutils.clickOnElement(contNameChkBoxs.get(i));
      break;
    }
}
}
public void clickOnDeleteButton(){
        webutils.clickOnElement(deleteIcon);
}

public void clickOnYesButtonOnConfirmationPopUp() throws InterruptedException {
        Thread.sleep(4000);
        webutils.clickOnElement(yesDltBtn);
}

    public void validateDeletedConnectionNameIsPresentInAllConnectionsTable() throws InterruptedException {
        pageNation("100");
        boolean value=true;
        String connectionName=Context.CONNECTION_NAME.getValue();
        for(WebElement connectionsList : lstConnectNames){
            if(webutils.getElementText(connectionsList).equals(connectionName)){
                value=false;
                break;
            }
        }
        valUtils.validateAssertTrue(value,connectionName+" connection is present in Connections list after deletion also");
    }

}



