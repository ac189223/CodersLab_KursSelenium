package com.kurs.selenium.Zadanie10_PageObjectPattern;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Zadanie10_POP_Test {
    private static Zadanie10_POP_Gadgets gadget = new Zadanie10_POP_Gadgets();

    @BeforeClass
    public static void setUp() {
        gadget.openWebPage("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void TestKatalonForm_01_shouldFillInTextFields() {
        gadget.enterFirstName("Jan");
        gadget.enterLastName("Kowalski");
        gadget.enterDateOfBirth("05/22/2010");
        gadget.enterAddress("Prosta 51");
        gadget.enterEmail("jan.kowalski@mailinator.com");
        gadget.enterPassword("Pas123");
        gadget.enterCompany("Coders Lab");
        gadget.enterComment("This is my first test automate");
    }

    @Test
    public void TestKatalonForm_02_shouldSelectOptionsAndCheckboxes() {
        gadget.chooseGender();
        gadget.chooseRole();
        gadget.chooseTwoExpectations();
        gadget.chooseTwoWaysOfDevelopment();
    }

    @Test
    public void TestKatalonForm_03_shouldSubmitForm() {
        gadget.submitForm();
        gadget.confirmSubmission();
   }

    @AfterClass
    public static void tearDown() throws Exception {
        gadget.closeWebBrowser();
    }
}
