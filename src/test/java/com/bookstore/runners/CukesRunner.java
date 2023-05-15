package com.bookstore.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/bookstore/stepdefs",
        dryRun = false,
        tags = "@bookStoreFlow"
)
public class CukesRunner {
}
