
@Regression
Feature: Reset Division Functionality Verification

  Scenario: Reset division filters
    Given I navigate to the Deutsche Bank careers website
    And I search using division
    And I select profession category as "SomeDivisionCategory"
    And I select country as "SomeCountry"
    And I select corporate title as "SomeCorporateTitle"
    And I specify availability as "SomeAvailability"
    When I reset the division filters
    Then the division filters should be reset