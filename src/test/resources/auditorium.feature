Feature: Client wants to get information about auditoriums
  Scenario: Client makes call to GET an auditorium by id
    When the client calls /auditorium/get-auditorium
    And the searched auditorium has the id 1234567890
    Then the client receives status code of 200
    And the client receives the name room1
    And the seat number 101 of the auditorium

  Scenario: Client makes call to GET an auditorium by name
    When the client calls /auditorium/get-auditorium-by-name
    And the searched auditorium has the name room1
    Then the client receives status code of 200
    And the client receives the id 1234567890
    And the seat number 101 of the auditorium

  Scenario: Client makes call to GET a list of auditoriums in which a certain movie will be casted
    When the client calls /auditorium/auditoriums-for-movie
    And the searched movie has the id 123
    Then the client receives status code of 200
    And the auditorium with the id 1234567890 is in the list