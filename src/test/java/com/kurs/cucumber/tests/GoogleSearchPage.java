package com.kurs.cucumber.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GoogleSearchPage {
    public static WebDriver driver;

    void openWebPage(String webPageAddress) {
        // Set drivers for browser
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        // Open new browser
        driver = new FirefoxDriver();
        // Delete cookies
        driver.manage().deleteAllCookies();
        // Maximize window
        driver.manage().window().maximize();
        // Open Google page
        driver.get(webPageAddress);
        // Init getting elements from page
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "q")
    private WebElement inputStringToSearchElement;

    void enterStringToSearch(String stringToSearch) {
        // Clear
        this.inputStringToSearchElement.clear();
        // Enter string
        this.inputStringToSearchElement.sendKeys(stringToSearch);
        // Send form
        this.inputStringToSearchElement.submit();
        // Wait for loading
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    void checkIfSearchResulstContains(String searchedString) {
        // Choose first element from results
        WebElement element = (driver.findElement(By.cssSelector("div.r")).findElement(By.xpath(".//h3")));
        // Check it
        Assert.assertTrue(element.getText().toLowerCase().contains(searchedString));
    }

    void closeWebBrowser() { driver.quit(); }
}
