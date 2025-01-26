@Coindesk
Feature: Verify CoinDesk API response

  Scenario: Verify the BPI values and GBP description
    Given I send a GET request to the CoinDesk API
    Then the response should contain the BPIs USD, GBP, and EUR
    And the GBP description should be "British Pound Sterling"
