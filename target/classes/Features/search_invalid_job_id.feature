
@Regression
Feature: Search with Invalid Job ID

  Scenario: Searching with an invalid job ID
    Given I am on the career page
    When I search with an invalid job ID "InvalidJob123"
    Then I should see zero search results
