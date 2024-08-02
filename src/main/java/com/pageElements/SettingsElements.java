package com.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SettingsElements {

    @FindBy(css = "[data-testid='NotificationsActiveOutlinedIcon']")
    public WebElement notification;

    @FindBy(xpath = "//*[text()='View All']")
    public WebElement viewAll;
    @FindBy(xpath = "//*[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall')]//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-fontSizeSmall')]")
    public WebElement mode;  //data-testid

    @FindBy(css = "[class='dx-device-desktop dx-device-generic']")
    public WebElement bgColor;
    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logout;
    @FindBy(css = "[class='MuiBox-root css-i9gxme'] [data-testid='PersonIcon']")
    public WebElement account;
    @FindBy(css = "[role='combobox']")
    public WebElement languageDropdown;
    @FindBy(css = "[role='option']")
    public List<WebElement> languages;

    @FindBy(css = "[data-testid='DiscFullOutlinedIcon']")
    public WebElement serviceStatusIcon;

    @FindBy(css = "[role='menuitem']")
    public List<WebElement> lstServices;

}
