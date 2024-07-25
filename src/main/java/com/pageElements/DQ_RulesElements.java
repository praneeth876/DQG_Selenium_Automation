package com.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DQ_RulesElements {

    @FindBy(xpath = "//*[text()='Create DQ Rule']")
    public WebElement createDQRuleBtn;

    @FindBy(css = "[alt='Database']")
    public WebElement databaseIcon;
    @FindBy(css = "[placeholder='Select Connection']")
    public WebElement sltContDrpDwn;

    @FindBy(css = "[placeholder='Select Table']")
    public WebElement sltTabledrpDwn;

    @FindBy(xpath = "//*[contains(@class,'MuiListItem-gutters')]//*[contains(@class,'MuiListItemText-primary')]")
    public List<WebElement> lstmoduleNames;
    @FindBy(xpath = "//*[@role='gridcell' and @aria-colindex='2']")
    public List<WebElement> lstConnectNames;
    @FindBy(xpath = "//*[@role='gridcell' and @aria-colindex='3']")
    public List<WebElement> lstRuleNames;

    @FindBy(css = "[class='ag-selection-checkbox'] [type='checkbox']")
    public List<WebElement> contNameChkBoxs;

    @FindBy(css = "[aria-label='Delete']")
    public WebElement deleteIcon;


    @FindBy(css = "[class='ecRuleCheckCard MuiBox-root css-0']")
    public List<WebElement> sltValChecksList;


//    @FindBy(css = "MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng")
//    public WebElement sltValChecksList;

    @FindBy(xpath = "//*[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-8 css-zpohz8']//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']")
     public WebElement sltValChecksFieldList;

    @FindBy(xpath = "")
    public WebElement sltValChecksFieldList1;
    @FindBy(css = "ag-loading-text")
    public WebElement loading;

}
