package com.kurs.cucumber.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class aavtrainCreateAccountParameters {
    private WebDriver driver;

    @Given("^an open browser with http://aavtrain\\.com/ acap_feature")
    public void anOpenBrowserWithHttpAavtrainComP() {
        // Configure of drivers for webBrowser
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        // Run new webBrowser window
        driver = new FirefoxDriver();
        // Maximize window
        driver.manage().window().maximize();
        // Go to webPage
        driver.get("http://aavtrain.com/");
    }

    @When("^button First Time Students Register Here is clicked acap_feature")
    public void buttonFirstTimeStudentsRegisterHereIsClickedP() {
        // Find user creation button
        WebElement element = (driver.findElement(By.cssSelector("div.bodytxt")).findElement(By.xpath(".//a")));
        // Click this button
        element.click();
        // Wait for loading (max 10sek)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^form on https://aavtrain\\.com/create_user\\.asp opens acap_feature")
    public void formOnHttpsAavtrainComCreate_userAspOpensP() {
        // Check if current url is an expected one
        Assert.assertEquals("https://aavtrain.com/create_user.asp", driver.getCurrentUrl());
    }

    @And("^user fills in required fields: first name (.*), last name (.*), email (.*), user name (.*), address (.*), city (.*), state (.*), zip code (.*), password (.*) acap_feature$")
    public void userFillsInRequiredFieldsP(String  firstName, String lastName, String email, String userName, String address, String city, String state, String zipCode, String password) {
         // Input data
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        driver.findElement(By.name("last_name")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("user_name")).sendKeys(userName);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("prov")).sendKeys(state);
        driver.findElement(By.name("zip")).sendKeys(zipCode);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("^click Submit button acap_feature")
    public void clickSubmitButtonP() {
        // Click submit
        driver.findElement(By.name("Submit")).click();
    }

    @Then("^error is displayed acap_feature")
    public void errorIsDisplayedP() {
        // Find error message element (bold)
        WebElement element = (driver.findElement(By.cssSelector("div.errortextB")).findElement(By.xpath(".//strong")));
        // Check if message is an expected one
        Assert.assertEquals("The password you have entered is not valid or has already been used,\n" +
                "please check your password and try again.\n" +
                "If this problem persists, contact your instructor.", element.getText());
    }

    @And("^close web browser acap_feature")
    public void closeWebBrowserP() {
        //Close webBrowser
        //driver.quit();
    }
}
