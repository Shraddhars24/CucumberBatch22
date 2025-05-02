Feature: Login related scenarios

  Background:
  #Given user is able to access HRMS application

  @sprint1 @smoke @regression @shrads @Login123
  Scenario: Valid admin login

    When user enters valid username and password
    And user clicks on login button
    Then user is able to see dashboard page

    @error @shrads
  Scenario: InValid admin login
    # Given user is able to access HRMS application
    When user enters invalid username and password
    And user clicks on login button
    Then user can see error message

