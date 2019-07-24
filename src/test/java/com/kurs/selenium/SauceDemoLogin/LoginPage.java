package com.kurs.selenium.SauceDemoLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        // super wywołuje konstruktora klasy nadrzędnej (superklasa)
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement userNameElement;

    @FindBy(id = "password")
    WebElement passwordElement;

    @FindBy(className = "btn_action")
    WebElement loginButton;

    public void enterName(String name) {
        //userNameElement.sendKeys(name);
        clickClearSend(userNameElement, name);
    }

    public void enterPassword(String password) {
        //passwordElement.sendKeys(password);
        clickClearSend(passwordElement, password);
    }

    public void submit() {
        loginButton.click();
    }
}
