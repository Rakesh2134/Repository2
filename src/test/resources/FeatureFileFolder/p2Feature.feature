Feature: To test compose function in gmail and send an email

Scenario Outline: Compose email and send it
	Given User is signedin to gmail account
	When User clicks on compose
	And User enters "<recipient email>"  "<subject>" and "<body>"
	And User clicks on send button
	Then Message displayed Message Sent
	Then Signout from gmail
	And close the browser
	
Examples:
    |     recipient email       |     subject  |                       body                   |
    |     test@test.com         |       Test1  |                           test body 1        |
    |     test@test.com         |       Test2  |                                             |
    
