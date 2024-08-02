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
    @Before
    public void setUp() {
        ReadConfig.loadFile();
        Browsers browser = ReadConfig.getBrowser();
        switch (browser) {
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(Url());
                driver.manage().window().maximize();
            }
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("[--remote-allow-origins=*]");
                driver = new ChromeDriver(opt);
                driver.manage().window().maximize();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().driverVersion("0.34.0").setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
    }


    public static String Url() {
        ReadConfig.setUrl();
        return ReadConfig.getUrl();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        driver.close();
    }

}
