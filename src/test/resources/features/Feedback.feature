@RegressionTests
Feature: Feedback

  Scenario: Test Case 1 - Check error messages when submitting an empty feedback form
    Given I am in Home page
    When I navigate to Contact page
    And I submit the feedback
    Then I can see header page error messages
    And I can see error messages from required fields
    When I populate the mandatory fields
      | Forename | Email             | Message                     |
      | Smith    | mrsmith@gmail.com | This is my feedback message |
    Then header page error message will be removed
    And error messages from required fields will be removed

  Scenario: Test Case 2 - User to successfully submit feedback form
    Given I am in Home page
    When I navigate to Contact page
    And I populate the mandatory fields
      | Forename | Email             | Message                     |
      | Smith    | mrsmith@gmail.com | This is my feedback message |
    And I submit the feedback
    Then the feedback is submitted successfully