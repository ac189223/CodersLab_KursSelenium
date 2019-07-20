Feature: Aavtrain user creation

  Scenario: user can create an account on website

    Given an open browser with http://aavtrain.com/

    When button First Time Students Register Here is clicked

    Then form on https://aavtrain.com/create_user.asp opens

    When user fills in all required fields

    Then click Submit button

    When error is displayed

    Then close web browser
