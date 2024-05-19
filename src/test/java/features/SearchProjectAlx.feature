Feature: Search Project functionality of ALX

  @run
  Scenario: Search Projetc Alx
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And I click on the my Search icon
    Then I write the name of the Pitch project
    And I click on the project Alx
    Then Take Screenshoort