
@Smoke @Sanity
Feature: Career Search on Division Deutsche Bank Page

  Scenario: Search using Division and Filter Selection
    Given I navigate to the Deutsche Bank careers website
    When I search using "Division Category" as "<division>", "Country" as "<country>", "Corporate title" as "<corporateTitle>", and "Availability" as "<availability>"
    Then I should see relevant search results
