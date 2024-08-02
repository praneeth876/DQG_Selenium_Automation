package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    JavascriptExecutor js;

    public JavaScriptUtils(WebDriver driver){
        this.js=(JavascriptExecutor)driver;
    }
    /*
     * js method to click on element
     * @param element
     */
    public void clickOnElement(WebElement element){
        js.executeScript("arguments[0].click();",element);
    }
    /*
     * js method to update element value
     * @param element
     * @param text
     */
    public void sendText(WebElement element,String text){
        js.executeScript("arguments[0].value='"+text+"';",element);
    }
    /*
     * js method to get page title
     *@return page title
     */
    public void getPageTitle(){
         js.executeScript("return document.title");
    }
    /*
     * js method to scroll page by co-ordinates
     * @param start
     * @param end
     */
    public void srollByCordinates(int start,int end){
        js.executeScript("window.scrollTo("+start+","+end+")");
    }
    /*
     * method to perform Drag and drop action
     * @param element
     */
    public void srollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }
    /*
     * method to perform Drag and drop action
     * @param element
     */
    public void highlightElement(WebElement element){
        js.executeScript("arguments[0].style.border='3px solid red'",element);
    }
}
