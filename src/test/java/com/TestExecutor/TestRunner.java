package com.TestExecutor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/DQRules.feature", glue = {"com.stepDefinitions", "com.pages"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
                            "json:target/cucumber-reports/cucumber-json-report.json",
                            "timeline:target/test-output-thread/",
                            "junit:target/cucumber-reports/cucumber-junit-report.xml"
        },
        tags = "@DQRules-ExecResult",
        dryRun = false)
public class TestRunner  {

}




