
@Regression
Feature: Search by Job ID
  As a user
  I want to search for a job by its ID
  So that I can view its details

  Scenario: Search for a job with valid ID
    Given I am on the careers page
    When I search for job ID "R0252154"
    Then I should see the job details