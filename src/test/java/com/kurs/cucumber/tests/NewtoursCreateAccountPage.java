package com.kurs.cucumber.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewtoursCreateAccountPage {
    public static WebDriver driver;

    void openWebPage(String webPageAddress) {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(webPageAddress);
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "firstName")
    WebElement firstNameElement;

    @FindBy(name = "lastName")
    WebElement lastNameElement;

    @FindBy(name = "phone")
    WebElement phoneElement;

    @FindBy(name = "userName")
    WebElement emailElement;

    @FindBy(name = "address1")
    WebElement address1Element;

    @FindBy(name = "address2")
    WebElement address2Element;

    @FindBy(name = "city")
    WebElement cityElement;

    @FindBy(name = "state")
    WebElement stateElement;

    @FindBy(name = "postalCode")
    WebElement postalCodeElement;

    @FindBy(name = "email")
    WebElement userNameElement;

    @FindBy(name = "password")
    WebElement passwordElement;

    @FindBy(name = "confirmPassword")
    WebElement passwordCElement;

    void enterFirstName(String firstName) { ifDisplayed_thenFillIn(this.firstNameElement, firstName); }

    void enterLastName(String lastName) {
        ifDisplayed_thenFillIn(this.lastNameElement, lastName);
    }

    void enterPhone(String phone) {
        ifDisplayed_thenFillIn(this.phoneElement, phone);
    }

    void enterEmail(String email) { ifDisplayed_thenFillIn(this.emailElement, email); }

    void enterAddressFirstLine(String address1) { ifDisplayed_thenFillIn(this.address1Element, address1); }

    void enterAddressSecondLine(String address2) { ifDisplayed_thenFillIn(this.address2Element, address2); }

    void enterCity(String city) { ifDisplayed_thenFillIn(this.cityElement, city); }

    void enterState(String state) { ifDisplayed_thenFillIn(this.stateElement, state); }

    void enterPostalCode(String postalCode) { ifDisplayed_thenFillIn(this.postalCodeElement, postalCode); }

    void enterUserName(String userName) { ifDisplayed_thenFillIn(this.userNameElement, userName); }

    void enterPassword(String password) { ifDisplayed_thenFillIn(this.passwordElement, password); }

    void enterPasswordConfirmation(String passwordC) { ifDisplayed_thenFillIn(this.passwordCElement, passwordC); }

    private void ifDisplayed_thenFillIn(WebElement element, String inputText) {
        ifDisplayed(element);
        element.click();
        element.clear();
        element.sendKeys(inputText);
    }

    private void ifDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
        Assert.assertTrue(element.isEnabled());
    }

    @FindBy(name = "register")
    WebElement submitButton;

    void submitForm() {
        submitButton.click();
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    void confirmCreation() {
        // Check if current url is an expected one
//        Assert.assertTrue(driver.getCurrentUrl().contains("create_account_success"));
    }

    void closeBrowser() {
        //Close webBrowser
//        driver.quit();
    }
}
