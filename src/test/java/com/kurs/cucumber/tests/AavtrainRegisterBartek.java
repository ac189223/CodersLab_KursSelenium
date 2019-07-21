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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AavtrainRegisterBartek {

    private WebDriver driver;
    private WebDriverWait wait;
    private int defaultTimeout = 20;

    public AavtrainRegisterBartek() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, defaultTimeout);
    }

    @Given("an open browser with https://aavtrain.com/")
    public void openAactrainMainPage() {
        driver.manage().window().maximize();
        driver.get("https://aavtrain.com/");
    }

    @When("a 'First Time Students Register Here' button is clicked")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='create_user.asp']")));
        WebElement registerButton = driver.findElement(By.xpath("//a[@href='create_user.asp']"));
        registerButton.click();
    }

    @Then("registration form opens")
    public void isRegistrationPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("first_name")));
        Boolean isFirstNameDisplayed = driver.findElement(By.name("first_name")).isDisplayed();
        Assert.assertTrue(isFirstNameDisplayed);
    }


    // user inputs <firstName>, <lastName>, <emailAddress>, <username>, <address1>, <city>, <state>, <zip>, <password>
    @When("user inputs (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
    public void inputRegistrationData(String firstName, String lastName, String emailAddress, String userName,
                                      String address1, String city, String state, String zip, String password) {
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        //input last name
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(lastName);
        //input email address
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(emailAddress);
        //input email address
        driver.findElement(By.name("user_name")).clear();
        driver.findElement(By.name("user_name")).sendKeys(userName);
        //input email address
        driver.findElement(By.name("address1")).clear();
        driver.findElement(By.name("address1")).sendKeys(address1);
        //input city
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(city);
        //input state
        driver.findElement(By.name("prov")).clear();
        driver.findElement(By.name("prov")).sendKeys(state);
        //input zip code
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        //input password
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("clicks 'Submit' button")
    public void clickSubmitButton() {
        driver.findElement(By.name("Submit")).click();
    }

    @Then("error 'There is an error in the information you provided.' occurs")
    public void didErrorOccured() {
        String errorMessage = driver.findElement(By.className("errortextB")).getText();
        Assert.assertTrue(errorMessage.contains("There is an error in the information you provided"));
    }

    @And("close aavtrain page")
    public void closeBrowser() {
        driver.quit();
    }
}