Feature: Validating place API's
  Scenario: Verify the add place functionality
    Given Add place payload
    When User calls "AddPlaceAPI" with Post http request
    Then The API call will get scuccess with status code
    And The "status" in response body is "OK"
    And "scope" in response body is "App"
