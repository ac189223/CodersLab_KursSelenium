Feature: Google search

  Scenario: user can search any keyword

    Given an open browser with google.com gtsre_feature

    When a keyword selenium is entered in input field gtsre_feature

    Then the first one should contain selenium gtsre_feature

    And close browser gtsre_feature