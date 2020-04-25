package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                  "rerun:target/rerun.txt",
                  "json:target/cucumber.json"
                },

        features = "src/test/resources/features",
        glue = "com/cybertek/library/step_definitions",
        dryRun = false,
        tags = "@lib-2423"
)
public class CukesRunner {
}