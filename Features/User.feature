Feature: Create User
Scenario: Login with valid credentials

Given user launch Chrome Browser
When user open URL "https://impl-unified.etpgroup.sg/"
And User enters Email as "aditi.waingankar@etpgroup.com" and Password as "Aditi@2001#"
And Clicks on Login
And User Selects Sylphy Group
And User Clicks on Searchbox
And User Clicks on Administration Menu
And User Click on User Management Sub Menu
And User click on plus button in the list screen.
And User fills user information
Then User Clicks on Save button.
