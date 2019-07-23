package com.kurs.cucumber.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AavtrainCreateAccountPOP {
    public AavtrainPageObjectWelcomePage aavtrainWelcomePage = new AavtrainPageObjectWelcomePage();

    @Given("^an open browser with http://aavtrain\\.com/ acapop_feature$")
    public void openBrowserWithAavtrain() {
        aavtrainWelcomePage.openWebPage("http://aavtrain.com/");
    }

    @When("^button First Time Students Register Here is clicked acapop_feature$")
    public void registrationButtonClick() {
        aavtrainWelcomePage.registrationButtonClick();
    }

    @Then("^form on https://aavtrain\\.com/create_user\\.asp opens acapop_feature$")
    public void registrationFormOpens() {
        aavtrainWelcomePage.confirmWebAddress("https://aavtrain.com/create_user.asp");
    }

    AavtrainPageObjectCreateAccountPage aavtrainCreateAccountPage = new AavtrainPageObjectCreateAccountPage();


    @And("^user fills in all required fields acapop_feature$")
    public void userFillsInAllRequiredFields() {
        aavtrainCreateAccountPage.openWebPage("https://aavtrain.com/create_user.asp");
        // Input data
        aavtrainCreateAccountPage.enterFirstName("James");
        aavtrainCreateAccountPage.enterLastName("Butt");
        aavtrainCreateAccountPage.enterEmail("jbutt@gmail.com");
        aavtrainCreateAccountPage.enterUserName("jambut");
        aavtrainCreateAccountPage.enterAddress("6649 N Blue Gum St");
        aavtrainCreateAccountPage.enterCity("New Orleans");
        aavtrainCreateAccountPage.enterState("LA");
        aavtrainCreateAccountPage.enterZipCode("70116");
        aavtrainCreateAccountPage.enterPassword("jambut123");
    }

    @And("^click Submit button acapop_feature$")
    public void submitForm() {
        aavtrainCreateAccountPage.submitForm();
    }

    @Then("^error is displayed acapop_feature$")
    public void checkIfError() {
        aavtrainCreateAccountPage.checkSubmissionErrorText();
    }

    @And("^close web browser acapop_feature$")
    public void closeWebBrowser() {
        aavtrainCreateAccountPage.closeWebBrowser();
    }

}
