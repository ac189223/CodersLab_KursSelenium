package com.kurs.cucumber.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchFirst {
    private static GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    private String stringToSearch = "selenium";

    @Given("^an open browser with google\\.com gts_feature$")
    public void openBrowserWithGoogle() { googleSearchPage.openWebPage("http://www.google.com"); }

    @When("^a keyword selenium is entered in input field gts_feature$")
    public void enterSelenium() { googleSearchPage.enterStringToSearch(stringToSearch); }

    @Then("^the first one should contain selenium gts_feature$")
    public void checkResults() { googleSearchPage.checkIfSearchResulstContains(stringToSearch); }

        @And("^close browser gts_feature$")
    public void closeBrowser() { googleSearchPage.closeWebBrowser(); }
}
