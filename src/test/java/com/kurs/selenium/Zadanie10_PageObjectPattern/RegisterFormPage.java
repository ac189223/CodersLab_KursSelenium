package com.kurs.selenium.Zadanie10_PageObjectPattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterFormPage {
    public static WebDriver driver;

    void openWebPage(String webPageAddress) {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(webPageAddress);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameElement;

    @FindBy(id = "last-name")
    private WebElement lastNameElement;

    @FindBy(id = "dob")
    private WebElement dateOfBirthElement;

    @FindBy(id = "address")
    private WebElement addressElement;

    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "company")
    private WebElement companyElement;

    @FindBy(id = "comment")
    private WebElement commentElement;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(className = "submit-msg")
    private WebElement confirmation;

    @FindBy(name = "gender")
    private List<WebElement> genderList;

    @FindBy(className = "development-ways")
    private WebElement parentElementForWaysOfDevelopment;

    @FindBy(id = "role")
    private WebElement parentElementForRoleElements;

    @FindBy(id = "expectation")
    private WebElement parentElementForExpectationsElements;

    void enterFirstName(String firstName) { ifDisplayed_thenFillIn(this.firstNameElement, firstName); }

    void enterLastName(String lastName) {
        ifDisplayed_thenFillIn(this.lastNameElement, lastName);
    }

    void enterDateOfBirth(String dateOfBirth) {
        ifDisplayed_thenFillIn(this.dateOfBirthElement, dateOfBirth);
    }

    void enterAddress(String address) {
        ifDisplayed_thenFillIn(this.addressElement, address);
    }

    void enterEmail(String email) { ifDisplayed_thenFillIn(this.emailElement, email); }

    void enterPassword(String password) { ifDisplayed_thenFillIn(this.passwordElement, password); }

    void enterCompany(String company) { ifDisplayed_thenFillIn(this.companyElement, company); }

    void enterComment(String comment) { ifDisplayed_thenFillIn(this.commentElement, comment); }

    void chooseRole() {
        chooseFromTheList(this.parentElementForRoleElements,1);
    }

    void chooseTwoExpectations() { chooseFromTheList(this.parentElementForExpectationsElements,2); }

    private void ifDisplayed_thenFillIn(WebElement element, String inputText) {
        ifDisplayed(element);
        element.click();
        element.clear();
        element.sendKeys(inputText);
        printFieldAndValue(element, inputText);
    }

    private void ifDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
        Assert.assertTrue(element.isEnabled());
    }

    private void printFieldAndValue(WebElement element, String inputText) {
        String labelText = getLabelByXpath(element, "./../../label");
        printOut(labelText, inputText);
    }

    void submitForm() {
        ifDisplayed(this.submitButton);
        this.submitButton.click();
        // Wait for loading of page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void confirmSubmission() {
        Boolean conf = this.confirmation.isDisplayed();
        if (conf) {
            System.out.println("* * * * * * * * * * * * * * * \n Form was send with success \n* * * * * * * * * * * * * * *");
        }
        Assert.assertTrue(conf);
    }

    private void chooseFromTheList(WebElement element, int qty) {
        List<WebElement> items = element.findElements(By.xpath("./option"));
        checkIfListDisplayed(items);
        String labelText = getLabelByXpath(element, "./../../label");
        String inputText = selectItemsAndMarkThem(element, items, qty);
        printOut(labelText, inputText);
    }

    private String selectItemsAndMarkThem(WebElement element, List<WebElement> items, int qty) {
        Select itemsToSelect = new Select(driver.findElement(By.id(element.getAttribute("id"))));
        String inputText = "";
        for (int i = 0; i < qty; i++) {
            int chosenItem = chooseRandomItem(items);
            itemsToSelect.selectByIndex(chosenItem);
            inputText += items.get(chosenItem).getText();
            if (i < qty-1) {
                inputText += ", ";
            }
        }
        return inputText;
    }

    private int chooseRandomItem(List<WebElement> items) {
        int chosenItem = new Random().nextInt(items.size());
        while (items.get(chosenItem).isSelected()) {
            chosenItem = new Random().nextInt(items.size());
        }
        return chosenItem;
    }

    private String getLabelByXpath(WebElement element, String labelLocation) {
        WebElement label = element.findElement(By.xpath(labelLocation));
        return label.getText();
    }

    private void checkIfListDisplayed(List<WebElement> items) { for (WebElement item : items) ifDisplayed(item); }

    void chooseGender() {
        checkIfListDisplayed(this.genderList);
        int chosenItem = chooseRandomItem(this.genderList);
        WebElement genderElement = this.genderList.get(chosenItem);
        genderElement.click();
        String labelText = getLabelByXpath(genderElement, "./../../../../label");
        String inputText = getLabelByXpath(genderElement, "./..");
        printOut(labelText, inputText);
    }

    void chooseTwoWaysOfDevelopment() {
        List<WebElement> items = this.parentElementForWaysOfDevelopment.findElements(By.xpath(".//input"));
        checkIfListDisplayed(items);
        String inputText = chooseItemsAndMarkThem(items, 2, "./..");
        String labelText = getLabelByXpath(this.parentElementForWaysOfDevelopment, "./../label");
        printOut(labelText, inputText);
    }

    private void printOut(String labelText, String inputText) { System.out.println(labelText + " : " + inputText); }

    private String chooseItemsAndMarkThem(List<WebElement> items, int qty, String itemsLabelsLocation) {
        String inputText = "";
        for (int i = 0; i < qty; i++) {
            int chosenItem = chooseRandomItem(items);
            WebElement element = items.get(chosenItem);
            element.click();
            inputText += getLabelByXpath(element, itemsLabelsLocation);
            if (i < qty-1) {
                inputText += ", ";
            }
        }
        return inputText;
    }

    void closeWebBrowser() { driver.quit(); }
}