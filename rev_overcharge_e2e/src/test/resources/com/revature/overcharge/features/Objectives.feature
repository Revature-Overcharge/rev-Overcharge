Feature: Objectives
  I want to see objectives in the objectives tab and through sidebar nav
  
  Scenario: Guest wants to see Objectives
  	Given User is viewing the app
    Given User is not logged in
    When User clicks the Objectives topnav
    Then Message to login in shown at top
    When User clicks the Objectives sidenav
    Then Message to login is shown in the middle
    
  Scenario: User sees login objective completed
    Given User is not logged in
    When User logs in for the first time
    Then Login objective toast appears
    
  Scenario: User wants to Rate a Deck they do not own 5 Stars 
    Given User without a deck is logged in
    And User clicks on Library
    And User clicks Study
    And User goes through a deck
    And User rates the deck 5 stars
    When User clicks the Objectives topnav
    Then Tab shows Rate a Deck complete
    When User clicks the Objectives sidenav
    Then Objectives show Rate a Deck complete
    
  Scenario: User sees a 5 star rating on their deck
    Given User with a 5 star rating on their deck is logged in
    When User clicks the Objectives topnav
    Then Tab shows Get a 5 Star Rating complete
    When User clicks the Objectives sidenav
    Then Objectives show Get a 5 Star Rating complete
    
  Scenario: User wants to Rate a Deck they own 5 Stars
    Given User has not rated a deck, has a deck, and is logged in
    And User clicks on Library
    And User clicks Study on a deck they own
    And User goes through the deck
    And User rates the same deck 5 stars
    When User clicks the objective topnav
    Then Tab shows Rate a Deck incomplete
    And Tab shows Get a 5 Star Rating incomplete
    When User clicks the objective sidenav
    Then Objectives show Rate a Deck incomplete
    And Objectives show Get a 5 Star Rating incomplete
    
  Scenario: User wants to Master 5 Cards
    Given User is logged in one
    And User clicks on Library
    And User clicks Study
    And User clicks Mark as Mastered for 4 cards
    When User clicks the Objectives topnav
    Then Tab shows Master 5 Cards almost filled
    When User clicks Mark as Mastered for 1 more card
    And User clicks the Objectives topnav
    Then Tab shows Master 5 Cards complete
    When User clicks the Objectives sidenav
    Then Objectives show Master 5 Cards complete
  
  Scenario: User with a deck wants to Create 4 Cards
    Given User that has a deck is logged in
    And User clicks on Library
    And User clicks add/edit cards
    And User adds 2 cards
    When User clicks the Objectives topnav
    Then Tab shows Create 4 Cards as halfway
    When User clicks add/edit cards again
    And User adds 2 more cards
    And User clicks the Objectives topnav
    Then Tab shows Create 4 Cards complete
    When User clicks the Objectives sidenav
    Then Objectives show Create 4 Cards complete
  
  Scenario: User wants to Create a Deck
    Given User clicks on Create (should change to Deck rather than Sets)
    And User Creates a Deck
    When User clicks the Objectives topnav
    Then Tab shows Create a Deck complete
    When User clicks the Objectives sidenav
    Then Objectives show Create a Deck complete
  
#  Scenario: User wants to Master a Deck
#    Given User clicks on Library
#    And User clicks Study
#    And User clicks Mark as Mastered for all cards
#    And User rates the deck
#    When User clicks the Objectives topnav
#    Then Tab shows Master a Deck complete
#    When User clicks the Objectives sidenav
#    Then Objectives show Master a Deck complete