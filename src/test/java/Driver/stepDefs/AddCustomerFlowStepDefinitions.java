package Driver.stepDefs;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.AccountPage_OR;
import ObjectRepository.BlockAndUnblockPage_OR;
import ObjectRepository.CollectionsPage_OR;
import ObjectRepository.CustomerPage_OR;
import ObjectRepository.DenySupplier_OR;
import ObjectRepository.ExpensesPage_OR;
import ObjectRepository.HelpPage_OR;
import ObjectRepository.HomePage_OR;
import ObjectRepository.LandingPage_OR;
import ObjectRepository.LinkPay_OR;
import ObjectRepository.MerchantProfilePage_OR;
import ObjectRepository.MoneyTransfer_OR;
import ObjectRepository.SupplierPage_OR;
import ObjectRepository.TransactionPage_OR;
import PageObjects.CommonMethodsFunctions;
import Utility.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class AddCustomerFlowStepDefinitions extends desiredCapabilities {

	PropertyData data = new PropertyData();
	CommonMethodsFunctions CF = new CommonMethodsFunctions();


	String customerName100Char = CF.randomAlphaNumeric(100);
	String customerAddressLarge =  CF.randomAlphaNumeric(500);
	String CustomerName = CF.randomAlphaNumeric(10);
	String CustomerNumber8Digit =CF.randomNumber(8);
	String CustomerNumber1Digit =CF.randomNumber(1);
	String CustomerNumber12Digit =CF.randomNumber(12);
	String customerNumber= "9994072804";
	String DeletedCustomer= "Shiva";
	String CommonAccountText="Your customer can see this account. Know More";
	String SupplierCommonAccountText="Your supplier can see this account. Know More";
	String DenyPermission = "Permission to add transaction is disabled by you.";
	String UnBlock = "UNBLOCK";
	String CallSupplier="CALL SUPPLIER";
	String CallCustomer="CALL CUSTOMER";
	String IvalidCustomerName = CF.randomAlphaNumeric(10)+"@#@!#@!@@";
	String IvalidCustomerNumber = "Test123456";
	public String DeletedSuppliername;
	public static String SupplierNumber;

	public static String ExistingCustomer;
	public static String ContactList;
	public static String ExistingCustomerName;
	public static String DeleteName;
	public static String type;
	
	@When("^User is in \"([^\"]*)\" Page$")
	public static void user_is_in_page(String Page) {

		if(Page.equals("Home")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.HamburgerMenu));
			Assert.assertTrue(HomePage_OR.CustomerTab.isDisplayed());
			Log.info("User is in Home Page");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Filter));
			HomePage_OR.Filter.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Cancel));
			HomePage_OR.Cancel.click();
		}
	}
	@Then("^Verify \"([^\"]*)\"$")
	public void verify(String options) throws InterruptedException, MalformedURLException {
		if(options.equals("Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerNameSubmitButton));
			Assert.assertTrue(HomePage_OR.CustomerNameSubmitButton.isEnabled());
		}
		else if(options.equals("Customer Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerName));
			Assert.assertTrue(CustomerPage_OR.CustomerName.isDisplayed());
		} 
		
		else if(options.equals("Balances Due")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.BalanceDue));
			Assert.assertTrue(CustomerPage_OR.BalanceDue.isDisplayed());
			String BalanceDueText =CustomerPage_OR.BalanceDue.getText();
			Log.info("Move to supplier check the balances due:"+ BalanceDueText);
		}
		
		else if(options.equals("Balances Advance")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.BalanceDue));
			Assert.assertTrue(CustomerPage_OR.BalanceDue.isDisplayed());
			String BalanceAdvance = CustomerPage_OR.BalanceDue.getText();
//			Assert.assertEquals(data.BalanceAdvance, BalanceAdvance);

		}
		else if(options.equals("Balances Total")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.TotalBalance));
			Assert.assertTrue(CustomerPage_OR.TotalBalance.isDisplayed());
			String TotalBalanceAmount = CustomerPage_OR.TotalBalance.getText();
//			Assert.assertEquals(data.BalanceAmount, TotalBalanceAmount);
			Assert.assertTrue(data.BalanceAmount.equals(TotalBalanceAmount));
		}
		
		else if(options.equals("Total Due Balance")) {
			Thread.sleep(3000);
			String TotalBalanceDueAmount = CustomerPage_OR.TotalAmount.getText();
			Log.info("Total Due Balance :" +TotalBalanceDueAmount );
		} 
		else if(options.equals("Total Advance Balance")) {
			String TotalBalanceDueAmount = CustomerPage_OR.TotalAmount.getText();
			Assert.assertEquals(data.BalanceAdvanceAmount, TotalBalanceDueAmount);
		}
		
		else if(options.equals("Customer Details Question")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerName));
			Assert.assertTrue(CustomerPage_OR.CustomerName.isDisplayed());
		}
		else if(options.equals("Frequently Asked Question")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.FrequentlyAsked));
			Assert.assertTrue(HelpPage_OR.FrequentlyAsked.isDisplayed());
		}

		else if(options.equals("Not a Creator")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CannotMigrate));
			Assert.assertTrue(CustomerPage_OR.CannotMigrate.isDisplayed());
			String CannotMigratenotcreator = CustomerPage_OR.CannotMigrate.getText();
			Log.info("Move to supplier check the balances due:"+ CannotMigratenotcreator);
			Assert.assertEquals(data.CannotMigrate, CannotMigratenotcreator);
		}
		else if(options.equals("Profile Move to Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CannotMigrate));
			Assert.assertTrue(CustomerPage_OR.CannotMigrate.isDisplayed());
			String CannotMigratenotcreator = CustomerPage_OR.CannotMigrate.getText();
			Log.info("Cannot migrate same number as migration"+ CannotMigratenotcreator);
			Assert.assertEquals(data.SameNumberSupplier, CannotMigratenotcreator);
		}
		
		else if(options.equals("Customer Related Question")) {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.CustomerRelated));
			Assert.assertTrue(HelpPage_OR.CustomerRelated.isDisplayed());
		}
		else if(options.equals("Transaction Related Question")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.TransactionRelated));
			Assert.assertTrue(HelpPage_OR.TransactionRelated.isDisplayed());
		}
		else if(options.equals("Account statement Question")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.AccountStatement));
			Assert.assertTrue(HelpPage_OR.AccountStatement.isDisplayed());
		}
		else if(options.equals("Account Security Question")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.AccountSecurity));
			Assert.assertTrue(HelpPage_OR.AccountSecurity.isDisplayed());
		} 
		else if(options.equals("Contact Us")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.ContactUs));
			Assert.assertTrue(HelpPage_OR.ContactUs.isDisplayed());
		} 
		else if(options.equals("Feedback Thanks")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.FeedbackThanks));
			Assert.assertTrue(HelpPage_OR.FeedbackThanks.isDisplayed());
		} 
		else if(options.equals("Help Feedback")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.HelpFeedback));
			Assert.assertTrue(HelpPage_OR.HelpFeedback.isDisplayed());
		} 
		else if(options.equals("Merchant")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.Merchant));
			Assert.assertTrue(HelpPage_OR.Merchant.isDisplayed());
		}
		else if(options.equals("Busniess Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.BusinessName));
			Assert.assertTrue(HelpPage_OR.BusinessName.isDisplayed());
		}
		else if(options.equals("No Business Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.NoBusinessName));
			Assert.assertTrue(HelpPage_OR.NoBusinessName.isDisplayed());
		}
		else if(options.equals("Email Text")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.Email_Text));
			Assert.assertTrue(HelpPage_OR.Email_Text.isDisplayed());
		}
		else if(options.equals("Customer List")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomeNameList));

			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/name_text_view");
			ExistingCustomer= elementsList.get(1).getText();
			System.out.println("One of the Customer here is :" + ExistingCustomer);
		}
		else if(options.equals("Customer Name and Header")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.AddedCustomerHeader));
			Assert.assertTrue(CustomerPage_OR.AddedCustomerHeader.isDisplayed());
			String CustomerName = CustomerPage_OR.AddedCustomerHeader.getText();
			Log.info("The Choosen customer name is :"+ CustomerName);

		}
		else if(options.equals("Customer Profile Picture")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ProfileImageCamera));
			Assert.assertTrue(CustomerPage_OR.ProfileImage.isDisplayed());
		}
		else if(options.equals("Supplier Profile Picture")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ProfileImageCamera));
			Assert.assertTrue(CustomerPage_OR.ProfileImage.isDisplayed());
		}
		else if(options.equals("Customer Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
			Assert.assertTrue(CustomerPage_OR.MobileNumber.isDisplayed());
			String CustomerNumber = CustomerPage_OR.MobileNumber.getText();
			Log.info("The Choosen customer number is : "+CustomerNumber );
		}
		else if(options.equals("Supplier Mobile Number")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SupplierNumber));
			Assert.assertTrue(CustomerPage_OR.SupplierNumber.isDisplayed());
			String SupplierNumber = CustomerPage_OR.SupplierNumber.getText();
			Log.info("The Choosen Supplier number is : "+SupplierNumber );
			}
			catch(Exception E) {
				Log.info("The supplier did not added mobile number");
			}
		}
		else if(options.equals("Customer Address")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddress));
			Assert.assertTrue(CustomerPage_OR.CustomerAddress.isDisplayed());
			String CustomerAddress = CustomerPage_OR.CustomerAddress.getText();
			Log.info("The Choosen customer Address is : "+CustomerAddress );
		}
		else if(options.equals("Supplier Address")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddress));
			Assert.assertTrue(CustomerPage_OR.CustomerAddress.isDisplayed());
			String CustomerAddress = CustomerPage_OR.CustomerAddress.getText();
			Log.info("The Choosen Supplier Address is : "+CustomerAddress );
		}
		else if(options.equals("Reminders Option")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Reminder));
			Assert.assertTrue(CustomerPage_OR.Reminder.isDisplayed());
			String CustomerReminder = CustomerPage_OR.ReminderSelected.getText();
			Log.info("The Choosen Reminder method for this customer is : "+CustomerReminder );
			}
			catch(Exception E) {
				Log.info("User did not added Mobile number. Reminder is not available");
			}
		}
		else if(options.equals("Text Limit in Customer Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.NameXpath));
			CustomerPage_OR.NameXpath.click();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerNameInputField));
			CustomerPage_OR.CustomerNameInputField.sendKeys(customerName100Char);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.NameUpdateSubmitButton));
			CustomerPage_OR.NameUpdateSubmitButton.click();

			String UpdatedCustomerName = CustomerPage_OR.CustomerName.getText();
			Log.info("The Length of the Customer Name here is :" + UpdatedCustomerName.length());
			}
			catch(Exception E) {
				Log.info("The Customer here is verified hence cannot change the name.");
				CustomerPage_OR.GotIt.click();
			}

		}
		else if(options.equals("Text Limit in Supplier Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.NameXpath));
			CustomerPage_OR.NameXpath.click();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerNameInputField));
			CustomerPage_OR.CustomerNameInputField.sendKeys(customerName100Char);
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierProfileNameSubmit));
			SupplierPage_OR.SupplierProfileNameSubmit.click();

			String UpdatedCustomerName = CustomerPage_OR.CustomerName.getText();
			Log.info("The Length of the Supplier Name here is :" + UpdatedCustomerName.length());
			}
			catch(Exception E) {
				Log.info("The Supplier here is verified hence cannot change the name.");
				CustomerPage_OR.GotIt.click();
			}

		}
		else if(options.equals("Error Messages in the Mobile Number Field")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
			CustomerPage_OR.MobileNumber.click();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerNumberInputField));
			CustomerPage_OR.CustomerNumberInputField.clear();
			CustomerPage_OR.CustomerNumberInputField.sendKeys("1234");
			CustomerPage_OR.CustomerphoneInputFieldOkButton.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.InvalidMobileNumber));
			Assert.assertTrue(CustomerPage_OR.InvalidMobileNumber.isDisplayed());
			String ErrorMessage1 = CustomerPage_OR.InvalidMobileNumber.getText();
			Log.info("The error in Mobile number field is : "+ErrorMessage1 );

			CustomerPage_OR.CustomerNumberInputField.clear();
			CustomerPage_OR.CustomerNumberInputField.sendKeys(CustomerNumber12Digit);
			CustomerPage_OR.CustomerphoneInputFieldOkButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.InvalidMobileNumber));
			Assert.assertTrue(CustomerPage_OR.InvalidMobileNumber.isDisplayed());
			String ErrorMessage2 = CustomerPage_OR.InvalidMobileNumber.getText();
			Log.info("The error in Mobile number field is : "+ErrorMessage2 );
			
			}
			catch(Exception E) {
				Log.info("The Supplier here is verified hence cannot change the name.");
				CustomerPage_OR.GotIt.click();
			}

		}
		else if(options.equals("Changes in User Profile")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerName));
			String customerNameNew = CustomerPage_OR.CustomerName.getText();
			Log.info("Customer name after the changes :" +customerNameNew );

			String customerNumberNew = CustomerPage_OR.MobileNumber.getText();
			Log.info("Customer Number after the changes :" +customerNumberNew );

			String customerAddress = CustomerPage_OR.CustomerAddress.getText();
			Log.info("Customer name after the changes :" +customerAddress );

		}
		else if(options.equals("Text Limit in the Address")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddress));
			CustomerPage_OR.CustomerAddress.click();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddressinputField));
			CustomerPage_OR.CustomerAddressinputField.click();
			CustomerPage_OR.CustomerAddressinputField.clear();
			CustomerPage_OR.CustomerNameInputField.sendKeys(customerAddressLarge);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddressinputFieldOkButton));
			CustomerPage_OR.CustomerAddressinputFieldOkButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.AddresError));
			String CustomerAddressLimit = CustomerPage_OR.AddresError.getText();
			Log.info("Error Because of :" + CustomerAddressLimit);
			}
			catch(Exception E) {
				
				Log.info("The Supplier here is verified hence cannot change the Address");
				
				if(CustomerPage_OR.GotIt.isEnabled()) {
				CustomerPage_OR.GotIt.click();
				}
			}
		}
		else if(options.equals("Text Limit in Supplier Address")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddress));
			CustomerPage_OR.CustomerAddress.click();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddressinputField));
			CustomerPage_OR.CustomerAddressinputField.clear();
			CustomerPage_OR.CustomerAddressinputField.sendKeys(customerAddressLarge);
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierProfileAddressSubmit));
			SupplierPage_OR.SupplierProfileAddressSubmit.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.AddresError));
			String CustomerAddressLimit = CustomerPage_OR.AddresError.getText();
			Log.info("Error Because of :" + CustomerAddressLimit);
			}
			catch(Exception E) {
				
				Log.info("The Supplier here is verified hence cannot change the Address");
				
				if(CustomerPage_OR.GotIt.isEnabled()) {
				CustomerPage_OR.GotIt.click();
				}
			}
			driver.navigate().back();
		}
		else if(options.equals("Transaction SMS")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.TransactionSmsText));
			String TransactionStatus = CustomerPage_OR.SMSSwitchIcon.getText();
			Log.info("The transaction sms is turened " +TransactionStatus);
		}
		else if(options.equals("SMS Language")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SmsLanguageText));
			String LanguageSelected = CustomerPage_OR.SelectedSmsLanguange.getText();
			Log.info("The Selected SMS language is " +LanguageSelected);
		}
		else if(options.equals("Delete Customer")) {
			CF.scrollToText("Delete Customer", driver);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.DeleteCustomer));
			Assert.assertTrue(CustomerPage_OR.DeleteCustomer.isDisplayed());
		}
		else if(options.equals("Delete Customer Page")) {

			try {
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.DeleteMessage));
				Assert.assertTrue(CustomerPage_OR.CustomerName.isDisplayed());
				DeleteName = CustomerPage_OR.CustomerName.getText();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Password));
				Assert.assertTrue(CustomerPage_OR.Password.isDisplayed());
			}
			catch(Exception E) {
				Log.info("The customer has Due");
				Assert.assertTrue(CustomerPage_OR.SettlementWhileDeleteAccept.isDisplayed());
				String remainingDue = CustomerPage_OR.SettlementWhileDeleteAccept.getText();
				Log.info("Remaining Payment :" + remainingDue);
				CustomerPage_OR.SettlementWhileDeleteAccept.click();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ButtonSubmit));
				CustomerPage_OR.ButtonSubmit.click();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.DeleteMessage));
				Assert.assertTrue(CustomerPage_OR.CustomerName.isDisplayed());
				DeleteName = CustomerPage_OR.CustomerName.getText();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Password));
				Assert.assertTrue(CustomerPage_OR.Password.isDisplayed());
			}

		}
		else if(options.equals("Reset Password Page")) {
				String Otp = "0";
				try {
					wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
					LandingPage_OR.OtpTextBox1.sendKeys(Otp);
					LandingPage_OR.OtpTextBox2.sendKeys(Otp);
					LandingPage_OR.OtpTextBox3.sendKeys(Otp);
					LandingPage_OR.OtpTextBox4.sendKeys(Otp);
					LandingPage_OR.OtpTextBox5.sendKeys(Otp);
					LandingPage_OR.OtpTextBox6.sendKeys(Otp);
				}
				catch(Exception E) {
					Log.info("OTP Entered Automatically");
				}
		}
		else if(options.equals("Deleted user is removed from the homepage")) {
			LoginAndRegistrationFlowStepDefinitions Login  = new LoginAndRegistrationFlowStepDefinitions();
			Log.info("Deleted Customer name is : " +Login.DeletedCustomername );
		}
		else if(options.equals("Deleted Customer is removed from the home page")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumber);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.TypeinSearchResult));
				Log.info("The Duplicate Contact available with same Number");
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoContactFoundMessage));
				Assert.assertTrue(HomePage_OR.NoContactFoundMessage.isDisplayed());
			}
		}
		else if(options.equals("Deleted Customer is Available in home page")) {
			HomePage_OR.SearchOrAddNext.clear();
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumber);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.TypeinSearchResult));
				String type = HomePage_OR.TypeinSearchResult.getText();
				if(type.equals("Supplier")) {
					Log.info("Searching Customer is not available in Customer");
				}
				else {
					Log.info("Searching customer is availabe in list");
				}
			}
			catch (Exception E){
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoContactFoundMessage));
				Assert.assertTrue(HomePage_OR.NoContactFoundMessage.isDisplayed());
				Log.info("The Deleted Contact is not Available in Customer List");
			}
			
		}
		else if(options.equals("Deleted Supplier is removed from the Supplier page")) {

			Log.info("Deleted Supplier name is : " +DeletedSuppliername);
		}
		else if(options.equals("Date Box Enabled")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DateContainer));
			Assert.assertTrue(TransactionPage_OR.DateContainer.isDisplayed());
		}
		else if(options.equals("Supplier Date Box Enabled")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SupplierDateContainer));
			Assert.assertTrue(TransactionPage_OR.SupplierDateContainer.isDisplayed());
		}
		else if(options.equals("Added Bills")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ImageThumb));
			Assert.assertTrue(TransactionPage_OR.ImageThumb.isDisplayed());
			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/pic");
			int AddedPicThumb= elementsList.size();
			System.out.println("Number of images added here is :" + AddedPicThumb);
		}
		else if(options.equals("Added Payment")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.TransactionDate));
			Assert.assertTrue(TransactionPage_OR.TransactionDate.isDisplayed());
			String addedDate = TransactionPage_OR.TransactionDate.getText();
			Log.info("The transaction is added On :" + addedDate);
		}
		else if(options.equals("Added Credit")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.TransactionDate));
			Assert.assertTrue(TransactionPage_OR.TransactionDate.isDisplayed());
			String addedDate = TransactionPage_OR.TransactionDate.getText();
			Log.info("The transaction is added On :" + addedDate);
		}
		else if(options.equals("Total balance")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.TotalAmountBottomBar));
			String TotalAmount = TransactionPage_OR.TotalAmountBottomBar.getText();
			Log.info("The Total amount of Transaction is :" + TotalAmount);
		}
		else if(options.equals("Last Payment Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.TotalAmountNearTransaction));
			TransactionPage_OR.TotalAmountNearTransaction.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedAmountDetailsPage));
			String LastAddedAmount =TransactionPage_OR.AddedAmountDetailsPage.getText();
			Log.info("The Last added amount is :" + LastAddedAmount);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedNoteDetailsPage));
			String LastAddedNote =TransactionPage_OR.AddedNoteDetailsPage.getText();
			Log.info("The Last added Note is :" + LastAddedNote);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SyncStatusDetailsPage));
			String SyncStatus =TransactionPage_OR.SyncStatusDetailsPage.getText();
			Log.info("The Sync status :" + SyncStatus);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedDateDetailsPage));
			String Dateadded =TransactionPage_OR.AddedDateDetailsPage.getText();
			Log.info("The payment was added On :" + Dateadded);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.BilledDateDetailsPage));
			String BilledDate =TransactionPage_OR.BilledDateDetailsPage.getText();
			Log.info("The Billed date was:" + BilledDate);
		}
		else if(options.equals("Last Credit Details")) {

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.TotalAmountNearTransaction));
			TransactionPage_OR.TotalAmountNearTransaction.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedAmountDetailsPage));
			String LastAddedAmount =TransactionPage_OR.AddedAmountDetailsPage.getText();
			Log.info("The Last Credit is :" + LastAddedAmount);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedNoteDetailsPage));
			String LastAddedNote =TransactionPage_OR.AddedNoteDetailsPage.getText();
			Log.info("The Last added Note is :" + LastAddedNote);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SyncStatusDetailsPage));
			String SyncStatus =TransactionPage_OR.SyncStatusDetailsPage.getText();
			Log.info("The Sync status :" + SyncStatus);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedDateDetailsPage));
			String Dateadded =TransactionPage_OR.AddedDateDetailsPage.getText();
			Log.info("The Credit was added On :" + Dateadded);

			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.BilledDateDetailsPage));
			String BilledDate =TransactionPage_OR.BilledDateDetailsPage.getText();
			Log.info("The Billed date was:" + BilledDate);
		}
		else if(options.equals("Deleted Payment")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletePayment));
			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/delete_text");
			int DeletedPayment= elementsList.size();
			System.out.println("Number of Deleted Payment is :" + DeletedPayment);

		}
		else if(options.equals("Deleted Credit")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CreditDeleted));

			List<MobileElement> elementsList = driver.findElementsByXPath("//android.widget.TextView[@text='Credit Deleted']");
			int DeletedCREDIT= elementsList.size();
			System.out.println("Number of Deleted Credit is :" + DeletedCREDIT);
		}
		else if(options.equals("Deleted Payment Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletePayment));
			TransactionPage_OR.DeletePayment.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedAmountDetailsPage));
			Assert.assertTrue(TransactionPage_OR.AddedAmountDetailsPage.isDisplayed());
			String LastAddedAmount =TransactionPage_OR.AddedAmountDetailsPage.getText();
			Log.info("The Last Deleted amount is :" + LastAddedAmount);
		}
		else if(options.equals("Deleted Credit Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletePayment));
			TransactionPage_OR.DeletePayment.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedAmountDetailsPage));
			Assert.assertTrue(TransactionPage_OR.AddedAmountDetailsPage.isDisplayed());
			String LastAddedAmount =TransactionPage_OR.AddedAmountDetailsPage.getText();
			Log.info("The Last Deleted credit is :" + LastAddedAmount);
		}
		else if(options.equals("WhatsApp Reminder")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsappReminderIcon));
				Assert.assertTrue(TransactionPage_OR.WhatsappReminderIcon.isDisplayed());
			}
			catch(Exception E) {
				System.out.println("Reminder is not enabled for the user because of fewer transactions");
			}
		}
		else if(options.equals("Balance Due")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.BalanceAdvance));
			Assert.assertTrue(TransactionPage_OR.BalanceAdvance.isDisplayed());
			String Balancedue = TransactionPage_OR.TotalAmountBottomBar.getText();
			Log.info("The total due is : "+Balancedue );
		}
		else if(options.equals("Set Due Date")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SetDueDate));
			Assert.assertTrue(TransactionPage_OR.SetDueDate.isDisplayed());
			}
			catch(Exception E) {
				Log.info("Due date is already Set for the Customer");
			}
		}
		else if(options.equals("Request Payment")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.RequestPayment));
			Assert.assertTrue(TransactionPage_OR.RequestPayment.isDisplayed());
		}
		else if(options.equals("Due Reminder")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.UpcomingDue));
			Assert.assertTrue(TransactionPage_OR.UpcomingDue.isDisplayed());
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DueDate));
			String SelectedDueDate = TransactionPage_OR.DueDate.getText();
			Log.info("The selected Due date for the credti is :" + SelectedDueDate);
		}
		else if(options.equals("Whatsapp Request")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ReminderOptionWhatsApp));
			Assert.assertTrue(TransactionPage_OR.ReminderOptionWhatsApp.isDisplayed());
			TransactionPage_OR.ReminderOptionWhatsApp.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.OkCreditContact));
			TransactionPage_OR.OkCreditContact.click();
			Log.info("Selected the OkCredit Contact");
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppSendClick));
			TransactionPage_OR.WhatsAppSendClick.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareMessage));

			String ShareMessage =  TransactionPage_OR.ShareMessage.getText();
			Log.info("The Description in the Share message is :" + ShareMessage);
			TransactionPage_OR.WhatsAppSendClick.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppCaption));
		}
		else if(options.equals("SMS Request")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ReminderOptionSms));
			Assert.assertTrue(TransactionPage_OR.ReminderOptionSms.isDisplayed());
			TransactionPage_OR.ReminderOptionSms.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SMSBody));
			String ShareMessageSms =  TransactionPage_OR.SMSBody.getText();
			Log.info("The Description in the Share message is :" + ShareMessageSms);

		}
		else if(options.equals("Call Customer")) {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CallCustomer));
			Assert.assertTrue(TransactionPage_OR.CallCustomer.isDisplayed());
			TransactionPage_OR.CallCustomer.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CustomerNumber));

			String CustomerNumber =  TransactionPage_OR.CustomerNumber.getText();
			Log.info("The Description in the Share message is :" + CustomerNumber);
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.EndCall));
			TransactionPage_OR.EndCall.click();
			Thread.sleep(3000);
		}
		else if(options.equals("Report")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ReportMenu));
			Assert.assertTrue(TransactionPage_OR.ReportMenu.isDisplayed());
		}
		else if(options.equals("Expenses Card")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Card));
			Assert.assertTrue(ExpensesPage_OR.Expenses_Card.isDisplayed());
		}
		else if(options.equals("Expenses Seven Days")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Seven_Days));
			Assert.assertTrue(ExpensesPage_OR.Expenses_Seven_Days.isDisplayed());
		}
		else if(options.equals("Expenses This Month")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_This_Month));
			Assert.assertTrue(ExpensesPage_OR.Expenses_This_Month.isDisplayed());
		}
		else if(options.equals("Expenses Last Month")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Last_Month));
			Assert.assertTrue(ExpensesPage_OR.Expenses_Last_Month.isDisplayed());
		} 
		else if(options.equals("Expenses All")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_All));
			Assert.assertTrue(ExpensesPage_OR.Expenses_All.isDisplayed());
		}
		else if(options.equals("Added Expenses Type")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Type_Verify));

			List<MobileElement> expensesType = driver.findElementsById("in.okcredit.merchant:id/type");
			String AddedType = expensesType.get(0).getText();
			Log.info("Recently Added Expenses type is :"+ AddedType);
			Assert.assertEquals(data.typeExpenses, AddedType);
		}
		else if(options.equals("Added Expenses Amount")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Amount_Verify));

			List<MobileElement> expensesAmount = driver.findElementsById("in.okcredit.merchant:id/amount");
			String AddedAmount = expensesAmount.get(0).getText();
			Log.info("Recently Added Amount : "+ AddedAmount);
			Assert.assertEquals(data.expenses, AddedAmount);
		}
		else if(options.equals("Customer Common Account Text")) {
			Log.info("Verify Common Account Message in  Customer Transaction Screen");
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.CommonAccount));
			List<MobileElement> commonAccount = driver.findElementsById("in.okcredit.merchant:id/comment_account_text");
			String commonText = commonAccount.get(0).getText();
			System.out.println(commonText);
			Assert.assertEquals(CommonAccountText, commonText);
		}
		else if(options.equals("Supplier Common Account Text")) {
			Log.info("verify Common Account Message in Supplier Trasaction screen");
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.SupplierCommonAccountText));
			List<MobileElement> commonAccount = driver.findElementsById("in.okcredit.merchant:id/supplier_account_text");
			String commonText = commonAccount.get(0).getText();
			System.out.println(commonText);
			Assert.assertEquals(SupplierCommonAccountText, commonText);
		}
		else if(options.equals("Permission Disable")) {
			Log.info("verify permission is disable in customer");
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.CommonAccount));
			List<MobileElement> denyTrans = driver.findElementsById("in.okcredit.merchant:id/comment_account_text");
			String denyTransText = denyTrans.get(0).getText();
			System.out.println(denyTransText);
			Assert.assertEquals(DenyPermission, denyTransText);
		} 
		else if(options.equals("Permisson Disable Supplier")) {
			Log.info("Verify permission is diabled in supplier");
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.CommonAccountSupplier));
			Assert.assertTrue(DenySupplier_OR.CommonAccountSupplier.isDisplayed());
		}
		else if(options.equals("Customer Profile")) {
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.CustomerProfilePage));
			Assert.assertTrue(DenySupplier_OR.CustomerProfilePage.isDisplayed());
		}
		else if(options.equals("UnBlock Accept")) {
			wait.until(ExpectedConditions.elementToBeClickable(BlockAndUnblockPage_OR.UnBlocking));
			Assert.assertTrue(BlockAndUnblockPage_OR.UnBlocking.isDisplayed());
		}

		else if(options.equals("Call Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(BlockAndUnblockPage_OR.CallSupplier));
			Assert.assertTrue(BlockAndUnblockPage_OR.CallSupplier.isDisplayed());
		} 
		else if(options.equals("Call Customer")) {
			wait.until(ExpectedConditions.elementToBeClickable(BlockAndUnblockPage_OR.CallCustomer));
			Assert.assertTrue(BlockAndUnblockPage_OR.CallCustomer.isDisplayed());

		}
		else if(options.equals("Reminder Options")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Remind));

			WebElement element = driver.findElement(By.id("in.okcredit.merchant:id/reminder_action"));

			new TouchAction(driver).press(ElementOption.element(element))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SelectReminderType));
				Assert.assertTrue(TransactionPage_OR.ReminderPanelAmount.isDisplayed());
			}
			catch(Exception E) {
				Log.info("Add mobile number to send reminder");
			}
		}
		else if(options.equals("TrueCaller Popup")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrueCallerHeader));
			Assert.assertTrue(LandingPage_OR.TrueCallerHeader.isDisplayed());	
		}
		else if(options.equals("User details in truecaller popupp")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrucallerNumberandName));

			List<MobileElement> elementsList = driver.findElementsById("com.truecaller:id/text");
			String MerchantNumber= elementsList.get(0).getText();
			System.out.println("The choosen merchant in from trucaller is: " + MerchantNumber);

			String MerchantName= elementsList.get(1).getText();
			System.out.println("The choosen merchant in from trucaller is: " + MerchantName);
		}
		else if(options.equals("Existing Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberField));
			String MobileNumber = LandingPage_OR.MobileNumberField.getText();
			Log.info("The Mobile Number here : " + MobileNumber);
		}
		else if(options.equals("Successful Login")) {
			try {
				wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.NotNow)).isDisplayed();
				LandingPage_OR.NotNow.click();
				Log.info("The OTP is not arrived and user enter the OTP Manuallly");
				String Otp1 = "0";
				wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
				LandingPage_OR.OtpTextBox1.sendKeys(Otp1);
				LandingPage_OR.OtpTextBox2.sendKeys(Otp1);
				LandingPage_OR.OtpTextBox3.sendKeys(Otp1);
				LandingPage_OR.OtpTextBox4.sendKeys(Otp1);
				LandingPage_OR.OtpTextBox5.sendKeys(Otp1);
				LandingPage_OR.OtpTextBox6.sendKeys(Otp1);
				wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.VerifycationSuccess));

			}
			catch(Exception E) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Log.info("The Login is Successfull, Downloading the user data");
			}
		}
		else if(options.equals("Supplier Page")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.AddSupplier));
			Assert.assertTrue(SupplierPage_OR.AddSupplier.isDisplayed());
			//			int SupplierList = SupplierPage_OR.SupplierList.size();
			//			for(int i=0; i<=SupplierList-1; i++) {
			//				String SupplierListText= SupplierPage_OR.SupplierList.get(i).getText();
			//				Log.info("List of Sup[plier here");
			//				System.out.println(i+1 +" : "+SupplierListText);
			//				}
		}
		else if(options.equals("Contact List")) {
			try {

				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierEmptyText));
				Assert.assertTrue(SupplierPage_OR.SupplierEmptyText.isEnabled());
				String EmptyTEXT = SupplierPage_OR.SupplierEmptyText.getText();
				Log.info(EmptyTEXT+ " is available in Search");
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.ContactListHeader));
				Assert.assertTrue(SupplierPage_OR.ContactListHeader.isEnabled());
				SupplierPage_OR.ImportPhoneContacts.click();
			}

		}
		else if(options.equals("Supplier OK")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
			Assert.assertTrue(SupplierPage_OR.SupplierNameSubmitOk.isEnabled());
		}
		else if(options.equals("Supplier Mobile Number")) {
			wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.SupplierNameNumberTextBox));
			Assert.assertTrue(SupplierPage_OR.SupplierNameNumberTextBox.isEnabled());
		}
		else if(options.equals("Supplier Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.DeleteSupplier));

			String SupplierName = SupplierPage_OR.ContactsName.getText();
			System.out.println("Supplier Name : "+ SupplierName);
			SupplierNumber = SupplierPage_OR.ContactsNumber.getText();
			if(SupplierNumber.contains("Add Mobile Number")) {
				Log.info("The Supplier does not have mobile number");
			}
			else {
				System.out.println("Supplier Mobile number is : "+ SupplierNumber);
			}
		}
		else if(options.equals("Cannot Add Supplier Pop-Up")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.CannotAddSupplier));
			Assert.assertTrue(SupplierPage_OR.CannotAddSupplier.isEnabled());
		}
		else if(options.equals("Success message on Moving customer to Supplier")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovingSuccessful));
				Assert.assertTrue(SupplierPage_OR.MovingSuccessful.isDisplayed());
				SupplierPage_OR.Home.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovingFailed));
				Assert.assertTrue(SupplierPage_OR.MovingFailed.isDisplayed());
				SupplierPage_OR.Retry.click();
			}
		}
		else if(options.equals("Customer is moved to Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			String ExistingCustomerNumber = AddTransactionsStepDefinitions.SupplierNumber;
			HomePage_OR.SearchOrAddNext.sendKeys(ExistingCustomerNumber);
			String NewSupplier = SupplierPage_OR.SupplierListSingle.getText();
			Log.info("New Supplier here is : " + NewSupplier);
		}
		else if(options.equals("Delete Supplier Page")) {
			try {
			Thread.sleep(4000);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerName));
			Assert.assertTrue(CustomerPage_OR.CustomerName.isDisplayed());
			DeletedSuppliername= CustomerPage_OR.CustomerName.getText();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Password));
			Assert.assertTrue(CustomerPage_OR.Password.isDisplayed());
			}
			catch(Exception E) {
				Log.info("The customer has Due");
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SettlementWhileDeleteAccept));
				Assert.assertTrue(CustomerPage_OR.SettlementWhileDeleteAccept.isDisplayed());
				String remainingDue = CustomerPage_OR.SettlementWhileDeleteAccept.getText();
				Log.info("Remaining Payment :" + remainingDue);
				CustomerPage_OR.SettlementWhileDeleteAccept.click();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ButtonSubmit));
				CustomerPage_OR.ButtonSubmit.click();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.DeleteMessage));
				Assert.assertTrue(CustomerPage_OR.CustomerName.isDisplayed());
				DeleteName = CustomerPage_OR.CustomerName.getText();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Password));
				Assert.assertTrue(CustomerPage_OR.Password.isDisplayed());
			}
		}
		else if(options.equals("No Internet Connection")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.NoInternetConnection));
			Assert.assertTrue(SupplierPage_OR.NoInternetConnection.isDisplayed());
		}
		else if(options.equals("Delete Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.DeleteSupplier));
			Assert.assertTrue(SupplierPage_OR.DeleteSupplier.isDisplayed());
		}
		else if(options.equals("Search Result Customer")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			Assert.assertTrue(HomePage_OR.CustomerSearchList.isDisplayed());
			String resultName = HomePage_OR.CustomerSearchList.getText();
			Log.info("Searched Customer/Supplier here is :" + resultName);
		}
		else if(options.equals("No Contact Found")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoContactFoundMessage));
			Assert.assertTrue(HomePage_OR.NoContactFoundMessage.isDisplayed());
		}
		else if(options.equals("Sign Out Confirmation")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SignOutConfirmButton));
			Assert.assertTrue(HomePage_OR.SignOutConfirmButton.isDisplayed());
		}
		else if(options.equals("Verified User Pop Up")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.VerifiedMessage));
			Assert.assertTrue(CustomerPage_OR.VerifiedMessage.isDisplayed());
			String message = CustomerPage_OR.VerifiedMessage.getText();
			Log.info(message);
		}
		else if(options.equals("Account Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AccountMenu));
			Assert.assertTrue(HomePage_OR.AccountMenu.isDisplayed());
		}
		else if(options.equals("Account Menu Options")) {
			wait.until(ExpectedConditions.visibilityOf(AccountPage_OR.DownloadBackup));
			Assert.assertTrue(AccountPage_OR.DownloadBackup.isDisplayed());
		}
		else if(options.equals("PaymentStatus")) {
			wait.until(ExpectedConditions.visibilityOf(AccountPage_OR.Balance));
			Assert.assertTrue(AccountPage_OR.Balance.isDisplayed());

			String PaymemtType = AccountPage_OR.Balance.getText();
			Log.info("The Type of payment is "+ PaymemtType);

			String PaymemtAmount = AccountPage_OR.BalanceAmount.getText();
			Log.info("The Balance Due/Advance is " +PaymemtAmount);
		}
		else if(options.equals("Account Statements")) {
			wait.until(ExpectedConditions.visibilityOf(AccountPage_OR.AccountStatementHeader));
			Assert.assertTrue(AccountPage_OR.AccountStatementHeader.isDisplayed());

			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.DateRange));

			String AccountDuration = AccountPage_OR.DateRange.getText();
			Log.info("The Duration of the transaction is : "+ AccountDuration);

			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.totalAmount));

			String NetBalance = AccountPage_OR.totalAmount.getText();
			Log.info("The net Balance of the transaction is : "+ NetBalance);
			
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.TotalAmountLabel));

			String NetBalanceType = AccountPage_OR.TotalAmountLabel.getText();
			Log.info("The net Balance type of the transaction is : "+ NetBalanceType);
			
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.TotalPaymentCount));

			String PaymentsCount = AccountPage_OR.TotalPaymentCount.getText();
			Log.info("The total payment is : "+ PaymentsCount);
			
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.TotalPaymentAmount));

			String PaymentsAmount = AccountPage_OR.TotalPaymentAmount.getText();
			Log.info("The total payment amount is : "+ PaymentsAmount);

			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.TotalCreditCount));

			String CreditCount = AccountPage_OR.TotalCreditCount.getText();
			Log.info("The total Credit Count is : "+ CreditCount);

			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.Discount));

			String DiscountAmount = AccountPage_OR.DiscountAmount.getText();
			Log.info("The total DiscountAmount offered : "+ DiscountAmount);
		}
		else if(options.equals("Transactions Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.TransPageHeader));
			Assert.assertTrue(TransactionPage_OR.AddedAmountDetailsPage.isDisplayed());

			String Amonunt = TransactionPage_OR.AddedAmountDetailsPage.getText();
			Log.info("Amount in the details page is :" + Amonunt );
		}
		else if(options.equals("Money Transfer Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.MoneyTransfer));
			Assert.assertTrue(HomePage_OR.MoneyTransfer.isDisplayed());
		}
		else if(options.equals("Video about Money Transfer")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.VideoTitle));
			Assert.assertTrue(MoneyTransfer_OR.VideoTitle.isDisplayed());
			Log.info("Plying the Money Transfer Video");
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.VideoPlay));
			MoneyTransfer_OR.VideoPlay.click();
		}
		else if(options.equals("Add Bank Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.AddBankAccount));
			Assert.assertTrue(MoneyTransfer_OR.AddBankAccount.isDisplayed());
		}
		else if(options.equals("Account Number Text Box")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.AddAccountNumberTextBox));
			Assert.assertTrue(CollectionsPage_OR.AddAccountNumberTextBox.isDisplayed());
		}
		else if(options.equals("User enters only the Numbers in Account field")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.AddAccountNumberTextBox));
			CollectionsPage_OR.AddAccountNumberTextBox.sendKeys("abc");

			boolean status =CollectionsPage_OR.SubmitAccountNumber.isEnabled();
			System.out.println(status);
			if(status == false) {
				Log.info("User cannot enter text in Account Number field");
			}
			else {
				Log.info("User can enter the texts in Account Number field ");
			}
		}
		else if(options.equals("IFSC code Text Box")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.IFSCCodeTextBox));
			Assert.assertTrue(CollectionsPage_OR.IFSCCodeTextBox.isDisplayed());
		}
		else if(options.equals("Error Message for Wrong Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.InvalidAddress));
			Assert.assertTrue(CollectionsPage_OR.InvalidAddress.isDisplayed());
			String Error = CollectionsPage_OR.InvalidAddress.getText();
			Log.info(Error);
		}
		else if(options.equals("Error Message for Wrong IFSC")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.InvalidIFSC));
			Assert.assertTrue(CollectionsPage_OR.InvalidIFSC.isDisplayed());
			String Error = CollectionsPage_OR.InvalidIFSC.getText();
			Log.info(Error);
		}
		else if(options.equals("Validating Bank Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.ValidatingBankDetails));
			Assert.assertTrue(MoneyTransfer_OR.ValidatingBankDetails.isDisplayed());
		}
		else if(options.equals("Account Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.ConfirmBankDetailsHeader));
			Assert.assertTrue(CollectionsPage_OR.PaymentModeIcon.isDisplayed());

			String AccountHolderName = CollectionsPage_OR.AccountHolderName.getText();
			Log.info("Account Holder Name is : "+AccountHolderName);

			String AccountNumber = CollectionsPage_OR.AccountNumber.getText();
			Log.info("Account Holder number is : "+AccountNumber);

			String IFSC = CollectionsPage_OR.IFSCInValidationPage.getText();
			Log.info("Account IFSC : "+IFSC);

		}
		else if(options.equals("Send Money")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.SendMoney));
			Assert.assertTrue(MoneyTransfer_OR.SendMoney.isDisplayed());
		}
		else if(options.equals("Change Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.ChangeAccount));
			Assert.assertTrue(MoneyTransfer_OR.ChangeAccount.isDisplayed());
		}
		else if(options.equals("User cannot send money without adding Amount")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.SendMoney));
			boolean SendMoneyEnabled = MoneyTransfer_OR.SendMoney.isEnabled();
			if(SendMoneyEnabled == false) {
				Log.info("User cannot send money without adding amount");	
			}
			else{
				Log.info("User Added Amount to transfer");
			}
		}
		else if(options.equals("Payment Options")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayMentOptionBHIM));
			Assert.assertTrue(MoneyTransfer_OR.PayMentOptionBHIM.isDisplayed());
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayMentOptionDebitCard));
			Assert.assertTrue(MoneyTransfer_OR.PayMentOptionDebitCard.isDisplayed());
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayMentOptionNetbanking));
			Assert.assertTrue(MoneyTransfer_OR.PayMentOptionNetbanking.isDisplayed());

		}
		else if(options.equals("Amount In Payment Page")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.Amount));
			Assert.assertTrue(MoneyTransfer_OR.Amount.isDisplayed());
			String Amount =MoneyTransfer_OR.Amount.getText();
			Log.info("Entered amount is : " + Amount);
		}
		else if(options.equals("Give Discount Option")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.GiveDiscount));
			Assert.assertTrue(TransactionPage_OR.GiveDiscount.isEnabled());
		}
		else if(options.equals("Submit Discount")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
				Assert.assertTrue(TransactionPage_OR.PaymentSubmit.isEnabled());
			}
			catch(Exception E) {
				Log.info("Submit Discount button is not enabled");
			}
		}
		else if(options.equals("Discount Offered CTA")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DiscountOfferedHeader));
			Assert.assertTrue(TransactionPage_OR.DiscountOfferedHeader.isEnabled());
		}
		else if(options.equals("Discount SMS Status")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DiscountSMSDetails));
			Assert.assertTrue(TransactionPage_OR.DiscountSMSDetails.isEnabled());

			String SmsStatus = TransactionPage_OR.DiscountSMSDetails.getText();
			Log.info(SmsStatus);
		}
		else if(options.equals("Discount Offered Amount")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddedAmountDetailsPage));
			Assert.assertTrue(TransactionPage_OR.AddedAmountDetailsPage.isEnabled());

			String amount = TransactionPage_OR.AddedAmountDetailsPage.getText();
			Log.info("The merchant given the discount of : " + amount);
		}
		else if(options.equals("Discount Added time")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DiscountAddedDetails));
			Assert.assertTrue(TransactionPage_OR.DiscountAddedDetails.isEnabled());

			String time = TransactionPage_OR.DiscountAddedDetails.getText();
			Log.info("The merchant given the discount on : " + time);
		}
		else if(options.equals("Delete Discount")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletePayment));
			Assert.assertTrue(TransactionPage_OR.DeletePayment.isEnabled());
		}
		else if(options.equals("Deleted Discount")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DiscountDeleted));
			Assert.assertTrue(TransactionPage_OR.DiscountDeleted.isEnabled());
		}	
		else if(options.equals("Deleted Discount Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DiscountDeleted));
			Assert.assertTrue(TransactionPage_OR.DiscountDeleted.isEnabled());
			TransactionPage_OR.DiscountDeleted.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletedDateDiscount));
			Assert.assertTrue(TransactionPage_OR.DeletedDateDiscount.isDisplayed());

			String Deletedtime = TransactionPage_OR.DeletedDateDiscount.getText();
			Log.info("The merchant given the discount on : " + Deletedtime);
		}
		else if(options.equals("Discount Offered Section")) {
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.DISCOUNTSOFFERED));
			Assert.assertTrue(AccountPage_OR.DISCOUNTSOFFERED.isEnabled());
		}
		else if(options.equals("Total Discount Offered Amount")) {
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.TotalDiscountAmount));
			Assert.assertTrue(AccountPage_OR.TotalDiscountAmount.isEnabled());

			String totalAmount = AccountPage_OR.TotalDiscountAmount.getText();
			Log.info("Total discount offerred by the merchant : "+totalAmount );
		}
		else if(options.equals("Number of Discount Offered")) {
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.TotalDiscountAmount));

			int length = AccountPage_OR.DiscountOfferedHeader.size();
			Log.info("The Number of active discounts added by the merchant : "+length);

		}
		else if(options.equals("Balance Due CTA")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.BalanceDue));
				Assert.assertTrue(TransactionPage_OR.BalanceDue.isEnabled());

				String balanceDue = TransactionPage_OR.TotalAmountBottomBar.getText();
				Log.info("Total due is : " + balanceDue);
			}
			catch(Exception E) {
				Log.info("Balance due CTA is not available");
			}
		}
		else if(options.equals("Remind")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Remind));
			Assert.assertTrue(TransactionPage_OR.Remind.isEnabled());
		}
		else if(options.equals("Due date CTA")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SelectCollectionDate));
			Assert.assertTrue(TransactionPage_OR.SelectCollectionDate.isEnabled());
		}
		else if(options.equals("Reminder date in Due date CTA")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DueDate));
			Assert.assertTrue(TransactionPage_OR.DueDate.isEnabled());
			Log.info("Current Date : "+ CF.GetCurrentDate() );
			String Date = TransactionPage_OR.DueDate.getText();
			Log.info("Selected Due date = " + Date);
		}
		else if(options.equals("Reminder message in WhatsApp")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppCaption));
				Assert.assertTrue(TransactionPage_OR.WhatsAppCaption.isEnabled());

				String reminderMessage = TransactionPage_OR.WhatsAppCaption.getText();
				Log.info(reminderMessage);
			}
			catch(Exception E) {
				Log.info("Whatsapp is not installed. Hence cannot share the message");
			}
			
		}
		else if(options.equals("Collect the Reminder in Home page")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CollectOn));
			Assert.assertTrue(HomePage_OR.CollectOn.isEnabled());
		}
		else if(options.equals("Collection")) {
			wait.until(ExpectedConditions.visibilityOf(HomePage_OR.Collections));
			Assert.assertTrue(HomePage_OR.Collections.isEnabled());
		}
		else if(options.equals("UPI ID Text Box")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.AddBankDetailsTitle));
			Log.info(CollectionsPage_OR.AddPaymentDescription.getText());
			Assert.assertTrue(CollectionsPage_OR.UPIIDTextBox.isEnabled());
		}
		else if(options.equals("QR Code icon")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.QRSccannerIcon));
			Assert.assertTrue(CollectionsPage_OR.QRSccannerIcon.isEnabled());
		}
		else if(options.equals("UPI Options")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.UPILogos));
			Assert.assertTrue(CollectionsPage_OR.UPILogos.isEnabled());
		}
		else if(options.equals("Error message for wrong UPI")) {
			Assert.assertTrue(CollectionsPage_OR.InvalidAddress.isEnabled());
			Log.info(CollectionsPage_OR.InvalidAddress.getText());
		}
		else if(options.equals("UPI Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.ConfirmBankDetailsHeader));
			Assert.assertTrue(CollectionsPage_OR.PaymentModeIcon.isEnabled());

			String AccountName = CollectionsPage_OR.AccountHolderName.getText();
			Log.info("Account Holder Name is : "+AccountName);

			String UPIID = CollectionsPage_OR.IFSCInValidationPage.getText();
			Log.info("Account Holder UPI ID is : "+UPIID);
		}

		else if(options.equals("Merchant Collection Page")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.MerchantQRCode));
			Assert.assertTrue(CollectionsPage_OR.MerchantQRCode.isDisplayed());
			String accountType = CollectionsPage_OR.MerchantNumberandUPIinQRPage.getText();

			if(accountType.contains("@ybl")) {
				Log.info("User is Added by UPI Method");
			}
			else {
				Log.info("User is Added by Account");
			}
		}
		else if(options.equals("Delete Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.DeleteAccount));
			Assert.assertTrue(CollectionsPage_OR.DeleteAccount.isEnabled());
		}
		else if(options.equals("Share")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.ShareQR));
			Assert.assertTrue(CollectionsPage_OR.ShareQR.isEnabled());
		}
		else if(options.equals("Save")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SaveQR));
			Assert.assertTrue(CollectionsPage_OR.SaveQR.isEnabled());
		}
		else if(options.equals("QR Code Saved")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.FileSavedSuccesFully));
			Assert.assertTrue(CollectionsPage_OR.FileSavedSuccesFully.isEnabled());
		}
		else if(options.equals("Filter in Statement")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.AllTransaction));
			Assert.assertTrue(CollectionsPage_OR.AllTransaction.isEnabled());
		}
		else if(options.equals("Online Statements")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.DateRangeinCollectionStatement));
			Assert.assertTrue(CollectionsPage_OR.DateRangeinCollectionStatement.isEnabled());
			try {
				Assert.assertTrue(CollectionsPage_OR.YouDontHaveAnyTransaction.isEnabled());
				Log.info("No Online Transactions made till now");
			}
			catch(Exception E) {
				Log.info("Transactions are made");
			}
		}
		else if(options.equals("Update Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.UpdateBankUPI));
			Assert.assertTrue(CollectionsPage_OR.UpdateBankUPI.isEnabled());
		}
		else if(options.equals("Update Account CTA")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.UpdateUPIHeader));
			Assert.assertTrue(CollectionsPage_OR.UPIDetailID.isEnabled());
			Log.info("Current Account Details : "+ CollectionsPage_OR.UPIDetailID.getText());
			Log.info(CollectionsPage_OR.UpateDescription.getText());
		}
		else if(options.equals("Filter Options")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.FilterHeader));
			Assert.assertTrue(HomePage_OR.Today.isEnabled());
			Assert.assertTrue(HomePage_OR.Pending.isEnabled());
			Assert.assertTrue(HomePage_OR.UpComingDue.isEnabled());

		}
		else if(options.equals("Selected Sort Options")) {
			String Checked = HomePage_OR.SortName.getAttribute("Checked");
			System.out.println(Checked);

			if(Checked.equals("true")) 
			{
				Log.info("Customer list is sorted by Name");
			}
			else if(HomePage_OR.SortAmount.getAttribute("Checked").equals("true"))
			{
				Log.info("Customer list is sorted by Amount");
			}
			else if(HomePage_OR.SortLatest.getAttribute("Checked").equals("true"))
			{
				Log.info("Customer list is sorted by Latest Items");
			}
		}
		else if(options.equals("Number of Filters Active")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.FilterCount));
			Assert.assertTrue(HomePage_OR.FilterCount.isEnabled());
		}
		else if(options.equals("Clear Filters")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ClearInFilters));
			Assert.assertTrue(HomePage_OR.ClearInFilters.isEnabled());
		}
		else if(options.equals("Results by Filter Today")) {
			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.DueInfo));
				Assert.assertTrue(HomePage_OR.DueInfo.isEnabled());
				String DueStatus = HomePage_OR.DueInfo.getText();
				Log.info("Due Status for the customer is : " +DueStatus);

				List<MobileElement> element = driver.findElementsById("in.okcredit.merchant:id/due_info");
				Log.info("No of results appeared by applying the filter is " + element.size());
			}
			catch (Exception E){
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoResultsFound));
				Assert.assertTrue(HomePage_OR.NoResultsFound.isEnabled());
				Log.info("No due from Customers for today");
			}
		}
		else if(options.equals("Clear Filters")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchListlist.get(0)));
			int size =HomePage_OR.CustomerSearchListlist.size();
			Log.info("No of results appeared by removing the filter is " + size);

		}
		else if(options.equals("Pending Collections")) {
			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.PendingCollection));
				Assert.assertTrue(HomePage_OR.PendingCollection.isEnabled());
			}
			catch (Exception E){
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoResultsFound));
				Assert.assertTrue(HomePage_OR.NoResultsFound.isEnabled());
				Log.info("No due from Customers for today");
			}
		}
		else if(options.equals("Results by Filter Pending Today")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.PendingCollection));
			Assert.assertTrue(HomePage_OR.PendingCollection.isEnabled());
			Dimension size =HomePage_OR.PendingCollection.getSize();
			Log.info("No of results appeared by applying the Pending filter is " + size);
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoResultsFound));
				Assert.assertTrue(HomePage_OR.NoResultsFound.isEnabled());
				Log.info("No due from Customers for today");
			}
		}
		else if(options.equals("Amount Sort in Customer List")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Balance));
			Assert.assertTrue(HomePage_OR.Balance.isEnabled());
			String Amount = HomePage_OR.Balance.getText();
			Log.info("Due Amount for the first customer in the List is : " + Amount);
		}
		else if(options.equals("Results by Filter Upcoming")) {
			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.DueInfo));
				Assert.assertTrue(HomePage_OR.DueInfo.isEnabled());
				String DueStatus = HomePage_OR.DueDatenfo.getText();
				Log.info("Due Date for the Selected customer is : " +DueStatus);

				List<MobileElement> element = driver.findElementsById("in.okcredit.merchant:id/due_date_info");
				Log.info("No of results appeared by applying the filter is " + element.size());
			}
			catch (Exception E){
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoResultsFound));
				Assert.assertTrue(HomePage_OR.NoResultsFound.isEnabled());
				Log.info("No due from Customers for today");
			}
		}
		else if(options.equals("Results by all Filter")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.FilterCount));
			String totalFilter ="3";
			if(HomePage_OR.FilterCount.getText().equals(totalFilter)){
				Log.info("All Three filters are applied");
			}
			else {
				Log.info("Filters are not applied properly");
			}
		}
		else if(options.equals("Sort Options")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SortName));
			Assert.assertTrue(HomePage_OR.SortName.isEnabled());
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SortAmount));
			Assert.assertTrue(HomePage_OR.SortAmount.isEnabled());
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SortLatest));
			Assert.assertTrue(HomePage_OR.SortLatest.isEnabled());
		}
		else if(options.equals("Result Sorted by Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomeNameList));
			Assert.assertTrue(HomePage_OR.CustomeNameList.isEnabled());

			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/name_text_view");

			String FirstCustomer = elementsList.get(0).getText();
			Log.info("First customer name in the list is : "+ FirstCustomer );

		}
		else if(options.equals("Result Sorted by Amount")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Balance));
			Assert.assertTrue(HomePage_OR.CustomeNameList.isEnabled());

			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/tvBalance");

			String FirstCustomerDue = elementsList.get(0).getText();
			Log.info("First customer Due in the list is : "+ FirstCustomerDue );

		}
		else if(options.equals("Result Sorted by Latest")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomeNameList));

			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/name_text_view");
			ExistingCustomer= elementsList.get(1).getText();
			System.out.println("First Customer name after filtering Latest:" + ExistingCustomer);
		}
		else if(options.equals("Supplier Payment Buttons")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CreditButton));
			Assert.assertTrue(TransactionPage_OR.CreditButton.isEnabled());
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentButton));
			Assert.assertTrue(TransactionPage_OR.PaymentButton.isEnabled());
		}
		else if(options.equals("Pay Online")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PayOnline));
			Assert.assertTrue(TransactionPage_OR.PayOnline.isEnabled());
		}
		else if(options.equals("Error message for Existing Number")) {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.InvalidMobileNumber));
			Assert.assertTrue(CustomerPage_OR.InvalidMobileNumber.isEnabled());
			
			String ErrorMessage = CustomerPage_OR.InvalidMobileNumber.getText();
			Log.info("The Mobile Number "+data.CustomerNumberDelete +" is " + ErrorMessage);
		}
		else if(options.equals("Take Credit")) {
				wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.CreditButton));
				Assert.assertTrue(TransactionPage_OR.CreditButton.isEnabled());
		}
		else if(options.equals("Credit")) {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CreditButton));
				Assert.assertTrue(TransactionPage_OR.CreditButton.isEnabled());
		}
		else if(options.equals("Give Payment")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentButton));
			Assert.assertTrue(TransactionPage_OR.PaymentButton.isEnabled());
		}
		else if(options.equals("Payment")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentButton));
			Assert.assertTrue(TransactionPage_OR.PaymentButton.isEnabled());
		}
		else if(options.equals("Supplier Account Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierAccountName));
			Assert.assertTrue(SupplierPage_OR.SupplierAccountName.isEnabled());
			Log.info("Supplier Account Name is : "+SupplierPage_OR.SupplierAccountName.getText());
			Log.info("Supplier Account Number/ UPI ID is : "+SupplierPage_OR.SupplierAccountnumber.getText());
			
			}
		else if(options.equals("Error message for Credit Card")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.CreditCardErrorMessage));
			Assert.assertTrue(MoneyTransfer_OR.CreditCardErrorMessage.isEnabled());
			String message = MoneyTransfer_OR.CreditCardErrorMessage.getText();
			Log.info(message);
		}
		else if(options.equals("Error message for Expire Date")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.CreditCardErrorMessage));
			Assert.assertTrue(MoneyTransfer_OR.CreditCardErrorMessage.isEnabled());
			String message = MoneyTransfer_OR.CreditCardErrorMessage.getText();
			Log.info(message);
		}
		else if(options.equals("Error message for Card Holder name")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.EnterValidCusomerName));
			Assert.assertTrue(MoneyTransfer_OR.EnterValidCusomerName.isEnabled());
			String message = MoneyTransfer_OR.EnterValidCusomerName.getText();
			Log.info(message);
		}
		else if(options.equals("Error message for CVV")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.ErrorMessageForCVV));
			Assert.assertTrue(MoneyTransfer_OR.ErrorMessageForCVV.isEnabled());
			String message = MoneyTransfer_OR.ErrorMessageForCVV.getText();
			Log.info(message);
		}
		else if(options.equals("Error message for Card Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.ErrorMessageCardNumber));
			Assert.assertTrue(MoneyTransfer_OR.ErrorMessageCardNumber.isEnabled());
			String message = MoneyTransfer_OR.ErrorMessageCardNumber.getText();
			Log.info(message);
		}
		else if(options.equals("Error message for AMEX Card Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.ErrorMessageForCVV));
			Assert.assertTrue(MoneyTransfer_OR.ErrorMessageForCVV.isEnabled());
			String message = MoneyTransfer_OR.ErrorMessageForCVV.getText();
			Log.info(message);
		}
		else if(options.equals("Error message for DinersClub Card Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.ErrorMessageCardNumber));
			Assert.assertTrue(MoneyTransfer_OR.ErrorMessageCardNumber.isEnabled());
			String message = MoneyTransfer_OR.ErrorMessageCardNumber.getText();
			Log.info(message);
		}
		else if(options.equals("Bank List")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.SBIBank));
			Assert.assertTrue(MoneyTransfer_OR.SBIBank.isEnabled());
			String message = MoneyTransfer_OR.SBIBank.getText();
			Log.info("First Bank in the Page" + message);
			
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.HDFCBank));
			Assert.assertTrue(MoneyTransfer_OR.HDFCBank.isEnabled());
			
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.ICICIBank));
			Assert.assertTrue(MoneyTransfer_OR.ICICIBank.isEnabled());
			
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.AxisBank));
			Assert.assertTrue(MoneyTransfer_OR.AxisBank.isEnabled());
		}
		else if(options.equals("All Bank List")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.Allbanks));
			Assert.assertTrue(MoneyTransfer_OR.Allbanks.isEnabled());
			
//			int Size = MoneyTransfer_OR.BankListOthers.size();
//			Log.info("List of Bank displyed in the page is" + Size);
//			
//			for(int i=0;i>=Size; i++) {
//				
//				System.out.println("Bank List is in the First Page : ");
//				System.out.println(i +" : " + MoneyTransfer_OR.BankListOthers.get(i).getText());
//			}
		}
		else if(options.equals("Selected Bank Home Page")) {
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Log.info("Selected Bank Page will be open in a while Be Patient");
		}
		else if(options.equals("Merchant Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantName));
			Assert.assertTrue(MerchantProfilePage_OR.MerchantName.isDisplayed());
			String MerchantName = MerchantProfilePage_OR.MerchantName.getText();
			Log.info("Merchant Name : " + MerchantName);
		}
		else if(options.equals("Merchant Profile Picture")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantProfilePicture));
			Assert.assertTrue(MerchantProfilePage_OR.MerchantProfilePicture.isEnabled());
		}
		else if(options.equals("Merchant Business Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessName));
			Assert.assertTrue(MerchantProfilePage_OR.BusinessName.isEnabled());
			
			String MerchantBusinessName = MerchantProfilePage_OR.BusinessName.getText();
			
			if(MerchantBusinessName.isEmpty()) {
				Log.info("Merchant did not added Mobile Number");
			}
			else{
				Log.info("Merchant Name : " + MerchantBusinessName);
			}
			
		}
		else if(options.equals("Merchant Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantMobileNumber));
			Assert.assertTrue(MerchantProfilePage_OR.MerchantMobileNumber.isEnabled());
			
			String Merchantmobile = MerchantProfilePage_OR.MerchantMobileNumber.getText();
			Log.info("Merchant Mobile Number : " + Merchantmobile);
		}
		else if(options.equals("Merchant Business Type")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessType));
			Assert.assertTrue(MerchantProfilePage_OR.BusinessType.isEnabled());
			
			String BusinessType = MerchantProfilePage_OR.BusinessType.getText();
			if(BusinessType.isEmpty()) {
				Log.info("Merchant did not added Business Type");
			}
			else{
			Log.info("Merchant Busniess Type : " + BusinessType);
			}
		}
		else if(options.equals("Merchant Business Category")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Category));
			Assert.assertTrue(MerchantProfilePage_OR.Category.isEnabled());
			
			String BusinessCategory = MerchantProfilePage_OR.Category.getText();
			if(BusinessCategory.isEmpty()) {
				Log.info("Merchant did not added Business Category");
			}
			else{
			Log.info("Merchant Busniess Category : " + BusinessCategory);
			}
		}
		else if(options.equals("Merchant Business Address")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantAddress));
			Assert.assertTrue(MerchantProfilePage_OR.MerchantAddress.isEnabled());
			
			String MerchantAddress = MerchantProfilePage_OR.MerchantAddress.getText();
			if(MerchantAddress.isEmpty()) {
				Log.info("Merchant did not added Business Address");
			}
			else{
			Log.info("Merchant Busniess Address : " + MerchantAddress);
			}
		}
		else if(options.equals("Merchant Other Info")) {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			CF.scrollToText("Share your business Card", driver);
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.OtherINfo));
			Assert.assertTrue(MerchantProfilePage_OR.OtherINfo.isEnabled());
			
			MerchantProfilePage_OR.OtherINfo.click();
			
			CF.scrollToText("Share your business Card", driver);
			
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantEmail));
			Assert.assertTrue(MerchantProfilePage_OR.MerchantEmail.isEnabled());
			
			String MerchantEmail = MerchantProfilePage_OR.MerchantEmail.getText();
			if(MerchantEmail.isEmpty()) {
				Log.info("Merchant did not added Email");
			}
			else{
			Log.info("Merchant Email Address : " + MerchantEmail);
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.AboutBusiness));
			Assert.assertTrue(MerchantProfilePage_OR.AboutBusiness.isEnabled());
			
			String AboutBusiness = MerchantProfilePage_OR.AboutBusiness.getText();
			if(AboutBusiness.isEmpty()) {
				Log.info("Merchant did not added Business Info");
			}
			else{
			Log.info("Merchant Busniess Info : " + AboutBusiness);
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.ContactPersonName));
			Assert.assertTrue(MerchantProfilePage_OR.ContactPersonName.isEnabled());
			
			String ContactPerson = MerchantProfilePage_OR.ContactPersonName.getText();
			if(ContactPerson.isEmpty()) {
				Log.info("Merchant did not added Business Contact Person");
			}
			else{
			Log.info("Merchant Busniess Contact Person Name : " + ContactPerson);
			}
		}
		else if(options.equals("Merchant Business Card")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.ShareBusinessCard));
			Assert.assertTrue(MerchantProfilePage_OR.ShareBusinessCard.isEnabled());
		}
		else if(options.equals("Merchant Profile")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerName));
			Assert.assertTrue(CustomerPage_OR.CustomerName.isEnabled());
			Log.info("Merchant Name : " + CustomerPage_OR.CustomerName.getText());
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.VerifiedIcon));
			Assert.assertTrue(CustomerPage_OR.VerifiedIcon.isEnabled());
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
			Assert.assertTrue(CustomerPage_OR.MobileNumber.isEnabled());
			Log.info("Merchant Mobile Number : " + CustomerPage_OR.MobileNumber.getText());
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddress));
			Assert.assertTrue(CustomerPage_OR.CustomerAddress.isEnabled());
			Log.info("Merchant Address : " + CustomerPage_OR.CustomerAddress.getText());
			
			CustomerPage_OR.CustomerAddress.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.VerifiedUser));
			Assert.assertTrue(CustomerPage_OR.VerifiedUser.isEnabled());
			Log.info("Merchant is verified. so , cannot modify the details.");
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.VerifiedMessage));
			Log.info(CustomerPage_OR.VerifiedMessage.getText());
			
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.GotIt));
			CustomerPage_OR.GotIt.click();
		}
		else if(options.equals("Merchant Business Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessName));
			Assert.assertTrue(MerchantProfilePage_OR.BusinessName.isEnabled());
			String BusinessName = MerchantProfilePage_OR.BusinessName.getText();
			Log.info("Merchant Business Name : " + BusinessName);
		}
		else if(options.equals("Business Category")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.CategoryItems));
			Assert.assertTrue(MerchantProfilePage_OR.CategoryItems.isEnabled());
			driver.hideKeyboard();
			List<MobileElement> category =  driver.findElements(By.id("in.okcredit.merchant:id/category_title"));
			Log.info("Available categories : " + category.size());
			
			for(int i=0; i<=category.size()-1; i++) {
				System.out.println( "Category List : " +i + " : " + category.get(i).getText());
			}
		}
		else if(options.equals("Sync status")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SyncStatusDetailsPage));
			Assert.assertTrue(TransactionPage_OR.SyncStatusDetailsPage.isEnabled());
		}
		else if(options.equals("Sync status In Home Page")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SyncStatus));
			Assert.assertTrue(HomePage_OR.SyncStatus.isEnabled());
			try {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.UnSyncedTransactions));
				Assert.assertTrue(HomePage_OR.UnSyncedTransactions.isEnabled());
				Log.info(HomePage_OR.UnSyncedTransactions.getText());
			}
			catch(Exception E) {
				Log.info("There is no Unsynced Transaction Available");
			}
		}
		else if(options.equals("Sync status In Supplier Page")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SyncStatusInSupplier));
			Assert.assertTrue(HomePage_OR.SyncStatusInSupplier.isEnabled());
			try {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.UnSyncedTransactions));
				Assert.assertTrue(HomePage_OR.UnSyncedTransactions.isEnabled());
				Log.info(HomePage_OR.UnSyncedTransactions.getText());
			}
			catch(Exception E) {
				Log.info("There is no Unsynced Transaction Available");
			}
		}
		else if(options.equals("Rewards Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Rewards));
			Assert.assertTrue(HomePage_OR.Rewards.isEnabled());
		}
		else if(options.equals("Help Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.Help));
			Assert.assertTrue(HelpPage_OR.Help.isDisplayed());
		}
		else if(options.equals("Share Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ShareMenu));
			Assert.assertTrue(HomePage_OR.ShareMenu.isDisplayed());
		}
		else if(options.equals("About Us")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AboutUs));
			Assert.assertTrue(HomePage_OR.AboutUs.isDisplayed());
		}
		else if(options.equals("Home Delivery")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.HomeDelivery));
			Assert.assertTrue(HomePage_OR.HomeDelivery.isDisplayed());
		}
		else if(options.equals("Mobile Recharge")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.MobilePrepaidRecharge));
			Assert.assertTrue(HomePage_OR.MobilePrepaidRecharge.isDisplayed());
		}
		else if(options.equals("Insurance")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Insurance));
			Assert.assertTrue(HomePage_OR.Insurance.isDisplayed());
		}
		else if(options.equals("Privacy Policy")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.PrivacyPolicy));
			Assert.assertTrue(HomePage_OR.PrivacyPolicy.isDisplayed());
		}
		else if(options.equals("Rate Us")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.RateUs));
			Assert.assertTrue(HomePage_OR.RateUs.isDisplayed());
		}
		else if(options.equals("Internet Required Error Message")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.INternetRequiredMessage));
			Assert.assertTrue(CustomerPage_OR.INternetRequiredMessage.isDisplayed());
			Log.info(CustomerPage_OR.INternetRequiredMessage.getText());
		}
		else if(options.equals("Reminder Call")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CallIcon));
			Assert.assertTrue(TransactionPage_OR.CallIcon.isDisplayed());
		}
		else if(options.equals("Reminder Whatsapp")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsappReminderIcon));
			Assert.assertTrue(TransactionPage_OR.WhatsappReminderIcon.isDisplayed());
		}
		else if(options.equals("Password field for Transactions")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.EnterPassword));
			Assert.assertTrue(TransactionPage_OR.EnterPassword.isDisplayed());
		}
		else if(options.equals("Reminder in Whatsapp")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ReminderToast));
			Assert.assertTrue(TransactionPage_OR.ReminderToast.isDisplayed());
			Log.info(TransactionPage_OR.ReminderToast.getText());
			}
			catch(Exception E) {
				if(TransactionPage_OR.FrequentlyContacted.isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.FrequentlyContacted));
				Assert.assertTrue(TransactionPage_OR.FrequentlyContacted.isDisplayed());
				}
				else {
					Log.info("Whatsapp Not Installed");
				}
			}
		}
		else if(options.equals("Creating Report")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CreatingReport));
				Assert.assertTrue(TransactionPage_OR.CreatingReport.isDisplayed());
			}
			catch(Exception E) {
				
				Log.info("Statement opened already or Downloaded");
			}
		}
		else if(options.equals("Download Report Success")) {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.FileDownloadedSuccessfully));
				Assert.assertTrue(TransactionPage_OR.FileDownloadedSuccessfully.isDisplayed());
				
			}
		else if(options.equals("Date Range")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SelectedDateRange));
			Assert.assertTrue(TransactionPage_OR.SelectedDateRange.isDisplayed());
			Log.info(TransactionPage_OR.SelectedDateRange.getText());
		}
		else if(options.equals("Share Report")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.share_report));
			Assert.assertTrue(TransactionPage_OR.share_report.isDisplayed());
		}
		else if(options.equals("Transaction Status")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleveredStatus));
			Assert.assertTrue(TransactionPage_OR.DeleveredStatus.isDisplayed());
		}
		else if(options.equals("Chat Icon")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.chat));
			Assert.assertTrue(CustomerPage_OR.chat.isDisplayed());
		}
		else if(options.equals("Chat Message")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ChatMessageSent));
			Assert.assertTrue(CustomerPage_OR.ChatMessageSent.isDisplayed());
			String msg = CustomerPage_OR.ChatMessageSent.getText();
			Log.info(msg);
		}
		else if(options.equals("Chat Message Status")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ChatStatus));
			Assert.assertTrue(CustomerPage_OR.ChatStatus.isDisplayed());
			
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ChatDate));
			Assert.assertTrue(CustomerPage_OR.ChatDate.isDisplayed());
			
			String chatTime = CustomerPage_OR.ChatDate.getText();
			Log.info("Recent Chat time : " + chatTime);
		}
		else if(options.equals("Existing Chat messages")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ChatMessageSent));
			Assert.assertTrue(CustomerPage_OR.ChatMessageSent.isDisplayed());
			String msg = CustomerPage_OR.ChatMessageSent.getText();
			Log.info(msg);
		}	
		else if(options.equals("Total Collection")) {
			wait.until(ExpectedConditions.elementToBeClickable(LinkPay_OR.TotalOnlineCollection));
			Assert.assertTrue(LinkPay_OR.TotalOnlineCollection.isDisplayed());
			String msg = LinkPay_OR.TotalBalance.getText();
			Log.info("Total Online Collection : "+ msg);
		}
	}
	@And("^Verify \"([^\"]*)\" Field$")
	public void verify_field(String Field) {
		if(Field.equals("Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AddCustomerNumberField));
			Assert.assertTrue(HomePage_OR.AddCustomerNumberField.isEnabled());
		}
		else if(Field.equals("Other Info")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantEmail));
			Assert.assertTrue(MerchantProfilePage_OR.MerchantEmail.isEnabled());
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.AboutBusiness));
			Assert.assertTrue(MerchantProfilePage_OR.AboutBusiness.isEnabled());
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.ContactPersonName));
			Assert.assertTrue(MerchantProfilePage_OR.ContactPersonName.isEnabled());
		}
	}
	@And("^Navigate to \"([^\"]*)\"$")
	public void navigate_to_page(String Page) {
		if(Page.equals("Customer Profile")) {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.AddedCustomerHeader));
			CustomerPage_OR.AddedCustomerHeader.click();
		}
		if(Page.equals("Supplier Profile")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameProfileHeader));
			SupplierPage_OR.SupplierNameProfileHeader.click();
		}
		if(Page.equals("Merchant Profile")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantNameinShare));
			MerchantProfilePage_OR.MerchantNameinShare.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantNumber));
				MerchantProfilePage_OR.MerchantNumber.click();
			}
		}
		if(Page.equals("New Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierListSingle));
			SupplierPage_OR.SupplierListSingle.click();
		}
	}
	@And("^Verify user \"([^\"]*)\" add the customer$")
	public void user_adds_customer(String option) {
		if(option.equals("not able to")) {
//			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerNameSubmitButton));
//			HomePage_OR.CustomerNameSubmitButton.click();

			SoftAssert softAssert = new SoftAssert();
			softAssert.assertFalse(HomePage_OR.CustomerNameSubmitButton.isEnabled());
		}
	}
	@And("^User enters the \"([^\"]*)\" with \"([^\"]*)\"$")
	public void user_enters_the_customer_details_with_data(String data1 , String data2) {
		if(data1.equals("Customer Name") && data2.equals("100 Letters")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.InputCustomerName));
			HomePage_OR.InputCustomerName.click();
			HomePage_OR.InputCustomerName.sendKeys(customerName100Char);

		}
		if(data1.equals("Customer Name") && data2.equals("Existing Customer Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ContactList));

			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/name");
			ExistingCustomerName= elementsList.get(1).getText();
			System.out.println("One of the Customer here is :" + ExistingCustomerName);

			HomePage_OR.InputCustomerName.click();
			HomePage_OR.InputCustomerName.sendKeys(ExistingCustomerName);

		}
		if(data1.equals("Customer Name") && data2.equals("New Customer Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.InputCustomerName));
			HomePage_OR.InputCustomerName.click();
			HomePage_OR.InputCustomerName.sendKeys("Customer"+CustomerName);

		}
		if(data1.equals("Customer Number") && data2.equals("Existing Customer Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AddCustomerNumberField));
			HomePage_OR.AddCustomerNumberField.sendKeys("Customer"+customerNumber);
		}
		if(data1.equals("Customer Name") && data2.equals("Deleted Customer Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.InputCustomerName));
			HomePage_OR.InputCustomerName.click();
			HomePage_OR.InputCustomerName.sendKeys(DeletedCustomer);
		}
		if(data1.equals("Customer Number") && data2.equals("8 Digits")) {

			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.InputCustomerName));
			HomePage_OR.AddCustomerNumberField.click();
			HomePage_OR.AddCustomerNumberField.sendKeys(CustomerNumber8Digit);
		}
		if(data1.equals("Customer Number") && data2.equals("12 Digits")) {

			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.InputCustomerName));
			HomePage_OR.AddCustomerNumberField.click();
			HomePage_OR.AddCustomerNumberField.sendKeys(CustomerNumber12Digit);
		}
		if(data1.equals("Customer Name") && data2.equals("Invalid Customer Name")) {

			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.InputCustomerName));
			HomePage_OR.InputCustomerName.click();
			HomePage_OR.InputCustomerName.sendKeys(CustomerName);
		}
		if(data1.equals("Customer Number") && data2.equals("Invalid Customer Number")) {

			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AddCustomerNumberField));
			HomePage_OR.AddCustomerNumberField.click();
			HomePage_OR.AddCustomerNumberField.sendKeys(CustomerName);
		}
		if(data1.equals("Supplier Name") && data2.equals("Existing Supplier Name")) {

			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
			SupplierPage_OR.SupplierNameNumberTextBox.click();
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys("Test Supplier");
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierEmptyText));
			SupplierPage_OR.ClearSupplierName.click();
		}
		if(data1.equals("Debit Card Details") && data2.equals("Past Expire date")) {
			
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.Expiry));
			MoneyTransfer_OR.Expiry.click();
//			MoneyTransfer_OR.Expiry.clear();
			MoneyTransfer_OR.CardNumber.sendKeys(data.PastExpiry);
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.CardNumber));
			MoneyTransfer_OR.CardNumber.click();
			MoneyTransfer_OR.CardNumber.clear();
			MoneyTransfer_OR.CardNumber.sendKeys(data.DebitCardMasterCard);
			
		}
	}
	@And("^User Selects \"([^\"]*)\" in list$")
	public void user_selects_in_list(String Option) {
		if(Option.equals("Customer")) {

			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ContactList));
			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/mobile");

			int listofContacts = elementsList.size();
			Log.info("Listed contacts is : " + listofContacts);
			ContactList= elementsList.get(1).getText();
			System.out.println("One of the Contact here is :" + ContactList);
			elementsList.get(1).click();
			//			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerPagetoolbar));
		}
		else if (Option.equals("Filtered Customer")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.FilterdContact));
			HomePage_OR.FilterdContact.click();
		}
		else if (Option.equals("Existing Customer")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.FilterdContact));
			HomePage_OR.FilterdContact.click();
		}
		else if(Option.equals("Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ContactList));
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.ContactsName));
			ContactList=SupplierPage_OR.ContactsName.getText();
			System.out.println("One of the Contact here is :" + ContactList);
			SupplierPage_OR.ContactsName.click();

			try {
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.CannotAddSupplier));
				String Description = SupplierPage_OR.CannotAddSupplier.getText();
				Log.info(Description);
				SupplierPage_OR.MovetoSupplier.click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MoveToSupplierHeader));
				String Description1 = SupplierPage_OR.MoveSupplierText1.getText();
				Log.info(Description1);
				String Description2 = SupplierPage_OR.MoveSupplierText2.getText();
				Log.info(Description2);
				SupplierPage_OR.MovetoSupplier.click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovetoSupplierTitle));
				SupplierPage_OR.Confirm.click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovingToSupplier));
				String LoadingValue = SupplierPage_OR.LoadingValueWhileMoving.getText();
				Log.info("Moving is Done " + LoadingValue);
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovingSuccessful));
				Assert.assertTrue(SupplierPage_OR.MovingSuccessful.isDisplayed());
				SupplierPage_OR.Home.click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierTab));
				SupplierPage_OR.SupplierTab.click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.AddSupplier));
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+ContactList+"']")).click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierEmptyText));

			}
			catch(Exception E) {
				Log.info("Supplier is added from Contact");
			}
		}
		else if (Option.equals("Filtered Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
			SupplierPage_OR.SupplierNameNumberTextBox.click();
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys("Anbu");
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
			SupplierPage_OR.SupplierNameSubmitOk.click();
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.NewSupplier));
			Assert.assertTrue(SupplierPage_OR.NewSupplier.isDisplayed());
		}
	}
	@Then("^Verify user able to add \"([^\"]*)\" with \"([^\"]*)\"$")
	public void verify_user_is_able_to_add_cutomer_with_data(String data1 , String data2) {
		if(data1.equals("Customer") && data2.equals("100 Letters")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerNameSubmitButton));
			HomePage_OR.CustomerNameSubmitButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AddCustomerNumberField));
			if(HomePage_OR.AddCustomerNumberField.isDisplayed()) {

				String CustomerNamewith100Characters = HomePage_OR.AddCustomerNumberField.getText();
				Log.info("User is able to Add 100 characters in Customer Name. The user name is" + CustomerNamewith100Characters);
			}
			else {
				Log.info("User is not able to Add 100 characters in Customer Name");
			}

		}
		else if(data1.equals("Customer") && data2.equals("Existing Customer name")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AddCustomerNumberField));
			if(HomePage_OR.AddCustomerNumberField.isDisplayed()) {

				String ExistingCustomerName = HomePage_OR.AddCustomerNumberField.getText();
				Log.info("User is able to add existing Customer Name. The user name is" + ExistingCustomerName);
			}
			else {
				Log.info("User is not able to Add existing Customer Name in Customer Name");
			}
		}
		else if(data1.equals("Customer") && data2.equals("Existing Customer Number")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.CustomerNumberSubmitButton));
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(HomePage_OR.CustomerNumberSubmitButton.isEnabled());
		}
		else if(data1.equals("Customer") && data2.equals("8 Digit Customer Number")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.CustomerNumberSubmitButton));
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(HomePage_OR.CustomerNumberSubmitButton.isEnabled());
		}
		else if(data1.equals("Customer") && data2.equals("Invalid Customer Name")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.InputCustomerName));
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(HomePage_OR.AddCustomerClearText.isEnabled());
		}
		else if(data1.equals("Customer") && data2.equals("Invalid Customer Number")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.InputCustomerName));
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(HomePage_OR.AddCustomerClearText.isEnabled());
		}
	}
	@And("^User clears data in \"([^\"]*)\"$")
	public void user_clears_data_in_field(String Field) {
		if(Field.equals("Customer Name Field")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.InputCustomerName));
			HomePage_OR.InputCustomerName.click();
			HomePage_OR.InputCustomerName.clear();
//			HomePage_OR.AddCustomerClearText.click();
		}
		else if(Field.equals("Customer Number Field")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.AddCustomerNumberField));
			HomePage_OR.AddCustomerNumberField.click();
			HomePage_OR.AddCustomerNumberClearText.click();
		}
	}	
	@And("^User searches for \"([^\"]*)\"$")
	public void User_searches_for(String Field) {
		if(Field.equals("Existing Customer")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			HomePage_OR.SearchOrAddNext.clear();
			HomePage_OR.SearchOrAddNext.sendKeys("Customer");
		}
		else if(Field.equals("Existing Customer with Number")) {
			try {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumber);
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAddNext));
				HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumber);
			}
		}
		else if(Field.equals("Available Contact")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAddNext));
			HomePage_OR.SearchOrAddNext.clear();
			HomePage_OR.SearchOrAddNext.sendKeys("Customer");
		}
		else if(Field.equals("Random Customer")) {
			
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAdd));
				HomePage_OR.SearchOrAdd.click();
				HomePage_OR.SearchOrAddNext.clear();
				HomePage_OR.SearchOrAddNext.sendKeys(CustomerNumber12Digit);
				}
				catch(Exception E) {
					wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAddNext));
					HomePage_OR.SearchOrAddNext.sendKeys(CustomerNumber12Digit);
				}
		}
		if(Field.equals("Merchant Account")) {
			driver.navigate().back();
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			HomePage_OR.SearchOrAddNext.clear();
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumber);
		}
		if(Field.equals("Business Category")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(MerchantProfilePage_OR.SearchCategory));
			MerchantProfilePage_OR.SearchCategory.click();
			MerchantProfilePage_OR.SearchCategory.clear();
			MerchantProfilePage_OR.SearchCategory.sendKeys("Random");
			wait.until(ExpectedConditions.visibilityOfAllElements(MerchantProfilePage_OR.PlaceholderforEmptyCategory));
			Assert.assertTrue(MerchantProfilePage_OR.NoResultsFound.isDisplayed());
			Log.info(MerchantProfilePage_OR.AddAsCategory.getText());
			Assert.assertTrue(MerchantProfilePage_OR.AddCategory.isDisplayed());
			MerchantProfilePage_OR.SearchCategory.clear();
			MerchantProfilePage_OR.SearchCategory.sendKeys(data.BusinessCategory);
			wait.until(ExpectedConditions.visibilityOfAllElements(MerchantProfilePage_OR.CategoryItems));
			Assert.assertTrue(MerchantProfilePage_OR.CategoryItems.isDisplayed());
			
		}
	}
	@And("^User clears the \"([^\"]*)\"$")
	public void user_clears(String option) {
		if(option.equals("Search")){
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.ClearSearchX));
			HomePage_OR.ClearSearchX.click();
		}
		else if(option.equals("Card Holder name")){
			wait.until(ExpectedConditions.visibilityOfAllElements(MoneyTransfer_OR.CardHolderName));
			MoneyTransfer_OR.CardHolderName.click();
			MoneyTransfer_OR.CardHolderName.clear();
		}
		else if(option.equals("CVV")){
			wait.until(ExpectedConditions.visibilityOfAllElements(MoneyTransfer_OR.CVV));
			MoneyTransfer_OR.CVV.click();
			MoneyTransfer_OR.CVV.clear();
		}
		else if(option.equals("Card Number")){
			wait.until(ExpectedConditions.visibilityOfAllElements(MoneyTransfer_OR.CardNumber));
			MoneyTransfer_OR.CardNumber.click();
			MoneyTransfer_OR.CardNumber.clear();
		}
	}
	
}
