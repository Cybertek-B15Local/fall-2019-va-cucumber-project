package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
//                "message:https://b1f2yk58d8.execute-api.eu-west-3.amazonaws.com/api/repository/9e0fce3d-1dc8-4e91-8f6b-a1f53adbc0c0",
                "pretty",
//                "html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },

        features = "src/test/resources/features",
        glue = "com/cybertek/library/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {}
