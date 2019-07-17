package com.kurs.selenium.SlackMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private WebDriver driver;

    @Before
    public void setUp() {

        // Open the page
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://warteao02.slack.com/messages/CKETQ77A8/");

    }

    @Test
    public void SlackMessageSender() {

        // User creation and check of data
        User user = new User();
        if (user.getName().equals("") || user.getUserName().equals("") || user.getPassword().equals("")) {
            userSetData(user);
        }

        WebElement loginEmailElement = driver.findElement(By.className("btn_filled"));
        if (loginEmailElement != null) {
            // Need to log in
            logIntoSlack(user);
            System.out.println("Need to login");
        }

        //Wait for page to load
        // driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // It must be done as my user is in a hidden mode
        hideAwayPopUp();

        // Checking the name of the user
        if (!controlOfUser(user)) {
            System.out.println("You are not the right user!");
        } else {
            System.out.println("You are the right user!");
            sendMessages();
        }
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    // Setting user data module
    private void userSetData(User user) {
        Scanner typedIn = new Scanner(System.in);
        // Set name if it was empty
        if (user.getName().equals("")) {
            System.out.println("Type in name of the user (as it is on Slack): ");
            String inputName = "";
            while (inputName.equals("")) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                inputName = typedIn.nextLine();
            }
            user.setName(inputName);
        }
        // Set username if it was empty
        if (user.getUserName().equals("")) {
            System.out.println("Type in username (email): ");
            String inputUsername = "";
            while (inputUsername.equals("")) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                inputUsername = typedIn.nextLine();
            }
            user.setUserName(inputUsername);
        }
        // Set password if it was empty
        if (user.getPassword().equals("")) {
            System.out.println("Type in password: ");
            String inputPassword = "";
            while (inputPassword.equals("")) {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                inputPassword = typedIn.nextLine();
            }
            user.setPassword(inputPassword);
        }
    }

    // Log into module
    private void logIntoSlack(User user) {
        // Enter login
        WebElement loginEmailElement = driver.findElement(By.id("email"));
        loginEmailElement.click();
        loginEmailElement.sendKeys(user.getUserName());
        // Enter password
        WebElement loginPasswordlElement = driver.findElement(By.id("password"));
        loginPasswordlElement.click();
        loginPasswordlElement.sendKeys(user.getPassword());

        // Submit
        WebElement loginButton = driver.findElement(By.id("signin_btn"));
        loginButton.submit();
    }

    // Check if we logged in into right account (by displayed name of user)
    private boolean controlOfUser(User user) {
        boolean contr = false;
        WebElement userNameElement = driver.findElement(By.id("team_menu_user_name"));
        contr = (user.getName().equals(userNameElement.getText()));
        return contr;
    }

    // Send message module
    private void sendMessages() {
        // List of all possible people to send it =-_-=
//        List<WebElement> listOfUsersToSend = driver.findElements(By.cssSelector("span.p-channel_sidebar__name span"));
//        for (WebElement user : listOfUsers) {
//            System.out.println(user.getText());
//            WebElement location = driver.findElement(By.cssSelector("div.p-channel_sidebar__static_list"));
//            WebElement userToSend = location.findElement(By.partialLinkText(user.getText()));
//            userToSend.click();
//            WebElement inputField = driver.findElement(By.cssSelector("div.client_toolbar"));
//            WebElement input = inputField.findElement(By.xpath("./div"));
//            input.sendKeys("*****  Auto Test Msg  ***** \n" );
//        }

        // Go to msg page
        WebElement location = driver.findElement(By.cssSelector("div.p-channel_sidebar__static_list"));
        WebElement userToSend = location.findElement(By.partialLinkText("Slackbot"));
        userToSend.click();

        // Go to input field
        WebElement inputField = driver.findElement(By.cssSelector("div.client_toolbar"));
        WebElement input = inputField.findElement(By.xpath("./div"));
        input.sendKeys("*****  Auto Test Msg  ***** \n" );
    }

    // Hide popups module
    private void hideAwayPopUp() {
        WebElement awayPopUp = driver.findElement(By.id("generic_dialog"));
        if (awayPopUp.isDisplayed()) {
            WebElement buttonToHide = awayPopUp.findElement(By.cssSelector("button.dialog_cancel"));
            buttonToHide.click();
        }
    }



}
