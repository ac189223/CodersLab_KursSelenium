package com.kurs.cucumber.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AavtrainPageObjectWelcomePage extends AavtrainPageObject {

    WebElement registrationButton(WebDriver driver) {
        // Find user creation button
        WebElement element = (driver.findElement(By.cssSelector("div.bodytxt")).findElement(By.xpath(".//a")));
        // Click this button
        return element;
    }

    void wait(WebDriver driver) {
        // Wait for loading (max 10sek)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    void confirmWebAddress(String webPageAddress, WebDriver driver) {
        // Check if current url is an expected one
        Assert.assertEquals(webPageAddress, driver.getCurrentUrl());
    }
}
