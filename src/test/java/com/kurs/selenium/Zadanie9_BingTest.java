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

import java.util.concurrent.TimeUnit;

public class Zadanie9_BingTest {
    private WebDriver driver;

    // This part will go before every normal one
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        // WebBrowser open, maximize it and open page
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.bing.com");
    }

    // This part is a normal one
    @Test
    public void testGoogleSearch() {
        //Find an element with such an id, clean it, write phrase into it and submit
        WebElement element = driver.findElement(By.id("sb_form_q"));
        element.clear();
        element.sendKeys("Mistrzostwa Świata w piłce nożnej 2018");
        element.submit();
        // Wait for loading of page
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        // Test check - amount of found  results
        WebElement numberOfResults = driver.findElement(By.xpath("/html/body/div[@id='b_content']/main/div/span[1]"));
        String numberOfResultsText = numberOfResults.getText();
        Assert.assertEquals("428 000 Results",numberOfResultsText);
    }

    // This part will go after every normal one
    @After
    public void tearDown() throws Exception {
        // Close WebBrowser
        // driver.quit();
    }

}