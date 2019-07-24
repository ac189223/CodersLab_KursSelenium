package com.kurs.cucumber.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewtoursCreateAccountParameters {
    private static NewtoursCreateAccountPage newtoursCreateAccountPage = new NewtoursCreateAccountPage();

    @Given("^an open browser with (.*) ncap_feature$")
    public void openBrowser(String webAddress) {
        newtoursCreateAccountPage.openWebPage(webAddress);
    }

    @When("^user fills in required fields: (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) ncap_feature$")
    public void fillInRequiredFields(String firstName, String lastName, String phone, String email, String address1, String address2, String city, String state, String zip, String userName, String password, String passwordC) {
        // Input data
        newtoursCreateAccountPage.enterFirstName(firstName);
        newtoursCreateAccountPage.enterLastName(lastName);
        newtoursCreateAccountPage.enterPhone(phone);
        newtoursCreateAccountPage.enterEmail(email);
        newtoursCreateAccountPage.enterAddressFirstLine(address1);
        newtoursCreateAccountPage.enterAddressSecondLine(address2);
        newtoursCreateAccountPage.enterCity(city);
        newtoursCreateAccountPage.enterState(state);
        newtoursCreateAccountPage.enterPostalCode(zip);
        newtoursCreateAccountPage.enterUserName(userName);
        newtoursCreateAccountPage.enterPassword(password);
        newtoursCreateAccountPage.enterPasswordConfirmation(passwordC);
    }

    @And("^click Submit button ncap_feature$")
    public void clickSubmit() {
        newtoursCreateAccountPage.submitForm();
    }

    @Then("^user is created ncap_feature$")
    public void confirmCreation() {
        newtoursCreateAccountPage.confirmCreation();
    }

    @And("^close web browser ncap_feature$")
    public void closeBrowser() {
        newtoursCreateAccountPage.closeBrowser();
    }
}
