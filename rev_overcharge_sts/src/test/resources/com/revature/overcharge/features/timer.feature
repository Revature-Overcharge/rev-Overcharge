Feature: Timer

# All buzzer functionality is a stretch goal.

Background:
	Given User is on any page
  Given User is logged in

Scenario: User toggles timer visibility on
  Given Timer is not visible
  When User clicks toggle visibility button
  Then Timer is visible

Scenario: User toggles timer visibility off
  Given Timer is visible
  When User clicks toggle visibility button
  Then Timer is not visible

Scenario: User starts timer
  Given Timer is visible
  When User clicks start button
  Then Timer starts counting down

Scenario: User pauses timer
  Given Timer is visible
  And Timer is active
  When User clicks pause button
  Then Timer activity is paused

Scenario: User resets timer
  Given Timer is visible
  And Timer is not at initial value
  When User clicks reset button
  Then Timer is reset to initial value
    
Scenario: Timer reaches 0
  Given Timer is active
  When Timer cycle is complete
  Then Timer is complete
  #And Modal pops up to notify User #Needs to be rewritten as a modal?
  #And Buzzer noise plays

Scenario: User selects break timer
  Given Timer is on Study Mode
  When User clicks toggle mode button
  Then Timer is on Break Mode

Scenario: User selects study timer
  Given Timer is on Break Mode
  When User clicks toggle mode button
  Then Timer is on Study Mode
   
Scenario: User toggles input visibility on
	Given Timer input is not visible
	When User clicks toggle input button
	Then Timer input is visible

Scenario: User toggles input visibility off
	Given Timer input is visible
	When User clicks toggle input button
	Then Timer input is not visible

Scenario Outline: User sets custom time
  Given Timer input is visible
  When User inputs <hours> hours
  And User inputs <minutes> minutes
  And User clicks set timer button
  Then Timer initial value is <newTime>

	Examples: 
	| hours | minutes | newTime |
	| "23" | "59" | "23:59:00" |
	| "0" | "1" | "00:01:00" |
	| "2" | "15" | "02:15:00" |

#Scenario: Timer Buzzer is turned off
#    Given Timer Buzzer is active
#    When User clicks Buzzer icon
#    Then Timer Buzzer is inactive
#
#Scenario: Timer Buzzer is turned on
#    Given Timer Buzzer is inactive
#    When User clicks Buzzer icon
#    Then Timer Buzzer is active