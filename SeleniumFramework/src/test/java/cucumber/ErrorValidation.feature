@tag
Feature: Error Validation
	I want to use this template for my feature file
	
	@ErrorValidation
	Scenario Outline::Positive Test of Submitting the order
	Given I landed on Ecommerce Page   
	When Logged in with username <uname> and password <pwd>
	Then "Epic sadface: Username and password do not match any user in this service" message is displayed
	
	Examples:
		| uname			| pwd			|
		| standard_user	| secret_sae	|	
		| visual_user	| secretuce		|
	
	