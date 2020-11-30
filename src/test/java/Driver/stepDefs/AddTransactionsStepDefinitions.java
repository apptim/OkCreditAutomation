package Driver.stepDefs;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Driver.PropertyData;
import Driver.desiredCapabilities;
import ObjectRepository.AccountPage_OR;
import ObjectRepository.CollectionsPage_OR;
import ObjectRepository.CustomerPage_OR;
import ObjectRepository.HomePage_OR;
import ObjectRepository.LandingPage_OR;
import ObjectRepository.MerchantProfilePage_OR;
import ObjectRepository.SupplierPage_OR;
import ObjectRepository.TransactionPage_OR;
import PageObjects.CommonMethodsFunctions;
import Utility.Log;
import cucumber.api.java.en.And;
import io.appium.java_client.MobileElement;

public class AddTransactionsStepDefinitions extends desiredCapabilities {
	 
	
		@SuppressWarnings("unused")
		private By IMAGETHUMBINGALLERY = By.id("in.okcredit.merchant:id/gallery_image");
		
//		WebDriverWait trywait = new WebDriverWait(driver, 15);
	
		@SuppressWarnings("unused")
		private WebElement waitFor(By locator) {
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
		CommonMethodsFunctions CF = new CommonMethodsFunctions();
		
		String CustomerName = CF.randomAlphaNumeric(10);
		String LongString = CF.randomAlphaNumeric(1000);
		String CustomerNumber =CF.randomNumber(10);
		PropertyData data = new PropertyData();
		public String DeletedSuppliername;
		public static String SupplierNumber;
		public static String DeleteName;
		public static String DeleteNumber;
	 
	 @And("^User adds \"([^\"]*)\"$")
	 public void user_adds_billS(String Options) {
		 if(Options.equals("Bills From Camera")) {
			 try {
				 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ButtonAllow));
				 TransactionPage_OR.ButtonAllow.click();
				 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ButtonAllow));
				 TransactionPage_OR.ButtonAllow.click();
				 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CaptureButton));
				 TransactionPage_OR.CaptureButton.click();
				 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CapturesPhotoBigTick));
				 TransactionPage_OR.CapturesPhotoBigTick.click();
			 }
			 catch(Exception E) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CaptureButton));
			 TransactionPage_OR.CaptureButton.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CapturesPhotoBigTick));
			 TransactionPage_OR.CapturesPhotoBigTick.click();
			 }
		 }
		 else if(Options.equals("Bills From Gallery")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.GalleryImageThumb));
			 
//			 waitFor(IMAGETHUMBINGALLERY).click();
			 
			 List<MobileElement> element = driver.findElements(By.id("in.okcredit.merchant:id/gallery_image"));
			 element.get(0).click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.CapturesPhotoBigTick));
			 TransactionPage_OR.CapturesPhotoBigTick.click();
		 }
		 else if(Options.equals("many bills")) {
			 
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddBillsMany));
			 TransactionPage_OR.AddBillsMany.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.FlashIcon));
			 List<MobileElement> element = driver.findElements(By.id("in.okcredit.merchant:id/gallery_image"));
			 int size = element.size();
			 Log.info("No of Imgae thumb from gallery is : "+size);
			 element.get(0).click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddMore));
			 TransactionPage_OR.AddMore.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.GalleryImageThumb));
			 element.get(2).click();
			 element.get(3).click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SelectedImageCounter));
			 TransactionPage_OR.SelectedImageCounter.click();
		 }
		 else if(Options.equals("Note")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.AddNoteTextBox));
			 TransactionPage_OR.AddNoteTextBox.click();
			 TransactionPage_OR.AddNoteTextBox.sendKeys("Adding Payment/Credit to Customer/Supplier");
		 }
		 else if(Options.equals("Payment")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
			 TransactionPage_OR.PaymentSubmit.click();
		 }
		 else if(Options.equals("Credit")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
			 TransactionPage_OR.PaymentSubmit.click();
		 }
		 else if(Options.equals("More Credit")) {
			 Log.info("Merchant Entering Payment Details");
			 try {
			 wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.CreditButton)).isDisplayed();
			 TransactionPage_OR.CreditButton.click();
			 }
			 catch(Exception E) {
				 wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.CreditButtonAB)).isDisplayed();
				 TransactionPage_OR.CreditButtonAB.click();
			 }
			 wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.ButtonFive)).isDisplayed();
			 TransactionPage_OR.ButtonOne.click();
			 TransactionPage_OR.ButtonZero.click();
			 TransactionPage_OR.ButtonZero.click();
			 TransactionPage_OR.ButtonZero.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
			 TransactionPage_OR.PaymentSubmit.click();
		 }
		 else if(Options.equals("More Payment")) {
			 Log.info("Merchant Entering Payment Details");
			 try {
			 wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.PaymentButton)).isDisplayed();
			 TransactionPage_OR.PaymentButton.click();
			 }
			 catch(Exception E) {
				 wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.PaymentButtonAB)).isDisplayed();
				 TransactionPage_OR.PaymentButtonAB.click();
			 }
			 wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.ButtonFive)).isDisplayed();
			 TransactionPage_OR.ButtonThree.click();
			 TransactionPage_OR.ButtonZero.click();
			 TransactionPage_OR.ButtonZero.click();
			 TransactionPage_OR.ButtonZero.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
			 TransactionPage_OR.PaymentSubmit.click();
		 }
		 else if(Options.equals("Credit to Supplier")) {
			 Log.info("Merchant Entering Payment Details");
			 wait.until(ExpectedConditions.visibilityOf(TransactionPage_OR.ButtonFive)).isDisplayed();
			 TransactionPage_OR.ButtonOne.click();
			 TransactionPage_OR.ButtonZero.click();
			 TransactionPage_OR.ButtonZero.click();
			 TransactionPage_OR.ButtonZero.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.PaymentSubmit));
			 TransactionPage_OR.PaymentSubmit.click();
		 }
		 else if(Options.equals("Due Date")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.SetDueDate));
			 TransactionPage_OR.SetDueDate.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DueDate30));
			 TransactionPage_OR.DueDate30.click();
		 }
		 else if(Options.equals("Customer")) {
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AddCustomer));
			 HomePage_OR.AddCustomer.click();
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.InputCustomerName));
			 HomePage_OR.InputCustomerName.click();
			 HomePage_OR.InputCustomerName.sendKeys(CustomerName);
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerNameSubmitButton));
			 HomePage_OR.CustomerNameSubmitButton.click();
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.AddCustomerNumberField));
			 HomePage_OR.AddCustomerNumberField.sendKeys(CustomerNumber);
			 
			 SupplierNumber = CustomerNumber;
			 System.out.println("Added Customer Number here " + SupplierNumber);
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerNumberSubmitButton));
			 HomePage_OR.CustomerNumberSubmitButton.click();
		 }
		 else if(Options.equals("Supplier")) {
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.AddSupplier));
			 SupplierPage_OR.AddSupplier.click();
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
			 SupplierPage_OR.SupplierNameNumberTextBox.click();
			 SupplierPage_OR.SupplierNameNumberTextBox.sendKeys("Supplier"+CustomerName);
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
			 SupplierPage_OR.SupplierNameSubmitOk.click();
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
			 SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(CustomerNumber);
			 
			 SupplierNumber = CustomerNumber;
			 System.out.println("Added Customer Number here " + SupplierNumber);
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
			 SupplierPage_OR.SupplierNameSubmitOk.click();
		 }
		 else if(Options.equals("Supplier Account")) {
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.AddSupplier));
			 SupplierPage_OR.AddSupplier.click();
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
			 SupplierPage_OR.SupplierNameNumberTextBox.click();
			 SupplierPage_OR.SupplierNameNumberTextBox.sendKeys("Supplier"+CustomerName);
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
			 SupplierPage_OR.SupplierNameSubmitOk.click();
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameNumberTextBox));
			 SupplierPage_OR.SupplierNameNumberTextBox.sendKeys(data.MobileNumberSupplier);
			 
			 SupplierNumber = data.MobileNumberSupplier;
			 System.out.println("Added Supplier Number here " + SupplierNumber);
			 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.SupplierNameSubmitOk));
			 SupplierPage_OR.SupplierNameSubmitOk.click();
			 
			 try {
				 wait.until(ExpectedConditions.elementToBeClickable(SupplierPage_OR.ViewSupplier)).isDisplayed();
				 SupplierPage_OR.ViewSupplier.click();
				 wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.SupplierText));
				 Assert.assertTrue(TransactionPage_OR.SupplierText.isDisplayed());
				}
			 catch(Exception E) {
					wait.until(ExpectedConditions.visibilityOfAllElements(TransactionPage_OR.SupplierText));
					Assert.assertTrue(TransactionPage_OR.SupplierText.isDisplayed());
					Log.info("Added Supplier Account");
				
				}
		 }
		 else if(Options.equals("Customer with Deleted Number")) {
			 wait.until(ExpectedConditions.visibilityOf(HomePage_OR.InputCustomerName)).isDisplayed();
			 HomePage_OR.InputCustomerName.sendKeys(CustomerName);
			 HomePage_OR.CustomerNameSubmitButton.click();
			 HomePage_OR.AddCustomerNumberField.sendKeys(data.CustomerNumberDelete);
			 wait.until(ExpectedConditions.visibilityOf(HomePage_OR.CustomerNumberSubmitButton)).isDisplayed();
			 HomePage_OR.CustomerNumberSubmitButton.click();
		}
		 else if(Options.equals("Transaction with Supplier")) {
			 wait.until(ExpectedConditions.visibilityOf(HomePage_OR.SearchOrAdd)).isDisplayed();
			 HomePage_OR.SearchOrAdd.click();
			 wait.until(ExpectedConditions.visibilityOf(HomePage_OR.SearchOrAddNext));
			 HomePage_OR.SearchOrAddNext.sendKeys("Supplier");
			 wait.until(ExpectedConditions.visibilityOf(HomePage_OR.CustomerSearchList));
			 HomePage_OR.CustomerSearchList.click();
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.AcceptPayment));
			 CustomerPage_OR.AcceptPayment.click();
			 wait.until(ExpectedConditions.visibilityOf(SupplierPage_OR.GivePaymentTextBox));
			 TransactionPage_OR.ButtonFive.click();
			 TransactionPage_OR.ButtonZero.click();
			 TransactionPage_OR.PaymentSubmit.click();
		 }
		 else if(Options.equals("Only Number in chat")) {
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.ChatInput)).isDisplayed();
			 CustomerPage_OR.ChatInput.sendKeys("9999999999");
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.SendChat)).isDisplayed();
		}
		 else if(Options.equals("Large text in chat")) {
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.ChatInput)).isDisplayed();
			 CustomerPage_OR.ChatInput.sendKeys(LongString);
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.SendChat)).isDisplayed();
		}
		 else if(Options.equals("Special characters in chat")) {
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.ChatInput)).isDisplayed();
			 CustomerPage_OR.ChatInput.sendKeys("%$&*(*&&^%$#!!");
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.SendChat)).isDisplayed();
		}
	 }
	 @And("^User checks the \"([^\"]*)\"$")
	 public void user_checks(String option) {
		 if(option.equals("Added Bill")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ImageThumb));
			 TransactionPage_OR.ImageThumb.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ImagePreview));
			 Assert.assertTrue(TransactionPage_OR.ImagePreview.isDisplayed());
		 }
	 }
	 @And("^User Deletes \"([^\"]*)\"$")
	 public void user_deletes(String Option) throws MalformedURLException, InterruptedException {
		 if(Option.equals("the Bill")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteButton));
			 TransactionPage_OR.DeleteButton.click();
		 }
		 else if(Option.equals("the Payment")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletePayment));
			 TransactionPage_OR.DeletePayment.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteAmount));
			 TransactionPage_OR.DeleteAmount.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteButton));
			 TransactionPage_OR.DeleteButton.click();
		 }
		 else if(Option.equals("the Credit")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeletePayment));
			 TransactionPage_OR.DeletePayment.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteAmount));
			 TransactionPage_OR.DeleteAmount.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteButton));
			 TransactionPage_OR.DeleteButton.click();
		 }
		 else if(Option.equals("Transaction")) {
			 wait.until(ExpectedConditions.elementToBeClickable(AccountPage_OR.DeleteTextInAccount));
			 AccountPage_OR.DeleteTextInAccount.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteButton));
			 TransactionPage_OR.DeleteButton.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteButton));
			 TransactionPage_OR.DeleteButton.click();
		 }
		 else if(Option.equals("the Discount")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.DeleteButton));
			 TransactionPage_OR.DeleteButton.click();
		 }
		 else if(Option.equals("the Account")) {
			 wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.Delete));
			 Log.info(CollectionsPage_OR.DeleteMessage.getText());
			 CollectionsPage_OR.Delete.click();
		 }
		 else if(Option.equals("Customer")) {
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SearchOrAdd));
			 HomePage_OR.SearchOrAdd.click();
			 HomePage_OR.SearchOrAddNext.sendKeys("Customer");
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.CustomerSearchList));
			 HomePage_OR.CustomerSearchList.click();
			 wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.AddedCustomerHeader));
			 CustomerPage_OR.AddedCustomerHeader.click();
			 wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ProfileImage));
			 CF.scrollToText("Delete", driver);
			 wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.DeleteCustomer));
			 CustomerPage_OR.DeleteCustomer.click();
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
					wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.Password));
					Assert.assertTrue(CustomerPage_OR.Password.isDisplayed());
					Assert.assertTrue(CustomerPage_OR.CustomerName.isDisplayed());
					DeleteName = CustomerPage_OR.CustomerName.getText();
				}
			 wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.PasswordField));
			 Log.info("Merchant Entering Password to delete the Customer");
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.Password)).isDisplayed();
			 wait.until(ExpectedConditions.visibilityOf(CustomerPage_OR.Password)).isDisplayed();
			 CustomerPage_OR.Password.click();
			 CustomerPage_OR.Password.clear();
			 CustomerPage_OR.Password.sendKeys(data.password);
			 CustomerPage_OR.Delete.click();
		 }
		 else if(Option.equals("Profile Picture")) {
			 wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.EditMerchantProfilePhoto));
			 MerchantProfilePage_OR.EditMerchantProfilePhoto.click();
			 try{
				 wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Delete));
				 MerchantProfilePage_OR.Delete.click();
				 wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.DeleteImage));
				 MerchantProfilePage_OR.DeleteImage.click();
				 
			 }
			 catch(Exception E) {
				 Log.info("Customer imgae not added ignoring..!");
				 driver.navigate().back();
			 }
		 }
		 
	 }
	 @And("^User shares the \"([^\"]*)\"$")
	 public void user_shares(String Option) {
		 if(Option.equals("Payment")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareDetailsPage));
			 TransactionPage_OR.ShareDetailsPage.click();
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.OkCreditContact));
			 TransactionPage_OR.OkCreditContact.click();
			 Log.info("Selected the OkCredit Contact");
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppSendClick));
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareMessage));
			 
			 String ShareMessage =  TransactionPage_OR.ShareMessage.getText();
			 Log.info("The Descri[tion in the Share message was :" + ShareMessage);
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppCaption));
			 Thread.sleep(5000);
			 driver.navigate().back();
			 driver.navigate().back();
			 }
			 catch(Exception E) {
				 Log.info("WhatsApp is not Installed. Can't share the payment");
			 }
		 }
		 if(Option.equals("Credit")) {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareDetailsPage));
			 TransactionPage_OR.ShareDetailsPage.click();
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.OkCreditContact));
			 TransactionPage_OR.OkCreditContact.click();
			 Log.info("Selected the OkCredit Contact");
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppSendClick));
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareMessage));
			 
			 String ShareMessage =  TransactionPage_OR.ShareMessage.getText();
			 Log.info("The Description in the Share message was :" + ShareMessage);
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppCaption));
			 driver.navigate().back();
			 driver.navigate().back();
		 }
		 catch(Exception E) {
			 Log.info("WhatsApp is not Installed. Can't share the Credit");
		 }
		 }
		 if(Option.equals("Reminder")) {
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.OkCreditContact));
			 TransactionPage_OR.OkCreditContact.click();
			 Log.info("Selected the OkCredit Contact");
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppSendClick));
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareMessage));
			 
			 String ShareMessage =  TransactionPage_OR.ShareMessage.getText();
			 Log.info("The Description in the Share message was :" + ShareMessage);
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppCaption));
			 driver.navigate().back();
			 driver.navigate().back();
		 }
		 catch(Exception E) {
			 Log.info("WhatsApp is not Installed. Can't share the Reminder");
		 }
		 }
		 if(Option.equals("QR")) {
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.OkCreditContact));
			 TransactionPage_OR.OkCreditContact.click();
			 Log.info("Selected the OkCredit Contact");
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppSendClick));
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareMessage));
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(CollectionsPage_OR.WhastAppTextBox));
			 }
			 catch(Exception E) {
				 Log.info("WhatsApp is not Installed. Can't share the QR");
			 }
		 }
		 if(Option.equals("Business Card")) {
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.ShareBusinessCard));
			 MerchantProfilePage_OR.ShareBusinessCard.click();
			 wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Send));
			 Log.info("Merchant Name : " + MerchantProfilePage_OR.MerchantNameinShare.getText());
			 Log.info("Merchant Address : " + MerchantProfilePage_OR.MerchantAddressinShare.getText());
			 Log.info("Merchant Email : " + MerchantProfilePage_OR.MerchantEmailinShare.getText());
			 wait.until(ExpectedConditions.elementToBeClickable(MerchantProfilePage_OR.Send));
			 MerchantProfilePage_OR.Send.click();
			 }
			 catch(Exception E) 
			 {
				 Log.info("WhatsApp is not Installed. Can't share the Business Card");
	 		}
		 }
		 
		 else if(Option.equals("Report")) {
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.OkCreditContact));
			 TransactionPage_OR.OkCreditContact.click();
			 Log.info("Selected the OkCredit Contact");
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.WhatsAppSendClick));
			 TransactionPage_OR.WhatsAppSendClick.click();
			 wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ShareMessage));
			 
			 String ShareMessage =  TransactionPage_OR.ShareMessage.getText();
			 Log.info("The Description in the Share message was :" + ShareMessage);
			 TransactionPage_OR.WhatsAppSendClick.click();
			 driver.navigate().back();
			 driver.navigate().back();
		 }
			 catch(Exception E) {
				 Log.info("WhatsApp is not Installed. Can't share the Reminder");
		 	}
		 }
	 }
	 @And("^Verify \"([^\"]*)\" Message$")
	 public void verify_message(String Message) {
		 if(Message.equals("No Internet")) {
			 wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.NoInternetText));
			 Log.info(HomePage_OR.NoInternetText.getText());
		 }
	 }
	
}
