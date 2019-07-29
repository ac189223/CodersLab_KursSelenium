package com.kurs.selenium.ToolsQA.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SortablePage extends PageObject {
    public SortablePage(WebDriver driver) {
        super(driver);
    }

    static void sortableSolution(WebDriver driver) {
        List<WebElement> sortableItemsList = driver.findElements(By.cssSelector("li.ui-sortable-handle"));
        Assert.assertFalse(sortableItemsList.isEmpty());
        WebElement itemToMove;
        WebElement placeToMove;
        Actions builder = new Actions(driver);
        for (int i = 0; i < 10; i++) {
            itemToMove = getRandomItem(sortableItemsList);
            placeToMove = getRandomItem(sortableItemsList);
            sortItems(itemToMove, placeToMove, builder);
        }
    }

    private static void sortItems(WebElement itemToMove, WebElement placeToMove, Actions builder) {
        builder.clickAndHold(itemToMove).pause(250).moveToElement(placeToMove).pause(250).release().perform();
    }
}
