#one File one Feature

@feature_login #This tag applies to all scenarios inside this feature.
Feature: Login Feature

  @smoke @login #Put @smoke/@regression group, @login group for each target scenario
  Scenario: Login with valid username and password
    Given User is on Login page
    When User enters username and Password
    And User clicks on Login button
    Then User should be logged in successfully

  @regression @login
  Scenario: Login with invalid username and password
    Given User is on Login page
    When User enters wrong username and Password
    And User clicks on Login button
    Then Error message should be displayed
