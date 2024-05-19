Feature: Project functionality of ALX

  //@run
  Scenario: Show Projetcs Alx
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And I click on the my Project icon
    Then I Click on the ExpandAll button
    And Display last projects Alx
    Then Take Screenshort