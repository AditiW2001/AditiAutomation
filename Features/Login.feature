Feature: Login 

Scenario: Login with valid credentials

Given user launch Chrome Browser
When user open URL "https://test-unify.etpgroup.sg/"
And User enters Email as "egs.enterprise@etpgroup.com" and Password as "Egs@1612"
And Clicks on Login
And User Selects Sylphy Group
And User Clicks on User Profile
When User clicks on Logout link
And close the browser.