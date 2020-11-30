package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Driver.desiredCapabilities;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingPage_OR extends desiredCapabilities{
	
	@FindBy(id =  "in.okcredit.merchant:id/tvSelectLanguage")
	public static WebElement SelectLanguage;
	
	@FindBy(id =  "in.okcredit.merchant:id/tvTitleLanguage")
	public static List<WebElement>  LanguageTile;

	@FindBy(xpath =  "//android.widget.TextView[@text='English']")
	public static WebElement LanguageEnglish;
	
	@FindBy(xpath ="//android.widget.TextView[@text='मराठी']")
	public static WebElement LanguageMarathi;
	
	@FindBy(xpath ="//android.widget.TextView[@text='ગુજરાતી']")
	public static WebElement LanguageGujarathi;
	
	@FindBy(xpath ="//android.widget.TextView[@text='தமிழ்']")
	public static WebElement LanguageTamil;
	
	@FindBy(xpath ="//android.widget.TextView[@text='తెలుగు']")
	public static WebElement LanguageTelugu;
	
	@FindBy(xpath ="//android.widget.TextView[@text='ਪੰਜਾਬੀ']")
	public static WebElement LanguagePanjabi;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Malayalam)']")
	public static WebElement LanguageMalayalam;
	
	@FindBy(xpath ="//android.widget.TextView[@text='ಕನ್ನಡ']")
	public static WebElement LanguageKannada;
	
	@FindBy(xpath ="//android.widget.TextView[@text='বাংলা']")
	public static WebElement LanguageBangla;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Hinglish']")
	public static WebElement LanguageHinglish;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Hindi in English)']")
	public static WebElement LanguageHinglishText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(English)']")
	public static WebElement LanguageEnglishText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Marathi)']")
	public static WebElement LanguageMarathiText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Hindi)']")
	public static WebElement LanguageHindiText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Gujrati)']")
	public static WebElement LanguageGujratiText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Tamil)']")
	public static WebElement LanguageTamilText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Telugu)']")
	public static WebElement LanguageTeluguText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Punjabi)']")
	public static WebElement LanguagePunjabiText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Malayalam)']")
	public static WebElement LanguageMalayalamText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Kannada)']")
	public static WebElement LanguageKannadaText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='(Bangla)']")
	public static WebElement LanguageBanglaText;
	
	@FindBy(xpath ="//android.widget.TextView[@text='हिंदी']")
	public static WebElement LanguageHindi;
	
	@FindBy(id ="in.okcredit.merchant:id/ivLangSelected")
	public static WebElement LanguageSelected;
	
	@FindBy(xpath ="//android.widget.Button[@text='Facebook']")
	public static WebElement FacebookAd;	
	
	@FindBy(xpath ="//android.widget.Button[@text='Close']")
	public static WebElement FacebookAdClose;
	
	@FindBy(id ="in.okcredit.merchant:id/tvWelcome")
	public static WebElement WelcomeToOkCred;
	
	@FindBy(id ="in.okcredit.merchant:id/tvNextVariant")
	public static WebElement NextButton;
	
	@FindBy(id ="in.okcredit.merchant:id/getStarted")
	public static WebElement GetStarted;
	
	@FindBy(id ="n.okcredit.merchant:id/digital_india_1")
	public static WebElement DigitalUdhar;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'Good Bye')]")
	public static WebElement GoodByePen;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'Free SMS')]")
	public static WebElement FreeSMS;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'Anywhere')]")
	public static WebElement UseAnywhere;
	
	@FindBy(id ="in.okcredit.merchant:id/image_logo")
	public static WebElement OkCreditLogo;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'Mobile')]")
	public static WebElement EnterMobileNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/ok")
	public static WebElement OK;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'Enter Password')]")
	public static WebElement EnterPassword;
	
	@FindBy(xpath ="//android.widget.EditText[contains(@text, 'Password')]")
	public static WebElement PasswordField;
	
	@FindBy(id ="in.okcredit.merchant:id/mbVerifyMobile")
	public static WebElement VerifyMobile;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTerms")
	public static WebElement TermsOfService;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTutorialTitle")
	public static WebElement TutotrialTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/mobile")
	public static WebElement MobileNumberVerifyPage;
	
	@FindBy(id ="com.google.android.gms:id/cancel")
	public static WebElement NoneOfTheAbove;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitle")
	public static WebElement YourSixDigitPin;
	
	@FindBy(id ="in.okcredit.merchant:id/etMobileNumber")
	public static WebElement MobileNumberEntryField;
	
	@FindBy(id ="com.google.android.gms:id/credentials_hint_picker_title")
	public static WebElement ContinueWith;
	
	@FindBy(xpath ="//android.widget.LinearLayout[@content-desc='090039 99957']")
	public static WebElement ChooseMobilefromThelist;
	
	@FindBy(id ="in.okcredit.merchant:id/etMobileNumber")
	public static WebElement MobileNumberField;
	
	@FindBy(id ="in.okcredit.merchant:id/ivCancelNumber")
	public static WebElement MobileNumberCancel;
	
	@FindBy(id ="in.okcredit.merchant:id/fbNumberSubmit")
	public static WebElement MobileNumberSubmit;
	
	@FindBy(id ="in.okcredit.merchant:id/title")
	public static WebElement PleaseBePatient;
	
	@FindBy(id ="in.okcredit.merchant:id/desc")
	public static WebElement RecieveOtpinSec;
	
	@FindBy(id ="in.okcredit.merchant:id/animation_view")
	public static WebElement VerificationAnimation;
	
	@FindBy(id ="in.okcredit.merchant:id/syncing_title")
	public static WebElement DownloadingYourData;
	
	@FindBy(id ="in.okcredit.merchant:id/syncing_title")
	public static WebElement SyncingPaused;
	
	@FindBy(id ="in.okcredit.merchant:id/syncing_desc")
	public static WebElement SyncingText;
	
	@FindBy(id ="in.okcredit.merchant:id/sync_error_image")
	public static WebElement SyncingErrorImage;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_retry_file")
	public static WebElement Retry;
	
	@FindBy(id ="in.okcredit.merchant:id/tvDidntGetOtp")
	public static WebElement DidntGetOtp;
	
	@FindBy(id ="in.okcredit.merchant:id/title")
	public static WebElement AreYouOnWhatsApp;
	
	@FindBy(id ="com.whatsapp:id/send")
	public static WebElement WhatsAppSend;
	
	@FindBy(id ="com.whatsapp:id/entry")
	public static WebElement WhatsAppActivationKey;
	
	@FindBy(id ="com.whatsapp:id/conversation_contact_name")
	public static WebElement WhatsAppconversation_contact_name;
	
	@FindBy(id ="in.okcredit.merchant:id/desc")
	public static WebElement AreYouOnWhatsAppDesc;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_cancel")
	public static WebElement NotNow;
	
	@FindBy(id ="in.okcredit.merchant:id/etBusinessName")
	public static WebElement BusinessNameEntryField;
	
	@FindBy(id ="in.okcredit.merchant:id/ivCancelName")
	public static WebElement ClearBusinessName;
	
	@FindBy(id ="in.okcredit.merchant:id/mbSkip")
	public static WebElement SkipButtonInBusinessNameEntryScreen;
	
	@FindBy(id ="in.okcredit.merchant:id/fbBusinessNameSubmit")
	public static WebElement BusinessNameSubmitButton;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitle")
	public static WebElement EnterYourName;
	
	@FindBy(id ="in.okcredit.merchant:id/etBusinessName")
	public static WebElement BusinessNameField;
	
	@FindBy(id ="in.okcredit.merchant:id/fbBusinessNameSubmit")
	public static WebElement BusinessNameSubmit;
	
	@FindBy(id ="in.okcredit.merchant:id/snackbar_text")
	public static WebElement NoInternetToastMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/snackbar_action")
	public static WebElement NoInternetRetryButton;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Sign Out']")
	public static WebElement Signout;
	
	@FindBy(id ="in.okcredit.merchant:id/logout")
	public static WebElement ConfirmLogout;
	
	@FindBy(id ="in.okcredit.merchant:id/next")
	public static WebElement SendOTP;
	
	@FindBy(id ="in.okcredit.merchant:id/mobile")
	public static WebElement OtpPageMobileNumber;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'Auto verifying OTP')]")
	public static WebElement AutoVerifyOtp;
	
	@FindBy(id ="in.okcredit.merchant:id/timer")
	public static WebElement Timer;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'not')]")
	public static WebElement DidNotRecieveOtp;
	
	@FindBy(id ="in.okcredit.merchant:id/whatsapp")
	public static WebElement RegisterByWhatsapp;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_ok")
	public static WebElement WhatsAppAllow;
	
	@FindBy(id ="com.android.packageinstaller:id/permission_allow_button")
	public static WebElement Allow;
	
	@FindBy(id ="in.okcredit.merchant:id/loading_autoread")
	public static WebElement AutoVerifyingOtp;
	
	@FindBy(id ="in.okcredit.merchant:id/otp")
	public static WebElement OtpTextBox;
	
	@FindBy(xpath ="//android.widget.Toast[@text='OTP sent successfully']")
	public static WebElement OTPsentsuccessfully;
	
	@FindBy(xpath ="//*/android.widget.LinearLayout/android.widget.EditText[1]")
	public static WebElement OtpTextBox1;
	
	@FindBy(xpath ="//*/android.widget.LinearLayout/android.widget.EditText[2]")
	public static WebElement OtpTextBox2;
	
	@FindBy(xpath ="//*/android.widget.LinearLayout/android.widget.EditText[3]")
	public static WebElement OtpTextBox3;
	
	@FindBy(xpath ="//*/android.widget.LinearLayout/android.widget.EditText[4]")
	public static WebElement OtpTextBox4;
	
	@FindBy(xpath ="//*/android.widget.LinearLayout/android.widget.EditText[5]")
	public static WebElement OtpTextBox5;
	
	@FindBy(xpath ="//*/android.widget.LinearLayout/android.widget.EditText[6]")
	public static WebElement OtpTextBox6;
	
	@FindBy(id ="in.okcredit.merchant:id/tvInCorrectPin")
	public static WebElement InCorrectPin;
	
	@FindBy(id ="com.google.android.apps.messaging:id/lockup")
	public static WebElement Messages;
	
	@FindBy(id ="com.google.android.apps.messaging:id/conversation_icon")
	public static WebElement ConversationHeader;
	
	@FindBy(id ="com.google.android.apps.messaging:id/conversation_name")
	public static WebElement ConversationName;
	
	@FindBy(id ="com.google.android.apps.messaging:id/message_text")
	public static WebElement MessageText;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'OkCredit')]")
	public static WebElement OtpTextMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/mbEditMobile")
	public static WebElement EditMobileNumber;
	
	@FindBy(id ="com.truecaller:id/partnerLoginIntentText")
	public static WebElement TrueCallerHeader;
	
	@FindBy(id ="com.truecaller:id/text")
	public static WebElement TrucallerNumberandName;
	
	@FindBy(id ="com.truecaller:id/confirm")
	public static WebElement TrucallerContinue;
	
	@FindBy(id ="com.truecaller:id/continueWithDifferentNumber")
	public static WebElement TrucallerSkip;
	
	@FindBy(id ="com.truecaller:id/profileImage")
	public static WebElement TrucallerProfile;
	
	@FindBy(id ="in.okcredit.merchant:id/lottieOtpVerifySuccess")
	public static WebElement VerifycationSuccess;
	
}