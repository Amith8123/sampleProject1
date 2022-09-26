#Author: GokulNath
Feature: Verify RCB Team

  @Regression @Positive @DemoTest
  Scenario: Verify foreign player in team RCB
    Given The team RCB has submitted its team for an upcoming match
    Then verify the team has only 4 foreign players

  @smoke @Regression @Negative @DemoTest
  Scenario: Verify there is at least one wicket keeper
    Given The team RCB has submitted its team for an upcoming match
    Then verify that there is at least one wicket keeper