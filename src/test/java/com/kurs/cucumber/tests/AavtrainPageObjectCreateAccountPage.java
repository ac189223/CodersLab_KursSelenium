package com.kurs.cucumber.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AavtrainPageObjectCreateAccountPage extends AavtrainPageObject {

    @FindBy(name = "first_name")
    private WebElement inputFirstNameElement;

    void enterFirstName(String string) { inputFirstNameElement.sendKeys(string); }

    @FindBy(name = "last_name")
    private WebElement inputLastNameElement;

    void enterLastName(String string) { inputLastNameElement.sendKeys(string); }

    @FindBy(name = "email")
    private WebElement inputEmailElement;

    void enterEmail(String string) { inputEmailElement.sendKeys(string); }

    @FindBy(name = "user_name")
    private WebElement inputUserNameElement;

    void enterUserName(String string) { inputUserNameElement.sendKeys(string); }

    @FindBy(name = "address1")
    private WebElement inputAddressElement;

    void enterAddress(String string) { inputAddressElement.sendKeys(string); }

    @FindBy(name = "city")
    private WebElement inputCityElement;

    void enterCity(String string) { inputCityElement.sendKeys(string); }

    @FindBy(name = "prov")
    private WebElement inputStateElement;

    void enterState(String string) { inputStateElement.sendKeys(string); }

    @FindBy(name = "zip")
    private WebElement inputZipCodeElement;

    void enterZipCode(String string) { inputZipCodeElement.sendKeys(string); }

    @FindBy(name = "password")
    private WebElement inputPasswordElement;

    void enterPassword(String string) { inputPasswordElement.sendKeys(string); }

    @FindBy(name = "Submit")
    private WebElement submitButton;

    void submitForm() { submitButton.click(); }

    void checkSubmissionErrorText() {
        // Find error message element (bold)
        WebElement element = (driver.findElement(By.cssSelector("div.errortextB")).findElement(By.xpath(".//strong")));
        // Check if message is an expected one
        Assert.assertEquals("The password you have entered is not valid or has already been used,\n" +
                "please check your password and try again.\n" +
                "If this problem persists, contact your instructor.", element.getText());
    }
}
