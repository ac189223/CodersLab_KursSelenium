package com.kurs.selenium.Zadanie10_CleanVersion;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Zadanie10_Test {
    private Zadanie10_Gadgets gadget = new Zadanie10_Gadgets();

    @BeforeClass
    public static void setUp() {
        Zadanie10_Gadgets.openWebPage("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void TestKatalonForm_01_shouldFillInTextFields() {
        gadget.searchById_ifDisplayed_thenFillIn("first-name", "Jan");
        gadget.searchById_ifDisplayed_thenFillIn("last-name", "Kowalski");
        gadget.searchById_ifDisplayed_thenFillIn("dob", "05/22/2010");
        gadget.searchById_ifDisplayed_thenFillIn("address", "Prosta 51");
        gadget.searchById_ifDisplayed_thenFillIn("email", "jan.kowalski@mailinator.com");
        gadget.searchById_ifDisplayed_thenFillIn("password", "Pas123");
        gadget.searchById_ifDisplayed_thenFillIn("company", "Coders Lab");
        gadget.searchById_ifDisplayed_thenFillIn("comment", "This is my first test automate");
    }

    @Test
    public void TestKatalonForm_02_shouldSelectOptionsAndCheckboxes() {
        gadget.searchByName_ifDisplayedListItems_chooseFromThem("gender", "./../../../../label", "./..");
        gadget.searchParentById_ifDisplayedListItems_chooseFromThem("role", "./option", 1, "./../../label");
        gadget.searchParentById_ifDisplayedListItems_chooseFromThem("expectation", "./option", 2, "./../../label");
        gadget.searchParentByCssSelector_ifDisplayedListItems_chooseFromThem("div.col-sm-10.development-ways", ".//input", 2, "./../label", "./..");
    }

    @Test
    public void TestKatalonForm_03_shouldSubmitForm() {
        gadget.searchById_ifDisplayed_thenSubmit("submit");
        gadget.searchByClassName_confirmSubmission("submit-msg");
   }

    @AfterClass
    public static void tearDown() throws Exception {
        //Zadanie10_Gadgets.closeWebBrowserP();
    }
}
