Feature: Login functionality of ALX intranet site

  //@run
  Scenario: Successful login
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And Take a screenshort dashboard
