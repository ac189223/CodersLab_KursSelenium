package com.kurs.selenium.ToolsQA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void tasksToDo(WebDriver driver) {
        List<WebElement> tasksToDoList = driver.findElements(By.cssSelector("aside.widget ul li a"));
        System.out.println("\n" + tasksToDoList.size() + " elements to do");
        System.out.println("==========================================");
        String taskName;

        String[] tasksToDoArray = new String[tasksToDoList.size()];
        int i = 0;
        for (WebElement taskToDo : tasksToDoList) {
            taskName = taskToDo.getText();
            System.out.println(taskName);
            tasksToDoArray[i] = taskName;
            i++;
        }

        // Selection of an element to do
        for (int j = 0; j < tasksToDoArray.length; j++) {
            WebElement fieldWithListOfElementsToDo = driver.findElement(By.id("sidebar"));
            String nameOfAnElementToDo = tasksToDoArray[j];
            WebElement linkToAnElementToDo = fieldWithListOfElementsToDo.findElement(By.linkText(nameOfAnElementToDo));
            linkToAnElementToDo.click();
            solution(j, driver);
        }
//        for (int j = 1; j < 3; j++) {
//            driver.get("https://demoqa.com/");
//            WebElement fieldWithTasks = driver.findElement(By.cssSelector("div.widget-area"));
//            String taskName = tasksToDoArray[j];
//            WebElement taskLink = fieldWithTasks.findElement(By.linkText(taskName));
//            taskLink.click();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            resizableSolution(j, driver);
//        }
    }

    private void solution(int i, WebDriver driver) {
        if (i == 0) { SortablePage.sortableSolution(driver); }
//        else if (i == 1) { SelectablePage.selectableSolution(driver); }
//        else if (i == 2) { ResizablePage.resizableSolution(driver); }
//        else if (i == 3) { DroppablePage.droppableSolution(driver); }
//        else if (i == 4) { DraggablePage.draggableSolution(driver); }
//        else if (i == 5) { SolutionKeyboardEventsSampleFormPage.SKESFSolution(driver); }
        else if (i == 6) { TooltipAndDoubleClickPage.TADCSolution(driver); }
        else if (i == 7) { solutionTooltip(); }
        else if (i == 8) { solutionTabs(); }
        else if (i == 9) { solutionSpinner(); }
        else if (i == 10) { solutionSlider(); }
        else if (i == 11) { solutionSelectmenu(); }
        else if (i == 12) { solutionProgressbar(); }
        else if (i == 13) { solutionMenu(); }
        else if (i == 14) { solutionDialog(); }
        else if (i == 15) { solutionDatepicker(); }
        else if (i == 16) { solutionControlgroup(); }
        else if (i == 17) { solutionCheckboxradio(); }
        else if (i == 18) { solutionButton(); }
        else if (i == 19) { solutionAutocomplete(); }
        else { solutionAccordion(); }
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



}
