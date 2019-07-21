package com.kurs.cucumber.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/kurs/cucumber/features/google-text-search-regular-exp.feature",
        plugin = {"pretty","html:out"})

public class GoogleSearchRegularExpTest {
}