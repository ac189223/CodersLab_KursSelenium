package com.kurs.cucumber.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AavtrainPOPCreateAccount {
    static WebDriver driver;
    public AavtrainPageObjectWelcomePage aavtrainWelcomePage = new AavtrainPageObjectWelcomePage();
    public AavtrainPageObjectCreateAccountPage aavtrainCreateAccountPage = new AavtrainPageObjectCreateAccountPage();

    @Given("^an open browser with http://aavtrain\\.com/ acapop_feature$")
    public void openBrowserWithAavtrain() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("http://aavtrain.com/");
        }

    @When("^button First Time Students Register Here is clicked acapop_feature$")
    public void registrationButtonClick() {
        aavtrainWelcomePage.registrationButton(driver).click();
        aavtrainWelcomePage.wait(driver);
    }

    @Then("^form on https://aavtrain\\.com/create_user\\.asp opens acapop_feature$")
    public void registrationFormOpens() {
        aavtrainWelcomePage.confirmWebAddress("https://aavtrain.com/create_user.asp", driver);
    }

    @And("^user fills in all required fields acapop_feature$")
    public void userFillsInAllRequiredFields() {
        aavtrainCreateAccountPage.findRequiredFields(driver);
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
        aavtrainCreateAccountPage.checkSubmissionErrorText(driver);
    }

    @And("^close web browser acapop_feature$")
    public void closeWebBrowser() {
        driver.quit();
    }

}
