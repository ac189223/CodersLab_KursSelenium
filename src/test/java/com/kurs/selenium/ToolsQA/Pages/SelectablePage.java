package com.kurs.selenium.ToolsQA.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SelectablePage extends PageObject {
    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    static void selectableSolution(WebDriver driver) {
        WebElement fieldWithItems = driver.findElement(By.cssSelector("ol.ui-selectable"));
        List<WebElement> itemsList = fieldWithItems.findElements(By.className("ui-widget-content"));
        Assert.assertFalse(itemsList.isEmpty());
        WebElement itemToSelect;
        for (int i = 0; i < 10; i++) {
            itemToSelect = getRandomItem(itemsList);
            itemToSelect.click();
            if (i % 3 == 0) clickToUnselect(itemToSelect, driver);
        }
    }

    private static void clickToUnselect(WebElement selectedItem, WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(selectedItem, -20, 10).click().perform();
    }
}
