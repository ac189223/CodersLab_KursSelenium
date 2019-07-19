package com.kurs.selenium.Zadanie10_CleanVersion;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Zadanie10_Gadgets {
    public static WebDriver driver;

    static void openWebPage(String webPageAddress) {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(webPageAddress);
    }

    void searchById_ifDisplayed_thenFillIn(String fieldName, String inputText) {
        WebElement element = driver.findElement(By.id(fieldName));
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

    void searchById_ifDisplayed_thenSubmit(String buttonName) {
        WebElement submitButton = driver.findElement(By.id(buttonName));
        ifDisplayed(submitButton);
        submitButton.click();
        // Wait for loading of page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void searchByClassName_confirmSubmission(String fieldName) {
        WebElement confirmation = driver.findElement(By.className(fieldName));
        Boolean conf = confirmation.isDisplayed();
        if (conf) {
            System.out.println("* * * * * * * * * * * * * * * \n Form was send with success \n* * * * * * * * * * * * * * *");
        }
        Assert.assertTrue(conf);
    }

    void searchParentById_ifDisplayedListItems_chooseFromThem(String parentName, String itemsLocation, int qty, String labelLocation) {
        WebElement element = driver.findElement(By.id(parentName));
        List<WebElement> items = element.findElements(By.xpath(itemsLocation));
        checkIfListDisplayed(items);
        String labelText = getLabelByXpath(element, labelLocation);
        String inputText = selectItemsAndMarkThem(parentName, items, qty);
        printOut(labelText, inputText);
    }

    private String selectItemsAndMarkThem(String parentName, List<WebElement> items, int qty) {
        Select itemsToSelect = new Select(driver.findElement(By.id(parentName)));
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

    private void checkIfListDisplayed(List<WebElement> items) {
        for (WebElement item : items) ifDisplayed(item);
    }

    void searchByName_ifDisplayedListItems_chooseFromThem(String itemsFieldsName, String labelLocation, String itemsLabelsLocation) {
        List<WebElement> items = driver.findElements(By.name(itemsFieldsName));
        checkIfListDisplayed(items);
        int chosenItem = chooseRandomItem(items);
        WebElement genderElement = items.get(chosenItem);
        genderElement.click();
        String labelText = getLabelByXpath(genderElement, labelLocation);
        String inputText = getLabelByXpath(genderElement, itemsLabelsLocation);
        printOut(labelText, inputText);
    }

    void searchParentByCssSelector_ifDisplayedListItems_chooseFromThem(String parentLocation, String itemsLocation, int qty, String labelLocation, String itemsLabelsLocation) {
        WebElement element = driver.findElement(By.cssSelector(parentLocation));
        List<WebElement> items = element.findElements(By.xpath(itemsLocation));
        checkIfListDisplayed(items);



        String inputText = chooseItemsAndMarkThem(items, qty, itemsLabelsLocation);
        String labelText = getLabelByXpath(element, labelLocation);
        printOut(labelText, inputText);
    }

    private void printOut(String labelText, String inputText) {
        System.out.println(labelText + " : " + inputText);
    }

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

    public static void closeWebBrowser() {
        driver.quit();
    }
}
