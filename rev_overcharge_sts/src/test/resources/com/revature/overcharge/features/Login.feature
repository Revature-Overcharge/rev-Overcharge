Feature: Login

Background:
	Given User has nagivated to the website

Scenario: User opens modal from sidenav
	When User clicks "Sidenav Login"
	Then Login modal is displayed

Scenario: User opens modal from header
	When User clicks "Header Login"
	Then Login modal is displayed

Scenario: Successful Login
	Given User opens the login modal
	When User logs in with "valid" credentials
	Then Modal displays "Success" message
	And Username is displayed
	And Login buttons disappear
	And User is redirected
	
Scenario: Invalid Login
	Given User opens the login modal
	When User logs in with "invalid" credentials
	Then Modal displays "Failure" message

Scenario: Login error
	Given User opens the login modal
	When User produces a login error
	Then Modal displays "Error" message

Scenario: Logout
	Given User is logged in
	When User clicks "Logout"
	Then Username is removed
	And Login buttons appear
	And User is redirected

Scenario: Exit Modal
	Given User opens login modal
	When User clicks "Exit"
	Then Modal closes
	