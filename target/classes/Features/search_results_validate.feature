
@Regression
Feature: Validate search results contain a specific keyword

  Scenario: Search results should contain a keyword
    Given I navigate to the search results page
    Then the search results should contain the keyword "dynamic_keyword"