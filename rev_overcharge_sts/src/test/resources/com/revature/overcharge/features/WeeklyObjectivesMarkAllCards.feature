Feature: WeeklyObjectives
  As a user I want to see my objectives updating properly when I complete them
    
  Scenario: A random user is logged in
    Given User is on homepage
    When User clicks the login
    When User enters in a different username and password
    When User clicks submit
    
  Scenario: User picks a deck to study
    Given User on the Library Page
    When User clicks on Deck two (Testing)
    
  Scenario: User goes through a deck
  	Given User on the card page
  	When User goes through all the cards and clicked mastered
  	
  Scenario: User objectives for marked all cards is complete
  	When User clicks on the objectives page
  	Then User will see completed objectives
  	And Wait for some time to explain
  