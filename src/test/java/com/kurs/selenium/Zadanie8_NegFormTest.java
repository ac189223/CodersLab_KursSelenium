package com.kurs.selenium;

// Import of needed parts of packages
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Zadanie8_NegFormTest {
    private WebDriver driver;

    // This part will go before every normal one
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        // WebBrowser open, maximize it and open page and wait
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // This part is a normal one
    @Test
    public void testGoogleSearch() {

        // Filling in the form
        //Find an element with an id and write phrase into it
        WebElement element = driver.findElement(By.id("first-name"));
        element.sendKeys("Karol");
        // element = driver.findElement(By.id("last-name"));
        // element.sendKeys("Kowalski");
        element = driver.findElement(By.name("gender"));
        element.click();
        element = driver.findElement(By.id("dob"));
        element.sendKeys("05/22/2010");
        element = driver.findElement(By.id("address"));
        element.sendKeys("Prosta 51");
        element = driver.findElement(By.id("email"));
        element.sendKeys("karol.kowalski@mailinator.com");
        element = driver.findElement(By.id("password"));
        element.sendKeys("Pass123");
        element = driver.findElement(By.id("company"));
        element.sendKeys("Coders Lab");
        // Locate by id and select role from dropdown list
        element = driver.findElement(By.id("role"));
        new Select(element).selectByVisibleText("QA");
        // Locate by xpath and select values
        element = driver.findElement(By.xpath("/html/body/div/div/form/div[10]/div/select/option[4]"));
        element.click();
        element = driver.findElement(By.xpath("/html/body/div/div/form/div[11]/div/div[3]/label/input"));
        element.click();
        element = driver.findElement(By.xpath("/html/body/div/div/form/div[11]/div/div[4]/label/input"));
        element.click();
        // Locate by id and input comment
        element = driver.findElement(By.id("comment"));
        element.sendKeys("To jest mój pierwszy automat testowy");

        // Send form
        element = driver.findElement(By.id("submit"));
        element.click();
        // Wait for loading of page
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        // Test check - if alert text at last-name is visible
        WebElement errorConf = driver.findElement(By.id("last-name-error"));
        String errorConfText = errorConf.getText();
        Assert.assertEquals("This field is required.",errorConfText);

        // Test check - if confirmation text is invisible
        WebElement confirmation = driver.findElement(By.className("submit-msg"));
        Boolean conf = confirmation.isDisplayed();
        System.out.println(conf);
        Assert.assertTrue(!conf);
    }

    // This part will go after every normal one
    @After
    public void tearDown() throws Exception {
        // Close WebBrowser
        // driver.quit();
    }

}
