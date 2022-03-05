@wip
Feature: Bejamas Train Reservation

#Scenario #1

  Scenario:User can display module information when hover over
    Given The user navigates to main page
    When The user hover over the module sign
    Then The user displays the related information


#Scenario #2

  Scenario Outline: The user can reservation with valid data and Direct Connection
    Given The user navigates to main page
    When  The user enter "<destination>" and "<arrival>" station
    And The user selects the date and "15:30" as departure time
    And Check the departure radio button is selected
    And Click the Direct Connection check box
    And Click the search button
    Then  Check the result
    Examples:
      | destination | arrival |
      | KATOWICE-   | LUBLIN- |

#Scenario #3

  Scenario Outline: The user can be add Intermediate Station
    Given The user navigates to main page
    When The user enters "<destination>","<arrival>" and "<intermediate_station>"
    And Click the arrival radio button and check it is selected
    And Click the search button
    Then  Check the result

    Examples:
      | destination | arrival   | intermediate_station |
      | LUBLIN-     | KATOWICE- | BOCHNIA              |
