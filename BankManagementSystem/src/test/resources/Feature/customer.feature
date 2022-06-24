Feature: Feature to add customers

  Scenario: Check customer added successfully or not
    Given Admin enters the customer details
    When Admin sends post http request
    Then Admin gets valid response

  Scenario: Getting customer details or not
    Given Admin enters the get method url
    When Admin sends get http request
    Then Admin gets valid response
