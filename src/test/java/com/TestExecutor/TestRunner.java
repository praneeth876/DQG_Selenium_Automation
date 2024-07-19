package com.TestExecutor;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Connections.feature", glue = {"com.stepDefinitions", "com.pages"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
                            "json:target/cucumber-reports/cucumber-json-report.json",
                            "timeline:target/test-output-thread/",
                            "junit:target/cucumber-reports/cucumber-junit-report.xml"
        },
        tags = "@Connections-DQRule-Rulename",
        dryRun = false)
public class TestRunner  {
//        @BeforeSuite
//        public void testStart(){
//                System.out.println("Test execution started");
//        }
//        @AfterSuite
//        public void testFinish(){
//                System.out.println("Test execution finished");
//        }
}




