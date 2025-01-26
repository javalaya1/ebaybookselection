@eBay
Feature: Search and Add to Cart

  Scenario: Search for a book and add to cart
    Given I open the browser and navigate to "https://www.ebay.com"
    When I search for "book"
    And I click on the item 2 in the list
    And I click on Add to cart
    Then the cart should be updated and display the number of items in the cart