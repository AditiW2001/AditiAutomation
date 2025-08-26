Feature: Bill Save

  Background: To save a bill in POS.
    Given user launches Chrome Browser
    When user opens URL
    And User is logged in
    Given when user searches the POS Menu
    Then Select the POS Menu
    Then Selects the Company
    Then Searches the Store
    Then Selects the Store
    Then Selects the Counter
    Then Enters Denonimation
    Then Begins the Shift
    Then I close the unwanted popup window

  Scenario: User scans multiple products and saves the bill twice
    Then user saves the bill twice with following products:
      | ProductCode |
      | Soundcore02 |
      | FAW99       |
      | Boateb04    |
      | Boateb03    |

