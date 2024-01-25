package com.runTest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,

        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "json:reports/Cucumber.json"},
        features = {"./src/test/resources/features"},
        glue = {"com.titansoftware.steps", "com.titansoftware.configuration"},
        tags = "@Smoke_test")
public class RunTest {
}



