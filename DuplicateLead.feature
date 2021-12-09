Feature: Duplicate Lead in the LeafTaps Application

Background:
Given Enter Username as "Demosalesmanager"
And Enter Password as "crmsfa"
When Click on Login button
Given Click on CRM
Given Click on Leads

Scenario Outline: Duplicate Lead
Given Click on Find Leads
Given Click on Phone
Given Enter the phone <phNo>
And Click on Search Leads
And Click on the Lead Record
And Click on the Duplicate Button
Then Click on Update Button


Examples:
|phNo|
|'425'|
|'989'|
