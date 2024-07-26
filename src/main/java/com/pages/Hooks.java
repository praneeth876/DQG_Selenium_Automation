package com.pages;

import com.Config.ReadConfig;
import com.DriverManagers.DriverManager;
import com.Enum.Browsers;
import com.Enum.URL;
import com.baseClass.BasePage;
import com.utilities.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class Hooks extends BasePage {
   // public static WebDriver driver;
    @Before
    public void setUp() {

        //ReadConfig.loadFile();
//        Browsers browser = ReadConfig.getBrowser();
//        System.out.println(browser);
String browser="EDGE";
        switch (browser) {
            case "EDGE" :
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;

        case "CHROME" :
                WebDriverManager.chromedriver().setup();
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("[--remote-allow-origins=*]");
                driver = new ChromeDriver(opt);
                break;

            case "FIREFOX" :
                WebDriverManager.firefoxdriver().driverVersion("0.34.0").setup();
                driver = new FirefoxDriver();
                break;
            }
        }



//
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
    //super.setUp();

    @After
    public void tearDown(Scenario scenario) throws IOException, InterruptedException {

//        WebElement account=driver.findElement(By.cssSelector("[class='MuiBox-root css-i9gxme'] [data-testid='PersonIcon']"));
//        account.click();
//        Thread.sleep(10000);
//        WebElement logout=driver.findElement(By.xpath("//*[text()='Logout']"));
//        logout.click();
//        if(scenario.isFailed()) {
//            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            File file = new File(System.getProperty("user.dir") + "\\Screenshots\\Defects.png");
//            FileOutputStream fileOut = new FileOutputStream(file);
//            fileOut.write(screenshot);
//        }
driver.close();

    }


//    @Before
//    public void setUp() {
//        super.setUp();
//    }
//
//    @After
//    public void tearDown() {
//        super.tearDown();
//    }


}
