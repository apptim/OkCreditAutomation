package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;
import io.appium.java_client.MobileElement;

public class MoneyTransfer_OR extends desiredCapabilities{

	@FindBy(xpath ="//android.view.View[@text='Money Transfer']")
	public static WebElement MoneyTransferHeader;
	
	@FindBy(xpath ="//android.view.View[@text='Send money to any Bank Account online and Earn']")
	public static WebElement SendMoneyMessage;
	
	@FindBy(xpath ="//android.view.View[@content-desc='OKCredit']")
	public static WebElement VideoTitle;
	
	@FindBy(xpath ="//android.widget.Spinner[@text='More']")
	public static WebElement VideoMore;
	
	@FindBy(xpath ="//android.widget.Spinner[@text='Play']")
	public static WebElement VideoPlay;
	
	@FindBy(xpath ="//android.widget.Button[@text='Add Bank Account']")
	public static WebElement AddBankAccount;
	
	@FindBy(xpath ="//android.widget.TextView[@text='By continuing, you agree to our']")
	public static WebElement TermsText;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'Terms and Conditions')]")
	public static WebElement TermsandConditions;
	
	@FindBy(xpath ="//android.view.View[contains(@text, 'Terms and Conditions')]")
	public static WebElement TermsandConditionsText;
	
	@FindBy(xpath ="//android.widget.Button[@text='menu']")
	public static WebElement BackButton;
	
	@FindBy(xpath ="//android.view.View[@text='Add Bank Account']")
	public static WebElement AddBankAccountHeader;
	
	@FindBy(xpath ="//android.view.View[@text='Please add the destination Bank Account']")
	public static WebElement PleaseAddDetailsText;
	
	@FindBy(xpath ="//android.view.View[@text='Account Number']")
	public static WebElement AccountNUmberText;
	
	@FindBy(xpath ="//*/android.view.View/android.view.View[2]/android.widget.EditText")
	public static WebElement AccountNumberTextBox;
	
	@FindBy(xpath ="//android.widget.Button[@text='cancel input']")
	public static WebElement ClearAccountX;
	
	@FindBy(xpath ="//*/android.view.View[2]/android.view.View[4]/android.widget.Button")
	public static WebElement SubmitAccountNumber;
	
	@FindBy(xpath ="//android.view.View[@text='IFSC Code']")
	public static WebElement IFSCCodeText;
	
	@FindBy(xpath ="//*/android.view.View[5]/android.view.View/android.view.View[2]/android.widget.EditText")
	public static WebElement IFSCTextBox;
	
	@FindBy(xpath ="//*/android.view.View[2]/android.view.View[5]/android.widget.Button")
	public static WebElement SubmitIFSC;
	
	@FindBy(xpath ="//android.view.View[@text='Validating Bank Details']")
	public static WebElement ValidatingBankDetails;
	
	@FindBy(xpath ="//android.view.View[@text='Send to :']")
	public static WebElement SendTo;
	
	@FindBy(id ="in.okcredit.merchant:id/change_account")
	public static WebElement ChangeAccount;
	
	@FindBy(xpath ="//*/android.view.View/android.view.View[4]/android.view.View[1]")
	public static WebElement AccountHolderName;
	
	@FindBy(xpath ="/android.view.View/android.view.View[4]/android.view.View[2]")
	public static WebElement AccountNumber;
	
	@FindBy(xpath ="//*/android.view.View/android.view.View[4]/android.view.View[3]")
	public static WebElement IFSCCode;
	
	@FindBy(xpath ="//*/android.view.View/android.view.View/android.widget.EditText")
	public static WebElement AmountTextBox;
	
	@FindBy(xpath ="//android.widget.Button[@text='Send Money']")
	public static WebElement SendMoney;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Invalid bank details. Retry with valid details.']")
	public static WebElement InvalidAccountDetails;
	
	@FindBy(xpath ="//*[@text='Amount to be paid']")
	public static WebElement AmountToBePaid;
	
	@FindBy(xpath ="//android.widget.Button[@text='bhim-icon BHIM UPI gpay-icon phonepe-icon paytm-icon']")
	public static WebElement PayMentOptionBHIM;
	
	@FindBy(xpath ="//android.widget.Button[@text='card icon Debit card']")
	public static WebElement PayMentOptionDebitCard;
	
	@FindBy(xpath ="//android.widget.Image[contains(@text,'submit-arrow')]")
	public static WebElement PayMentOptionNetbanking;
	
	@FindBy(xpath ="//android.view.View[@text='All your transactions are safe and secure']")
	public static WebElement PaymentDisclaimer;
	
	@FindBy(xpath ="//android.widget.EditText[@resource-id='card_number']")
	public static WebElement CardNumber;
	
	@FindBy(xpath ="//android.widget.EditText[@resource-id='card_expiry']")
	public static WebElement Expiry;
	
	@FindBy(xpath ="//android.widget.EditText[@resource-id='card_name']")
	public static WebElement CardHolderName;
	
	@FindBy(xpath ="//android.widget.EditText[@resource-id='card_cvv']")
	public static WebElement CVV;
	
	@FindBy(xpath ="//android.view.View[@resource-id='merchant-name']")
	public static WebElement MerchantNameInCardDetailsPage;
	
	@FindBy(xpath ="//android.view.View[@resource-id='merchant-desc']")
	public static WebElement CustomerNumberInCardPage;
	
	@FindBy(xpath ="//android.view.View[@text='Added Beneficiary']")
	public static WebElement AddedBeneficiary;
	
	@FindBy(xpath ="//android.view.View[@resource-id='fd-t']")
	public static WebElement CreditCardErrorMessage;
	
	@FindBy(xpath ="//android.widget.Button[@resource-id='fd-hide']")
	public static WebElement Retry;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'Please enter name on your card')]")
	public static WebElement EnterValidCusomerName;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'code printed')]")
	public static WebElement ErrorMessageForCVV;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'Please enter a valid card number.')]")
	public static WebElement ErrorMessageCardNumber;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'SBI')]")
	public static WebElement SBIBank;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'HDFC')]")
	public static WebElement HDFCBank;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'ICICI')]")
	public static WebElement ICICIBank;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'Axis')]")
	public static WebElement AxisBank;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'Axis')]")
	public static WebElement AxisBankInList;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'Kotak')]")
	public static WebElement KotakBank;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'Yes')]")
	public static WebElement YesBank;
	
	@FindBy(xpath ="//android.widget.Button[@resource-id='bank-select']")
	public static WebElement SelectDifferentBank;
	
	@FindBy(xpath ="//android.view.View[@resource-id='amount']")
	public static WebElement AmountInCardDetailsPage;
	
	@FindBy(xpath ="//android.widget.Button[@resource-id='footer']")
	public static WebElement PayButtonInCardDetailsPage;
	
	@FindBy(className ="android.widget.EditText")
	public static WebElement Amount;
	
	@FindBy(xpath ="//android.view.View[contains(@resource-id,'bank-item')]")
	public static List<MobileElement> BankListMain;
	
	@FindBy(xpath ="//android.widget.Spinner[@text='Select a different bank']")
	public static WebElement SelectDifferentBankText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Select a different bank']")
	public static WebElement SelectDifferentBankTextInListPage;
	
	@FindBy(xpath ="//android.view.View[@text='All banks']")
	public static WebElement Allbanks;
	
	@FindBy(id ="android:id/text1")
	public static List<MobileElement> BankListOthers;
	
	@FindBy(xpath ="//android.widget.Spinner[@resource-id='bank-select']")
	public static WebElement SelectedBank;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Axis Bank']")
	public static WebElement AxisBankiInList;
	
	@FindBy(xpath ="//*/android.view.View[2]/android.view.View[2]/android.view.View[1]")
	public static WebElement BeneficiaryListFirst;
	
	
}
