package com.utilities;

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
   // WebUtils webUtils;
//Actions actions;
    //Creating a constructor to initialize driver
public WebUtils(WebDriver driver){

    this.driver=driver;
    //this.webUtils=new WebUtils(driver);

    }
//Mouse hover action
public void hoverToElement(WebElement element){
     Actions actions=new Actions(driver);
        actions.moveToElement(element);
}
//Drag and drop action
public void dragAndDropElement(WebElement dragElement,WebElement dropElement){
    Actions actions=new Actions(driver);
    actions.dragAndDrop(dragElement,dropElement);
}

//KeyBoard Actions using Actions class
public void keyBoardOperations(String keyboardButtonName){
    Actions actions=new Actions(driver);
    actions.sendKeys("Keys."+keyboardButtonName+"").build().perform();
}

//Select dropdown values
    public void selectdropDownValuebyText(WebElement element,String visibleText){
         select=new Select(element);
        select.selectByVisibleText(visibleText);
}
    public void selectdropDownbyValue(WebElement element,String value){
        select=new Select(element);
        select.selectByValue(value);
    }
    public void selectdropDownValuebyIndex(WebElement element,int index){
        select=new Select(element);
        select.selectByIndex(index);
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
    }
    public void updateElementValue(WebElement element,String text) {
        String attributeValue = element.getAttribute("value");
        if (attributeValue != null) {
            element.clear();
        } else {
            element.sendKeys(text);
        }
    }
    public String getElementText(WebElement element){
      return  element.getText();
    }
    public String getElementAttribute(WebElement element,String attribute){
        return  element.getAttribute(attribute);
    }
    public void sendText(WebElement element,String text){
          element.sendKeys(text);
    }

    public void updateElementText(WebElement element,String text){
          if(element.getAttribute("value")!=null){
              element.clear();
              element.sendKeys(text);
          }
    }
    public void clickOnElement(WebElement element){
        element.click();
    }
    public void waitUntilElementVisible(WebElement element){
     wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(element));
    }



}
