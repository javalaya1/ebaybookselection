@regression
Feature: Verify CoinDesk API response

  @Coindesk
  Scenario: Verify the BPI values and GBP description
    Given I send a GET request to the CoinDesk API
    Then the response should contain the BPIs USD, GBP, and EUR
    And the GBP description should be "British Pound Sterling"

  @abc
  Scenario: Verify the BPI values and GBP description2
    Given I send a GET request to the CoinDesk API2
    Then the response should contain the BPIs USD, GBP, and EUR2
    And the GBP description should be2 "British Pound Sterling"