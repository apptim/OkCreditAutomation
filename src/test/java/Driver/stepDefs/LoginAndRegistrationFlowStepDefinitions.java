
/*
 * 
 * Author : Sivasankaramalan G
 */

package Driver.stepDefs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.CharMatcher;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.AccountPage_OR;
import ObjectRepository.BlockAndUnblockPage_OR;
import ObjectRepository.CollectionsPage_OR;
import ObjectRepository.CustomerPage_OR;
import ObjectRepository.DenySupplier_OR;
import ObjectRepository.ExpensesPage_OR;
import ObjectRepository.HamburgerMenuOptions;
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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginAndRegistrationFlowStepDefinitions extends desiredCapabilities {

	
	PropertyData data = new PropertyData();
	CommonMethodsFunctions CF = new CommonMethodsFunctions();
	AddTransactionsStepDefinitions ATS = new AddTransactionsStepDefinitions();
	
	String customerName = CF.randomAlphaNumeric(5);
	String CustomerNumber =CF.randomNumber(10);
	
	public static String Otp;
	public static String input;
	public static String output;
	public static String WrongOtp1;
	public static String WrongOtp2;
	public static String WrongOtp3;
	public static String WrongOtp4;
	public static String WrongOtp5;
	public static String WrongOtp6;
	public static String SpecialCharacter1;
	public static String SpecialCharacter2;
	public String DeletedCustomername;
	public String ShortBusinessName;
	public static String LongBusinessName;
	
	
	public static int LanguagesCount;
	
	public String ADB_COMMAND_TO_TURNOFF_WIFI = "adb shell am broadcast -a io.appium.settings.wifi --es setstatus disable";
	public String ADB_COMMAND_TO_TURNON_WIFI = "adb shell am broadcast -a io.appium.settings.wifi --es setstatus enable";
	public String ADB_COMMAND_TO_ON_DEVICE = "adb shell input keyevent KEYCODE_POWER";
	public String ADB_COMMAND_TO_SWIPE_TO_OBTAIN_PIN = "adb shell input swipe 100 800 800 800";
	public String ADB_COMMAND_TO_ENTER_PIN = "adb shell input text {123456}";
	public String ADB_COMMAND_TO_SUBMIT_PIN = "adb shell input keyevent KEYCODE_ENTER";
	
	public String ANDROID_HOME = System.getProperty("ANDROID_HOME");
//	public String ANDROID_HOME = "/Users/admin/Library/Android/sdk";
	
	
	
	@Given("Launch the App$")
	public void launch_the_app() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		Log.startLog("Test is Starting");
		
		Log.info("Launching the Application based on the Capabilities from the Driver file");
		System.out.println("Platform Name here is: " + driver.getCapabilities().getCapability("platformName"));
		

//		List<List<Object>> performanceData = driver.getPerformanceData("in.okcredit.merchant", "cpuinfo", 5);
//		
//		List<String> performanceTypes = driver.getSupportedPerformanceDataTypes();
//
//		
//		List<String> dataTypes = new ArrayList<String>();
//		dataTypes.add("cpuinfo");
//		dataTypes.add("memoryinfo");
//		dataTypes.add("batteryinfo");
//		dataTypes.add("networkinfo");
//		// check what data type you can get
//		List<String> supportedPerformanceDataTypes =driver.getSupportedPerformanceDataType;
//		// get data
//		List<List<Object>> performanceData =driver.
//		  getPerformanceData("your.app.package", "dataType", dataReadTimeout);
	}
	
	@SuppressWarnings("deprecation")
	@And("^Verify the \"([^\"]*)\" Page$")
	public void verify_the_given_page(String Page) throws InterruptedException, IOException {
		
		if(Page.equals("Welcome")){
			Log.info("Validating the Compnents in the Welcome Page");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.WelcomeToOkCred));
			
			LanguagesCount =LandingPage_OR.LanguageTile.size();
			
			System.out.println("The No of languages  in welcome page is :" + LanguagesCount);
		}
		else if (Page.endsWith("Verify Mobile")) {
			Log.info("User is registering with Mobile number");
			try {
//			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberEntryField));
//			Assert.assertTrue(LandingPage_OR.NoneOfTheAbove.isDisplayed(), "Associated mobile numbers are not displayed");
//			LandingPage_OR.NoneOfTheAbove.click();
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin));
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.MobileNumberEntryField));
			}
			catch(Exception E) {
				Log.info("Google Auto verify is not displaying OR App launched with new UI");
			}
		}
		else if (Page.endsWith("WhatsApp Login")) {
			Log.info("Whatsapp Screen will display to sign-in if the OTP not arrives in 15 Seconds");
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.AreYouOnWhatsApp));
			Assert.assertTrue(LandingPage_OR.AreYouOnWhatsApp.isDisplayed());
			
		}
		else if (Page.equals("OTP")) {
			Log.info("Verifying the OTP Page");
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.PleaseBePatient));
			Assert.assertTrue(LandingPage_OR.PleaseBePatient.isDisplayed());
			String mobileNumber =	LandingPage_OR.RecieveOtpinSec.getText();
			
				 input = mobileNumber;
				 output = CharMatcher.is('-').or(CharMatcher.digit()).retainFrom(input);
				 System.out.println("The Mobile Number of the User is: " + output);
		}
		else if (Page.equals("Enter Business Name")) {
			Log.info("Verifying Business name entry screen");
				wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.BusinessNameEntryField));
				wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.SkipButtonInBusinessNameEntryScreen));
				wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.BusinessNameSubmitButton));
			//}
			
		}
		else if (Page.equals("No Internet toast message")) {
			Log.info("No Internet toast message displayed");
				wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.NoInternetToastMessage));
				wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.NoInternetRetryButton));
				
			//}
			
		}
		else if (Page.equals("Home")) {
			Log.info("Landed on Home Page");
			//try 
//			{
//			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.HomepageWAShare));
//			Assert.assertTrue(HomePage_OR.HomepageWAShare.isDisplayed());
//			driver.navigate().back();
//			Thread.sleep(3000);
//			driver.navigate().back();
//			}
//			catch(Exception E) {
				wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.SearchOrAdd));
				Assert.assertTrue(HomePage_OR.SearchOrAdd.isDisplayed());
			//}
			
		}
		else if (Page.endsWith("WhatsApp")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.WhatsAppconversation_contact_name));
			Assert.assertTrue(LandingPage_OR.WhatsAppSend.isDisplayed());
			String ActivationKey = LandingPage_OR.WhatsAppActivationKey.getText();
			System.out.println("The Activation key for the user is :"+ ActivationKey);
		}
		else if (Page.endsWith("Customer")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(CustomerPage_OR.AddedCustomerHeader ));
			Assert.assertTrue(CustomerPage_OR.AddedCustomerHeader.isDisplayed());
			
			String CustomerName = CustomerPage_OR.AddedCustomerHeader.getText();
			System.out.println("The Customer name is :"+ CustomerName);
		}
		else if (Page.equals("Transaction")) {
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.EmptyText));
				Assert.assertTrue(TransactionPage_OR.EmptyText.isDisplayed());
				Log.info("The selected user doesn't have any transactions");
			}
			catch(Exception E){
				System.out.println("The user has Transactions");
				wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.PaymentButton));
				Assert.assertTrue(TransactionPage_OR.PaymentButton.isDisplayed());
			}
		}
		else if (Page.equals("Supplier Transaction")) {
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.EmptyText));
				Assert.assertTrue(TransactionPage_OR.EmptyText.isDisplayed());
				Log.info("The selected user doesn't have any transactions");
			}
			catch(Exception E){
				System.out.println("The user has Transactions");
				wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.TakeCredit));
				Assert.assertTrue(TransactionPage_OR.TakeCredit.isDisplayed());
			}
		}
		
		else if (Page.equals("Transaction Details")) {
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.EmptyText));
				Assert.assertTrue(TransactionPage_OR.EmptyText.isDisplayed());
				Log.info("The selected user doesn't have any transactions");
			}
			catch(Exception E){
				System.out.println("Validating the transaction Page");
			}
		}
		else if (Page.equals("Payment")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.AddPaymentText));
			Assert.assertTrue(TransactionPage_OR.AddPaymentText.isDisplayed());
			Log.info("Add Payment Text is Visible");
		}
		else if (Page.equals("Cannot Add As a supplier")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(CustomerPage_OR.CannotAddSupplier));
			Assert.assertTrue(CustomerPage_OR.CannotAddSupplier.isDisplayed());
		}
		else if (Page.equals("View Customer")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(CustomerPage_OR.ViewCustomer));
			Assert.assertTrue(CustomerPage_OR.ViewCustomer.isDisplayed());
		}
		else if (Page.endsWith("Credit")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.AddCredit));
			Assert.assertTrue(TransactionPage_OR.AddCredit.isDisplayed());
			Log.info("Add Credit Text is Visible");
		}
		else if (Page.endsWith("Supplier Mobile Number")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(SupplierPage_OR.SkipMobileNumber));
			Assert.assertTrue(SupplierPage_OR.SupplierNameNumberTextBox.isDisplayed());
			Log.info("Enter Supplier Mobile number");
		}
		else if (Page.endsWith("Supplier Details")) {
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.SupplierText));
				Assert.assertTrue(TransactionPage_OR.SupplierText.isDisplayed());
				Log.info(TransactionPage_OR.SupplierText.getText());
			}
			catch(Exception E) {
			wait.until(ExpectedConditions.visibilityOfAllElements(SupplierPage_OR.SupplierEmptyText));
			Assert.assertTrue(SupplierPage_OR.SupplierEmptyText.isDisplayed());
			Log.info("Supplier Created with empty transaction");
			}
		}
		else if (Page.endsWith("Move to Supplier")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(SupplierPage_OR.MoveToSupplierHeader));
			Assert.assertTrue(SupplierPage_OR.MoveToSupplierHeader.isDisplayed());
			String Description1 = SupplierPage_OR.MoveSupplierText1.getText();
			Log.info(Description1);
			String Description2 = SupplierPage_OR.MoveSupplierText2.getText();
			Log.info(Description2);
		}
		else if (Page.endsWith("Move to Supplier Loader")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovingToSupplier));
			String LoadingValue = SupplierPage_OR.LoadingValueWhileMoving.getText();
			Log.info("Moving is Done " + LoadingValue);
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovingFailed));
				String LoadingValue = SupplierPage_OR.MovingFailed.getText();
				Log.info(LoadingValue);
			}
		}
		else if (Page.endsWith("Money Transfer")) {
			Thread.sleep(8000);
			try {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.MoneyTransferHeader));
			Assert.assertTrue(MoneyTransfer_OR.TermsandConditions.isDisplayed());
			}
			catch(Exception E) {
				Log.info("Money Transfer page taking more time to load");
			}
		}
		else if (Page.endsWith("Discount")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddCredit));
			Assert.assertTrue(TransactionPage_OR.AddCredit.isDisplayed());
		}
		else if (Page.endsWith("Discount Delete")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DiscountOfferedinDetailPage));
			Assert.assertTrue(TransactionPage_OR.DiscountOfferedinDetailPage.isDisplayed());
			String message =TransactionPage_OR.DeleteDiscountMessage.getText();
			Log.info(message);
		}
		else if (Page.endsWith("Collection")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SetupCollection));
			Assert.assertTrue(CollectionsPage_OR.SetupCollection.isDisplayed());
			String message =CollectionsPage_OR.CollectionDescription.getText();
			Log.info(message);
			}
			catch(Exception E){
				Log.info("Collection Account Setup is done Already");
				wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.QRIcon));
				CollectionsPage_OR.QRIcon.click();
				wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.ThreeDotMenuinQRPage));
				CollectionsPage_OR.ThreeDotMenuinQRPage.click();
				wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.DeleteAccount));
				CollectionsPage_OR.DeleteAccount.click();
				wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.Delete));
				CollectionsPage_OR.Delete.click();
				wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.PleaseBePatient));
				if(CollectionsPage_OR.SetupCollection.isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SetupCollection));
				}
				else {
					Otp = "0";
					wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox1)).isDisplayed();
					LandingPage_OR.OtpTextBox1.sendKeys(Otp);
					LandingPage_OR.OtpTextBox2.sendKeys(Otp);
					LandingPage_OR.OtpTextBox3.sendKeys(Otp);
					LandingPage_OR.OtpTextBox4.sendKeys(Otp);
					LandingPage_OR.OtpTextBox5.sendKeys(Otp);
					LandingPage_OR.OtpTextBox6.sendKeys(Otp);
				}
			}
		}
		else if (Page.endsWith("Add Bank Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.AddAccountNumberTextBox));
			Assert.assertTrue(CollectionsPage_OR.AddAccountNumberTextBox.isDisplayed());
			String message =CollectionsPage_OR.AddPaymentDescription.getText();
			Log.info(message);
			if(CollectionsPage_OR.AddAccountNumberTextBox.getText() != null){
				Log.info("Account Number Added : " + CollectionsPage_OR.AddAccountNumberTextBox.getText());
				Log.info("IFSC  Added : " + CollectionsPage_OR.IFSCCodeTextBox.getText());
			}
		}
		else if (Page.endsWith("QR Scanner")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.MessageInScannerPage));
			Assert.assertTrue(CollectionsPage_OR.MessageInScannerPage.isDisplayed());
			String message =CollectionsPage_OR.MessageInScannerPage.getText();
			Log.info(message);
		}
		else if (Page.endsWith("Add UPI")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.UPIIDTextBox));
			Assert.assertTrue(CollectionsPage_OR.UPIIDTextBox.isDisplayed());
			String message =CollectionsPage_OR.AddPaymentDescription.getText();
			Log.info(message);
			if(CollectionsPage_OR.UPIIDTextBox.getText() != null){
				Log.info("UPI ID Added : " + CollectionsPage_OR.UPIIDTextBox.getText());
			}
		}
		else if (Page.endsWith("Collection Statistics")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.DateRange));
			Assert.assertTrue(CollectionsPage_OR.DateRange.isDisplayed());
			Log.info("Collection details are listed here for the period of : " + CollectionsPage_OR.DateRange.getText());
			
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.TotalCreditGivenAmount));
			Assert.assertTrue(CollectionsPage_OR.TotalCreditGivenAmount.isDisplayed());
			Log.info("Total Credit Given :" + CollectionsPage_OR.TotalCreditGivenAmount);
			CF.scrollToText("Total online collection", driver);
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.TotalOfflineCollectionAmount));
			Assert.assertTrue(CollectionsPage_OR.TotalOfflineCollectionAmount.isDisplayed());
			Log.info("Total Offline Collection Amount :" + CollectionsPage_OR.TotalOfflineCollectionAmount);
			
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.TotalOnlineCollectionAmount));
			Assert.assertTrue(CollectionsPage_OR.TotalOnlineCollectionAmount.isDisplayed());
			Log.info("Total Online Collection Amount :" + CollectionsPage_OR.TotalOnlineCollectionAmount);
		}
		else if (Page.endsWith("Add Supplier UPI")) {
			
			if (CollectionsPage_OR.UPIIDTextBox.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOfAllElements(CollectionsPage_OR.UPIIDTextBox));
				Assert.assertTrue(CollectionsPage_OR.UPIIDTextBox.isDisplayed());
				if (CollectionsPage_OR.UPIIDTextBox.getText() != null) {
					Log.info("UPI ID Added : " + CollectionsPage_OR.UPIIDTextBox.getText());
				}
			} else {
				Log.info("Account details already added for supplier");
				wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.change_details));
				SupplierPage_OR.change_details.click();
				wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.UPIIDTextBox));
				Assert.assertTrue(CollectionsPage_OR.UPIIDTextBox.isDisplayed());
				if (CollectionsPage_OR.UPIIDTextBox.getText() != null) {
					Log.info("UPI ID Added : " + CollectionsPage_OR.UPIIDTextBox.getText());
				}
			}
				
		}
		else if (Page.equals("Supplier Payment")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.AmountToBePaid));
			Assert.assertTrue(MoneyTransfer_OR.AmountToBePaid.isDisplayed());
			}
			catch(Exception E) {
				Log.info("The Payment page will load in a while");
				wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.AmountToBePaid));
				Assert.assertTrue(MoneyTransfer_OR.AmountToBePaid.isDisplayed());
			}
			
//			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.AmountTextBox));
//			Assert.assertTrue(MoneyTransfer_OR.AmountTextBox.isDisplayed());
//			String Amount =MoneyTransfer_OR.AmountTextBox.getText();
//			Log.info("Amount need to be paid to the supplier is : " + Amount);
		}
		else if (Page.endsWith("Payment Processing")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.PaymentProcessing));
			Assert.assertTrue(SupplierPage_OR.PaymentProcessing.isDisplayed());
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.AmountTextInPaymentProcessing));
			String message =SupplierPage_OR.AmountTextInPaymentProcessing.getText();
			Log.info("Amount processing for the Supplier is : " +message);
		}
		else if (Page.endsWith("Card Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.MerchantNameInCardDetailsPage));
			Assert.assertTrue(MoneyTransfer_OR.MerchantNameInCardDetailsPage.isDisplayed());
			String CustomerName =MoneyTransfer_OR.MerchantNameInCardDetailsPage.getText();
			Log.info("Supplier is : " +CustomerName);
			
			Assert.assertTrue(MoneyTransfer_OR.AmountInCardDetailsPage.isDisplayed());
			String Amount =MoneyTransfer_OR.AmountInCardDetailsPage.getText();
			Log.info("Amount processing for the Supplier is: " +Amount);
			
			Assert.assertTrue(MoneyTransfer_OR.CustomerNumberInCardPage.isDisplayed());
			String Number =MoneyTransfer_OR.CustomerNumberInCardPage.getText();
			Log.info("Amount processing for the Supplier number is : " +Number);
		}
		else if (Page.equals("Net Banking Home")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.SBIBank));
			Assert.assertTrue(MoneyTransfer_OR.SBIBank.isDisplayed());
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			int size = MoneyTransfer_OR.BankListMain.size()
//			for(int i=0; i<=size; i++) {
//				
//				Log.info("List of Banks availabe in the Netbanking page is : " +MoneyTransfer_OR.BankListMain.get(i));
//			}
			
		}
		else if (Page.equals("Merchant Profile")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.EditMerchantProfilePhoto));
			Assert.assertTrue(MerchantProfilePage_OR.EditMerchantProfilePhoto.isDisplayed());
		}
		else if (Page.equals("Rewards")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.TotalRewards));
			Assert.assertTrue(HamburgerMenuOptions.TotalRewards.isDisplayed());
			}
			catch(Exception E) {
				Log.info("You have new Rewards");
				Assert.assertTrue(HamburgerMenuOptions.RewardsPageReward.isDisplayed());
			}
		}
		else if (Page.equals("Share")) {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.SharePageTellYourFamily));
			Assert.assertTrue(HamburgerMenuOptions.SharePageTellYourFamily.isDisplayed());
		}
		else if (Page.equals("About")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.OkCWebPage));
			Assert.assertTrue(HamburgerMenuOptions.OkCWebPage.isDisplayed());
			}
			catch(Exception E) {
				Log.info("Webpage taking more time to load.");
			}
		}
		else if (Page.equals("Home Delivery")) {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.HomeDeleiveryHeader));
			Assert.assertTrue(HamburgerMenuOptions.HomeDeleiveryHeader.isDisplayed());
		}
		else if (Page.equals("Mobile Recharge")) {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.MobileRechargeHeader));
			Assert.assertTrue(HamburgerMenuOptions.MobileRechargeHeader.isDisplayed());
		}
		else if (Page.equals("Insurance")) {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.InsurancePageProtect));
			Assert.assertTrue(HamburgerMenuOptions.InsurancePageProtect.isDisplayed());
		}
		else if (Page.equals("Privacy Policy")) {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.WhyMyDataOnline));
			Assert.assertTrue(HamburgerMenuOptions.WhyMyDataOnline.isDisplayed());
		}
		else if (Page.equals("Rate Us")) {
			wait.until(ExpectedConditions.elementToBeClickable(HamburgerMenuOptions.WhatsNewPlaystore));
			Assert.assertTrue(HamburgerMenuOptions.WhatsNewPlaystore.isDisplayed());
		}
		else if (Page.equals("Voice Assistant")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Listning));
			Assert.assertTrue(TransactionPage_OR.Listning.isDisplayed());
			}
			catch(Exception E) {
				Log.info("App verified in Playstore");
			}
		}
		else if (Page.equals("Customer Statement")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.BalanceInStatements));
			Assert.assertTrue(TransactionPage_OR.BalanceInStatements.isDisplayed());
		}
		else if (Page.equals("Total Balance in Statement")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.TotalBalanceInStatements));
			Assert.assertTrue(TransactionPage_OR.TotalBalanceInStatements.isDisplayed());
			Log.info(TransactionPage_OR.CurrentBalanceInStatements.getText()+" : " +TransactionPage_OR.TotalBalanceInStatements.getText());
		}
		else if (Page.equals("Balance in Statement")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.BalanceInStatements));
			Assert.assertTrue(TransactionPage_OR.BalanceInStatements.isDisplayed());
			Log.info(TransactionPage_OR.BalanceInStatements.getText());
		}
		else if (Page.equals("Whatsapp Share")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsappSendTo));
			Assert.assertTrue(TransactionPage_OR.WhatsappSendTo.isDisplayed());
		}
		else if (Page.equals("Chat")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.chatPageHi));
				Log.info(CustomerPage_OR.chatPageHi.getText());
				driver.navigate().back();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.chatPageBanner));
				Assert.assertTrue(CustomerPage_OR.chatPageBanner.isDisplayed());
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ChatInput));
				Assert.assertTrue(CustomerPage_OR.ChatInput.isDisplayed());
			}
			catch(Exception E) {
				Log.info("Please click on user's name and add mobile number to start chatting");
//				Assert.assertTrue(CustomerPage_OR.NoMobileNumbertoast.isDisplayed());
				driver.navigate().back();
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
				HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumber);
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
				HomePage_OR.CustomerSearchList.click();
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.chat));
				CustomerPage_OR.chat.click();
			}
		}
	}
	 @And("^Verify the Language \"([^\"]*)\"$")
	 public void verify_language(String Language) {
		 
		 if(Language.endsWith("List")) {
			Log.info("Verifying language list Onboarding Page"); 
			
			System.out.println("The Language tiles present in the Welcome page is : ");
			for(int i=0; i<=LanguagesCount-1; i++) {
				String LanguagesList= LandingPage_OR.LanguageTile.get(i).getText();
				System.out.println(i+1 +" : "+LanguagesList);
				}
		 }
		 else if(Language.endsWith("English")) {
			Log.info("Verifying English on Onboarding Page"); 
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.LanguageEnglish));
			Assert.assertTrue(LandingPage_OR.LanguageEnglish.isDisplayed(), "English is not Displayed");
		 }
		 else if(Language.endsWith("Hindi")) {
			Log.info("Verifying Hindi on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguageHindi.isDisplayed(), "Hindi is not Displayed");
		 }
		 else if(Language.endsWith("Marathi")) {
			Log.info("Verifying Marathi on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguageMarathi.isDisplayed(), "Marathi is not Displayed");
		 }
		 else if(Language.endsWith("Hinglish")) {
			Log.info("Verifying Hinglish on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguageHinglish.isDisplayed(), "Hinglish is not Displayed");
		 }
		 else if(Language.endsWith("Gujarathi")) {
			Log.info("Verifying Gujarathi on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguageGujarathi.isDisplayed(), "Gujarathi is not Displayed");
		 }
		 else if(Language.endsWith("Tamil")) {
			Log.info("Verifying Tamil on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguageTamil.isDisplayed(), "Tamil is not Displayed");
		 }
		 else if(Language.endsWith("Telugu")) {
			Log.info("Verifying Telugu on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguageTelugu.isDisplayed(), "Telugu is not Displayed");
		 }
		 else if(Language.endsWith("Punjabi")) {
			Log.info("Verifying Punjabi on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguagePanjabi.isDisplayed(), "Punjabi is not Displayed");
		 }
		 else if(Language.endsWith("Malayalam")) {
			Log.info("Verifying Malayalam on Onboarding Page"); 
			Assert.assertTrue(LandingPage_OR.LanguageMalayalam.isDisplayed(), "Malayalam is not Displayed");
		 }
		 else if(Language.endsWith("Kannada")) {
				Log.info("Verifying Kannada on Onboarding Page"); 
				Assert.assertTrue(LandingPage_OR.LanguageKannada.isDisplayed(), "Kannada is not Displayed");
			 }
		 else if(Language.endsWith("Bangla")) {
				Log.info("Verifying Bangla on Onboarding Page"); 
				Assert.assertTrue(LandingPage_OR.LanguageBangla.isDisplayed(), "Bangla is not Displayed");
			 }
	 }
	
	@And("^Select Language as \"([^\"]*)\"$")
	public void select_language(String Language) {
		
		if(Language.equals("Hinglish")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageHinglishText)).isDisplayed();
			LandingPage_OR.LanguageHinglishText.click();
			String WelcomeTextinHinglish =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinHinglish);
			Assert.assertTrue(WelcomeTextinHinglish.contains("Bhasha Chuniye"));
		}
		else if(Language.equals("English")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageEnglishText)).isDisplayed();
			LandingPage_OR.LanguageEnglishText.click();
			String WelcomeTextinEnglish =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			Assert.assertTrue(WelcomeTextinEnglish.contains("Select your Language"));
		}
		else if(Language.equals("Marathi")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageMarathiText)).isDisplayed();
			LandingPage_OR.LanguageMarathiText.click();
			String WelcomeTextinMarathi =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinMarathi);
			Assert.assertTrue(WelcomeTextinMarathi.contains("आपली भाषा निवडा"));
		}
		else if(Language.equals("Hindi")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageHindiText)).isDisplayed();
			LandingPage_OR.LanguageHindiText.click();
			String WelcomeTextinHindi =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinHindi);
			Assert.assertTrue(WelcomeTextinHindi.contains("अपनी भाषा चुनें"));
		}
		else if(Language.equals("Gujrati")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageGujratiText)).isDisplayed();
			LandingPage_OR.LanguageGujratiText.click();
			String WelcomeTextinGujrati =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinGujrati);
			Assert.assertTrue(WelcomeTextinGujrati.contains("તમારી ભાષા પસંદ કરો"));
		}
		else if(Language.equals("Tamil")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageTamilText)).isDisplayed();
			LandingPage_OR.LanguageTamilText.click();
			String WelcomeTextinTamil =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinTamil);
			Assert.assertTrue(WelcomeTextinTamil.contains("உங்கள் மொழியினை தேர்ந்தெடுக்கவும்"));
		}
		else if(Language.equals("Telugu")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageTeluguText)).isDisplayed();
			LandingPage_OR.LanguageTeluguText.click();
			String WelcomeTextinTelugu =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinTelugu);
			Assert.assertTrue(WelcomeTextinTelugu.contains("మీ భాషను ఎంచుకోండి"));
		}
		else if(Language.equals("Punjabi")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguagePunjabiText)).isDisplayed();
			LandingPage_OR.LanguagePunjabiText.click();
			String WelcomeTextinPunjabi =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinPunjabi);
			Assert.assertTrue(WelcomeTextinPunjabi.contains("ਆਪਣੀ ਭਾਸ਼ਾ ਚੁਣੋ"));
		}
		else if(Language.equals("Malayalam")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageMalayalamText)).isDisplayed();
			LandingPage_OR.LanguageMalayalamText.click();
			String WelcomeTextinMalayalam =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinMalayalam);
			Assert.assertTrue(WelcomeTextinMalayalam.contains("നിങ്ങളുടെ ഭാഷ തിരഞ്ഞെടുക്കുക"));
		}
		else if(Language.equals("Kannada")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageKannadaText)).isDisplayed();
			LandingPage_OR.LanguageKannadaText.click();
			String WelcomeTextinKannada =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinKannada);
			Assert.assertTrue(WelcomeTextinKannada.contains("ನಿಮ್ಮ ಭಾಷೆಯನ್ನು ಆಯ್ಕೆ ಮಾಡಿ"));
		}
		else if(Language.equals("Bangla")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.LanguageBanglaText)).isDisplayed();
			LandingPage_OR.LanguageBanglaText.click();
			String WelcomeTextinBangla =	wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SelectLanguage)).getText();
			System.out.println("Welcome Text in Selected Language is : " + WelcomeTextinBangla);
			Assert.assertTrue(WelcomeTextinBangla.contains("আপনার ভাষা বাছুন"));
		}
	}
	
	@And("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_button(String Button) throws InterruptedException, IOException {
		
		if(Button.equals("Next")) {
			
//			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.NextButton));
			
			CF.clickAction(LandingPage_OR.NextButton, driver);
//			LandingPage_OR.NextButton.click();
		}
		else if(Button.equals("Terms of Service")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TermsOfService)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.TermsOfService.isDisplayed());
		}
		else if(Button.equals("Done button")) {
			Log.info("Submitting Applock pin");
			String ADB=ANDROID_HOME;
			String cmd = "/platform-tools/adb shell input keyevent KEYCODE_ENTER";
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(ADB+cmd);
			pr.waitFor();
			
		}
		else if(Button.equals("Submit Button")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.BusinessNameSubmitButton)).isDisplayed();
			LandingPage_OR.BusinessNameSubmitButton.click();
		}
		else if(Button.equals("Clear Button")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.ClearBusinessName)).isDisplayed();
			LandingPage_OR.ClearBusinessName.click();
		}
		else if(Button.equals("Skip")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.SkipButtonInBusinessNameEntryScreen)).isDisplayed();
			LandingPage_OR.SkipButtonInBusinessNameEntryScreen.click();
		}
		else if(Button.equals("Retry Button")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.NoInternetRetryButton)).isDisplayed();
			LandingPage_OR.NoInternetRetryButton.click();
		}
		else if(Button.equals("Help")) {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.Help)).isDisplayed();
			HelpPage_OR.Help.click();
		}
		else if(Button.equals("Move to Supplier View Supplier")) {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.ViewSupplier)).isDisplayed();
			SupplierPage_OR.ViewSupplier.click();
		}
		else if(Button.equals("Non Relationship Customer")) {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.NonMigratecustomer)).isDisplayed();
			CustomerPage_OR.NonMigratecustomer.click();
		}
		else if(Button.equals("Migrated Customer")) {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SameNumberSupplier)).isDisplayed();
			CustomerPage_OR.SameNumberSupplier.click();
		}
		else if(Button.equals("Help Icon")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.HelpIcon)).isDisplayed();
			HelpPage_OR.HelpIcon.click();
		}
		else if(Button.equals("Account Help")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.AccountHelp)).isDisplayed();
			HelpPage_OR.AccountHelp.click();
		}
		else if(Button.equals("Security Help")) {
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.SecurityHelp)).isDisplayed();
			HelpPage_OR.SecurityHelp.click();
		}
		else if(Button.equals("Verify Mobile")) {
			try {
			Log.info("Verify the Mobile number page");
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.VerifyMobile)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.VerifyMobile.isDisplayed());
			LandingPage_OR.VerifyMobile.click();
			Log.info("User should see the Mobile Number associated in the device");
			}
			catch(Exception E) {
				Log.info("App Launched with new UI");
			}
			
		}
		else if(Button.equals("OK")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
			LandingPage_OR.MobileNumberSubmit.click();
		}
		else if(Button.equals("Not Now")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.NotNow));
			LandingPage_OR.NotNow.click();
		}
		else if(Button.equals("Resend OTP")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.DidntGetOtp));
			LandingPage_OR.DidntGetOtp.click();
		}
		else if(Button.equals("X")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.MobileNumberCancel));
			LandingPage_OR.MobileNumberCancel.click();
		}
		else if(Button.equals("Allow")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.WhatsAppAllow));
			LandingPage_OR.WhatsAppAllow.click();
		}
		else if(Button.equals("Register Via WhatsApp")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.RegisterByWhatsapp));
			LandingPage_OR.RegisterByWhatsapp.click();
		}
		else if(Button.equals("Send message Button")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(LandingPage_OR.WhatsAppSend));
			LandingPage_OR.WhatsAppSend.click();
		}
		else if(Button.equals("Add Customer")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.AddCustomer));
			HomePage_OR.AddCustomer.click();
		}
		else if(Button.equals("Submit Name")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.CustomerNameSubmitButton));
			HomePage_OR.CustomerNameSubmitButton.click();
		}
		else if(Button.equals("Submit Number")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.CustomerNumberSubmitButton));
			HomePage_OR.CustomerNumberSubmitButton.click();
		}
		else if(Button.equals("CustomernameClear")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.InputCustomerName));
			HomePage_OR.InputCustomerName.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.AddCustomerClearText));
			HomePage_OR.AddCustomerClearText.click();
		}
		else if(Button.equals("CustomerNumberClear")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.AddCustomerNumberField));
			HomePage_OR.AddCustomerNumberField.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.AddCustomerNumberClearText));
			HomePage_OR.AddCustomerNumberClearText.click();
		}
		else if(Button.equals("Delete Customer")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(CustomerPage_OR.DeleteCustomer));
			CustomerPage_OR.DeleteCustomer.click();
		}
		else if(Button.equals("Forgot Password")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(CustomerPage_OR.forgot_password));
			CustomerPage_OR.forgot_password.click();
		}
		else if(Button.equals("Payment")) {
			try {
			wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.PaymentButton));
			TransactionPage_OR.PaymentButton.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.PaymentButtonAB));
				TransactionPage_OR.PaymentButtonAB.click();
			}
		}
		else if(Button.equals("Credit")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.CreditButton));
			TransactionPage_OR.CreditButton.click();
		}
		else if(Button.equals("Date Picker")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DateContainer));
			TransactionPage_OR.DateContainer.click();
		}
		
		else if(Button.equals("Supplier Date Picker")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SupplierDateContainer));
			TransactionPage_OR.SupplierDateContainer.click();
		}
		else if(Button.equals("Cancel")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CalenderCancel));
			TransactionPage_OR.CalenderCancel.click();
		}
		else if(Button.equals("Filter Cancel")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Cancel));
			HomePage_OR.Cancel.click();
		}
		
		else if(Button.equals("Calendar OK")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CalenderOK));
			TransactionPage_OR.CalenderOK.click();
		}
		else if(Button.equals("Add Bill")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddBill));
			TransactionPage_OR.AddBill.click();
		}
		else if(Button.equals("Request Payment")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.RequestPayment));
			TransactionPage_OR.RequestPayment.click();
		}
		else if(Button.equals("Expenses")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Menu));
			HomePage_OR.Menu.click();	
		}
		else if(Button.equals("Expenses Card")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Card));
			ExpensesPage_OR.Expenses_Card.click();	
		}
		else if(Button.equals("Expenses Button")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Button));
			ExpensesPage_OR.Expenses_Button.click();	
		}
		else if(Button.equals("Expenses Seven Days")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_Seven_Days));
			ExpensesPage_OR.Expenses_Seven_Days.click();	
		}
		else if(Button.equals("Expenses All")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_All));
			ExpensesPage_OR.Expenses_All.click();	
		}
		else if(Button.equals("Expenses This Month")) {
			wait.until(ExpectedConditions.elementToBeClickable(ExpensesPage_OR.Expenses_This_Month));
			ExpensesPage_OR.Expenses_This_Month.click();	
		}
		else if(Button.equals("First Customer")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SelectCustomer));
			CustomerPage_OR.SelectCustomer.click();	 
		} 
		else if(Button.equals("Click Help Menu")) {
			Thread.sleep(4000);
			HelpPage_OR.HelpMenu.click();	 
		} 
		else if(Button.equals("Help First Transction")) {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.FirstTransaction));
			HelpPage_OR.FirstTransaction.click();	 
		}
		else if(Button.equals("Help Menu Drop Down")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.HelpDropDown));
			HelpPage_OR.HelpDropDown.click();	 
		}
		else if(Button.equals("Help Customer Profile")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.Customerprofile));
			HelpPage_OR.Customerprofile.click();	 
		}
		else if(Button.equals("First Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.FirstSupplier));
			DenySupplier_OR.FirstSupplier.click();	
		} 
		else if(Button.equals("OnDeny Permission")) {
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.OnDenyPermission));
			DenySupplier_OR.OnDenyPermission.click();	
		} 
		else if(Button.equals("Supplier Tab")) {
			wait.until(ExpectedConditions.elementToBeClickable(DenySupplier_OR.SupplierTab));
			DenySupplier_OR.SupplierTab.click();

		} 
		else if(Button.equals("TrueCaller Skip")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrucallerSkip));
			LandingPage_OR.TrucallerSkip.click();
		}
		else if(Button.equals("Continue")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrucallerContinue));
			LandingPage_OR.TrucallerContinue.click();
		}
		else if(Button.equals("Continue")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrucallerContinue));
			LandingPage_OR.TrucallerContinue.click();
		}
		else if(Button.equals("Edit Mobile")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.EditMobileNumber));
			LandingPage_OR.EditMobileNumber.click();
		}
		else if(Button.equals("Block Customer")) {
			CF.scrollToText("Block", driver);
			wait.until(ExpectedConditions.elementToBeClickable(BlockAndUnblockPage_OR.BlockCustomer));
			BlockAndUnblockPage_OR.BlockCustomer.click();
		}
		else if(Button.equals("UnBlock Customer")) {
			wait.until(ExpectedConditions.elementToBeClickable(BlockAndUnblockPage_OR.UnBlocking));
			BlockAndUnblockPage_OR.UnBlocking.click();
		}
		else if(Button.equals("UnBlock Button")) {
			wait.until(ExpectedConditions.elementToBeClickable(BlockAndUnblockPage_OR.UnBlock));
			BlockAndUnblockPage_OR.UnBlock.click();
		}
		else if(Button.equals("Block Accept")) {
			wait.until(ExpectedConditions.elementToBeClickable(BlockAndUnblockPage_OR.BlockAccept));
			BlockAndUnblockPage_OR.BlockAccept.click();
		}
		
		else if(Button.equals("Supplier Tab")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierHeader.get(1)));
			SupplierPage_OR.SupplierHeader.get(1).click();
		}
		else if(Button.equals("Add Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.AddSupplier));
			SupplierPage_OR.AddSupplier.click();
		}
		else if(Button.equals("Supplier OK")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
			SupplierPage_OR.SupplierNameSubmitOk.click();
		}
		else if(Button.equals("Skip Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SkipMobileNumber));
			SupplierPage_OR.SkipMobileNumber.click();
		}
		else if(Button.equals("Move to Supplier")) {
			CF.scrollToText("Move to Supplier", driver);
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.MovetoSupplier));
			SupplierPage_OR.MovetoSupplier.click();
		}
		else if(Button.equals("Profile Move to Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.ProfileMovetoSupplier));
			SupplierPage_OR.ProfileMovetoSupplier.click();
		}
		else if(Button.equals("Confirm")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.Confirm));
			SupplierPage_OR.Confirm.click();
		}
		else if(Button.equals("Home")) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			CF.clickAction(SupplierPage_OR.Home, driver);
//			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.Home));
			SupplierPage_OR.Home.click();
		}
		else if(Button.equals("Delete Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.DeleteSupplier));
			SupplierPage_OR.DeleteSupplier.click();
		}
		else if(Button.equals("Customer Tab")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerTab));
			HomePage_OR.CustomerTab.click();
		}
		else if(Button.equals("Clear Search")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ClearSearchX));
			HomePage_OR.ClearSearchX.click();
		}
		else if(Button.equals("Search Result")) {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			HomePage_OR.CustomerSearchList.click();
		}
		else if(Button.equals("Add")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Add));
			HomePage_OR.Add.click();
		}
		else if(Button.equals("Hamburger Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.HamburgerMenu));
			HomePage_OR.HamburgerMenu.click();
		} 
		else if(Button.equals("Frequently Asked Question")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.FrequentlyAsked));
			HelpPage_OR.FrequentlyAsked.click();
		}
		else if(Button.equals("Contact Us")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.ContactUs));
			HelpPage_OR.ContactUs.click();
		} 
		else if(Button.equals("Like")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.Like));
			HelpPage_OR.Like.click(); 
		}
		else if(Button.equals("Dis Like")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.DisLike));
			HelpPage_OR.DisLike.click();
		}
		else if(Button.equals("First Help Content")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.FirstHelpContent));
			HelpPage_OR.FirstHelpContent.click();
		}
		else if(Button.equals("Share Feedback")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.HelpFeedback));
			HelpPage_OR.HelpFeedback.click();
		}
		else if(Button.equals("FeedBack Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(HelpPage_OR.FeedBack_Submit));
			HelpPage_OR.FeedBack_Submit.click();
		}
		else if(Button.equals("Help")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.HamburgerMenu));
			HomePage_OR.HamburgerMenu.click();
		}
		else if(Button.equals("Settings")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SettingsButton));
			HomePage_OR.SettingsButton.click();
		}
		else if(Button.equals("Sign Out")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SignOutButton));
			HomePage_OR.SignOutButton.click();
		}
		else if(Button.equals("Sign Out Confirm")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SignOutConfirmButton));
			HomePage_OR.SignOutConfirmButton.click();
		}
		else if(Button.equals("Sign Out Confirmation")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SignOutConfirmation));
			HomePage_OR.SignOutConfirmation.click();
		}
		else if(Button.equals("Got It")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.GotIt));
			CustomerPage_OR.GotIt.click();
		}
		else if(Button.equals("Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
			CustomerPage_OR.MobileNumber.click();
		}
		else if(Button.equals("Account Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AccountMenu));
			HomePage_OR.AccountMenu.click();
		}
		else if(Button.equals("Account Statement")) {
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.AccountStatement));
			AccountPage_OR.AccountStatement.click();
		}
		else if(Button.equals("Customer Statement")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.StatementIcon));
			TransactionPage_OR.StatementIcon.click();
		}
		else if(Button.equals("Money Transfer")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.MoneyTransfer));
			HomePage_OR.MoneyTransfer.click();
		}
		else if(Button.equals("Add Bank Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SwitchPayment));
			CollectionsPage_OR.SwitchPayment.click();
		}
		else if(Button.equals("Account Number Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SubmitAccountNumber));
			CollectionsPage_OR.SubmitAccountNumber.click();
		}
		else if(Button.equals("IFSC Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SubmitAccountNumber));
			CollectionsPage_OR.SubmitAccountNumber.click();
		}
		else if(Button.equals("Account Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SubmitUPI));
			CollectionsPage_OR.SubmitUPI.click();
		}
		else if(Button.equals("Supplier IFSC Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SubmitUPI));
			CollectionsPage_OR.SubmitUPI.click();
		}
		else if(Button.equals("Supplier UPI Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SubmitUPI));
			CollectionsPage_OR.SubmitUPI.click();
		}
		else if(Button.equals("Send Money")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.SendMoney));
			MoneyTransfer_OR.SendMoney.click();
		}
		else if(Button.equals("Change Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.change_details));
			SupplierPage_OR.ChangeAccount.click();
		}
		else if(Button.equals("Change Details")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.change_details));
			SupplierPage_OR.change_details.click();
		}
		else if(Button.equals("Net Banking")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayMentOptionNetbanking));
			MoneyTransfer_OR.PayMentOptionNetbanking.click();
		}
		else if(Button.equals("Three Dot Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ThreeDotMenu));
			TransactionPage_OR.ThreeDotMenu.click();
		}
		else if(Button.equals("Give Discount")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.GiveDiscount));
			TransactionPage_OR.GiveDiscount.click();
		}
		else if(Button.equals("Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
			TransactionPage_OR.PaymentSubmit.click();
		}
		else if(Button.equals("Discount Offered CTA")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DiscountOfferedHeader));
			TransactionPage_OR.DiscountOfferedHeader.click();
			}
			catch(Exception E) {
				Log.info("No discount is offered, hence cannot see the Discounts in details");
			}
		}
		else if(Button.equals("Delete Discount")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletePayment));
			TransactionPage_OR.DeletePayment.click();
		}
		else if(Button.equals("Discount Offered CTA")) {
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.DiscountOffered));
			AccountPage_OR.DiscountOffered.click();
		}
		else if(Button.equals("Collection Due")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CollectionDate));
			TransactionPage_OR.CollectionDate.click();
			}
			catch(Exception E) {
				Log.info("Due date is already selected for the user, so editing the existing date");
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.EditDueDate));
				TransactionPage_OR.EditDueDate.click();
			}
		}
		else if(Button.equals("Due date CTA")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.EditDueDate));
			TransactionPage_OR.EditDueDate.click();
		}
		else if(Button.equals("5 Days")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.FiveDays));
			TransactionPage_OR.FiveDays.click();
		}
		else if(Button.equals("10 Days")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.TenDays));
			TransactionPage_OR.TenDays.click();
		}
		else if(Button.equals("15 Days")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.FifteenDays));
			TransactionPage_OR.FifteenDays.click();
		}
		else if(Button.equals("30 Days")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ThirtyDays));
			TransactionPage_OR.ThirtyDays.click();
		}
		else if(Button.equals("Remind")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Remind));
			TransactionPage_OR.Remind.click();
		}
		else if(Button.equals("Collection")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Collections));
			HomePage_OR.Collections.click();
		}
		else if(Button.equals("Setup Collection")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SetupCollection));
			CollectionsPage_OR.SetupCollection.click();
		}
		else if(Button.equals("Change")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.Change));
			CollectionsPage_OR.Change.click();
		}
		else if(Button.equals("Add UPI ID")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SwitchPayment));
			CollectionsPage_OR.SwitchPayment.click();
		}
		else if(Button.equals("Add UPI")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.AddUPI));
			CollectionsPage_OR.AddUPI.click();
		}
		else if(Button.equals("QR Code icon")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.QRSccannerIcon));
			CollectionsPage_OR.QRSccannerIcon.click();
		}
		else if(Button.equals("UPI Submit")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SubmitAccountNumber));
			CollectionsPage_OR.SubmitAccountNumber.click();
		}
		else if(Button.equals("Confirm Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.Confirm));
			CollectionsPage_OR.Confirm.click();
		}
		else if(Button.equals("Merchant QR")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.QRIcon));
			CollectionsPage_OR.QRIcon.click();
		}
		else if(Button.equals("Collection Menu")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.ThreeDotMenuinQRPage));
			CollectionsPage_OR.ThreeDotMenuinQRPage.click();
		}
		else if(Button.equals("Delete Account")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.DeleteAccount));
			CollectionsPage_OR.DeleteAccount.click();
		}
		else if(Button.equals("Share QR")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.ShareQR));
			CollectionsPage_OR.ShareQR.click();
		}
		else if(Button.equals("Save")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.SaveQR));
			CollectionsPage_OR.SaveQR.click();
		}
		else if(Button.equals("All Transactions")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.AllTransaction));
			CollectionsPage_OR.AllTransaction.click();
		}
		else if(Button.equals("Collection Filter")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.FilterMenu));
			CollectionsPage_OR.FilterMenu.click();
		}
		else if(Button.equals("Online Collection")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.OnlineTransAction));
			CollectionsPage_OR.OnlineTransAction.click();
		}
		else if(Button.equals("Update Bank UPI")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.UpdateBankUPI));
			CollectionsPage_OR.UpdateBankUPI.click();
		}
		else if(Button.equals("Update Bank UPI OK")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.Ok));
			CollectionsPage_OR.Ok.click();
		}
		else if(Button.equals("Online Collection Statement")) {
			wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.OnlineCollectionSatement));
			CollectionsPage_OR.OnlineCollectionSatement.click();
		}
		else if(Button.equals("Filter")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Filter));
			HomePage_OR.Filter.click();
		}
		else if(Button.equals("Today In Filter")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Today));
			HomePage_OR.Today.click();
		}
		else if(Button.equals("Apply")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Apply));
			HomePage_OR.Apply.click();
		}
		else if(Button.equals("Clear Filter")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ClearInFilters));
			HomePage_OR.ClearInFilters.click();
		}
		else if(Button.equals("Clear Filter Page")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ClearInFilter));
			HomePage_OR.ClearInFilter.click();
		}
		else if(Button.equals("Name In Sort")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SortName));
			HomePage_OR.SortName.click();
		}
		else if(Button.equals("Amount in Sort")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SortAmount));
			HomePage_OR.SortAmount.click();
		}
		else if(Button.equals("Latest in Sort")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SortLatest));
			HomePage_OR.SortLatest.click();
		}
		else if(Button.equals("Take Credit")) {
			
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentButton));
				TransactionPage_OR.PaymentButton.click();
		}
		else if(Button.equals("Give Payment")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CreditButton));
			TransactionPage_OR.CreditButton.click();
		}
		else if(Button.equals("Customer Profile")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.AddedCustomerHeader));
			CustomerPage_OR.AddedCustomerHeader.click();
		}
		else if(Button.equals("Pay Online")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.PayOnline));
			SupplierPage_OR.PayOnline.click();
			}
			catch(Exception E){
				driver.navigate().back();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.PayOnline));
				SupplierPage_OR.PayOnline.click();
			}
		}
		else if(Button.equals("Proceed")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.Proceed));
			SupplierPage_OR.Proceed.click();
		}
		else if(Button.equals("Pay")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayButtonInCardDetailsPage));
			MoneyTransfer_OR.PayButtonInCardDetailsPage.click();
		}
		else if(Button.equals("Retry")) {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.Retry));
			SupplierPage_OR.Retry.click();
		}
		else if(Button.equals("Select Different Bank")) {
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.SelectDifferentBank));
			MoneyTransfer_OR.SelectDifferentBank.click();
		}
		else if(Button.equals("Merchant Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantNumber));
			MerchantProfilePage_OR.MerchantNumber.click();
		}
		else if(Button.equals("Business Category")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantCategory));
			MerchantProfilePage_OR.MerchantCategory.click();
		}
		else if(Button.equals("Other Info")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.OtherINfo));
			MerchantProfilePage_OR.OtherINfo.click();
		}
		else if(Button.equals("Sync Now")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SyncNow));
			HomePage_OR.SyncNow.click();
		}
		else if(Button.equals("Rewards")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Rewards));
			HomePage_OR.Rewards.click();
		}
		else if(Button.equals("Share")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.ShareMenu));
			HomePage_OR.ShareMenu.click();
		}
		else if(Button.equals("Home Delivery")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.HomeDelivery));
			HomePage_OR.HomeDelivery.click();
		}
		else if(Button.equals("Mobile Recharge")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.MobilePrepaidRecharge));
			HomePage_OR.MobilePrepaidRecharge.click();
		}
		else if(Button.equals("About Us")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AboutUs));
			HomePage_OR.AboutUs.click();
		}
		else if(Button.equals("Privacy Policy")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.PrivacyPolicy));
			HomePage_OR.PrivacyPolicy.click();
		}
		else if(Button.equals("Rate Us")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.RateUs));
			HomePage_OR.RateUs.click();
		}
		else if(Button.equals("Insurance")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Insurance));
			HomePage_OR.Insurance.click();
		}
		else if(Button.equals("Try Again")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.TryAgain));
			CustomerPage_OR.TryAgain.click();
		}
		else if(Button.equals("Internet Cancel")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Cancel));
			CustomerPage_OR.Cancel.click();
		}
		else if(Button.equals("Submit Transaction")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
			TransactionPage_OR.PaymentSubmit.click();
		}
		else if(Button.equals("Reminder Whatsapp")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsappReminderIcon));
			TransactionPage_OR.WhatsappReminderIcon.click();
		}
		else if(Button.equals("Reminder Call")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CallIcon));
			TransactionPage_OR.CallIcon.click();
		}
		else if(Button.equals("Voice Assistant")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.VoiceIconFab));
			TransactionPage_OR.VoiceIconFab.click();
		}
		else if(Button.equals("Statement Button")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.StatementIcon));
			TransactionPage_OR.StatementIcon.click();
		}
		else if(Button.equals("Download Report")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.download_report));
			TransactionPage_OR.download_report.click();
		}
		else if(Button.equals("Share Report")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.share_report));
			TransactionPage_OR.share_report.click();
		}
		else if(Button.equals("Send message")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SendChat));
			CustomerPage_OR.SendChat.click();
		}
		else if(Button.equals("Show QR")) {
			wait.until(ExpectedConditions.elementToBeClickable(LinkPay_OR.ShowQR));
			LinkPay_OR.ShowQR.click();
		}
	}
	@Then("^Verify all the slides in Welcome Page$")
	public void verify_slide() {
		wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TutotrialTitle)).isDisplayed();
		Assert.assertTrue(LandingPage_OR.TutotrialTitle.isDisplayed());
		String tutorialText = LandingPage_OR.TutotrialTitle.getText();
		
		System.out.println("The Current tutorial Header is :" + tutorialText );
	}
	
	@And("^User enters the \"([^\"]*)\"$")
	public void user_enters_mobile(String Number) throws InterruptedException, IOException {
		if(Number.equals("Invalid mobile number")) {
			Log.warn("Entering invalid Mobile  number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.InvalidMobileNumber);
		}
		else if(Number.equals("Mobile Number")) {
			Log.info("Entering Valid Mobile  number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.MobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
		}
		else if(Number.equals("New Mobile Number")) {
			Log.info("Entering New Mobile  number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.NewMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
		}
		else if(Number.equals("Special characters")) {
			Log.info("Entering Special characters");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			SpecialCharacter1 = ".";
			SpecialCharacter2 = ",";
			LandingPage_OR.MobileNumberField.sendKeys(SpecialCharacter1);
			LandingPage_OR.MobileNumberField.sendKeys(SpecialCharacter2);
		}
		else if(Number.equals("Short Business Name")) {
			Log.info("Entering Short Business Name");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.BusinessNameEntryField)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.BusinessNameEntryField.isDisplayed());
			ShortBusinessName = "Raju Medical";
			LandingPage_OR.BusinessNameEntryField.sendKeys(ShortBusinessName);
		}
		else if(Number.equals("Long Business Name")) {
			Log.info("Entering Long Business Name");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.BusinessNameEntryField)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.BusinessNameEntryField.isDisplayed());
			LongBusinessName = "Veena Rajan Pattani Kirana Store";
			LandingPage_OR.BusinessNameEntryField.sendKeys(LongBusinessName);
		}
		else if(Number.equals("More than 10 digit mobile number")) {
			Log.info("Entering more than 10 digit mobile number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.MobileNumberMoreThan10Digit);
		}
		else if(Number.equals("Mobile Number with applock enabled")) {
			Log.info("Entering mobile Number with applock enabled");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.MobileNumberWithApplockEnabled);
		}
		else if(Number.equals("Invalid applock pin")) {
			Thread.sleep(3000);
			Log.info("Entering Invalid applock pin");
//			CF.runCommand(ADB_COMMAND_TO_ENTER_PIN);
			String ADB=ANDROID_HOME;
			String cmd = "/platform-tools/adb shell input text 123458";
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(ADB+cmd);
			pr.waitFor();
		}
		else if(Number.equals("Valid applock pin")) {
			Thread.sleep(3000);
			Log.info("Entering Valid applock pin");
//			CF.runCommand(ADB_COMMAND_TO_ENTER_PIN);
			String ADB=ANDROID_HOME;
			String cmd = "/platform-tools/adb shell input text 123456";
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(ADB+cmd);
			pr.waitFor();
		}
		else if(Number.equals("New Help")) {
			Log.info("Entering Valid Mobile  number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.LPMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
		}
		else if(Number.equals("Mobile Expenses Number")) {
			Log.info("Entering Valid Mobile  number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.MobileNumberExpenses);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
		}
		else if(Number.equals("AB Number")) {
			Log.info("Entering Valid Mobile  number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.ABNumber);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
		}
		else if(Number.equals("Wrong OTP")) {
			WrongOtp1 = "1";
			WrongOtp2 = "2";
			WrongOtp3 = "3";
			WrongOtp4 = "4";
			WrongOtp5 = "5";
			WrongOtp6 = "6";
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
			LandingPage_OR.OtpTextBox1.sendKeys(WrongOtp1);
			LandingPage_OR.OtpTextBox2.sendKeys(WrongOtp2);
			LandingPage_OR.OtpTextBox3.sendKeys(WrongOtp3);
			LandingPage_OR.OtpTextBox4.sendKeys(WrongOtp4);
			LandingPage_OR.OtpTextBox5.sendKeys(WrongOtp5);
			LandingPage_OR.OtpTextBox6.sendKeys(WrongOtp6);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.InCorrectPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.InCorrectPin.isDisplayed());
		}
		else if(Number.equals("OTP")) {
			try {
			Otp = "0";
			if(LandingPage_OR.OtpTextBox1.isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox1)).isDisplayed();
			LandingPage_OR.OtpTextBox1.sendKeys(Otp);
			LandingPage_OR.OtpTextBox2.sendKeys(Otp);
			LandingPage_OR.OtpTextBox3.sendKeys(Otp);
			LandingPage_OR.OtpTextBox4.sendKeys(Otp);
			LandingPage_OR.OtpTextBox5.sendKeys(Otp);
			LandingPage_OR.OtpTextBox6.sendKeys(Otp);
			}
			else {
				LandingPage_OR.OtpTextBox.sendKeys("000000");
				}
			}
			catch(Exception E){
				Log.info("OTP Entered Automatically");
			}
		}
		else if(Number.equals("Customer Name")) {
			Log.info("Merchant Entering Customer name");
			try {
				wait.until(ExpectedConditions.visibilityOf(HomePage_OR.InputCustomerName)).isDisplayed();
				HomePage_OR.InputCustomerName.sendKeys("Customer"+customerName);
			}
			catch(Exception E) {
			wait.until(ExpectedConditions.visibilityOfAllElements(HomePage_OR.AddCustomer));
			HomePage_OR.AddCustomer.click();
			wait.until(ExpectedConditions.visibilityOf(HomePage_OR.InputCustomerName)).isDisplayed();
			HomePage_OR.InputCustomerName.sendKeys("Customer"+customerName);
			}
		}
		else if(Number.equals("Customer Number")) {
			Log.info("Merchant Entering Customer name");
			wait.until(ExpectedConditions.visibilityOf(HomePage_OR.InputCustomerName)).isDisplayed();
			HomePage_OR.AddCustomerNumberField.sendKeys(CustomerNumber);
		}
		else if(Number.equals("Wrong Password")) {
			Log.info("Merchant Entering  Wrong Password");
			wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.Password)).isDisplayed();
			CustomerPage_OR.Password.sendKeys("12345");
			CustomerPage_OR.Delete.click();
			Assert.assertTrue(CustomerPage_OR.WrongPassword.isDisplayed());
		}
		else if(Number.equals("Password")) {
			Log.info("Merchant Entering Password to delete the Customer");
			wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.Delete)).isDisplayed();
			CustomerPage_OR.Password.click();
			CustomerPage_OR.Password.clear();
			CustomerPage_OR.Password.sendKeys(data.password);
			CustomerPage_OR.Delete.click();
		}
		else if(Number.equals("Delete Password")) {
			Log.info("Merchant Entering Password to delete the Customer");
			wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.Password)).isDisplayed();
			CustomerPage_OR.Password.clear();
			CustomerPage_OR.Password.sendKeys(data.password);
			TransactionPage_OR.DeleteOK.click();
		}
		else if(Number.equals("Payment")) {
			Log.info("Merchant Entering Payment Details");
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.AddPaymentText)).isDisplayed();
			TransactionPage_OR.AddPaymentText.click();
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.ButtonFive)).isDisplayed();
			TransactionPage_OR.ButtonFive.click();
			TransactionPage_OR.ButtonZero.click();
			TransactionPage_OR.ButtonZero.click();
		}
		else if(Number.equals("Credit")) {
			Log.info("Merchant Entering Payment Details");
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.AddCredit)).isDisplayed();
			TransactionPage_OR.AddCredit.click();
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.ButtonFive)).isDisplayed();
			TransactionPage_OR.ButtonFive.click();
			TransactionPage_OR.ButtonZero.click();
			TransactionPage_OR.ButtonZero.click();
		}
		else if(Number.equals("Expenses Amount")) {
			Log.info("Merchant Entering Expenses Details");
			wait.until(ExpectedConditions.visibilityOf(ExpensesPage_OR.Expenses_Amount)).isDisplayed();
			ExpensesPage_OR.Expenses_Amount.click();
			wait.until(ExpectedConditions.visibilityOf(ExpensesPage_OR.Expenses_Amount)).isDisplayed(); 
			ExpensesPage_OR.Expenses_Amount.sendKeys(data.expenses);
		}
		else if(Number.equals("Enter Type Expenses")) {
			Log.info("Merchant Entering Type of Expenses Details");
			wait.until(ExpectedConditions.visibilityOf(ExpensesPage_OR.Expenses_Type)).isDisplayed();
			ExpensesPage_OR.Expenses_Type.click();
			wait.until(ExpectedConditions.visibilityOf(ExpensesPage_OR.Expenses_Type)).isDisplayed();
			ExpensesPage_OR.Expenses_Type.sendKeys(data.typeExpenses); 
		}
		else if(Number.equals("Supplier Name")) {
			Log.info("Merchant Entering Supplier name");
			wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.SupplierNameNumberTextBox)).isDisplayed();
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys("Supplier"+customerName);
		}
		else if(Number.equals("Supplier Number")) {
			Log.info("Merchant Entering Supplier Number");
			wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.SupplierNameNumberTextBox)).isDisplayed();
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(CustomerNumber);
		}
		else if(Number.equals("Supplier Number")) {
			Log.info("Merchant Entering Supplier Number");
			wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.SupplierNameNumberTextBox)).isDisplayed();
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(CustomerNumber);
		}
		else if(Number.equals("Enter Migrate Supplier Number")) {
			Log.info("Merchant Entering Supplier Number");
			wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.SupplierNameNumberTextBox)).isDisplayed();
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(CustomerNumber);
		}
		else if(Number.equals("Existing Customer Number")) {
			Log.info("Merchant Entering Existing Customer Number");
			wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.SupplierNameNumberTextBox)).isDisplayed();
			
			String ExistingCustomerNumber = AddTransactionsStepDefinitions.SupplierNumber;
			System.out.println("Entering Supplier Number as "+ ExistingCustomerNumber );
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(ExistingCustomerNumber);
		}
		else if(Number.equals("Deleted Supplier Name")) {
			Log.info("Merchant Entering Deleted Supplier name");
			wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.SupplierNameNumberTextBox)).isDisplayed();
			AddCustomerFlowStepDefinitions customer = new AddCustomerFlowStepDefinitions();
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(customer.DeletedSuppliername);
		}
		else if(Number.equals("Deleted Supplier Number")) {
			Log.info("Merchant Entering Deleted Supplier Number");
			String ExistingSupplierNumber = AddCustomerFlowStepDefinitions.SupplierNumber;
			if(ExistingSupplierNumber != null) {
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(ExistingSupplierNumber);
			try{
				SupplierPage_OR.SupplierNameSubmitOk.isEnabled();
			}
			catch(Exception E) {
				Log.info("The Deleted Supplier does not have mobile number associated. Entering Mobile number from different Supplier");
				SupplierPage_OR.ClearSupplierName.click();
				SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(CustomerNumber);
				}
			}
			else {
				Log.info("Not able to to get Deleted Supplier Number");
				SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(data.MobileNumberSupplier);
			}
		}
		else if(Number.equals("Deleted Supplier Account Number")) {
			Log.info("Merchant Entering Deleted Supplier Number");
			String ExistingSupplierNumber = AddCustomerFlowStepDefinitions.SupplierNumber;
			if(ExistingSupplierNumber != null) {
			SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(data.MobileNumberSupplier);
			try{
				SupplierPage_OR.SupplierNameSubmitOk.isEnabled();
			}
			catch(Exception E) {
				Log.info("The Deleted Supplier does not have mobile number associated. Entering Mobile number from different Supplier");
				SupplierPage_OR.ClearSupplierName.click();
				SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(CustomerNumber);
				}
			}
			else {
				Log.info("Not able to to get Deleted Supplier Number");
				SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(data.MobileNumberSupplier);
			}
		}
		else if(Number.equals("Wrong Account Number")) {
			Log.info("Merchant entering the wrong Account Number");
			wait.until(ExpectedConditions.visibilityOf(CollectionsPage_OR.AddAccountNumberTextBox)).isDisplayed();
			CollectionsPage_OR.AddAccountNumberTextBox.sendKeys(data.InvalidAccountNumber);
		}
		else if(Number.equals("Wrong IFSC")) {
			Log.info("Merchant entering the wrong IFSC Code");
			wait.until(ExpectedConditions.visibilityOf(CollectionsPage_OR.IFSCCodeTextBox)).isDisplayed();
			CollectionsPage_OR.IFSCCodeTextBox.sendKeys(data.InvalidIFSC);
		}
		else if(Number.equals("Account Number")) {
			Log.info("Merchant entering the wrong Account Number");
			wait.until(ExpectedConditions.visibilityOf(CollectionsPage_OR.AddAccountNumberTextBox)).isDisplayed();
			CollectionsPage_OR.AddAccountNumberTextBox.sendKeys(data.AccountNumber);
		}
		else if(Number.equals("IFSC")) {
			Log.info("Merchant entering the wrong IFSC Code");
			wait.until(ExpectedConditions.visibilityOf(CollectionsPage_OR.IFSCCodeTextBox)).isDisplayed();
			CollectionsPage_OR.IFSCCodeTextBox.clear();
			CollectionsPage_OR.IFSCCodeTextBox.sendKeys(data.IFSC);
		}
		else if(Number.equals("Amount")) {
			Log.info("Merchant entering Amount to transfer Money");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.AmountTextBox)).isDisplayed();
			MoneyTransfer_OR.AmountTextBox.sendKeys("100");
		}
		else if(Number.equals("FeedBack Text")) {
			Log.info("Merchant enter the feedback of help");
			wait.until(ExpectedConditions.visibilityOf(HelpPage_OR.FeedBack_Text)).isDisplayed();
			HelpPage_OR.FeedBack_Text.sendKeys("100");
		}
		else if(Number.equals("Discount as 0")) {
			Log.info("Merchant entering Discount as 0");
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.AddPaymentText)).isDisplayed();
			TransactionPage_OR.AddPaymentText.click();
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.ButtonZero)).isDisplayed();
			TransactionPage_OR.ButtonZero.click();
		}
		else if(Number.equals("Discount as 100")) {
			Log.info("Merchant entering Discount as 100");
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.AddPaymentText)).isDisplayed();
			TransactionPage_OR.AddCredit.click();
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.ButtonFive)).isDisplayed();
			TransactionPage_OR.ButtonOne.click();
			TransactionPage_OR.ButtonZero.click();
			TransactionPage_OR.ButtonZero.click();
		}
		else if(Number.equals("Wrong UPI ID")) {
			Log.info("Merchant entering the Wrong UPI ID");
			wait.until(ExpectedConditions.visibilityOf(CollectionsPage_OR.UPIIDTextBox)).isDisplayed();
			CollectionsPage_OR.UPIIDTextBox.clear();
			CollectionsPage_OR.UPIIDTextBox.sendKeys(data.WrongUPI);
		}
		else if(Number.equals("UPI ID")) {
			Log.info("Merchant entering the Wrong UPI ID");
			wait.until(ExpectedConditions.visibilityOf(CollectionsPage_OR.UPIIDTextBox)).isDisplayed();
			CollectionsPage_OR.UPIIDTextBox.clear();
			CollectionsPage_OR.UPIIDTextBox.sendKeys(data.UPI);
		}
		else if(Number.equals("Updated UPI ID")) {
			Log.info("Merchant entering the Wrong UPI ID");
			wait.until(ExpectedConditions.visibilityOf(CollectionsPage_OR.UPIIDTextBox)).isDisplayed();
			CollectionsPage_OR.UPIIDTextBox.clear();
			CollectionsPage_OR.UPIIDTextBox.sendKeys(data.UpdatedUPI);
		}
		else if(Number.equals("Customer Number for Delete")) {
			Log.info("Merchant Entering Customer name");
			wait.until(ExpectedConditions.visibilityOf(HomePage_OR.InputCustomerName)).isDisplayed();
			HomePage_OR.AddCustomerNumberField.sendKeys(data.CustomerNumberDelete);
		}
		else if(Number.equals("Credit Card Details")) {
			Log.info("Merchant Entering Suppliers Credit Card Details");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CardNumber)).isDisplayed();
			MoneyTransfer_OR.CardNumber.sendKeys(data.CreditCardMasterCard);
			Log.info("Card Number is : " + data.CreditCardMasterCard);
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CardHolderName)).isDisplayed();
			MoneyTransfer_OR.CardHolderName.sendKeys(data.CardHoldersname);
			Log.info("Card Holder name is : " + data.CardHoldersname);
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CVV)).isDisplayed();
			MoneyTransfer_OR.CVV.sendKeys(data.CVV);
			Log.info("CVV : " + data.CVV);
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.Expiry)).isDisplayed();
			MoneyTransfer_OR.Expiry.sendKeys(data.ExpiryDate);
			Log.info("Expiry  date for the card is : " + data.ExpiryDate);
		}
		else if(Number.equals("Card Holder name")) {
			Log.info("Merchant Entering Customer name");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CardHolderName)).isDisplayed();
			MoneyTransfer_OR.CardHolderName.sendKeys(data.CardHoldersname);
		}
		else if(Number.equals("CVV")) {
			Log.info("Merchant Entering CVV");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CVV)).isDisplayed();
			MoneyTransfer_OR.CVV.sendKeys(data.CVV);
		}
		else if(Number.equals("Master Card Number")) {
			Log.info("Merchant Entering Master Card Number");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CardNumber)).isDisplayed();
			MoneyTransfer_OR.CardNumber.sendKeys(data.DebitCardMasterCard);
		}
		else if(Number.equals("Visa Card Number")) {
			Log.info("Merchant Entering Visa Card Number");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CardNumber)).isDisplayed();
			MoneyTransfer_OR.CardNumber.clear();
			MoneyTransfer_OR.CardNumber.sendKeys(data.CreditCardVisa);
		}
		else if(Number.equals("AMEX Card Number")) {
			Log.info("Merchant Entering AMEX Card Number");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CardNumber)).isDisplayed();
			MoneyTransfer_OR.CardNumber.clear();
			MoneyTransfer_OR.CardNumber.sendKeys(data.AmexCard);
		}
		else if(Number.equals("DinersClub Card Number")) {
			Log.info("Merchant Entering DinersClub Card Number");
			wait.until(ExpectedConditions.visibilityOf(MoneyTransfer_OR.CardNumber)).isDisplayed();
			MoneyTransfer_OR.CardNumber.clear();
			MoneyTransfer_OR.CardNumber.sendKeys(data.DinerClub);
		}
		else if(Number.equals("Merchant Email")) {
			Log.info("Merchant Entering Merchant Email");
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.MerchantEmail)).isDisplayed();
			MerchantProfilePage_OR.MerchantEmail.click();
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.BusinessNameInput)).isDisplayed();
			MerchantProfilePage_OR.BusinessNameInput.sendKeys(data.MerchantEmail);
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.BUsinessNameSubmit)).isDisplayed();
			MerchantProfilePage_OR.BUsinessNameSubmit.click();
			try {
				wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.MerchantEmailError)).isDisplayed();
				Log.info((MerchantProfilePage_OR.MerchantEmailError).getText());
				Assert.assertTrue(MerchantProfilePage_OR.MerchantEmailError.isDisplayed());
			}
			catch(Exception E) {
				driver.navigate().back();
			}
		}
		else if(Number.equals("Merchant Business Info")) {
			Log.info("Merchant Entering Merchant Business Info");
			CF.scrollToText("Share your business card", driver);
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.AboutBusiness)).isDisplayed();
			MerchantProfilePage_OR.AboutBusiness.click();
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.BusinessNameInput)).isDisplayed();
			MerchantProfilePage_OR.BusinessNameInput.sendKeys(data.MerchantInfo);
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.BUsinessNameSubmit)).isDisplayed();
			MerchantProfilePage_OR.BUsinessNameSubmit.click();
		}
		else if(Number.equals("Contact Person Name")) {
			Log.info("Merchant Entering Contact Person Name");
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.ContactPersonName)).isDisplayed();
			MerchantProfilePage_OR.ContactPersonName.click();
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.BusinessNameInput)).isDisplayed();
			MerchantProfilePage_OR.BusinessNameInput.sendKeys(data.MerchantContact);
			wait.until(ExpectedConditions.visibilityOf(MerchantProfilePage_OR.BUsinessNameSubmit)).isDisplayed();
			MerchantProfilePage_OR.BUsinessNameSubmit.click();
		}
		else if(Number.equals("Password for Transaction")) {
			Log.info("Merchant Entering Password for Transaction");
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.EnterPassword)).isDisplayed();
			TransactionPage_OR.EnterPassword.click();
			TransactionPage_OR.EnterPassword.sendKeys(data.TrasnactionPassword);
		}
	}
	@Then("^Verify the \"([^\"]*)\" button$")
	public static void verify_the_button(String Button){
		if(Button.equals("X")) {
			Log.info("Clear the mobile number field by clicking X button");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.MobileNumberCancel)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberCancel.isDisplayed());
		}
		else if(Button.equals("OK")) {
			Log.info("Click OK button after entering the correct mobile number");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberSubmit.isDisplayed());
		}
		else if(Button.equals("Resend OTP")) {
			Log.info("Verifying the Resending the OTP option");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.DidntGetOtp)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.DidntGetOtp.isDisplayed());
		}
		else if(Button.equals("Edit Mobile")) {
			Log.info("Verifying the Edit Mobile option");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.EditMobileNumber)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.EditMobileNumber.isDisplayed());
		}
		else if(Button.equals("Voice Record")) {
			Log.info("Verifying the Edit Mobile option");
			wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.VoiceIconFab)).isDisplayed();
			Assert.assertTrue(TransactionPage_OR.VoiceIconFab.isDisplayed());
		}
	}
	@And("^User chooses number in the list$")
	public void user_chooses_number() {
		Log.info("Chooses the number from Auto Poppulated List");
		try {
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.ContinueWith)).isDisplayed();
			LandingPage_OR.ChooseMobilefromThelist.click();
		}
		catch(Exception E) {
			Log.info("Google Auto populate lists are not available. Please choose the contact manually");
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.YourSixDigitPin)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.MobileNumberField.isDisplayed());
			LandingPage_OR.MobileNumberField.sendKeys(data.InvalidMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
			LandingPage_OR.MobileNumberSubmit.click();
		}
	}
	
	@And("^User navigates back$")
	public void user_navigates_back() throws InterruptedException {
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().back();
	}
	@And("^Verify App in Different Network$")
	public void verify_differnet_network() {
		
		String removePicsCmd = "adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings";

		driver.executeScript("mobile: shell", removePicsCmd);
		
	}
	@And("^Hide Keyboard$")
	public void hide_keyboard() {
		driver.hideKeyboard();
	}
	@Then("^user closes the App$")
	public void user_closes_app() {
		driver.quit();
	}
	@Then("^User terminates the App$")
	public void user_terminates_app() {
		driver.closeApp();
	}
	@Then("^User relaunches the app$")
	public void user_relaunches_app() {
		driver.launchApp();
	}
	
	@And("^User disconnects \"([^\"]*)\"$")
	public void user_disconnects(String Option) throws InterruptedException, IOException {
		if(Option.equals("Internet")) {
			Thread.sleep(2000);
//			Log.info("Disconnecting the Internet : " + ADB_COMMAND_TO_TURNOFF_WIFI );
//			CF.runCommand(ADB_COMMAND_TO_TURNOFF_WIFI);
			
			String ADB=ANDROID_HOME;
			String cmd = "/platform-tools/adb shell am broadcast -a io.appium.settings.wifi --es setstatus disable";
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(ADB+cmd);
			pr.waitFor();
			
		}
	}
	@And("^User connects \"([^\"]*)\"$")
	public void user_connects(String Option) throws InterruptedException, IOException {
		if(Option.equals("Internet")) {
			Thread.sleep(2000);
//			CF.runCommand(ADB_COMMAND_TO_TURNON_WIFI);
			
			String ADB=ANDROID_HOME;
			String cmd = "/platform-tools/adb shell am broadcast -a io.appium.settings.wifi --es setstatus enable";
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(ADB+cmd);
			pr.waitFor();
			
		}
	}
	@And("^User close the app and relauches$")
	public void user_closes_and_relaunches_the_App() throws InterruptedException {
		driver.closeApp();
		Thread.sleep(4000);
		driver.launchApp();
	}
	@And("^User logins with \"([^\"]*)\"$")
	public void user_logins_with(String Option) throws InterruptedException {
		if(Option.equals("Supplier Account")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.NextButton)).isDisplayed();
				LandingPage_OR.NextButton.click();
				wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.VerifyMobile)).isDisplayed();
				LandingPage_OR.VerifyMobile.click();
				if(LandingPage_OR.NoneOfTheAbove.isDisplayed()) {
					LandingPage_OR.NoneOfTheAbove.click();
				}
				else {
					Log.info("Google Auto populate number is not appeared in Landing page");
				}
				
			}
			catch(Exception E) {
				Log.info("App Launches with New Login Page");
				wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberField)).isDisplayed();
			}
			
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.MobileNumberField)).isDisplayed();
			LandingPage_OR.MobileNumberField.sendKeys(data.MobileNumberSupplier);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
			LandingPage_OR.MobileNumberSubmit.click();
			Otp = "0";
			try {
				wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
				LandingPage_OR.OtpTextBox1.sendKeys(Otp);
				LandingPage_OR.OtpTextBox2.sendKeys(Otp);
				LandingPage_OR.OtpTextBox3.sendKeys(Otp);
				LandingPage_OR.OtpTextBox4.sendKeys(Otp);
				LandingPage_OR.OtpTextBox5.sendKeys(Otp);
				LandingPage_OR.OtpTextBox6.sendKeys(Otp);
				}
				catch (Exception e) {
				wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
				LandingPage_OR.OtpTextBox.click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				try {
					wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OTPsentsuccessfully)).isDisplayed();
				}
				catch(Exception E) {
					Log.info("OTP didn't recieved yet");
				}
				
				LandingPage_OR.OtpTextBox.click();
				LandingPage_OR.OtpTextBox.sendKeys(data.password);
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				js.executeScript("arguments[0].value='000000';", LandingPage_OR.OtpTextBox);
				}
			
		}
		if(Option.equals("Merchant Account")) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.NextButton)).isDisplayed();
				LandingPage_OR.NextButton.click();
				wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.VerifyMobile)).isDisplayed();
				LandingPage_OR.VerifyMobile.click();
				if(LandingPage_OR.NoneOfTheAbove.isDisplayed()) {
					LandingPage_OR.NoneOfTheAbove.click();
				}
				else {
					Log.info("Google Auto populate number is not appeared in Landing page");
				}
			}
			catch(Exception E) {
				Log.info("App Launches with New Login Page");
				wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberField)).isDisplayed();
			}
			wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.MobileNumberField)).isDisplayed();
			LandingPage_OR.MobileNumberField.sendKeys(data.MobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.MobileNumberSubmit)).isDisplayed();
			LandingPage_OR.MobileNumberSubmit.click();
			Otp = "0";
			try {
				wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
				LandingPage_OR.OtpTextBox1.sendKeys(Otp);
				LandingPage_OR.OtpTextBox2.sendKeys(Otp);
				LandingPage_OR.OtpTextBox3.sendKeys(Otp);
				LandingPage_OR.OtpTextBox4.sendKeys(Otp);
				LandingPage_OR.OtpTextBox5.sendKeys(Otp);
				LandingPage_OR.OtpTextBox6.sendKeys(Otp);
				}
				catch (Exception e) {
				wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
				LandingPage_OR.OtpTextBox.click();
				Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				try {
					wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OTPsentsuccessfully)).isDisplayed();
				}
				catch(Exception E) {
					Log.info("OTP didn't recieved yet");
				}
				
				LandingPage_OR.OtpTextBox.click();
				LandingPage_OR.OtpTextBox.sendKeys(data.password);
				}
		}
	}
	@Then("^User changes the \"([^\"]*)\" to \"([^\"]*)\"$")
	public void user_changes_filter(String Option1 , String Option2) {
		if(Option1.equals("Filter") && (Option2.equals("Pending"))){
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Today)).isDisplayed();
			HomePage_OR.Today.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Pending)).isDisplayed();
			HomePage_OR.Pending.click();
		}
		else if(Option1.equals("Filter") && (Option2.equals("Upcoming"))) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Today)).isDisplayed();
			HomePage_OR.Today.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Pending)).isDisplayed();
			HomePage_OR.Pending.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.UpComingDue)).isDisplayed();
			HomePage_OR.UpComingDue.click();
		}
		else if(Option1.equals("Filter") && (Option2.equals("All Three"))) {
			Log.info("Applying all three filter");
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Today)).isDisplayed();
			HomePage_OR.Today.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Pending)).isDisplayed();
			HomePage_OR.Pending.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.UpComingDue)).isDisplayed();
			HomePage_OR.UpComingDue.click();
		}
		else if(Option1.equals("Merchant Mobile Number") && (Option2.equals("Same Number"))){
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantMobileNumber)).isDisplayed();
			MerchantProfilePage_OR.MerchantMobileNumber.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.CropPageHeader)).isDisplayed();
			Assert.assertTrue(MerchantProfilePage_OR.OldNumberPic.isDisplayed());
			
			String message = MerchantProfilePage_OR.ChangeNumberMessage.getText();
			Log.info(message);
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.VerifyMobile)).isDisplayed();
			MerchantProfilePage_OR.VerifyMobile.click();
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.PleaseBePatient)).isDisplayed();
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.NewumberPic)).isDisplayed();
				Assert.assertTrue(MerchantProfilePage_OR.NewumberPic.isDisplayed());
			}
			catch(Exception E) {
				Otp = "0";
				wait.until(ExpectedConditions.visibilityOf(LandingPage_OR.OtpTextBox)).isDisplayed();
				LandingPage_OR.OtpTextBox1.sendKeys(Otp);
				LandingPage_OR.OtpTextBox2.sendKeys(Otp);
				LandingPage_OR.OtpTextBox3.sendKeys(Otp);
				LandingPage_OR.OtpTextBox4.sendKeys(Otp);
				LandingPage_OR.OtpTextBox5.sendKeys(Otp);
				LandingPage_OR.OtpTextBox6.sendKeys(Otp);
			}
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.EnterNewMobileNumber)).isDisplayed();
			Assert.assertTrue(MerchantProfilePage_OR.NewNumber.isDisplayed());
			MerchantProfilePage_OR.NewNumber.sendKeys(data.MobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.NewNumberSubmit)).isDisplayed();
			MerchantProfilePage_OR.NewNumberSubmit.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantAlreadyExist)).isDisplayed();
			Log.info(MerchantProfilePage_OR.MerchantAlreadyExist.getText());
			
		}
		else if(Option1.equals("Merchant Business Type") && (Option2.equals("Retail Shop"))) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessType)).isDisplayed();
			MerchantProfilePage_OR.BusinessType.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.RetailShop)).isDisplayed();
			MerchantProfilePage_OR.RetailShop.click();
		}
		else if(Option1.equals("Merchant Business Type") && (Option2.equals("Wholesale Distributor"))) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessType)).isDisplayed();
			MerchantProfilePage_OR.BusinessType.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.WholeSaleDistributor)).isDisplayed();
			MerchantProfilePage_OR.WholeSaleDistributor.click();
		}
		else if(Option1.equals("Merchant Business Type") && (Option2.equals("Personal Use"))) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessType)).isDisplayed();
			MerchantProfilePage_OR.BusinessType.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.PersonalUse)).isDisplayed();
			MerchantProfilePage_OR.PersonalUse.click();
		}
		else if(Option1.equals("Merchant Business Type") && (Option2.equals("Online Services"))) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessType)).isDisplayed();
			MerchantProfilePage_OR.BusinessType.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.OnlineServices)).isDisplayed();
			MerchantProfilePage_OR.OnlineServices.click();
		}
		else if(Option1.equals("Date Range") && (Option2.equals("This Month"))) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ThisMonth)).isDisplayed();
			TransactionPage_OR.ThisMonth.click();
		}
		else if(Option1.equals("Date Range") && (Option2.equals("Last Seven Days"))) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.LastSevenDays)).isDisplayed();
			TransactionPage_OR.LastSevenDays.click();
		}
		else if(Option1.equals("Date Range") && (Option2.equals("Last 0 Balance"))) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.last_zero_balance)).isDisplayed();
			TransactionPage_OR.last_zero_balance.click();
		}
		else if(Option1.equals("Date Range") && (Option2.equals("Last Month"))) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.last_month)).isDisplayed();
			TransactionPage_OR.last_month.click();
		}
		else if(Option1.equals("Date Range") && (Option2.equals("Last 3 Months"))) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.last_three_month)).isDisplayed();
			TransactionPage_OR.last_three_month.click();
		}
		else if(Option1.equals("Date Range") && (Option2.equals("Last 6 Months"))) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.last_six_month)).isDisplayed();
			TransactionPage_OR.last_three_month.click();
		}
		else if(Option1.equals("Date Range") && (Option2.equals("Overall"))) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Overall)).isDisplayed();
			TransactionPage_OR.Overall.click();
		}
		
	}
	@And("User Logins with \"([^\"]*)\"")
	public void user_logins_with_options(String Options){
		if(Options.equals("TrueCaller")) {
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrueCallerHeader)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.TrueCallerHeader.isDisplayed());
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrucallerNumberandName)).isDisplayed();
			Assert.assertTrue(LandingPage_OR.TrucallerNumberandName.isDisplayed());
			Log.info("Truecaller Profile : "+ LandingPage_OR.TrucallerNumberandName.getText());
			wait.until(ExpectedConditions.elementToBeClickable(LandingPage_OR.TrucallerContinue)).isDisplayed();
			LandingPage_OR.TrucallerContinue.click();
		}
	}
}
