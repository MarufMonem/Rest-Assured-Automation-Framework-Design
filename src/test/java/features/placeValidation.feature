Feature: Validating place APIs
  Scenario: Verify the add place functionality
    Given Add place payload
    When User calls "AddPlaceAPI" with Post http request
    Then The API call will get success with status code 200
    And The "status" in response body is "OK"
    And The "scope" in response body is "App"
