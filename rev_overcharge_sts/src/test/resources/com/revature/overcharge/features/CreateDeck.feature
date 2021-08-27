Feature: Create a Deck

Scenario: 
	Given Has nagivated to the website
	And User Logs in
	When User navigates to the library section in side nav
	Then User has option to create a deck
	And User creates a deck
	And User enters proper values to create a deck
	Then A new deck will be created
