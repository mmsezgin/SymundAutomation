@logout
Feature: Log out functionality with Cucumber-MS

  @symu-340
  Scenario: Verify that user should be able to log out-MS
    Given the user logged in
    When the user click user info and click Log out
    Then the user should be able to log out

  @symu-341
  Scenario: Verify that user cannot go back home page after logged out-MS
    Given the user logged in
    And the user navigates to user info at righthand corner and clicks log out
    When the user clicks go back button
    Then the user should not see home page