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

public class aavtrainCreateAccount {
    private WebDriver driver;

    @Given("^an open browser with http://aavtrain\\.com/ aca_feature$")
    public void anOpenBrowserWithHttpAavtrainCom() {
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

    @When("^button First Time Students Register Here is clicked aca_feature$")
    public void buttonFirstTimeStudentsRegisterHereIsClicked() {
        // Find user creation button
        WebElement element = (driver.findElement(By.cssSelector("div.bodytxt")).findElement(By.xpath(".//a")));
        // Click this button
        element.click();
        // Wait for loading (max 10sek)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^form on https://aavtrain\\.com/create_user\\.asp opens aca_feature$")
    public void formOnHttpsAavtrainComCreate_userAspOpens() {
        // Check if current url is an expected one
        Assert.assertEquals("https://aavtrain.com/create_user.asp", driver.getCurrentUrl());
    }

    @And("^user fills in all required fields aca_feature$")
    public void userFillsInAllRequiredFields() {
        // Input data
        driver.findElement(By.name("first_name")).sendKeys("James");
        driver.findElement(By.name("last_name")).sendKeys("Butt");
        driver.findElement(By.name("email")).sendKeys("jbutt@gmail.com");
        driver.findElement(By.name("user_name")).sendKeys("jambut");
        driver.findElement(By.name("address1")).sendKeys("6649 N Blue Gum St");
        driver.findElement(By.name("city")).sendKeys("New Orleans");
        driver.findElement(By.name("prov")).sendKeys("LA");
        driver.findElement(By.name("zip")).sendKeys("70116");
        driver.findElement(By.name("password")).sendKeys("jambut123");
    }

    @And("^click Submit button aca_feature$")
    public void clickSubmitButton() {
        // Click submit
        driver.findElement(By.name("Submit")).click();
    }

    @Then("^error is displayed aca_feature$")
    public void errorIsDisplayed() {
        // Find error message element (bold)
        WebElement element = (driver.findElement(By.cssSelector("div.errortextB")).findElement(By.xpath(".//strong")));
        // Check if message is an expected one
        Assert.assertEquals("The password you have entered is not valid or has already been used,\n" +
                "please check your password and try again.\n" +
                "If this problem persists, contact your instructor.", element.getText());
    }

    @And("^close web browser aca_feature$")
    public void closeWebBrowser() {
        //Close webBrowser
        driver.quit();
    }

}
