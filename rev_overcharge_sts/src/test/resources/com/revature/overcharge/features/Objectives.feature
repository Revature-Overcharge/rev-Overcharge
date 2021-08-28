Feature: Objectives
  I want to see objectives in the objectives tab and through sidebar nav
  
  Background:
    Given User is viewing the app
    
  Background: Guest wants to check Objectives things
    Given User is not logged in
  
  Scenario: Guest wants to see Objectives at the top
    When Guest clicks on Objectives at the top
    Then Message to login in shown at top
  
  Scenario: Guest wants to see Objectives from the side
    When Guest clicks on Objectives from the side
    Then Message to login is shown in the middle
    
  Scenario: User sees login objective completed
    When User logs in for the first time
    Then Login objective toast appears

  Background: User with a deck wants to check Objectives things
    Given User with a deck is logged in
    
  Scenario: User wants to Rate a Deck they do not own
    Given User has finished going through a deck
    And User rates the deck
    Then User clicks on 

  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
