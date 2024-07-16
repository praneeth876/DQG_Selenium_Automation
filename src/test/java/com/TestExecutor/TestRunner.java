package com.TestExecutor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/Connections.feature",glue={"com.stepDefinitions","com.pages"},
                plugin = {"pretty","html:target/cucumber-html-report"},dryRun = false)
public class TestRunner {

}


