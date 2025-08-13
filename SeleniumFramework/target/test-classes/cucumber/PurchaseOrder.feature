@tag
Feature: Purchase the order from Ecommmerce website
	I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Page
	
	@Regression
	Scenario Outline::Positive Test of Submitting the order
	Given Logged in with username <uname> and password <pwd>  
	When I add product <productname> to Cart
	And Checkout by providing first name <firstname> and last name <lastname> and zipcode <zipcode> details and submit the order
	Then "Thank you for your order!" message is displayed on ConfirmationPage
	
	Examples:
		| uname			| pwd			|  productname	 		| firstname	| lastname | zipcode |
		| standard_user	| secret_sauce	|  Sauce Labs Backpack	| Ashwin	| Kumar	   | 502032  |	
		| visual_user	| secret_sauce	|  Sauce Labs Backpack	| Akhira	| Kumar	   | 502032  |
	
	