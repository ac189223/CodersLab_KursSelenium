Feature: Aavtrain user creation

  Scenario: user can create an account on website

    Given an open browser with http://aavtrain.com/ aca_feature

    When button First Time Students Register Here is clicked aca_feature

    Then form on https://aavtrain.com/create_user.asp opens aca_feature

    And user fills in all required fields aca_feature

    And click Submit button aca_feature

    Then error is displayed aca_feature

    And close web browser aca_feature
