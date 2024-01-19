package com.byronlopezec.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "com.byronlopezec.glue",
        tags = "@SauceDemoChallenger"
)
public class RunnerTest {

}