package com.kurs.selenium.ToolsQA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class TooltipAndDoubleClickPage extends PageObject {
    TooltipAndDoubleClickPage(WebDriver driver) {
        super(driver);
    }

    static void TADCSolution(WebDriver driver) {
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions builder = new Actions(driver);
        builder.doubleClick(doubleClickButton).build().perform();
        closePopUpWithRobot(950,410);

        rightClickWithRobot(800,530);
        List<WebElement> contextMenu = driver.findElements(By.cssSelector("div.contextMenuItem"));
        getRandomItem(contextMenu).click();
        closePopUpWithRobot(800,410);

        moveToTooltipElementWithRobot(800,630);
    }

    private static Robot robot = null;

    private static void closePopUpWithRobot(int argX, int argY) {
        try {
            robot = new Robot();
            robot.mouseMove(argX, argY);
            robot.delay(1000);
            robot.mousePress(MouseEvent.BUTTON1_MASK);
            robot.mouseRelease(MouseEvent.BUTTON1_MASK);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void rightClickWithRobot(int argX, int argY) {
        try {
            robot = new Robot();
            robot.mouseMove(argX, argY);
            robot.delay(1000);
            robot.mousePress(MouseEvent.BUTTON3_MASK);
            robot.mouseRelease(MouseEvent.BUTTON3_MASK);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void moveToTooltipElementWithRobot(int argX, int argY) {
        try {
            robot = new Robot();
            robot.mouseMove(argX, argY);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static WebElement getRandomItem(List<WebElement> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

}
