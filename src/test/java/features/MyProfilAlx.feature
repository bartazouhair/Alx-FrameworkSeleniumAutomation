Feature: Profil functionality of ALX

  @run
  Scenario: Show Profil Alx
    Given I am on the ALX login page
    When I enter valid credentials
    And I click on the sign in button
    Then I should be redirected to the dashboard
    And I click on the my Profil icon
    Then I Change my picture
    Then Click on the Save Information button
    And Display the message: Your profile was successfully updated