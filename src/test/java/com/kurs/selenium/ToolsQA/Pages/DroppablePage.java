package com.kurs.selenium.ToolsQA.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppablePage extends PageObject {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    static void droppableSolution(WebDriver driver) {
        WebElement draggableItem = driver.findElement(By.id("draggable"));
        WebElement droppableItem = driver.findElement(By.id("droppable"));
        Assert.assertTrue(draggableItem.isDisplayed());
        Assert.assertTrue(droppableItem.isDisplayed());
        Actions builder = new Actions(driver);
        builder.clickAndHold(draggableItem).pause(250).moveToElement(droppableItem).pause(250).release().perform();
    }
}
