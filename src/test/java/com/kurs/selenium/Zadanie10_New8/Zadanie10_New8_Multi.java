package com.kurs.selenium.Zadanie10_New8;

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

public class Zadanie10_New8_Multi {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");

    }

    @Test
    public void TestKatalonForm() {

        String inputText = "";
        String inputText2 = "";
        String labelText = "";
        int i;
        int iGender = 0;
        int iRole = 0;
        int iJobExpectation = 0;
        int iWaysOfDevelopment = 0;

        // People creation - thrash version
        Person_Zadanie10[] peopleForTest = createPeopleForTest();

        // Test implementation for people from table
        for (Person_Zadanie10 personForTest : peopleForTest) {

            // Open new website
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

            // First name
            WebElement firstNameElement = driver.findElement(By.id("first-name"));
            Assert.assertTrue(firstNameElement.isDisplayed());
            Assert.assertTrue(firstNameElement.isEnabled());
            WebElement firstNameLabel = firstNameElement.findElement(By.xpath("./../../label"));
            labelText = firstNameLabel.getText();
            inputText = personForTest.getFirstName();
            System.out.println(labelText + " : " + inputText);
            firstNameElement.click();
            firstNameElement.sendKeys(inputText);

            // Last name
            WebElement lastNameElement = driver.findElement(By.id("last-name"));
            Assert.assertTrue(lastNameElement.isDisplayed());
            Assert.assertTrue(lastNameElement.isEnabled());
            WebElement lastNameLabel = lastNameElement.findElement(By.xpath("./../../label"));
            labelText = lastNameLabel.getText();
            inputText = personForTest.getLastName();
            System.out.println(labelText + " : " + inputText);
            lastNameElement.click();
            lastNameElement.sendKeys(inputText);

            // Gender
            List<WebElement> genderElements = driver.findElements(By.name("gender"));
            for (i = 0; i < genderElements.size(); i++) {
                Assert.assertTrue(genderElements.get(i).isDisplayed());
                Assert.assertTrue(genderElements.get(i).isEnabled());
            }
            int iGenderNow = iGender % genderElements.size();
            WebElement genderElement = genderElements.get(iGenderNow);
            WebElement genderElementLabel = genderElement.findElement(By.xpath("./.."));
            inputText = genderElementLabel.getText();
            WebElement genderLabel = genderElement.findElement(By.xpath("./../../../../label"));
            labelText = genderLabel.getText();
            System.out.println(labelText + " : " + inputText);
            genderElements.get(iGenderNow).click();
            iGender++;

            // Date of birth
            WebElement dateOfBirthElement = driver.findElement(By.id("dob"));
            Assert.assertTrue(dateOfBirthElement.isDisplayed());
            Assert.assertTrue(dateOfBirthElement.isEnabled());
            WebElement dateOfBirthLabel = dateOfBirthElement.findElement(By.xpath("./../../label"));
            labelText = dateOfBirthLabel.getText();
            inputText = personForTest.getDateOfBirth();
            System.out.println(labelText + " : " + inputText);
            dateOfBirthElement.click();
            dateOfBirthElement.sendKeys(inputText);

            // Adderss
            WebElement addressElement = driver.findElement(By.id("address"));
            Assert.assertTrue(addressElement.isDisplayed());
            Assert.assertTrue(addressElement.isEnabled());
            WebElement addressLabel = addressElement.findElement(By.xpath("./../../label"));
            labelText = addressLabel.getText();
            inputText = personForTest.getAddress();
            System.out.println(labelText + " : " + inputText);
            addressElement.click();
            addressElement.sendKeys(inputText);

            // Email
            WebElement emailElement = driver.findElement(By.id("email"));
            Assert.assertTrue(emailElement.isDisplayed());
            Assert.assertTrue(emailElement.isEnabled());
            WebElement emailLabel = emailElement.findElement(By.xpath("./../../label"));
            labelText = emailLabel.getText();
            inputText = personForTest.getEmail();
            System.out.println(labelText + " : " + inputText);
            emailElement.click();
            emailElement.sendKeys(inputText);

            // Password
            WebElement passwordElement = driver.findElement(By.id("password"));
            Assert.assertTrue(passwordElement.isDisplayed());
            Assert.assertTrue(passwordElement.isEnabled());
            WebElement passwordLabel = passwordElement.findElement(By.xpath("./../../label"));
            labelText = passwordLabel.getText();
            inputText = personForTest.getPassword();
            System.out.println(labelText + " : " + inputText);
            passwordElement.click();
            passwordElement.sendKeys(inputText);

            // Company
            WebElement companyElement = driver.findElement(By.id("company"));
            Assert.assertTrue(companyElement.isDisplayed());
            Assert.assertTrue(companyElement.isEnabled());
            WebElement companyLabel = companyElement.findElement(By.xpath("./../../label"));
            labelText = companyLabel.getText();
            inputText = personForTest.getCompany();
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
            inputText = personForTest.getComment();
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


    }

    private Person_Zadanie10[] createPeopleForTest() {

        Person_Zadanie10[] peopleForTest = new Person_Zadanie10[9];
        peopleForTest[0] = new Person_Zadanie10("James","Butt","03/03/2003","6649 N Blue Gum St","jbutt@gmail.com","jbu","Benton John B Jr","Test comment for James Butt");
        peopleForTest[1] = new Person_Zadanie10("Josephine","Darakjy","01/01/2001","4 B Blue Ridge Blvd","josephine_darakjy@darakjy.org","jos","Chanay Jeffrey A Esq","Test comment for Josephine Darakjy");
        peopleForTest[2] = new Person_Zadanie10("Art","Venere","05/05/2005","8 W Cerritos Ave 54","art@venere.org","art","Chemel James L Cpa","Test comment for Art Venere");
        peopleForTest[3] = new Person_Zadanie10("Lenna","Paprocki","02/02/2002","639 Main St","lpaprocki@hotmail.com","lpa","Feltz Printing Service","Test comment for Lenna Paprocki");
        peopleForTest[4] = new Person_Zadanie10("Donette","Foller","04/04/2004","34 Center St","donette.foller@cox.net","don","Printing Dimensions","Test comment for Donette Foller");
        peopleForTest[5] = new Person_Zadanie10("Simona","Morasca","06/06/2006","3 Mcauley Dr","simona@morasca.com","sim","Chapman Ross E Esq","Test comment for Simona Morasca");
        peopleForTest[6] = new Person_Zadanie10("Mitsue","Tollner","07/07/2007","7 Eads St","mitsue_tollner@yahoo.com","mit","Morlong Associates","Test comment for Mitsue Tollner");
        peopleForTest[7] = new Person_Zadanie10("Leota","Dilliard","08/08/2008","7 W Jackson Blvd","leota@hotmail.com","leo","Commercial Press","Test comment for Leota Dilliard");
        peopleForTest[8] = new Person_Zadanie10("Sage","Wieser","09/09/2009","5 Boston Ave 88","sage_wieser@cox.net","sag","Truhlar And Truhlar Attys","Test comment for Sage Wieser");
        return peopleForTest;
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }


}
