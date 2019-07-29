package com.kurs.selenium.ToolsQA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizablePage extends PageObject {
    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    static void resizableSolution(WebDriver driver) {
        Actions builder = new Actions(driver);
        WebElement resizableLineRight = driver.findElement(By.cssSelector("div.ui-resizable-e"));
        WebElement resizableLineDown = driver.findElement(By.cssSelector("div.ui-resizable-s"));
        WebElement resizableCorner = driver.findElement(By.cssSelector("div.ui-resizable-se"));
        move(resizableLineRight, 50, 0, builder);
        move(resizableLineDown, 0, 50, builder);
        move(resizableCorner, 50, 50, builder);
        move(resizableLineRight, -50, 0, builder);
        move(resizableLineDown, 0, -50, builder);
        move(resizableCorner, -50, -50, builder);
        move(resizableLineRight, 50, 0, builder);
        move(resizableLineDown, 0, 50, builder);
        move(resizableCorner, 50, 50, builder);
        move(resizableLineRight, 50, 0, builder);
        move(resizableLineDown, 0, 50, builder);
        move(resizableCorner, 50, 50, builder);
    }

    private static void move(WebElement element, int xOffset, int yOffset, Actions builder) {
        builder.clickAndHold(element).moveByOffset(xOffset, yOffset).pause(250).release().perform();
    }

}
