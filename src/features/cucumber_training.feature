Feature: cumcumber training login page
  Description:	nothing for now

  Scenario: login to the WebApp with invalid credentials
    Given system navaigates in login page
    When an invalid user and password are entere
    And login button is clicked
    Then an error message is returned
