Feature: MF Online Process

@MFOnlineStart
Scenario Outline: MF Online page navigation

Given User is on myportfolio page
When Family head select his name as "<FamilyHeadName>" from dropdown
And Click on MF Online button
Then Family head bydefault should display MF Holding page
Then User got loggout

Examples:
|FamilyHeadName|
|Sujit|

Scenario Outline: Particular Buy More link is clickable

Given User is on myportfolio page
When Family head select his name as "<FamilyHeadName>" from dropdown
And Click on MF Online button
And MF Holding page table to be display
And User click Buy More link of "<SchemeName>" and "<FolioNumber>"
Then Enter Amount Textbox should display

Examples:
|SchemeName|FolioNumber||FamilyHeadName|
|MOTILAL OSWAL DYNAMIC FUND - REGULAR GROWTH|91016246713||Sujit|


