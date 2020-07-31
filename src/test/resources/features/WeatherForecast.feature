@Regression
Feature: Verify weather forecast



  Scenario Outline: I verify the weather forecast feature
    When I click on more button
    And I click on weather
    Then I search the the "<city>" and select it
    And I click on the "<city>" on the map and capture the temperature
    Then I verify the following fields are displayed on the weather window
    |Condition         |
    |Wind              |
    |Temp in Degrees   |
    |Temp in Fahrenheit|
    Then I hit the api with "<Host>","<End Point>","<city>" and "<Api key>" and fetch the temperature from the api
    Then I verify the temperature from ui and the end point is matching with the variance

    Examples:
      |  city        |city         |Host           |End Point           |Api key          |
      |  Bengaluru   |  aberdeen   |weatherHost    |  weatherEndPoint   |  weatherKey     |



