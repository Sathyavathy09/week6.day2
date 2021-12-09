Feature: Delete Lead in the LeafTaps Application

Background:
Given Enter Username as "Demosalesmanager"
And Enter Password as "crmsfa"
When Click on Login button
Given Click on CRM
Given Click on Leads

Scenario Outline: Delete Lead
Given Click on Find Leads
Given Click on Phone
Given Enter the phone <phNo>
And Click on Search Leads
And Get the lead id
And Click on the Lead Record
When Click on the Delete Button
Given Click on Find Leads
Given Enter the LeadID
And Click on Search Leads
Then Verify the lead is deleted



Examples:
|phNo|
|'425'|

