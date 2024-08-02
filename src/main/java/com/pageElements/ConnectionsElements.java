package com.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ConnectionsElements {


    @FindBy(xpath = "//*[text()='Login with Azure AD']")
    public WebElement login;

    @FindBy(xpath = "//*[text()='Praneeth Reddy Katamreddy - Kairos']")
    public WebElement user;

    @FindBy(xpath = "//*[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root')]")
    public WebElement confirmPopup;

    @FindBy(xpath = "//*[text()='Confirm']")
    public WebElement confirm;

    @FindBy(css = "[id='email']")
    public WebElement emailField;

    @FindBy(css = "[name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign In']") //[type='submit']
    public WebElement signInBtn;

    @FindBy(css = "[class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root css-13zle66']")
    public WebElement sessionConfirmPopUp;

    @FindBy(xpath = "//*[text()='Confirm']")
    public WebElement confirmBtn;

    @FindBy(xpath = "//*[contains(@class,'MuiTypography-root MuiTypography-h6')]")
    public WebElement dashBoardPageHeader;

    @FindBy(css = "[class='center MuiBox-root css-1o817yz']")
    public WebElement allConnections;
    @FindBy(tagName = "img")
    public List<WebElement> lstConnectionImages;


    @FindBy(xpath = "//*[text()='Add new']")
    public WebElement addNewBtn;

    @FindBy(css = "[class='MuiTypography-root MuiTypography-h6 css-52kepn']")
    public WebElement PgHeader;
    @FindBy(css = "[name='connectionName']")
    public WebElement conectNameEle;

    @FindBy(css = "[name='server']")
    public WebElement serverELe;

    @FindBy(css = "[name='dataBase']")
    public WebElement datBaseEle;

    @FindBy(xpath = "(//*[@class='MuiGrid-root MuiGrid-container MuiGrid-item css-tyuwup'] //*[@aria-haspopup=\"listbox\"])[1]")
    public List<WebElement> AuthTypeDrpdwn;

    @FindBy(css = "[name='user']")
    public WebElement userEle;

    @FindBy(css = "[name='password']")
    public WebElement passEle;

    @FindBy(css = "[class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-1ds9jv8']")
    public WebElement schema;

    @FindBy(css = "[role='option']")
    public List<WebElement> schemaOptions;

    @FindBy(xpath = "//button[contains(text(),'Test')]")
    public WebElement testAndCreateBtn;

    @FindBy(xpath = "//*[@role='presentation']//*[@role='alert']")
    public WebElement alertPopUp;
    @FindBy(xpath = "//*[@role='alert']//*[contains(@class,'MuiAlert-message ')]")
    public WebElement alertPopUpMsg;

    @FindBy(css = "[data-testid='CancelOutlinedIcon']")
    public WebElement cancelIcon;

    @FindBy(css = "[id='demo-simple-select']")
    public WebElement pgeComboBox;

    @FindBy(css = "[role='option']")
    public List<WebElement> pageOptions;


    @FindBy(xpath = "//*[@role='gridcell' and @aria-colindex='2']")
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

    @FindBy(css = "[aria-label='Preview'] [fill='none']")
    public List<WebElement> previewIcon;

    @FindBy(xpath = "(//*[contains(@class,'titleItem')]//p)[2]")
    public WebElement dbConnTitle;

    @FindBy(css = "[class='prevConTableList MuiBox-root css-0'] [class='MuiTypography-root MuiTypography-body1 css-136foal']")
    public List<WebElement> tablesList;

    @FindBy(xpath = "//*[@id='enhanced-table-acordian-0']//b")
    public WebElement sltdTableTitle;

    @FindBy(css = "[role='button'] [type='button']")
    public WebElement validateBtn;

    @FindBy(css = "[class='MuiFormLabel-asterisk MuiInputLabel-asterisk Mui-error css-sp68t1']")
    public List<WebElement> starIcon;

    @FindBy(xpath = "//*[contains(@class,'css-l10032') ]")
    public List<WebElement> listOfFields;

    @FindBy(xpath = "//*[contains(@class,'MuiFormHelperText-root Mui-error')]")
    public WebElement helpText;

    @FindBy(css = "[name='ruleName']")
    public WebElement ruleNameEle;    //enter text
    @FindBy(xpath = "//*[text()=' Add Column']")
    public List<WebElement> addColumn;   //click
    @FindBy(css = "[class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeMedium css-1iyeb4d']")
    public List<WebElement> columnNameList;  //reference to select column
    @FindBy(xpath = "//*[contains(@class,'MuiTable-root MuiTable-stickyHeader')]//*[@type='checkbox']")
    public List<WebElement> chkBoxColName;  //check checkbox

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1')]")
    public List<WebElement> columnSection;

    @FindBy(xpath = "//*[@class='MuiBox-root css-tzofp1'] //*[@data-testid='CancelOutlinedIcon']")
    public WebElement cancelIconOnTablPopUp; //click

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1')]")
    public WebElement sltColNames;   //validate
    @FindBy(css = "[role='button'] [class='v-center MuiBox-root css-8atqhb']")
    public List<WebElement> listOfDragValCks;    //select value check dropdown
    @FindBy(xpath = "//*[text()='Drop here']")
    public List<WebElement> dropEle;   //drop selected check

    @FindBy(css = "[class='dragItemsList']")
    public WebElement sltChecksList;   //validate
    @FindBy(xpath = "//*[text()='Create Rule']")
    public WebElement createRule; //click

    @FindBy(xpath = "//*[@role='gridcell' and @col-id='TestName']")
    public List<WebElement> dqRuleNameColList;
    @FindBy(xpath = "//*[@role='gridcell' and @col-id='ConnectionName']")
    public List<WebElement> conntNameColList;
    @FindBy(css = "MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng")
    public WebElement sltValChecksList;

    @FindBy(xpath = "//*[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-8 css-zpohz8']//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']")
    public WebElement sltValChecksFieldList;

}
