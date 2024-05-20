Feature: Curriculums functionality of ALX

  @run
  Scenario: Show Curriculums Alx
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And I click on the my Curriculums icon
    And Click on the Show transcript
    Then Click on the Show Overview
    And I Take screenshort Overview
    Then Click on the leave Overview