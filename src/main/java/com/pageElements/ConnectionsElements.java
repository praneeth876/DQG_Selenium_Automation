package com.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConnectionsElements {


    @FindBy(css="[id='email']")
    public WebElement emailField;

    @FindBy(css="[name='password']")
    public WebElement passwordField;

    @FindBy(xpath="//button[text()='Sign In']") //[type='submit']
    public WebElement signInBtn;

    @FindBy(css = "[class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-13zle66']")
    public WebElement sessionConfirmPopUp;

    @FindBy(xpath = "//*[text()='Confirm']")
    public WebElement confirmBtn;
    @FindBy(css="[class='MuiTypography-root MuiTypography-h6 upper-case css-10k2nzz']")
    public WebElement dashBoardPageHeader;
    @FindBy(css="[class='center MuiBox-root css-1o817yz']")
    public WebElement allConnections;
    @FindBy(tagName="img")
    public List<WebElement> lstConnectionImages;


    @FindBy(xpath="//*[text()='Add new']")
    public WebElement addNewBtn;

    @FindBy(css="[class='MuiTypography-root MuiTypography-h6 css-52kepn']")
    public WebElement PgHeader;
    @FindBy(css="[name='connectionName']")
    public WebElement conectNameEle;

    @FindBy(css="[name='server']")
    public WebElement serverELe;

    @FindBy(css="[name='dataBase']")
    public WebElement datBaseEle;

    @FindBy(xpath="(//*[@class='MuiGrid-root MuiGrid-container MuiGrid-item css-tyuwup'] //*[@aria-haspopup=\"listbox\"])[1]")
    public List<WebElement> AuthTypeDrpdwn;

    @FindBy(css="[name='user']")
    public WebElement userEle;


    @FindBy(css="[name='password']")
    public WebElement passEle;

    @FindBy(xpath="//button[contains(text(),'Test')]")
    public WebElement testAndCreateBtn;

    @FindBy(css="[role='alert']")
    public WebElement alertPopUp;
    @FindBy(xpath="//*[contains(@class,'MuiAlert-message ')]")
    public WebElement alertPopUpMsg;

    @FindBy(css="[data-testid='CancelOutlinedIcon']")
    public WebElement cancelIcon;

    @FindBy(css ="[id='demo-simple-select']")
    public WebElement pgeComboBox;

    @FindBy(css = "[role='option']")
    public List<WebElement> pageOptions;

//    @FindBy(css ="[col-id='connectionName'][role='gridcell']")
//    public List<WebElement> lstConnectNames;

    @FindBy(css ="[col-id='connectionName'][role='gridcell'] [class='MuiBox-root css-38iob1']")
    public List<WebElement> lstConnectNames;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editBtn;
    @FindBy(xpath = "//button[contains(text(),'Test')]")
    public WebElement testAndUpdateBtn;

    @FindBy(css = "[class='ag-selection-checkbox'] [type='checkbox']")
    public List<WebElement> contNameChkBoxs;

@FindBy(css = "[aria-label='Delete']")
    public WebElement deleteIcon;
    @FindBy(xpath = "//*[text()='Yes']")
    public WebElement yesDltBtn;

}
