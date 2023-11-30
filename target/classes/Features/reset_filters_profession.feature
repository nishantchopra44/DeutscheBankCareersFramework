
@Regression
Feature: Reset Profession Functionality Verification

  Scenario: Reset profession filters
    Given I navigate to the Deutsche Bank careers website
    And I search using profession
    And I select profession category as "SomeProfessionCategory"
    And I select profession as "SomeProfession"
    And I select country as "SomeCountry"
    And I select corporate title as "SomeCorporateTitle"
    And I specify availability as "SomeAvailability"
    When I reset the profession filters
    Then the profession filters should be reset