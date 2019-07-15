package com.kurs.selenium.WikipediaTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikipediaTest4 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
    }

    @Test
    public void WikipediaTest() {

        driver.get("https://pl.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput"));
        if(search.isEnabled()) {
            search.sendKeys("Selenium");
            search.submit();
        }else {
            Assert.fail();
        }
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

}
