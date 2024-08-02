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

    @FindBy(css = "[class='ecRuleCheckCard MuiBox-root css-0'] [class='v-center MuiBox-root css-0'] [class='MuiTypography-root MuiTypography-body1 css-136foal']")
    public List<WebElement> sltValChecksList;

    @FindBy(css = "[class='ecRuleCheckCard MuiBox-root css-0']")
    public List<WebElement> boxList;

    @FindBy(css = "[class='ecRuleCheckCard MuiBox-root css-0'] [type='text']")
    public WebElement sltValChecksFieldFirst;

    @FindBy(css = "[class='ecRuleCheckCard MuiBox-root css-0'] [type='text']")
    public List<WebElement> sltValChecksFieldList;
    @FindBy(css = "ag-loading-text")
    public WebElement loading;

    @FindBy(xpath = "//*[text()='Add Row']")
    public WebElement addRow;

    @FindBy(xpath = "//*[@type='button' and @aria-label='Edit']")
    public List<WebElement> lstRuleEdits;
    @FindBy(xpath = "//*[text()='Update']")
    public WebElement updateBtn;

    @FindBy(css = "[data-testid='DeleteIcon']")
    public List<WebElement> lstDeleteSymbol;
    @FindBy(css = "[data-testid='DeleteIcon']")
    public WebElement deleteSymbol;

    @FindBy(xpath = "//*[contains(@class,'MuiTypography-root MuiTypography-h6 MuiDialogTitle-root dialogTitle')]")
    public WebElement pgHeaderTitle;
    @FindBy(xpath = "//*[text()='Preview']")
    public WebElement previewBtn;

    @FindBy(css = "[class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-8 css-zpohz8']")
    public List<WebElement> lstChecksRows;

    @FindBy(xpath = "//*[@class='MuiBox-root css-11ou7p6']")
    public List<WebElement> lstOfColumns;

    @FindBy(css = "[class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 css-mzl2r3'] [class='MuiTypography-root MuiTypography-body1 css-136foal']")
    public List<WebElement> lstColumnNames;

    @FindBy(css = "[class='ecRuleCheckCard MuiBox-root css-0'] [class='v-center MuiBox-root css-0'] [class='MuiTypography-root MuiTypography-body1 css-136foal']")
    public List<WebElement> sltChecksList;

    @FindBy(xpath = "//*[contains(@class,'MuiTableBody-root')]//*[contains(@class,'MuiTableRow-root')]")
    public List<WebElement> lstrowData;

    @FindBy(xpath = "//*[contains(@class,'MuiTableBody-root')]//*[contains(@class,'MuiTableRow-root')]")
    public WebElement rowData;


    @FindBy(xpath = "//*[@class='v-center' and @aria-label='Preview']")
    public List<WebElement> lstPreviewIcon;


    @FindBy(xpath = "//*[contains(@class,'DQRulePreviewContainer')]//*[contains(@class,'MuiTypography-root MuiTypography-h6 upper-case')]")
    public WebElement headingPreview;

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-true')] //p")
    public List<WebElement> lstSltPrevHeaders;

    @FindBy(css = "[aria-label='Results'] [class='v-center']")
    public List<WebElement> lstresultIcon;

    @FindBy(css = "[class='noExecutionsFound MuiBox-root css-0']")
    public WebElement textMsg;

    @FindBy(css = "[role='gridcell'][col-id='LastExecution']")
    public List<WebElement> lastExecution;

    @FindBy(css = "[aria-label='Execute'] [class='v-center']")
    public List<WebElement> lstExecuteIcon;

    @FindBy(xpath = "(//*[contains(@class,'MuiTypography-root MuiTypography-detailValue')])[3]")
    public WebElement exeResult;
}
