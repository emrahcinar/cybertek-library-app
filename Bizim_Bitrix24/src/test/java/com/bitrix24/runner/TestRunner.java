package com.bitrix24.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber.html"
        },
        features = "src/test/resources/features",
        glue = "com/bitrix24/step_definitions",
        tags=""

)


@RunWith(Cucumber.class)
public class TestRunner {

}
