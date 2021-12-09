Feature: Edit Lead in the LeafTaps Application

Background:
Given Enter Username as "Demosalesmanager"
And Enter Password as "crmsfa"
When Click on Login button
Given Click on CRM
Given Click on Leads

Scenario Outline: Edit Lead
Given Click on Find Leads
Given Click on Phone
Given Enter the phone <phNo>
And Click on Search Leads
And Click on the Lead Record
And Click on the Edit Button
Then Update the company name <company>
Then Click on Update Button


Examples:
|company|phNo|
|'CTS'|'425'|
|'TCS'|'989'|
