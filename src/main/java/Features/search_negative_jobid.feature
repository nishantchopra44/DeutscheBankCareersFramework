
@Regression
Feature: Validate entering incorrect Job ID

  Scenario: Entering wrong values in Job ID field should yield zero results
    Given I navigate to the job search page
    When I enter "wrong_job_id" in the Job ID field
    And I click the Search button
    Then the search results should be zero
