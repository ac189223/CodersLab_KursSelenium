package com.kurs.selenium.ToolsQA.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggablePage extends PageObject {
    public DraggablePage(WebDriver driver) {
        super(driver);
    }

    static void draggableSolution(WebDriver driver) {
        WebElement draggableItem = driver.findElement(By.id("draggable"));
        Assert.assertTrue(draggableItem.isDisplayed());
        Actions builder = new Actions(driver);
        move(draggableItem, 250, 30, builder);
        move(draggableItem, -50, 50, builder);
        move(draggableItem, 50, 50, builder);
        move(draggableItem, 150, -100, builder);
        move(draggableItem, -100, -50, builder);
        move(draggableItem, 50, 150, builder);
        move(draggableItem, 50, 30, builder);
        move(draggableItem, -200, -50, builder);
        move(draggableItem, 150, -50, builder);
        move(draggableItem, 50, 50, builder);
    }

    private static void move(WebElement element, int xOffset, int yOffset, Actions builder) {
        builder.clickAndHold(element).moveByOffset(xOffset, yOffset).pause(250).release().perform();
    }

}
