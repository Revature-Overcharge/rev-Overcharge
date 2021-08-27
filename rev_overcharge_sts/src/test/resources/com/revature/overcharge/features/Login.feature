Feature: Login

Background:
	Given User has nagivated to the website
	Given User opens the login modal

Scenario: 
	When User logs in with valid credentials
	Then Username is displayed
	And Login buttons disappear
	And User is redirected

Scenario:
	When User logs out
	Then Username is removed
	And Login buttons appear
	And User is redirected
	