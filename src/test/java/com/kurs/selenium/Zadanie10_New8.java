package com.kurs.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zadanie10_New8 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void  TestKatalonForm() {
        WebElement firstNameElement = driver.findElement(By.id("first-name"));
        firstNameElement.click();
        firstNameElement.sendKeys("Jan");
        WebElement lastNameElement = driver.findElement(By.id("last-name"));
        lastNameElement.click();
        lastNameElement.sendKeys("Kowalski");
        List<WebElement> genderElements = driver.findElements(By.name("gender"));
        genderElements.get(1).click();
        WebElement dateOfBirthElement = driver.findElement(By.id("dob"));
        dateOfBirthElement.click();
        dateOfBirthElement.sendKeys("05/22/2010");
        WebElement addressElement = driver.findElement(By.id("address"));
        addressElement.click();
        addressElement.sendKeys("Prosta 51");
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.click();
        emailElement.sendKeys("karol.kowalski@mailinator.com");
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.click();
        passwordElement.sendKeys("Pass123");
        WebElement companyElement = driver.findElement(By.id("company"));
        companyElement.click();
        companyElement.sendKeys("Coders Lab");

        // Select of role
        Select roleSelect = new Select(driver.findElement(By.id("role")));
        roleSelect.selectByVisibleText("Manager");

        // Select of job expectation
        Select expectationSelect = new Select(driver.findElement(By.id("expectation")));
        expectationSelect.selectByVisibleText("High salary");
        expectationSelect.selectByVisibleText("Good teamwork");

//        // Select of job expectation
//        Select expectationSelect = new Select(driver.findElement(By.id("expectation")));
//        expectationSelect.selectByIndex(1);
//        expectationSelect.selectByIndex(2);

//        // Select of job expectation
//        // .get(5) to .get(11)
//        List<WebElement> jobExpectationElements = driver.findElements(By.xpath("//option"));
//        jobExpectationElements.get(6).click();
//        jobExpectationElements.get(8).click();

        // List of checkboxes - we would have to omit three "input" that are for gender
        // we would have from .get(3) to .get(8)
        // But we found first "div" around our "input" and we have just ours !
        WebElement developmentWays = driver.findElement(By.cssSelector("div.col-sm-10.development-ways"));
        List<WebElement> waysOfDevelopmentElements = developmentWays.findElements(By.xpath(".//input"));
        waysOfDevelopmentElements.get(0).click();
        waysOfDevelopmentElements.get(1).click();

        WebElement commentElement = driver.findElement(By.id("comment"));
        commentElement.click();
        commentElement.sendKeys("To jest mój pierwszy automat testowy");

        // Send form
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        // Wait for loading of page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Test check - if confirmation text is visible
        WebElement confirmation = driver.findElement(By.className("submit-msg"));
        Boolean conf = confirmation.isDisplayed();
        System.out.println(conf);
        Assert.assertTrue(conf);
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }


}
