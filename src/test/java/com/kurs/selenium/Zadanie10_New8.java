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
    public void TestKatalonForm() {

        String inputText = "";
        String inputText2 = "";
        String labelText = "";
        int i;
        int timesMale = 0;
        int timesFemale = 0;
        int timesInBetween = 0;
        int iRole = 0;
        int iJobExpectation = 0;
        int iWaysOfDevelopment = 0;

        // First name
        WebElement firstNameElement = driver.findElement(By.id("first-name"));
        Assert.assertTrue(firstNameElement.isDisplayed());
        Assert.assertTrue(firstNameElement.isEnabled());
        WebElement firstNameLabel = firstNameElement.findElement(By.xpath("./../../label"));
        labelText = firstNameLabel.getText();
        inputText = "Jan";
        System.out.println(labelText + " : " + inputText);
        firstNameElement.click();
        firstNameElement.sendKeys(inputText);

        // Last name
        WebElement lastNameElement = driver.findElement(By.id("last-name"));
        Assert.assertTrue(lastNameElement.isDisplayed());
        Assert.assertTrue(lastNameElement.isEnabled());
        WebElement lastNameLabel = lastNameElement.findElement(By.xpath("./../../label"));
        labelText = lastNameLabel.getText();
        inputText = "Kowalski";
        System.out.println(labelText + " : " + inputText);
        lastNameElement.click();
        lastNameElement.sendKeys(inputText);

        // Gender
        List<WebElement> genderElements = driver.findElements(By.name("gender"));
        for (i = 0; i < genderElements.size(); i++) {
            Assert.assertTrue(genderElements.get(i).isDisplayed());
            Assert.assertTrue(genderElements.get(i).isEnabled());
        }
        i = randomGender(timesMale, timesFemale, timesInBetween);
        switch (i) {
            case 0:
                timesMale++;
            case 1:
                timesFemale++;
            case 2:
                timesInBetween++;
        }
        WebElement genderElement = genderElements.get(i);
        WebElement genderElementLabel = genderElement.findElement(By.xpath("./.."));
        inputText = genderElementLabel.getText();
        WebElement genderLabel = genderElement.findElement(By.xpath("./../../../../label"));
        labelText = genderLabel.getText();
        System.out.println(labelText + " : " + inputText);
        genderElements.get(i).click();

        // Date of birth
        WebElement dateOfBirthElement = driver.findElement(By.id("dob"));
        Assert.assertTrue(dateOfBirthElement.isDisplayed());
        Assert.assertTrue(dateOfBirthElement.isEnabled());
        WebElement dateOfBirthLabel = dateOfBirthElement.findElement(By.xpath("./../../label"));
        labelText = dateOfBirthLabel.getText();
        inputText = "05/22/2010";
        System.out.println(labelText + " : " + inputText);
        dateOfBirthElement.click();
        dateOfBirthElement.sendKeys(inputText);

        // Adderss
        WebElement addressElement = driver.findElement(By.id("address"));
        Assert.assertTrue(addressElement.isDisplayed());
        Assert.assertTrue(addressElement.isEnabled());
        WebElement addressLabel = addressElement.findElement(By.xpath("./../../label"));
        labelText = addressLabel.getText();
        inputText = "Prosta 51";
        System.out.println(labelText + " : " + inputText);
        addressElement.click();
        addressElement.sendKeys(inputText);

        // Email
        WebElement emailElement = driver.findElement(By.id("email"));
        Assert.assertTrue(emailElement.isDisplayed());
        Assert.assertTrue(emailElement.isEnabled());
        WebElement emailLabel = emailElement.findElement(By.xpath("./../../label"));
        labelText = emailLabel.getText();
        inputText = "karol.kowalski@mailinator.com";
        System.out.println(labelText + " : " + inputText);
        emailElement.click();
        emailElement.sendKeys(inputText);

        // Password
        WebElement passwordElement = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordElement.isDisplayed());
        Assert.assertTrue(passwordElement.isEnabled());
        WebElement passwordLabel = passwordElement.findElement(By.xpath("./../../label"));
        labelText = passwordLabel.getText();
        inputText = "Pass123";
        System.out.println(labelText + " : " + inputText);
        passwordElement.click();
        passwordElement.sendKeys(inputText);

        // Company
        WebElement companyElement = driver.findElement(By.id("company"));
        Assert.assertTrue(companyElement.isDisplayed());
        Assert.assertTrue(companyElement.isEnabled());
        WebElement companyLabel = companyElement.findElement(By.xpath("./../../label"));
        labelText = companyLabel.getText();
        inputText = "Coders Lab";
        System.out.println(labelText + " : " + inputText);
        companyElement.click();
        companyElement.sendKeys(inputText);

        // Role - select an item from a list
        WebElement roleElement = driver.findElement(By.id("role"));
        List<WebElement> roleElementsList = roleElement.findElements(By.xpath("./option"));
        for (i = 0; i < roleElementsList.size(); i++) {
            Assert.assertTrue(roleElementsList.get(i).isDisplayed());
            Assert.assertTrue(roleElementsList.get(i).isEnabled());
        }
        WebElement roleLabel = roleElement.findElement(By.xpath("./../../label"));
        labelText = roleLabel.getText();
        inputText = roleElementsList.get(iRole % roleElementsList.size()).getText();
        System.out.println(labelText + " : " + inputText);
        Select roleSelect = new Select(driver.findElement(By.id("role")));
        roleSelect.selectByVisibleText(inputText);
        iRole++;

        // Job expectation - select two items from a list
        WebElement jobExpectationElement = driver.findElement(By.id("expectation"));
        List<WebElement> jobExpectationElementsList = jobExpectationElement.findElements(By.xpath("./option"));
        for (i = 0; i < jobExpectationElementsList.size(); i++) {
            Assert.assertTrue(jobExpectationElementsList.get(i).isDisplayed());
            Assert.assertTrue(jobExpectationElementsList.get(i).isEnabled());
        }
        WebElement jobExpectationLabel = jobExpectationElement.findElement(By.xpath("./../../label"));
        labelText = jobExpectationLabel.getText();
        inputText = jobExpectationElementsList.get(iJobExpectation % jobExpectationElementsList.size()).getText();
        inputText2 = jobExpectationElementsList.get((iJobExpectation + 1) % jobExpectationElementsList.size()).getText();
        System.out.println(labelText + " : " + inputText + ", " + inputText2);
        Select jobExpectationSelect = new Select(driver.findElement(By.id("expectation")));
        jobExpectationSelect.selectByVisibleText(inputText);
        jobExpectationSelect.selectByVisibleText(inputText2);
        iJobExpectation++;

//        // Job expectations - another version
//        Select expectationSelect = new Select(driver.findElement(By.id("expectation")));
//        expectationSelect.selectByIndex(1);
//        expectationSelect.selectByIndex(2);

//        // Job expectation - another version with available .get(5) to .get(11)
//        List<WebElement> jobExpectationElements = driver.findElements(By.xpath("//option"));
//        jobExpectationElements.get(6).click();
//        jobExpectationElements.get(8).click();

        // Ways of development - select two from available ones
        WebElement waysOfDevelopment = driver.findElement(By.cssSelector("div.col-sm-10.development-ways"));
        List<WebElement> waysOfDevelopmentElementsList = waysOfDevelopment.findElements(By.xpath(".//input"));
        for (i = 0; i < waysOfDevelopmentElementsList.size(); i++) {
            Assert.assertTrue(waysOfDevelopmentElementsList.get(i).isDisplayed());
            Assert.assertTrue(waysOfDevelopmentElementsList.get(i).isEnabled());
        }
        WebElement waysOfDevelopmentLabel = waysOfDevelopment.findElement(By.xpath("./../label"));
        labelText = waysOfDevelopmentLabel.getText();
        int i1 = iWaysOfDevelopment % waysOfDevelopmentElementsList.size();
        int i2 = (iWaysOfDevelopment + 1) % waysOfDevelopmentElementsList.size();
        List<WebElement> waysOfDevelopmentElementsNames = waysOfDevelopment.findElements(By.xpath(".//label"));
        inputText = waysOfDevelopmentElementsNames.get(i1).getText();
        inputText2 = waysOfDevelopmentElementsNames.get(i2).getText();
        System.out.println(labelText + " : " + inputText + ", " + inputText2);
        waysOfDevelopmentElementsList.get(i1).click();
        waysOfDevelopmentElementsList.get(i2).click();
        iWaysOfDevelopment++;

        // Comment
        WebElement commentElement = driver.findElement(By.id("comment"));
        Assert.assertTrue(commentElement.isDisplayed());
        Assert.assertTrue(commentElement.isEnabled());
        WebElement commentLabel = commentElement.findElement(By.xpath("./../../label"));
        labelText = commentLabel.getText();
        inputText = "This is my first test automate";
        System.out.println(labelText + " : " + inputText);
        commentElement.click();
        commentElement.sendKeys(inputText);

        // Send form
        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(firstNameElement.isDisplayed());
        Assert.assertTrue(firstNameElement.isEnabled());
        submitButton.click();
        // Wait for loading of page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Test check - if confirmation text is visible
        WebElement confirmation = driver.findElement(By.className("submit-msg"));
        Boolean conf = confirmation.isDisplayed();
        if (conf) {
            System.out.println("* * * * * * * * * * * * * * * \n Form was send with success \n* * * * * * * * * * * * * * *");
        }
        Assert.assertTrue(conf);
    }

    private int randomGender(int timesM, int timesF, int timesIB) {
        if (timesM <= timesF && timesM <= timesIB) {
            return 0;
        } else if (timesF <= timesIB) {
            return 1;
        } else {
            return 2;
        }
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }


}
