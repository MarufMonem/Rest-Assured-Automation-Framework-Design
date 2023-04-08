Feature: Validating place APIs

@AddPlace
  Scenario Outline: Verify the add place functionality
    Given Add place payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "Post" http request
    Then The API call will get success with status code 200
    And The "status" in response body is "OK"
    And The "scope" in response body is "APP"
    And Verify place_ID created  maps to "<name>" using "getPlaceAPI"

    Examples:
      | name    | language | address            |
      | A house | English  | World cross center |
      | Maruf   | Bangla   | Dhaka              |

 @DeletePlace
  Scenario: Verify if the the Delete Place API is working
    Given DeletePlace payload
    When User calls "DeletePlaceAPI" with "Post" http request
    And The "status" in response body is "OK"





