@login
Feature: Login functionality-MS

  Background:
    Given the user is on login page

  @symu-419
  Scenario: Verify that user should be able to login with valid credentials
    When the user enters valid credentials
    And the user click Login button
    Then the user should be able to login
    And username should be seen under Profile icon

  @symu-420
  Scenario: Verify that user should be able to login by pressing "Enter" key
    When the user enters valid credentials
    And the user presses Enter key
    Then the user should be able to login
    And username should be seen under Profile icon

  @symu-421
  Scenario Outline: Verify that user can not login with invalid credentials <username> and <password>
    When the user enters "<username>" and "<password>"
    And the user click Login button
    Then "Wrong username or password." error message should be seen
    And the user should not be able to login

    Examples:
      | username    |  | password    |
      | wrong       |  | wrong       |
      | Employee81 |  | password    |
      | username    |  | Employee123 |
      | Employee81 |  | employee123 |
      | employee81 |  | Employee123 |
      | EMPLOYEE81 |  | Employee123 |

  @symu-422
  Scenario Outline: Verify that user should see Error message when a credential is left blank
    When the user left "<type>" as blank
    And the user click Login button
    Then Please fill in this field message for "<type>" should be seen
    And the user should not be able to login

    Examples:
      | type     |
      | username |
      | password |

  @symu-423
  Scenario: Verify that user can see the password in a form of dots
    When the user enters valid credentials
    Then the user can see password in a form of dots by default

  @symu-424
  Scenario: Verify that user should be able to see password explicitly
    When the user enters valid credentials
    And the user click "Eye Icon"
    Then the user should be able to see password explicitly

  @symu-425
  Scenario: Verify that user can see "forgot password" on the login page
    Then the link "Forgot password?" should be displayed on the login page

  @symu-426
  Scenario: Verify that user should be able to see "Reset password" button
    When the user click "Forgot password?"
    Then Reset password button should be seen

  @symu-427
  Scenario Outline: Verify that user can see valid placeholders on Username and Password fields
    Then the user should be able to see "<text>" for "<type>" field

    Examples:
      | type     |  | text              |
      | Username |  | Username or email |
      | Password |  | Password          |



