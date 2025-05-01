package com.example.bwappbdd;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.bwappbdd.stepdefs",
        plugin = {"pretty"},
        monochrome = true
)
public class RunCucumberTest {
}

