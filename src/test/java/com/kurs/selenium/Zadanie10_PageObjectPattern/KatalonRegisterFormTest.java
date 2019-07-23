package com.kurs.selenium.Zadanie10_PageObjectPattern;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KatalonRegisterFormTest {
    private static RegisterFormPage registerFormPage = new RegisterFormPage();

    @BeforeClass
    public static void setUp() {
        registerFormPage.openWebPage("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void KatalonRegisterFormTest_01_shouldFillInTextFields() {
        registerFormPage.enterFirstName("Jan");
        registerFormPage.enterLastName("Kowalski");
        registerFormPage.enterDateOfBirth("05/22/2010");
        registerFormPage.enterAddress("Prosta 51");
        registerFormPage.enterEmail("jan.kowalski@mailinator.com");
        registerFormPage.enterPassword("Pas123");
        registerFormPage.enterCompany("Coders Lab");
        registerFormPage.enterComment("This is my first test automate");
    }

    @Test
    public void KatalonRegisterFormTest_02_shouldSelectOptionsAndCheckboxes() {
        registerFormPage.chooseGender();
        registerFormPage.chooseRole();
        registerFormPage.chooseTwoExpectations();
        registerFormPage.chooseTwoWaysOfDevelopment();
    }

    @Test
    public void KatalonRegisterFormTest_03_shouldSubmitForm() {
        registerFormPage.submitForm();
        registerFormPage.confirmSubmission();
   }

    @AfterClass
    public static void tearDown() throws Exception {
        registerFormPage.closeWebBrowser();
    }
}
