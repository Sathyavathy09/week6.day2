Feature: Create Lead in the LeafTaps Application

Background:
Given Enter Username as "Demosalesmanager"
And Enter Password as "crmsfa"
When Click on Login button
Given Click on CRM
Given Click on Leads

@CreateLead
Scenario Outline: Create Lead
Given Click on Create Lead
And Enter the Company name <company>
And Enter the First Name <fName>
And Enter the Last Name <lName>
And Enter the phone number <phNo>
When Click on submit button
Then Lead created successfully

Examples:
|company|fName|lName|phNo|
|'TCS'|'Sathya'|'M'|'425'|
|'CTS'|'Swathi'|'N'|'989'|
|'Infosys'|'John'|'F'|'679'|




