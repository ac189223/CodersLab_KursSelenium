Feature: Aavtrain user creation

  Scenario: user can create an account on website

    Given an open browser with http://aavtrain.com/ acapop_feature

    When button First Time Students Register Here is clicked acapop_feature

    Then form on https://aavtrain.com/create_user.asp opens acapop_feature

    And user fills in all required fields acapop_feature

    And click Submit button acapop_feature

    Then error is displayed acapop_feature

    And close web browser acapop_feature
