Feature: Calculate Test

  Scenario Outline: Make a work with calculate

    Given Navigate to Website
    And Click calculate pagebutton
    And  Type firstnumber "<firstnumber>"
    And   Type secondnumber "<secondnumber>"
    And  Choose the type plus
    When  Click calculate button
    Then Verify  answer message
    Examples:
      | firstnumber | secondnumber |
      |5            |9             |
      |9            |55            |
      |18           |9             |
      |1000         |98            |
