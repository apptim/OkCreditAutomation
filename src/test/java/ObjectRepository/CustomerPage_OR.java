package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class CustomerPage_OR extends desiredCapabilities{

	
	@FindBy(id ="in.okcredit.merchant:id/toolbar")
	public static WebElement CustomerPagetoolbar;
	
	@FindBy(xpath ="//android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']")
	public static WebElement BackArrow;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_image")
	public static WebElement ProfileImage;
	
	@FindBy(id ="in.okcredit.merchant:id/camera")
	public static WebElement ProfileImageCamera;
	
	@FindBy(id ="in.okcredit.merchant:id/account_icon")
	public static WebElement account_icon;
	
	@FindBy(id ="in.okcredit.merchant:id/message")
	public static WebElement INternetRequiredMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/tryAgain")
	public static WebElement TryAgain;
	
	@FindBy(id ="in.okcredit.merchant:id/cancel")
	public static WebElement Cancel;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Moving Failed!']")
	public static WebElement MovingFailed;
	
	@FindBy(id ="in.okcredit.merchant:id/name_box")
	public static WebElement NameXpath;
	
	@FindBy(id ="in.okcredit.merchant:id/name")
	public static WebElement CustomerName;
	
	@FindBy(id ="in.okcredit.merchant:id/ivReminder")
	public static WebElement ReminderIcon;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Reminders On']")
	public static WebElement Reminder;
	
	@FindBy(id ="in.okcredit.merchant:id/sms")
	public static WebElement ReminderSms;
	
	@FindBy(id ="in.okcredit.merchant:id/whatsapp")
	public static WebElement ReminderWhatsApp;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_cancel")
	public static WebElement ReminderCancel;
	
	@FindBy(id ="in.okcredit.merchant:id/reminder")
	public static WebElement ReminderSelected;
	
	@FindBy(id ="in.okcredit.merchant:id/personals_title")
	public static WebElement ContactInfoHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/mobile")
	public static WebElement MobileNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/mobile")
	public static WebElement SupplierNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/call_icon")
	public static WebElement MobileIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/address")
	public static WebElement CustomerAddress;
	
	@FindBy(id ="in.okcredit.merchant:id/home_icon")
	public static WebElement HomeIcon;
	
	@FindBy(xpath ="//android.widget.TextView[@text='COMMUNICATIONS']")
	public static WebElement CommunicationHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/sms_text")
	public static WebElement TransactionSmsText;
	
	@FindBy(id ="in.okcredit.merchant:id/sms_icon")
	public static WebElement SMSIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/switch_sms")
	public static WebElement SMSSwitchIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/sms_lang_text")
	public static WebElement SmsLanguageText;
	
	@FindBy(id ="in.okcredit.merchant:id/globe_icon")
	public static WebElement Globe_icon;
	
	@FindBy(id ="in.okcredit.merchant:id/sms_lang")
	public static WebElement SelectedSmsLanguange;
	
	@FindBy(id ="in.okcredit.merchant:id/delete_text")
	public static WebElement DeleteCustomer;
	
	@FindBy(id ="in.okcredit.merchant:id/content")
	public static WebElement SelectSMSLanguage;
	
	@FindBy(id ="in.okcredit.merchant:id/english")
	public static WebElement LanguageEnglish;
	
	@FindBy(id ="in.okcredit.merchant:id/hindi")
	public static WebElement LanguageHindi ;
	
	@FindBy(id ="in.okcredit.merchant:id/panjabi")
	public static WebElement LanguagePanjabi;
	
	@FindBy(id ="in.okcredit.merchant:id/malayalam")
	public static WebElement Languagemalayalam;
	
	@FindBy(id ="in.okcredit.merchant:id/hinglish")
	public static WebElement Languagehinglish;
	
	@FindBy(id ="in.okcredit.merchant:id/marathi")
	public static WebElement Languagemarathi;
	
	@FindBy(id ="in.okcredit.merchant:id/tamil")
	public static WebElement Languagetamil;
	
	@FindBy(id ="in.okcredit.merchant:id/telugu")
	public static WebElement Languagetelugu;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_ok")
	public static WebElement ButtonOk;
	
	@FindBy(id ="in.okcredit.merchant:id/password")
	public static WebElement Password;
	
	@FindBy(xpath ="//android.widget.EditText[@text='Password']")
	public static WebElement PasswordField;
	
	@FindBy(id ="in.okcredit.merchant:id/delete")
	public static WebElement Delete;
	
	@FindBy(id ="in.okcredit.merchant:id/msg")
	public static WebElement DeleteMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/textinput_error")
	public static WebElement WrongPassword;
	
	@FindBy(id ="in.okcredit.merchant:id/text_input_end_icon")
	public static WebElement WrongPasswordErrorIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/forgot_password")
	public static WebElement forgot_password;
	
	@FindBy(id ="in.okcredit.merchant:id/et_phone_number")
	public static WebElement CustomerNumberInputField;
	
	@FindBy(id ="in.okcredit.merchant:id/phone_button")
	public static WebElement CustomerNameInputFieldOkButton;
	
	@FindBy(id ="in.okcredit.merchant:id/input_name")
	public static WebElement CustomerNameInputField;
	
	@FindBy(id ="in.okcredit.merchant:id/validate_details")
	public static WebElement CustomerphoneInputFieldOkButton;
	
	@FindBy(id ="in.okcredit.merchant:id/input_address")
	public static WebElement CustomerAddressinputField;
	
	@FindBy(id ="in.okcredit.merchant:id/address_button")
	public static WebElement CustomerAddressinputFieldOkButton;
	
	@FindBy(id ="in.okcredit.merchant:id/content")
	public static WebElement SmsSwitchMessage	;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_title")
	public static WebElement SwitchOff;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_name")
	public static WebElement AddedCustomerHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/empty_tx_text")
	public static WebElement AddCustomerPageemptyText;
	
	@FindBy(id ="in.okcredit.merchant:id/add_payment_btn_ab")
	public static WebElement AcceptPayment;
	
	@FindBy(id ="in.okcredit.merchant:id/add_credit_btn")
	public static WebElement AddCreditButton;
	
	@FindBy(id ="in.okcredit.merchant:id/name_button")
	public static WebElement NameUpdateSubmitButton;
	
	@FindBy(id ="in.okcredit.merchant:id/button_container_name")
	public static WebElement SupplierNameUpdateSubmitButton;
	
	@FindBy(id ="in.okcredit.merchant:id/errorMessage")
	public static WebElement InvalidMobileNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/counter_phone")
	public static WebElement MobileNumberCount;
	
	@FindBy(id ="in.okcredit.merchant:id/error_address")
	public static WebElement AddresError;
	
	@FindBy(id ="in.okcredit.merchant:id/counter_address")
	public static WebElement AddressCount;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Set New Password']")
	public static WebElement SetNewPassword;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Minimum 6 digits']")
	public static WebElement Minimum6Digits;
	
	@FindBy(id ="in.okcredit.merchant:id/ok")
	public static WebElement PasswordOK;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static WebElement SelectCustomer;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Reset Password']") 
	 public static WebElement ResetPasswordHeader;       
	
	@FindBy(id = "in.okcredit.merchant:id/timer")
	public static WebElement TimerforOTP;
	
	@FindBy(id ="in.okcredit.merchant:id/settlement")
	public static WebElement SettlementWhileDeleteAccept;
	
	@FindBy(id ="in.okcredit.merchant:id/settlement")
	public static WebElement SettlementMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_submit")
	public static WebElement ButtonSubmit;
	
	@FindBy(id ="in.okcredit.merchant:id/tvVerified")
	public static WebElement VerifiedUser;
	
	@FindBy(id ="in.okcredit.merchant:id/tvVerifiedMessage")
	public static WebElement VerifiedMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/tvAdd")
	public static WebElement GotIt;
	
	@FindBy(id ="in.okcredit.merchant:id/personals_icon")
	public static WebElement VerifiedIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/balance_text")
	public static WebElement BalanceDue; 

	@FindBy(id ="in.okcredit.merchant:id/tx_amount")
	public static WebElement TotalBalance; 

	@FindBy(id ="in.okcredit.merchant:id/title")
	public static WebElement CannotAddSupplier; 
	
	@FindBy(id ="in.okcredit.merchant:id/view_customer")
	public static WebElement ViewCustomer; 
	
	@FindBy(id ="in.okcredit.merchant:id/snackbar_text")
	public static WebElement CannotMigrate;
	
	@FindBy(id ="in.okcredit.merchant:id/view_customer")
	public static WebElement Retry;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Test3']")
	public static WebElement NonMigratecustomer;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Test2']")
	public static WebElement SameNumberSupplier;

	@FindBy(id ="in.okcredit.merchant:id/total_amount")
	public static WebElement TotalAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/chat")
	public static WebElement chat;
	
	@FindBy(xpath ="//android.widget.TextView[@text='NEW']")
	public static WebElement ChatNewLabel;
	
	@FindBy(id ="in.okcredit.merchant:id/messageRecyclerView")
	public static WebElement chatPage;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Say')]")
	public static WebElement chatPageHi;
	
	@FindBy(id ="in.okcredit.merchant:id/banner_text")
	public static WebElement chatPageBanner;
	
	@FindBy(id ="in.okcredit.merchant:id/call_toolbar")
	public static WebElement CallOption;
	
	@FindBy(id ="in.okcredit.merchant:id/date")
	public static WebElement DateHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/messageEditText")
	public static WebElement ChatInput;
	
	@FindBy(id ="in.okcredit.merchant:id/sendButton")
	public static WebElement SendChat;
	
	@FindBy(id ="in.okcredit.merchant:id/tx_date")
	public static WebElement ChatDate;
	
	@FindBy(id ="in.okcredit.merchant:id/sync")
	public static WebElement ChatStatus;
	
	@FindBy(id ="in.okcredit.merchant:id/material_container")
	public static WebElement ChatMessageSent;
	
	@FindBy(xpath ="//android.widget.Toast[contains(@text,'start chatting')]")
	public static WebElement NoMobileNumbertoast;
	
}
