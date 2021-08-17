Feature: Timer

Background:
    Given User is logged in

Scenario: User toggles timer visibility on
# Timer icon when off
    Given Timer is not visible
    When User clicks toggle button
    Then Timer is visible

Scenario: User toggles timer visibility off
    Given Timer is visible
    When User clicks toggle button
    Then Timer is not visible

Scenario: User starts timer
    Given Timer is visible
    When User clicks timer's start button
    Then Timer starts counting down

Scenario: User pauses timer
    Given Timer is visible
    And Timer is active
    When User clicks timer's pause button
    Then Timer activity is paused

Scenario: User resets timer
    Given Timer is visible
    And Timer is not at initial value
    When User clicks timer's reset button
    Then Timer is reset to initial value
    

Scenario: User selects break timer
    Given Timer is on Work Mode
    When User clicks timer's Break Mode button
    Then Timer is on Break Mode
    #Toggle button for work and break?

Scenario: User selects work timer
    Given Timer is on Break Mode
    When User clicks timer's Work Mode button
    Then Timer is on Work Mode

Scenario: User sets custom time
    Given Timer is at initial value
    When User clicks timer numbers
    #OR User clicks change time button
    And User inputs new timer value
    #Does this need validation?
    Then Timer initial value is changed

Scenario: Timer reaches 0
    Given Timer is active
    When Timer cycle is complete
    Then Modal pops up to notify User
    And Buzzer noise plays

Scenario: Timer Buzzer is turned off
    Given Timer Buzzer is active
    When User clicks Buzzer icon
    Then Timer Buzzer is inactive

Scenario: Timer Buzzer is turned on
    Given Timer Buzzer is inactive
    When User clicks Buzzer icon
    Then Timer Buzzer is active