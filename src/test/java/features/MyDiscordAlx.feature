Feature: Discord functionality of ALX

  @run
  Scenario: Show Discord Alx
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And I click on the My Discord icon
    Then I do login
    Then I Take a screenshort
