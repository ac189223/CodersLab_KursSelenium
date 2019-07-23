package com.kurs.cucumber.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchRegularExp {
    private static GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("^an open browser with google\\.com gtsre_feature$")
    public void openBrowserWithGoogle() { googleSearchPage.openWebPage("http://www.google.com"); }

    @When("a keyword (.*) is entered in input field gtsre_feature")
    public void enterKeyword(String keyword) { googleSearchPage.enterStringToSearch(keyword); }

    @Then("the first one should contain (.*) gtsre_feature")
    public void checkResults(String expectedText) { googleSearchPage.checkIfSearchResulstContains(expectedText); }

        @And("^close browser gtsre_feature$")
    public void closeBrowser() {
        googleSearchPage.closeWebBrowser();
    }
}
