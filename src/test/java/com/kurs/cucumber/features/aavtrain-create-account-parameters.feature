Feature: Aavtrain user creation

  Scenario Outline: user can create an account on website

    Given an open browser with http://aavtrain.com/ acap_feature

    When button First Time Students Register Here is clicked acap_feature

    Then form on https://aavtrain.com/create_user.asp opens acap_feature

    And user fills in required fields: first name <firstName>, last name <lastName>, email <email>, user name <userName>, address <address>, city <city>, state <state>, zip code <zipCode>, password <password>  acap_feature

    And click Submit button acap_feature

    Then error is displayed acap_feature

    And close web browser acap_feature

    Examples:
      |firstName |lastName |email                        |userName |address             |city        |state |zipCode |password  |
      |James     |Butt     |jbutt@gmail.com              |jambut   |6649 N Blue Gum St  |New Orleans |LA    |70116   |jambut123 |
      |Josephine |Darakjy  |josephine_darakjy@darakjy.org|josdar   |4 B Blue Ridge Blvd	|Brighton    |MI	|48116	 |josdar123 |
      |Art       |Venere   |art@venere.org               |artven   |8 W Cerritos Ave 54 |Bridgeport  |NJ    |8014    |artven123 |