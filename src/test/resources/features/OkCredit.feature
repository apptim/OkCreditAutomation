#Author: Sivasankaramalan
@sanity 
Feature: Running Sanity test on OkCredit App 

Background: Login to the OkCredit App 
	Given Launch the App 
	And User clicks on "Next" 
	And User clicks on "Verify Mobile" 
	Then Verify the "Verify Mobile" Page 
	And User enters the "Mobile Number" 
	And User clicks on "OK" 
	Then Verify "Successful Login" 
	Then Verify the "Home" Page 
	
Scenario: Add Customer to the Merchant with Name and Mobile Number 
	When User is in "Home" Page 
	And User clicks on "Add Customer" 
	And User enters the "Customer Name" 
	Then Verify "Submit" 
	And User clicks on "Submit Name" 
	And Verify "Mobile Number" Field 
	And User enters the "Customer Number" 
	And User clicks on "Submit Number" 
	Then Verify the "Customer" Page 
	And Navigate to "Customer Profile" 
	Then Verify "Customer Details" 
	Then user closes the App 
	
Scenario: Verify Deleting the Customer with Advances and Password 
	When User is in "Home" Page 
	And User Chooses the "Customer" 
	And Navigate to "Customer Profile" 
	And Verify "Delete Customer" 
	And User clicks on "Delete Customer" 
	And Verify "Delete Customer Page" 
	And User enters the "Password" 
	And Verify "Deleted user is removed from the homepage" 
	Then Verify the "Home" Page 
	
Scenario: Add Customer to the User By importing Contact 
	When User is in "Home" Page 
	And User clicks on "Add Customer" 
	And User Selects "Customer" in list 
	Then Verify the "Customer" Page 
	And User navigates back 
	When User is in "Home" Page 
	And User clicks on "Add Customer" 
	And User enters the "Customer Name" with "Existing Customer Name" 
	And User Selects "Filtered Customer" in list 
	Then Verify the "Customer" Page 
	
Scenario: Add Supplier to the Merchant with Name and Mobile Number 
	And User clicks on "Supplier Tab" 
	Then Verify "Supplier Page" 
	And User clicks on "Add Supplier" 
	And User enters the "Supplier Name" 
	Then Verify "Contact List" 
	Then Verify "Supplier OK" 
	And User clicks on "Supplier OK" 
	And Verify "Supplier Mobile Number" 
	And User enters the "Supplier Number" 
	And User clicks on "Supplier OK" 
	Then Verify the "Supplier Details" Page 
	And Navigate to "Supplier Profile" 
	Then Verify "Supplier Details" 
	Then user closes the App 
	
Scenario: Verify Customer Profile Page 
	When User is in "Home" Page 
	And User Chooses the "Customer" 
	And Verify the "Customer" Page 
	And Navigate to "Customer Profile" 
	And Verify "Customer Profile Picture" 
	And Verify "Customer Mobile Number" 
	And Verify "Customer Address" 
	And Verify "Reminders Option" 
	And User changes the "Reminders Option" 
	And User changes the "Customer Name" 
	And User changes the "Customer Mobile Number" 
	And User changes the "Address" 
	And Verify "Changes in User Profile" 
	And Verify "Transaction SMS" 
	And User disables the "Transaction SMS" 
	And Verify "SMS Language" 
	And User changes the "SMS Language" 
	Then user closes the App 
	
Scenario: Verify Supplier Profile Page 
	And User clicks on "Supplier Tab" 
	Then Verify "Supplier Page" 
	And User Chooses the "Supplier" 
	And Verify the "Supplier Details" Page 
	And Navigate to "Supplier Profile" 
	And Verify "Supplier Profile Picture" 
	And Verify "Supplier Mobile Number" 
	And Verify "Supplier Address" 
	And User changes the "Supplier Name" 
	And User changes the "Supplier Mobile Number"
	And User changes the "Address" 
	And Verify "Changes in User Profile" 
	And Verify "Transaction SMS" 
	And Verify "SMS Language" 
	And User changes the "SMS Language" 
	Then user closes the App 
	
Scenario: Verify Merchant Profile Page 
	When User is in "Home" Page 
	And User clicks on "Hamburger Menu" 
	And Verify "Merchant Name" 
	And Verify "Merchant Profile Picture" 
	And User clicks on "Merchant Name" 
	And Verify the "Merchant Profile" Page 
	And Verify "Merchant Business Name" 
	And Verify "Merchant Mobile Number" 
	And Verify "Merchant Business Type" 
	And Verify "Merchant Business Category" 
	And Verify "Merchant Business Address" 
	And Verify "Merchant Other Info" 
	And Verify "Merchant Business Card" 
	Then user closes the App 
	
Scenario: Setup Payment for Supplier 
	And User clicks on "Supplier Tab" 
	Then Verify "Supplier Page" 
	And User Chooses the "Supplier" 
	And Verify "Take Credit" 
	And Verify "Give Payment" 
	And User clicks on "Give Payment" 
	And User adds "Credit to Supplier" 
	And Verify "Pay Online" 
	And User clicks on "Pay Online" 
	And Verify the "Add Supplier UPI" Page 
	And User enters the "UPI ID" 
	And User clicks on "Add Bank Account" 
	And User enters the "Account Number" 
	And User enters the "IFSC" 
	And User clicks on "Supplier IFSC Submit" 
	And Verify "Supplier Account Details" 
	And User clicks on "Change Details" 
	And User enters the "UPI ID" 
	And User clicks on "Supplier UPI Submit" 
	And Verify "Supplier Account Details" 
	And User clicks on "Proceed" 
	And Verify the "Supplier Payment" Page 
	And Verify "Payment Options" 
	Then user closes the App 
	
Scenario: Verify Filter Options in Customer Page 
	When User is in "Home" Page 
	Then Verify the "Filter" Button 
	Then User clicks on "Filter" 
	Then Verify "Filter Options" 
	Then Verify "Selected Sort Options" 
	Then User clicks on "Filter Cancel" 
	Then User clicks on "Filter" 
	Then User clicks on "Today In Filter" 
	Then User clicks on "Apply" 
	Then Verify "Number of Filters Active" 
	Then Verify "Clear Filters" 
	Then Verify "Results by Filter Today" 
	Then User clicks on "Clear Filter" 
	Then Verify "Customer List" 
	Then User clicks on "Filter" 
	Then User clicks on "Today In Filter" 
	Then User clicks on "Name In Sort" 
	Then User clicks on "Apply" 
	Then Verify "Results by Filter Today" 
	Then User clicks on "Filter" 
	Then User changes the "Filter" to "Pending" 
	Then User clicks on "Apply" 
	Then Verify "Pending Collections" 
	Then User clicks on "Filter" 
	Then User clicks on "Today In Filter" 
	Then User clicks on "Apply" 
	Then Verify "Results by Filter Pending Today" 
	Then User clicks on "Filter" 
	Then User changes the "Filter" to "Upcoming" 
	Then User clicks on "Apply" 
	Then Verify "Results by Filter Upcoming" 
	Then User clicks on "Filter" 
	Then User clicks on "Clear Filter Page" 
	Then User clicks on "Filter" 
	Then User changes the "Filter" to "All Three" 
	Then User clicks on "Apply" 
	Then Verify "Results by all Filter" 
	Then Verify "Number of Filters Active" 
	Then User clicks on "Clear Filter" 
	Then Verify "Customer List" 
	Then user closes the App 
	
Scenario: Setup the Collection with Account Number and UPI without Adding 
	When User is in "Home" Page 
	And User clicks on "Hamburger Menu" 
	And Verify "Account Menu" 
	And User clicks on "Collection" 
	Then Verify the "Collection" Page 
	And User clicks on "Setup Collection" 
	Then Verify the "Add Bank Details" Page 
	And Verify "Account Number Text Box" 
	And Verify "User enters only the Numbers in Account field" 
	And User enters the "Wrong Account Number" 
	And Verify "IFSC code Text Box" 
	And User enters the "Wrong IFSC" 
	And Verify "Error Message for Wrong IFSC" 
	And User enters the "IFSC" 
	And User clicks on "IFSC Submit" 
	And Verify "Error Message for Wrong Account" 
	And User enters the "Account Number" 
	And User enters the "IFSC" 
	And User clicks on "IFSC Submit" 
	And Verify "Account Details" 
	And User clicks on "Change" 
	Then Verify the "Add Bank Details" Page 
	And User clicks on "Add UPI" 
	Then Verify the "Add UPI" Page 
	And Verify "UPI ID Text Box" 
	And Verify "QR Code icon" 
	And User clicks on "QR Code icon" 
	Then Verify the "QR Scanner" Page 
	And Verify "UPI Options" 
	And User navigates back 
	And User enters the "Wrong UPI ID" 
	And User clicks on "UPI Submit" 
	And Verify "Error message for wrong UPI" 
	And User enters the "UPI ID" 
	And User clicks on "UPI Submit" 
	And Verify "UPI Details" 
	And User clicks on "Change" 
	Then Verify the "Add UPI" Page 
	And User clicks on "UPI Submit" 
	And Verify "UPI Details" 
	Then user closes the App 
	
#Scenario: Verify Hamburger Menu Options 
#	When User is in "Home" Page 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Account Menu" 
#	And User clicks on "Account Menu" 
#	And Verify "Account Menu Options" 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Rewards Menu" 
#	And User clicks on "Rewards" 
#	And Verify the "Rewards" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Help Menu" 
#	And User clicks on "Help" 
#	And Verify "Help Topic" 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Share Menu" 
#	And User clicks on "Share" 
#	And Verify the "Share" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "About Us" 
#	And User clicks on "About Us" 
#	And Verify the "About" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Money Transfer" 
#	And User clicks on "Money Transfer" 
#	And Verify the "Money Transfer" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Home Delivery" 
#	And User clicks on "Home Delivery" 
#	And Verify the "Home Delivery" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Mobile Recharge" 
#	And User clicks on "Mobile Recharge" 
#	And Verify the "Mobile Recharge" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Insurance" 
#	And User clicks on "Insurance" 
#	And Verify the "Insurance" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Privacy Policy" 
#	And User clicks on "Privacy Policy" 
#	And Verify the "Privacy Policy" Page 
#	And User navigates back 
#	And User clicks on "Hamburger Menu" 
#	And Verify "Rate Us" 
#	And User clicks on "Rate Us" 
#	And Verify the "Rate Us" Page 
#	And User navigates back 
	
	#Scenario: Verify the Registration flow with OTP Manually 
	#	And User clicks on "Next" 
	#	And User clicks on "Verify Mobile" 
	#	Then Verify the "Verify Mobile" Page 
	#	Then User enters the "Invalid mobile number" 
	#	Then Verify the "X" button 
	#	Then Verify the "OK" button 
	#	Then User enters the "Invalid mobile number" 
	#	And User clicks on "OK" 
	#	Then Verify the "OTP" Page 
	#	Then Verify the "WhatsApp Login" Page 
	#	And User clicks on "Not Now" 
	#	Then Verify the "Resend OTP" button 
	#	And User enters the "Wrong OTP" 
	#	And User navigates back 
	#	And User navigates back 
	#	And User clicks on "X" 
	#	And User enters the "Mobile Number" 
	#	And User clicks on "OK" 
	#	And User enters the "OTP" 
	#	Then Verify the "Home" Page 
	#	Then user closes the App 
	