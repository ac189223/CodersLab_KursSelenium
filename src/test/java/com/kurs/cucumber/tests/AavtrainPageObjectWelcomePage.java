package com.kurs.cucumber.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AavtrainPageObjectWelcomePage extends AavtrainPageObject {

    void registrationButtonClick() {
        // Find user creation button
        WebElement element = (driver.findElement(By.cssSelector("div.bodytxt")).findElement(By.xpath(".//a")));
        // Click this button
        element.click();
        // Wait for loading (max 10sek)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    void confirmWebAddress(String webPageAddress) {
        // Check if current url is an expected one
        Assert.assertEquals(webPageAddress, driver.getCurrentUrl());
        closeWebBrowser();
    }

}
