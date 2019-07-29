package com.kurs.selenium.ToolsQA.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SolutionKeyboardEventsSampleFormPage extends PageObject{

    SolutionKeyboardEventsSampleFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    private static WebElement userNameElement;

    @FindBy(id = "currentAddress")
    private static WebElement currentAddressElement;

    @FindBy(id = "permanentAddress")
    private static WebElement permanentAddressElement;

    @FindBy(id = "submit")
    private static WebElement submitButton;

    static void SKESFSolution(WebDriver driver) {
        enterUserName("John Butt",800, 470);
        enterCurrentAddress("6649 N Blue Gum St,New Orleans,LA,70116",800, 670);
        enterPermanentAddress("8 W Cerritos Ave 54,Bridgeport,NJ,8014",800, 1270);
        resizeCurrentAddressField(965,670, 200);
        resizeField(965,1270, 200);
        resizePermanentAddressField(965,545, 200);
        submitForm(600, 630);
        closePopUp(815, 405);
    }

    private static void enterUserName(String inputText, int argX, int argY) {
        enterTextWithRobot(inputText,argX, argY);
    }

    private static void enterCurrentAddress(String inputText, int argX, int argY) {
        enterTextWithRobot(inputText,argX, argY);
    }

    private static void enterPermanentAddress(String inputText, int argX, int argY) {
        enterTextWithRobot(inputText,argX, argY);
    }

    private static void resizeCurrentAddressField(int argX, int argY, int move) {
        resizeField(argX, argY, move);
    }

    private static void resizePermanentAddressField(int argX, int argY, int move) {
        resizeField(argX, argY, move);
    }

    private static Robot robot = null;
    private static void enterTextWithRobot(String inputText, int argX, int argY) {
        try {
            robot = new Robot();
            initiateField(robot, argX, argY);
            String inputTextCaps = inputText.toUpperCase();
            char[] chars = inputText.toCharArray();
            char[] charsCaps = inputTextCaps.toCharArray();
            for (int i = 0; i < charsCaps.length; i++) {
                if (chars[i] == charsCaps[i] && isLetter(chars[i])) { robot.keyPress(KeyEvent.VK_SHIFT); }
                robot.keyPress(charsCaps[i]);
                robot.keyRelease(charsCaps[i]);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void initiateField(Robot robot, int argX, int argY) {
        robot.mouseMove(argX, argY);
        robot.delay(1000);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static void resizeField(int argX, int argY, int move) {
        try {
            robot = new Robot();
            initiateField(robot, argX - 100, argY);
            robot.mouseMove(argX, argY);
            robot.delay(1000);
            robot.mousePress(MouseEvent.BUTTON1_MASK);
            robot.mouseMove(argX, argY + move);
            robot.delay(1000);
            robot.mouseMove(argX, argY);
            robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void submitForm(int argX, int argY) {
        try {
            robot = new Robot();
            robot.delay(1000);
            initiateField(robot, argX, argY);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static void closePopUp(int argX, int argY) {
        try {
            robot = new Robot();
            robot.delay(1000);
            initiateField(robot, argX, argY);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
