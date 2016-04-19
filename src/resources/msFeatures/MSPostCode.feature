@MSFindAStore
Feature: Validate postcodes

  @ValidPostCode
  Scenario Outline: Validate valid postcode search
    When a customer inserts a postcode "<postcode>"
    Then a customer can view a list of stores

    Examples:
      | postcode |
      | e152fy   |
      | e149hp   |


  @InvalidPostCode
  Scenario Outline: Validate invalid postcode search
    When a customer inserts a postcode "<postcode>"
    Then error message is displayed for an invalid postcode "<postcode>"

    Examples:
      | postcode |
      | x        |
      | i        |

