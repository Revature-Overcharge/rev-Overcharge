Feature: WeeklyObjectives
  As a user I want to see my objectives updating properly when I complete them
    
  Scenario: A random user is logged in
    Given User is on homepage
    When User clicks the login
    When User enters in their username and password
    When User clicks submit
    
  Scenario: User picks a deck to study
    Given User on the Library Page
    When User clicks on Deck three (Spring)
    
  Scenario: User goes through a deck
  	Given User on the card page
  	When User goes through all the cards
  	Then User rates the deck as five stars
  	
  Scenario: Rating user logs out
  	When User taps on their username
  	When User taps on the logout button
  	Then User should logout and be at homepage
  	
  Scenario: The creator of deck three is logged in
    Given User is on homepage
    When User clicks the login
    When User enters in their username and password
    When User clicks submit
    
  Scenario: The creator of deck three sees a their get five star rating fulfiled
  	When User clicks on the objectives page
  	Then User will see 
  
  	
  