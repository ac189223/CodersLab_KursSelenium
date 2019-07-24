package com.kurs.selenium.SauceDemoLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickClearSend(WebElement element, String inputText) {
        element.click();
        element.clear();
        element.sendKeys(inputText);
    }
}
