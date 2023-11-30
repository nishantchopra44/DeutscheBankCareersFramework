
@Regression
Feature: Validate absence of a specific keyword in search results

  Scenario: Search results should not contain a specific keyword
    Given I navigate to the search results page
    Then the search results should not contain the keyword "negative_keyword"