Feature: Merge Lead in the LeafTaps Application

Background:
Given Enter Username as "Demosalesmanager"
And Enter Password as "crmsfa"
When Click on Login button
Given Click on CRM
Given Click on Leads

Scenario: Merge Lead
Given Click on Merge Leads
Given Click on first lookup
Given Go to the new window
Given Enter the lead first name "Sathya"
And Click on Search Leads
And Get the lead id
And Click on the Lead Record
And Go to main window
Given Click on second lookup
Given Go to the new window
Given Enter the lead first name "Swathi"
And Click on Search Leads
And Click on the Lead Record
And Go to main window
Then Click on Merge Button
Then Accept the Alert
Given Click on Find Leads
Given Enter the LeadID
And Click on Search Leads
Then Verify the lead is merged




