package com.kurs.selenium.ToolsQA;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main_ToolsQA {

    private WebDriver driver;

    @Before
    public void setUp() {

        // Open the page
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

    }

    @Test
    public void ToolsQA() {

        // List of elements to do
        List<WebElement> listOfElementsToDo = driver.findElements(By.cssSelector("aside.widget ul li a"));
        System.out.println(listOfElementsToDo.size() + " elements to do: ");
        String[] elementsToDoArray = new String[listOfElementsToDo.size()];
        int i = 0;
        for (WebElement elementToDo : listOfElementsToDo) {
            elementsToDoArray[i] = elementToDo.getText();
            System.out.println(elementsToDoArray[i]);
            i++;
        }

        // Selection of an element to do
//        for (int j = 0; j < elementsToDoArray.length; j++) {
//            driver.get("https://demoqa.com/");
//            WebElement fieldWithListOfElementsToDo = driver.findElement(By.cssSelector("div.widget-area"));
//            String nameOfAnElementToDo = elementsToDoArray[j];
//            WebElement linkToAnElementToDo = fieldWithListOfElementsToDo.findElement(By.linkText(nameOfAnElementToDo));
//            linkToAnElementToDo.click();
//            solution(i);
//        }
        for (int j = 1; j < 2; j++) {
            driver.get("https://demoqa.com/");
            WebElement fieldWithListOfElementsToDo = driver.findElement(By.cssSelector("div.widget-area"));
            String nameOfAnElementToDo = elementsToDoArray[j];
            WebElement linkToAnElementToDo = fieldWithListOfElementsToDo.findElement(By.linkText(nameOfAnElementToDo));
            linkToAnElementToDo.click();
            solution(j);
        }

    }

    private void solution(int i) {
        switch (i) {
            case 0:
                solutionSortable();
            case 1:
                solutionSelectable();
            case 2:
                solutionResizable();
            case 3:
                solutionDroppable();
            case 4:
                solutionDraggable();
            case 5:
                solutionKeyboardEventsSampleForm();
            case 6:
                solutionTooltipAndDoubleClick();
            case 7:
                solutionTooltip();
            case 8:
                solutionTabs();
            case 9:
                solutionSpinner();
            case 10:
                solutionSlider();
            case 11:
                solutionSelectmenu();
            case 12:
                solutionProgressbar();
            case 13:
                solutionMenu();
            case 14:
                solutionDialog();
            case 15:
                solutionDatepicker();
            case 16:
                solutionControlgroup();
            case 17:
                solutionCheckboxradio();
            case 18:
                solutionButton();
            case 19:
                solutionAutocomplete();
            case 20:
                solutionAccordion();
        }
    }

    private void solutionSortable() {
    }

    private void solutionSelectable() {
        WebElement fieldWithSelectableItems = driver.findElement(By.cssSelector("ol.ui-selectable"));
        List<WebElement> listOfSelectableItems = fieldWithSelectableItems.findElements(By.className("ui-widget-content"));
        System.out.println(listOfSelectableItems.isEmpty());
        String[] itemsToSelectArray = new String[listOfSelectableItems.size()];
        int i = 0;
        for (WebElement elementToDo : listOfSelectableItems) {
            itemsToSelectArray[i] = elementToDo.getText();
            System.out.println(itemsToSelectArray[i]);
            i++;
        }
        i = 0;
        while (i < 15) {
            WebElement itemToSelect = getRandomItem(listOfSelectableItems);
            itemToSelect.click();
//            if (i % 3 == 0) {
//                Actions moveMouseToItem = new Actions(driver).click(itemToSelect);
//                moveMouseToItem.build().perform();
//            }

            i++;
        }
    }

    private WebElement getRandomItem(List<WebElement> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private void solutionResizable() {
        WebElement resizableField = driver.findElement(By.id("resizable"));
        resizableField.getRect().setWidth(resizableField.getRect().getWidth() + 100);
        resizableField.getRect().setWidth(resizableField.getRect().getWidth() - 100);
        resizableField.getRect().setWidth(resizableField.getRect().getWidth() + 200);
        resizableField.getRect().setWidth(resizableField.getRect().getWidth() + 150);
        resizableField.getRect().setHeight(resizableField.getRect().getHeight() + 100);
        resizableField.getRect().setHeight(resizableField.getRect().getHeight() - 100);
        resizableField.getRect().setHeight(resizableField.getRect().getHeight() + 200);
        resizableField.getRect().setHeight(resizableField.getRect().getHeight() + 150);
        System.out.println(resizableField.getRect().getWidth());

//        WebElement resizableFieldRight = resizableField.findElement(By.cssSelector("div.ui-resizable-e"));
//        System.out.println(resizableFieldRight.getLocation());

    }

    private void solutionDroppable() {
    }

    private void solutionDraggable() {
    }

    private void solutionKeyboardEventsSampleForm() {
    }

    private void solutionTooltipAndDoubleClick() {
    }

    private void solutionTooltip() {
    }

    private void solutionTabs() {
    }

    private void solutionSpinner() {
    }

    private void solutionSlider() {
    }

    private void solutionSelectmenu() {
    }

    private void solutionProgressbar() {
    }

    private void solutionMenu() {
    }

    private void solutionDialog() {
    }

    private void solutionDatepicker() {
    }

    private void solutionControlgroup() {
    }

    private void solutionCheckboxradio() {
    }

    private void solutionButton() {
    }

    private void solutionAutocomplete() {
    }

    private void solutionAccordion() {
    }


    @After
    public void tearDown() {
        //driver.quit();
    }




}
