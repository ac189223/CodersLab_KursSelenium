package com.kurs.cucumber.tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class GoogleSearchRegularExp {
    private WebDriver driver;

    @Given("^an open browser with google\\.com gtsre_feature$")
    public void anOpenBrowserWithGoogleCom() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        // Uruchom nowy egzemplarz przeglądarki
        driver = new FirefoxDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("http://www.google.com");
    }

    @When("a keyword (.*) is entered in input field gtsre_feature")
    public void aKeywordSeleniumIsEnteredInInputField(String keyword) {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();
        // Zaczekaj
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("the first one should contain (.*) gtsre_feature")
    public void theFirstOneShouldContainSelenium(String expectedText) {
        WebElement element = (driver.findElement(By.cssSelector("div.r")).findElement(By.xpath(".//h3")));
        Assert.assertTrue(element.getText().toLowerCase().contains(expectedText));
    }

        @And("^close browser gtsre_feature$")
    public void closeBrowser() {
        driver.quit();
    }
}
