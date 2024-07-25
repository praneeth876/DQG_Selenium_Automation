package com.utilities;

import com.DriverManagers.LoggerManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;
import java.util.Set;

public class WebUtils {
WebDriver driver;
Select select;
WebDriverWait wait;
LoggerManager logger ;
   // WebUtils webUtils;
//Actions actions;
    //Creating a constructor to initialize driver
public WebUtils(WebDriver driver){

    this.driver=driver;
    logger=new LoggerManager();
    //this.webUtils=new WebUtils(driver);

    }
//Mouse hover action
public void hoverToElement(WebElement element){
     Actions actions=new Actions(driver);
        actions.moveToElement(element);
        logger.info("---Hover to element---");
}
//Drag and drop action
public void dragAndDropElement(WebElement dragElement,WebElement dropElement){
    Actions actions=new Actions(driver);
    actions.dragAndDrop(dragElement,dropElement).build().perform();
    logger.info("---dragged and dropped to element---");
}

//KeyBoard Actions using Actions class
public void pressKeyBoardDownArrow(){
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        //actions.sendKeys("Keys."+keyboardButtonName).build().perform();
       // logger.info("---keyboard action"+keyboardButtonName+" is pressed---");
    }
    public void pressKeyBoardENTER(){
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        //actions.sendKeys("Keys."+keyboardButtonName).build().perform();
        //logger.info("---keyboard action"+keyboardButtonName+" is pressed---");
    }

//Select dropdown values
    public void selectdropDownValuebyText(WebElement element,String visibleText){
         select=new Select(element);
        select.selectByVisibleText(visibleText);
        logger.info("----dropdown element is selected based on visible text -----");
}
    public void selectdropDownbyValue(WebElement element,String value){
        select=new Select(element);
        select.selectByValue(value);
        logger.info("----dropdown element is selected based on value -----");
    }
    public void selectdropDownValuebyIndex(WebElement element,int index){
        select=new Select(element);
        select.selectByIndex(index);
        logger.info("----dropdown element is selected based on index -----");
    }

    //multipleWindowHandling by Title
    public void switchToWindow(String windowName){
        Set<String> allWindows=driver.getWindowHandles();
        for(String window : allWindows){
            String title=driver.switchTo().window(window).getTitle();
            if(title.equals(windowName)){
                break;
            }
        }
        logger.info("----switched to window-----");
    }
    public void updateElementValue(WebElement element,String text) {
        String attributeValue = element.getAttribute("value");
        if (attributeValue != null) {
            element.clear();
        } else {
            element.sendKeys(text);
        }
        logger.info("----element value is updated-----");
    }
    public String getElementText(WebElement element){
      return  element.getText();
    }
    public String getElementAttribute(WebElement element,String attribute){
        return  element.getAttribute(attribute);
    }
    public void sendText(WebElement element,String text){
          element.sendKeys(text);
        logger.info("----sendkeys to element field-----");
    }

    public void updateElementText(WebElement element,String text){
          if(element.getAttribute("value")!=null){
              element.clear();
              element.sendKeys(text);
          }else {
              element.sendKeys(text);
          }
        logger.info("----element value is updated-----");
    }
    public String getElementCSSValue(WebElement element,String propName){
         return  element.getCssValue(propName);
    }
    public void clickOnElement(WebElement element){
        element.click();
        logger.info("----element is clicked-----");
    }
    public void waitUntilElementVisible(WebElement element){
     wait=new WebDriverWait(driver, Duration.ofSeconds(100));
     wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("----waited until element visible-----");
    }

public String getCurrentURL(){
    return driver.getCurrentUrl();
}

}
