Feature: Sandboxes functionality of ALX

  @run
  Scenario: Sandboxes Projetc Alx
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And I click on the my Sandboxes icon
    Then I click on the runing only Sandboxes
    And Open Sandboxe