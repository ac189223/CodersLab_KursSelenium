Feature: Google search

  Scenario: user can search any keyword

    Given an open browser with google.com gts_feature

    When a keyword selenium is entered in input field gts_feature

    Then the first one should contain selenium gts_feature

    And close browser gts_feature