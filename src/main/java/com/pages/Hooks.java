package com.pages;

import com.Config.ReadConfig;
import com.DriverManagers.DriverManager;
import com.Enum.Browsers;
import com.baseClass.BasePage;
import com.utilities.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Hooks extends BasePage {
    public static WebDriver driver;
    @Before
    public void setUp(Scenario scenario) {

        ReadConfig.loadFile();
        Browsers browser = ReadConfig.getBrowser();
        String URL=ReadConfig.getUrl();

        switch (browser) {
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                driver.navigate().to(URL);
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driver.navigate().to(URL);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                driver.navigate().to(URL);
        }
    }


//
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
    //super.setUp();


    @After
    public void tearDown(Scenario scenario) throws IOException {

//        if(scenario.isFailed()) {
//            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            File file = new File(System.getProperty("user.dir") + "\\Screenshots\\Defects.png");
//            FileOutputStream fileOut = new FileOutputStream(file);
//            fileOut.write(screenshot);
//        }


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
