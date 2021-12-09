Feature: Create Incident in the ServiceNow Application

@create
Scenario: Create New Incident
Given Click on Create New Option
Given Get the Incident ID
Given Click on Caller ID
And Go to the New Window
And Select the Caller
And Go to the Main Window
Then Fill the description
When Click on submit
Then Verify the incident number

@update
Scenario: Update the Incident
Given Search with incident "INC0000008"
Given Click on the incident
And Change the Urgency as High
And Change the state to In Progress
Then Click on Update

@assign
Scenario: Assign the Incident
Given Search with incident "INC0000009"
Given Click on the incident
Given Click on group
And Go to the New Window
And Select Software from the list
And Go to the Main Window
And Enter the Work notes
Then Click on Update to complete
Then Verify Incident is correctly assigned to group

@delete
Scenario: Delete the Incident
Given Search with incident "INC0000019"
Given Click on the incident
When Click on Delete
#Then Verify incident is deleted
