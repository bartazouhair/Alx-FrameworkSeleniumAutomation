Feature: Planning functionality of ALX

  @run
  Scenario: Show Planning Alx
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And I click on the My Planning icon
    Then I click on the Day button to see the projects for the day
    And I click on the Zoom button to enlarge the planning view 