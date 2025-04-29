@RegressionTests
Feature: Item Buying

  Scenario: Test Case 3 - Buy products, proceed to checkout, and verify price correctness
    Given I am in Home page
    When I navigate to Shop page
    And I buy the following items:
      | ItemName       | Quantity  |
      | Stuffed Frog   | 2         |
      | Fluffy Bunny   | 5         |
      | Valentine Bear | 3         |
    And I navigate to Cart page
    Then the price and subtotal value for each product is correct
      | ItemName       | AmountPerItem |
      | Stuffed Frog   | 10.99         |
      | Fluffy Bunny   | 9.99          |
      | Valentine Bear | 14.99         |
    And the grand total value is equal to '$116.9'