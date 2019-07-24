package com.kurs.selenium.SauceDemoLogin;

import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void TestLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.submit();
    }
}
