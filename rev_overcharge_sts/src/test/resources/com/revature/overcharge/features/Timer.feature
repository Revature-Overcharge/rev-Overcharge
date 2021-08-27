Feature: Using the timer

Background: 
	Given User has navigated to the website
	Given User shows Timer

Scenario Outline: User toggles Timer
	Given Timer visibility is <initial>
	When User clicks "Timer"
	Then Timer toggles visibility to <final>
	
	Examples:
	| initial | final |
	| "On" | "Off"|
	| "Off" | "On" |

Scenario: User plays timer
	Given Timer visibility is "On"
	When User clicks "Play"
	Then Timer status is "Active"

Scenario: User pauses timer
	Given Timer visibility is "On"
	When User clicks "Pause"
	Then Timer status is "Paused"

Scenario: User resets timer
	Given Timer visibility is "On"
	When User clicks "Reset"
	Then Timer status is "Inactive"
	
Scenario: Timer completes cycle
	Given Timer visibility is "On"
	When Timer display is "00:00:00"
	Then Timer status is "Complete"
	
Scenario Outline: User changes timer mode
	Given Timer visibility is "On"
	And Timer mode is <initial>
	When User clicks "Change Mode"
	Then Timer mode changes to <final>
	
	Examples:
	| initial | final |
	| "Study" | "Break" |
	| "Break" | "Study" |

Scenario Outline: User sets timer
	Given Timer visibility is "On"
	When User clicks "Display Input"
	And User inputs <hours> and <minutes>
	Then Timer is set to <newTime>
	
	Examples: 
	| hours | minutes | newTime |
	| "23" | "59" | "23:59:00" |
	| "0" | "1" | "00:01:00" |
	| "2" | "15" | "02:15:00" |