package com.kurs.selenium.ToolsQA;

import com.kurs.selenium.ToolsQA.Pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToolsQATest {

    private WebDriver driver;
    private MainPage mainPage = new MainPage(driver);

    @Before
    public void setUp() {

        // Open the page
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

    }

    @Test
    public void ToolsQA() {
    mainPage.tasksToDo(driver);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }




}
