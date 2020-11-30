package Driver.stepDefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.AccountPage_OR;
import ObjectRepository.CustomerPage_OR;
import ObjectRepository.DenySupplier_OR;
import ObjectRepository.HomePage_OR;
import ObjectRepository.MerchantProfilePage_OR;
import ObjectRepository.MoneyTransfer_OR;
import ObjectRepository.SupplierPage_OR;
import ObjectRepository.TransactionPage_OR;
import PageObjects.CommonMethodsFunctions;
import Utility.Log;
import cucumber.api.java.en.And;
import io.appium.java_client.MobileElement;

public class CustomerProfileStepDefinitions extends desiredCapabilities{
	
	PropertyData data = new PropertyData();
	CommonMethodsFunctions CF = new CommonMethodsFunctions();
	String CustomerName = CF.randomAlphaNumeric(10);
	String customerName = CF.randomAlphaNumeric(10);
	String SupplierName = "Supplier"+CF.randomName(10);
	String MerchantName = CF.randomName(10);
	String CustomerNumber =CF.randomNumber(10);
	String ExistingCustomer;
	String ExistingSupplier;
	
	WebDriverWait trywait = new WebDriverWait(driver, 15);
	

	@And("^User Chooses the \"([^\"]*)\"$")
	public void user_chooses_the_option(String Option) throws InterruptedException {
		if(Option.equals("Customer")) {
			
				List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/name_text_view");
				int ExistingCustomerCount = elementsList.size();
				System.out.println("There are "+ExistingCustomerCount+" Listed");
				ExistingCustomer= elementsList.get(2).getText();
				System.out.println("One of the Customer here is :" + ExistingCustomer);
				elementsList.get(2).click();
		}		
		else if(Option.equals("Date")) {
			
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.YearHeader));
			String CurrentYear = TransactionPage_OR.YearHeader.getText();
			Log.info("The current year in the calender "+CurrentYear);
			
			String CurrentDate = TransactionPage_OR.CurrentDate.getText();
			Log.info("The current year in the calender "+CurrentDate);
			
			int CalenderDate =CF.getRandomNumberInRange(1, 30);
			
			driver.findElement(By.xpath("//android.view.View[@text='"+CalenderDate+"']")).click();
			
			
			//android.view.View[@content-desc='"+CalenderDate+"']
			
			String CurrentDateNew = TransactionPage_OR.CurrentDate.getText();
			Log.info("The current year in the calender "+CurrentDateNew);
			
			if(CurrentDate.equals(CurrentDateNew)) {
				Log.info("The Selected Date is Future date and user cannot select future date. Please go with Current Date");
			}
			
			Log.info("User selected New Date. The slected date here is : " + CalenderDate );
		}
		else if(Option.equals("Due Date")){
			
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DueCalanderMonthHeader));
			Log.info("Current Date = " + CF.GetCurrentDate());
			int futuredateNew = CF.GetCurrentDate()+2;
			Log.info("New Due date "+ futuredateNew);
			if(futuredateNew <= 28){
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+futuredateNew+"']")).click();;
			}
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.NextMonthSymbol));
			TransactionPage_OR.NextMonthSymbol.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='2']")));
			driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
			
		}
		else if(Option.equals("Supplier")){
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
			HomePage_OR.SearchOrAddNext.sendKeys("Supplier");
			HomePage_OR.CustomerSearchList.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
				HomePage_OR.SearchOrAddNext.sendKeys("Supplier");
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
				HomePage_OR.CustomerSearchList.click();
			}
//			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/name_text_view");
//			ExistingCustomer= elementsList.get(2).getText();
//			System.out.println("One of the Supplier here is :" + ExistingSupplier);
//			elementsList.get(2).click();
		}
		else if(Option.equals("Supplier Account")){
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumberSupplier);
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			HomePage_OR.CustomerSearchList.click();
			}
			catch(Exception E) {
				Thread.sleep(4000);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.navigate().back();
				driver.navigate().back();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.AddSupplier));
				SupplierPage_OR.AddSupplier.click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
				SupplierPage_OR.SupplierNameNumberTextBox.click();
				SupplierPage_OR.SupplierNameNumberTextBox.sendKeys("Supplier"+CustomerName);
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
				SupplierPage_OR.SupplierNameSubmitOk.click();
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
				SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(data.MobileNumberSupplier);
				wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
				SupplierPage_OR.SupplierNameSubmitOk.click();
				Thread.sleep(4000);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.navigate().back();
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
				HomePage_OR.SearchOrAdd.click();
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
				HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumberSupplier);
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
				HomePage_OR.CustomerSearchList.click();
				
			}
		}
		else if(Option.equals("Last Transactions in Account Statement")){
			
			wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.DiscountAmount));
			List<MobileElement> elementsList = driver.findElementsById("in.okcredit.merchant:id/customer_name");
			int AvalibleTransCount= elementsList.size();
			System.out.println("Available Transactions count is :" + AvalibleTransCount);
			elementsList.get(0).click();
		}
		
		else if(Option.equals("Beneficiary")){
			Thread.sleep(8000);
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.BeneficiaryListFirst));
			String BeneficiaryListFirstName =MoneyTransfer_OR.BeneficiaryListFirst.getText();
			Log.info("Existing beneficiary name = " + BeneficiaryListFirstName);
			MoneyTransfer_OR.BeneficiaryListFirst.click();
		}
		else if(Option.equals("Customer with Discount")){
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			Thread.sleep(3000);
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			HomePage_OR.CustomerSearchList.click();
		}
		else if(Option.equals("Customer with Due")){
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.DueLabel));
			HomePage_OR.DueLabel.click();
		}
		else if(Option.equals("Customer for Block")){
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumberWithApplockEnabled);
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			HomePage_OR.CustomerSearchList.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Add));
				HomePage_OR.Add.click();
			}
			
		}
		else if(Option.equals("Supplier for Block")){
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
			HomePage_OR.SearchOrAddNext.sendKeys(data.SupplierBlockMobileNumber);
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			HomePage_OR.CustomerSearchList.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Add));
				HomePage_OR.Add.click();
			}
			
		}
		else if(Option.equals("Customer for Deny Permission")){
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumberExpenses);
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			HomePage_OR.CustomerSearchList.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Add));
				HomePage_OR.Add.click();
			}
			
		}
		else if(Option.equals("Customer for Report")){
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			HomePage_OR.SearchOrAdd.click();
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAddNext));
			HomePage_OR.SearchOrAddNext.sendKeys(data.MobileNumberReport);
			try {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			HomePage_OR.CustomerSearchList.click();
			}
			catch(Exception E) {
				wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Add));
				HomePage_OR.Add.click();
			}
		}
		else if(Option.equals("BHIM UPI")){
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayMentOptionBHIM));
			MoneyTransfer_OR.PayMentOptionBHIM.click();
		}
		else if(Option.equals("Debit Card")){
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayMentOptionDebitCard));
			MoneyTransfer_OR.PayMentOptionDebitCard.click();
		}
		else if(Option.equals("Net Banking")){
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.PayMentOptionNetbanking));
			MoneyTransfer_OR.PayMentOptionNetbanking.click();
		}
		else if(Option.equals("Bank")){
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.Allbanks));
			
//			int i = CF.getRandomNumberInRange(0, 9);
//			MoneyTransfer_OR.BankListOthers.get(i).click();;
//			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.SelectDifferentBank));
//			String SelectedBank = MoneyTransfer_OR.SelectDifferentBank.getText();
//			Log.info("Selected Bank from the List is : "  +SelectedBank);
			
			Log.info("Selecting Axis bank for Quick Transaction :)");
			wait.until(ExpectedConditions.elementToBeClickable(MoneyTransfer_OR.AxisBank));
			MoneyTransfer_OR.AxisBankInList.click();
		}
		else if(Option.equals("Business Category")){
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.CategoryItems));
			MerchantProfilePage_OR.CategoryItems.click();
		}
	}
	@And("^User changes the \"([^\"]*)\"$")
	public void user_changes_the_field(String Field) throws InterruptedException {
		if(Field.equals("Customer Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.NameXpath));
			CustomerPage_OR.NameXpath.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerNameInputField));
			CustomerPage_OR.CustomerNameInputField.sendKeys(customerName);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.NameUpdateSubmitButton));
			CustomerPage_OR.NameUpdateSubmitButton.click();
//			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerName));
			try {
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.INternetRequiredMessage));
				String message = CustomerPage_OR.INternetRequiredMessage.getText();
				Log.info(message);
			}
			catch(Exception E) {
				String UpdatedCustomerName = CustomerPage_OR.CustomerName.getText();
				Log.info("The Updated Customer Name here is :" + UpdatedCustomerName);
			}
		}
		if(Field.equals("Supplier Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.NameXpath));
			CustomerPage_OR.NameXpath.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerNameInputField));
			CustomerPage_OR.CustomerNameInputField.sendKeys(SupplierName);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SupplierNameUpdateSubmitButton));
			CustomerPage_OR.SupplierNameUpdateSubmitButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerName));
			String UpdatedCustomerName = CustomerPage_OR.CustomerName.getText();
			Log.info("The Updated Customer Name here is :" + UpdatedCustomerName);
		}
		else if(Field.equals("Customer Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
			CF.clickAction(CustomerPage_OR.MobileNumber, driver);
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerNumberInputField));
			CustomerPage_OR.CustomerNumberInputField.click();
			CustomerPage_OR.CustomerNumberInputField.clear();
			CustomerPage_OR.CustomerNumberInputField.sendKeys(CustomerNumber);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerphoneInputFieldOkButton));
			CustomerPage_OR.CustomerphoneInputFieldOkButton.click();
			}
			catch(Exception E) {
				Log.info("The Customer Already verified, Cannot change the Number");
				if(CustomerPage_OR.GotIt.isDisplayed()) {
					CustomerPage_OR.GotIt.click();
				}
				else {
					Log.info("Not able to change Users mobile");
				}
			}
		}
		else if(Field.equals("Supplier Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
			CustomerPage_OR.MobileNumber.click();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierProfileMobile));
			SupplierPage_OR.SupplierProfileMobile.click();
			SupplierPage_OR.SupplierProfileMobile.clear();
			SupplierPage_OR.SupplierProfileMobile.sendKeys(CustomerNumber);
			wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierProfilemobileNumberSubmit));
			SupplierPage_OR.SupplierProfilemobileNumberSubmit.click();
			}
			catch(Exception E) {
				Log.info("The Supplier Already verified, Cannot change the Number");
				if(CustomerPage_OR.GotIt.isDisplayed()) {
					CustomerPage_OR.GotIt.click();
				}
			}
		}
		else if (Field.equals("Address")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.HomeIcon));
			CustomerPage_OR.HomeIcon.click();
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddressinputField));
			CustomerPage_OR.CustomerAddressinputField.click();
			CustomerPage_OR.CustomerAddressinputField.clear();
			CustomerPage_OR.CustomerAddressinputField.sendKeys(data.CustomerAddress);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddressinputFieldOkButton));
			CF.clickAction(CustomerPage_OR.CustomerAddressinputFieldOkButton, driver);
			}
			catch(Exception E) {
				Log.info("Customer is Already verified, Cannot change the Address");
				if(CustomerPage_OR.GotIt.isDisplayed()) {
					CustomerPage_OR.GotIt.click();
				}
				else {
					
				}
			}
		}
		else if (Field.equals("Reminders Option")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ReminderSelected));
			String SelectedReminder = CustomerPage_OR.ReminderSelected.getText();
			Log.info("Selected Reminder : " + SelectedReminder);
			String Reminder = SelectedReminder.toUpperCase();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Reminder));
			CF.clickAction(CustomerPage_OR.Reminder, driver);
			if(Reminder.equals("SMS")) {
				
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ReminderWhatsApp));
				CustomerPage_OR.ReminderWhatsApp.click();
//				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerAddressinputFieldOkButton));
			}
			else {
				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ReminderSms));
				CustomerPage_OR.ReminderSms.click();
			}
			}
			catch(Exception E) {
				Log.info("Reminder options are not enabled since the user doesn't have mobile number associated");
			}
		}
		else if (Field.equals("SMS Language")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SelectedSmsLanguange));
			CustomerPage_OR.SelectedSmsLanguange.click();
			try {
			wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.LanguageEnglish));
			CustomerPage_OR.Languagehinglish.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ButtonOk));
			CustomerPage_OR.ButtonOk.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SelectedSmsLanguange));
			
			String LanguageSelected = CustomerPage_OR.SelectedSmsLanguange.getText();
			Log.info("The SMS language is Changed to " +LanguageSelected);
			}
			catch(Exception E) {
				Log.info("Customer is Already verified, Cannot change the Language");
				CustomerPage_OR.GotIt.click();
			}
		}
		else if (Field.equals("Due Date")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ChangeDueDate));
			TransactionPage_OR.ChangeDueDate.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DueClear));
			TransactionPage_OR.DueClear.click();
		}
		else if(Field.equals("Deleted Customer Mobile Number")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
			CustomerPage_OR.MobileNumber.click();
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerNumberInputField));
			CustomerPage_OR.CustomerNumberInputField.click();
			CustomerPage_OR.CustomerNumberInputField.sendKeys(data.CustomerNumberDelete);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.CustomerphoneInputFieldOkButton));
			CustomerPage_OR.CustomerphoneInputFieldOkButton.click();
		}
		else if (Field.equals("Profile Picture from Camera")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.EditMerchantProfilePhoto));
			MerchantProfilePage_OR.EditMerchantProfilePhoto.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.EditProfilePictureHeader));
			try {
				trywait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.ProfilePictureFullExisting));
				MerchantProfilePage_OR.Camera.click();
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.CameraShutter));
				MerchantProfilePage_OR.CameraShutter.click();
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Crop));
				MerchantProfilePage_OR.Crop.click();
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantProfilePictureInProfilePage));
				
			}
			catch(Exception E) {
				Log.info("Profile picture already added.");
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Camera));
				MerchantProfilePage_OR.Camera.click();
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.CameraShutter));
				MerchantProfilePage_OR.CameraShutter.click();
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.CameraOK));
				MerchantProfilePage_OR.CameraOK.click();
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Crop));
				MerchantProfilePage_OR.Crop.click();
				wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantProfilePictureInProfilePage));
			}
		}
		else if (Field.equals("Profile Picture from Gallery")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.EditMerchantProfilePhoto));
			MerchantProfilePage_OR.EditMerchantProfilePhoto.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.EditProfilePictureHeader));
			MerchantProfilePage_OR.Gallery.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.RecentIMages));
			MerchantProfilePage_OR.RecentIMages.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Crop));
			MerchantProfilePage_OR.Crop.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantProfilePictureInProfilePage));
		}
		else if (Field.equals("Merchant Business Name")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessNameDescription));
			MerchantProfilePage_OR.BusinessNameDescription.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessNameInput));
			MerchantProfilePage_OR.BusinessNameInput.sendKeys(MerchantName+" "+data.BusinessName);
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BUsinessNameSubmit));
			MerchantProfilePage_OR.BUsinessNameSubmit.click();
		}
		else if (Field.equals("Merchant Address")) {
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.MerchantAddress));
			MerchantProfilePage_OR.MerchantAddress.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.AddressHeaderinMap));
			MerchantProfilePage_OR.MyLocation.click();
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BusinessNameInput));
			MerchantProfilePage_OR.BusinessNameInput.clear();
			MerchantProfilePage_OR.BusinessNameInput.sendKeys(data.CustomerAddress);
			wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.BUsinessNameSubmit));
			MerchantProfilePage_OR.BUsinessNameSubmit.click();
		}
		else if (Field.equals("Date Range")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DateRange));
			TransactionPage_OR.DateRange.click();
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.dayOfMonthText));
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.StatementCalenderHeader));
			Log.info("Current Date = " + CF.GetCurrentDate());
			int pastDateNew = CF.GetCurrentDate()-10;
			Log.info("New Due date "+ pastDateNew);
			try {
			if(pastDateNew >= 2){
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+pastDateNew+"']")).click();
				}
			}	
			catch(Exception E) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.StatementCalenderPreviousMonth));
			TransactionPage_OR.StatementCalenderPreviousMonth.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='2']")));
			driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='"+CF.GetCurrentDate()+"']")));
			driver.findElement(By.xpath("//android.widget.TextView[@text='"+CF.GetCurrentDate()+"']")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.StatementCalenderOK));
			TransactionPage_OR.StatementCalenderOK.click();
		}
	}
	@And("^User disables the \"([^\"]*)\"$")
	public void user_disbles_options(String Option) throws InterruptedException {
		if(Option.equals("Transaction SMS")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SMSSwitchIcon));
			CustomerPage_OR.SMSSwitchIcon.click();
			try {
//				wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SmsSwitchMessage));
//				String smsswitchText = CustomerPage_OR.SmsSwitchMessage.getText();
//				Log.info(smsswitchText);
//				CustomerPage_OR.SwitchOff.click();
//				String TransactionStatus = CustomerPage_OR.SMSSwitchIcon.getText();
//				Log.info("The transaction sms is turened " +TransactionStatus);
				Log.info("The user is verified, hence cannot change the Transaction SMS");
			}
			catch(Exception E) {
				Log.info("Disabled the SMS");
			}
		}
	}
	@And("^User resets the \"([^\"]*)\"$")
	public void user_resets_options(String Options) {
		if(Options.equals("Password")) {
//			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.MobileNumber));
//			String CustomerNumber = CustomerPage_OR.MobileNumber.getText();
//			Log.info("The Customer number for resetting the password is :"+ CustomerNumber);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Minimum6Digits));
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.PasswordField));
			CustomerPage_OR.PasswordField.sendKeys(data.password);
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.PasswordOK));
			CustomerPage_OR.PasswordOK.click();
		}
	}
}
