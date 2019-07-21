Feature: Aavtrain register new user

  Scenario Outline: User can register in the Aavtrain website

    Given an open browser with https://aavtrain.com/
    When a 'First Time Students Register Here' button is clicked
    Then registration form opens
    When user inputs <firstName>, <lastName>, <emailAddress>, <username>, <address1>, <city>, <state>, <zip>, <password>
    And clicks 'Submit' button
    Then error 'There is an error in the information you provided.' occurs
    And close aavtrain page
    Examples:
      |firstName  |lastName |emailAddress         |username |address1 |city   |state  |zip    |password |
      |John       |Doe      |j.doe@mailinator.com |jdoe     |Dluga 5  |Warsaw |FL     |32003  |qwerty   |
      |John       |Doe      |j.doe@mailinator.com |jdoe     |Dluga 5  |Warsaw |FL     |32003  |qwerty   |