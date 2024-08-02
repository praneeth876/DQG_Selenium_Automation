package com.utilities;

import com.DriverManagers.LoggerManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class WebUtils {
    WebDriver driver;
    Select select;
    WebDriverWait wait;
    LoggerManager logger;

    public WebUtils(WebDriver driver) {
        this.driver = driver;
        logger = new LoggerManager();
    }

    /*
     * method to perform Mouse hover action
     * @param element
     */
    public void hoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        logger.info("---Hover to element---");
    }

    /*
     * method to perform Drag and drop action
     * @param dragElement
     * @param dropElement
     */
    public void dragAndDropElement(WebElement dragElement, WebElement dropElement) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropElement).build().perform();
        logger.info("---dragged and dropped to element---");
    }

    /*
     * KeyBoard Actions using Actions class
     */
    public void pressKeyBoardDownArrow() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    /*
     * method to perform keyboard Action ENTER
     */
    public void pressKeyBoardENTER() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    /*
     * method to Select dropdown value by visible text
     * @param element
     * @param visibleText
     */
    public void selectdropDownValuebyText(WebElement element, String visibleText) {
        select = new Select(element);
        select.selectByVisibleText(visibleText);
        logger.info("----dropdown element is selected based on visible text -----");
    }

    /*
     * method to select Dropdown value by value
     * @param element
     * @param value
     */
    public void selectdropDownbyValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
        logger.info("----dropdown element is selected based on value -----");
    }

    /*
     * method to select Dropdown value by Index
     * @param element
     * @param index
     */
    public void selectdropDownValuebyIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
        logger.info("----dropdown element is selected based on index -----");
    }

    /*
     * multipleWindowHandling by Title
     * @param windowName
     */
    public void switchToWindow(String windowName) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            String title = driver.switchTo().window(window).getTitle();
            if (title.equals(windowName)) {
                break;
            }
        }
        logger.info("----switched to window-----");
    }

    /*
     * method to update element value by clearing the existing data
     * @param element
     * @param text
     */
    public void updateElementValue(WebElement element, String text) {
        String attributeValue = element.getAttribute("value");
        if (attributeValue != null) {
            element.clear();
        } else {
            element.sendKeys(text);
        }
        logger.info("----element value is updated-----");
    }

    /*
     * method to get element text
     * @param element
     */
    public String getElementText(WebElement element) {
        return element.getText();
    }

    /*
     * method to get element Attribute
     * @param element
     * @param attribute
     */
    public String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /*
     * method to set element text
     * @param element
     * @param text
     */
    public void sendText(WebElement element, String text) {
        element.sendKeys(text);
        logger.info("----sendkeys to element field-----");
    }

    /*
     * method to update element text by clearing the existing data
     * @param element
     * @param text
     */
    public void updateElementText(WebElement element, String text) throws InterruptedException {

        if (!(element.getAttribute("value").equals(""))) {
            element.clear();
            element.sendKeys(text);
        } else if ((element.getAttribute("value").equals(""))) {
            element.sendKeys(text);
        }
        logger.info("----element value is updated-----");
    }

    /*
     * method to clear text using backspace Actions
     * @param element
     * @param text
     */
    public void clickBackSpace(WebElement element, String text) throws InterruptedException {
        String value = element.getAttribute("value");
        Actions action = new Actions(driver);
        for (int i = 0; i < value.length(); i++) {
            action.sendKeys(Keys.BACK_SPACE).build().perform();
        }
        Thread.sleep(3000);
        element.sendKeys(text);
        logger.info("----element value is updated-----");
    }

    /*
     * method to get Element Css value of element
     * @param element
     * @param text
     * @return elementCssValue
     */
    public String getElementCSSValue(WebElement element, String propName) {
        logger.info("----returned element CSS value-----");
        return element.getCssValue(propName);

    }

    /*
     * method to click on element
     * @param element
     */
    public void clickOnElement(WebElement element) {
        element.click();
        logger.info("----element is clicked-----");
    }

    /*
     * method to wait until element is visible
     * @param element
     */
    public void waitUntilElementVisible(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("----waited until element visible-----");
    }

    /*
     * method to click on element using Actions class
     * @param element
     */
    public void actionClickElement(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).build().perform();
        logger.info("----element is clicked-----");
    }

    /*
     * method to get Current page Url
     * @return currentUrl
     */
    public String getCurrentURL() {
        logger.info("----returned current URL value-----");
        return driver.getCurrentUrl();
    }

}

