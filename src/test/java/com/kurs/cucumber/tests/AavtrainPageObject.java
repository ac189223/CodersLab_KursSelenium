package com.kurs.cucumber.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class AavtrainPageObject {
    protected WebDriver driver;

    void openWebPage(String webPageAddress) {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(webPageAddress);
        PageFactory.initElements(driver,this);
    }

    void closeWebBrowser() { driver.quit(); }

}
