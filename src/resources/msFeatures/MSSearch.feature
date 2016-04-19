@MSSearch
Feature: Validate the search criteria for MS


  @ValidProductSearch
  Scenario Outline: Validate valid product search
    When a customer searches for a product "<product>"
    Then that customer can see a view of matching products "<product>"

    Examples:
      | product |
      | socks   |
      | shirts  |


  @InvalidProductSearch
  Scenario Outline: Validate invalid product search
    When a customer searches for a product "<product>"
    Then that customer will receive an error message if product is invalid "<product>"

    Examples:
      | product  |
      | xxseter  |
      | jeremayy |




