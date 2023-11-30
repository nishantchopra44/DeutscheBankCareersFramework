
@Smoke @Sanity
Feature: Career Search on Profession Deutsche Bank Page

  Scenario: Search using Profession and Filter Selection
    Given I navigate to the Deutsche Bank careers website
    When I search using "Profession Category" as "<Profession>", "Country" as "<country>", "Corporate title" as "<corporateTitle>", and "Availability" as "<availability>"
    Then I should see relevant search results