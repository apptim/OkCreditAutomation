package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.MobileElement;

import Driver.desiredCapabilities;

public class SupplierPage_OR extends desiredCapabilities{


	@FindBy(id ="in.okcredit.merchant:id/tvTabTitle")
	public static List<MobileElement> SupplierHeader;
	
	@FindBy(xpath ="//android.widget.TextView[@text='SUPPLIER']")
	public static WebElement SupplierTab;
	
	@FindBy(id ="in.okcredit.merchant:id/btnAddRelationship")
	public static WebElement AddSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/tvName")
	public static WebElement SupplierListCount;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static List<MobileElement> SupplierList;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static WebElement SupplierListSingle;
	
	@FindBy(id ="in.okcredit.merchant:id/top_edittext")
	public static WebElement SupplierNameNumberTextBox;
	
	@FindBy(id ="in.okcredit.merchant:id/ic_right_icon")
	public static WebElement ClearSupplierName;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Import Phone Contacts']")
	public static WebElement ImportPhoneContacts;
	
	@FindBy(id ="in.okcredit.merchant:id/title")
	public static WebElement ContactListHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/name")
	public static WebElement ContactsName;
	
	@FindBy(id ="in.okcredit.merchant:id/mobile")
	public static WebElement ContactsNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/empty_tx_text")
	public static WebElement SupplierEmptyText;
	
	@FindBy(id ="in.okcredit.merchant:id/bottom_name")
	public static WebElement SupplierNameBottom;
	
	@FindBy(id ="in.okcredit.merchant:id/bottom_button")
	public static WebElement SupplierNameSubmitOk;
	
	@FindBy(id ="in.okcredit.merchant:id/input_phone")
	public static WebElement SupplierProfileMobile;
	
	@FindBy(xpath ="//android.widget.TextView[@text='SKIP']")
	public static WebElement SkipMobileNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_name")
	public static WebElement SupplierNameProfileHeader;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Cannot add as supplier']")
	public static WebElement CannotAddSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/description")
	public static WebElement DescriptionforNotAddingSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/migrate_txt")
	public static WebElement MovetoSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/move_to_supplier")
	public static WebElement ProfileMovetoSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/toolbar_title")
	public static WebElement MoveToSupplierHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/customers_img")
	public static WebElement CustomerImageThumb;
	
	@FindBy(id ="in.okcredit.merchant:id/suppliers_img")
	public static WebElement SupplierImageThumb;
	
	@FindBy(id ="in.okcredit.merchant:id/how_text")
	public static WebElement HowDoesitWork;
	
	@FindBy(id ="in.okcredit.merchant:id/text_1")
	public static WebElement MoveSupplierText1;
	
	@FindBy(id ="in.okcredit.merchant:id/text_2")
	public static WebElement MoveSupplierText2;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Move to Supplier']")
	public static WebElement MovetoSupplierTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/accept")
	public static WebElement Confirm;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Moving to Supplier']")
	public static WebElement MovingToSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/loading_value_tv")
	public static WebElement LoadingValueWhileMoving;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Moving Successful']")
	public static WebElement MovingSuccessful;
	
	@FindBy(id ="in.okcredit.merchant:id/view_account")
	public static WebElement Home;
	
	@FindBy(xpath ="//android.widget.TextView[@text='New Supplier']")
	public static WebElement NewSupplier;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Moving Failed!']")
	public static WebElement MovingFailed;
	
	@FindBy(xpath ="//android.widget.Button[contains(@text,'RETRY')]")
	public static WebElement Retry;
	
	@FindBy(id ="in.okcredit.merchant:id/delete_text")
	public static WebElement DeleteSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/snackbar_text")
	public static WebElement NoInternetConnection;
	
	@FindBy(id ="in.okcredit.merchant:id/add_credit_text")
	public static WebElement GivePaymentTextBox;
	
	@FindBy(id ="in.okcredit.merchant:id/pay_online")
	public static WebElement PayOnline;
	
	@FindBy(id ="in.okcredit.merchant:id/name")
	public static WebElement SupplierAccountName;
	
	@FindBy(id ="in.okcredit.merchant:id/payment_address")
	public static WebElement SupplierAccountnumber;
	
	@FindBy(id ="in.okcredit.merchant:id/ifsc")
	public static WebElement SupplierIFSC;
	
	@FindBy(id ="in.okcredit.merchant:id/change_account")
	public static WebElement ChangeAccount;
	
	@FindBy(id ="in.okcredit.merchant:id/change_details")
	public static WebElement change_details;
	
	@FindBy(id ="in.okcredit.merchant:id/confirm")
	public static WebElement Proceed;
	
	@FindBy(xpath ="//android.view.View[@text='Payment Processing']")
	public static WebElement PaymentProcessing;
	
	@FindBy(xpath ="//*/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]")
	public static WebElement AmountTextInPaymentProcessing;
	
	@FindBy(xpath ="//android.view.View[@text='Attempted to']")
	public static WebElement Attemptedto;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_title")
	public static WebElement ViewSupplier;
	
	@FindBy(id ="in.okcredit.merchant:id/button_container_name")
	public static WebElement SupplierProfileNameSubmit;
	
	@FindBy(id ="in.okcredit.merchant:id/phone_button")
	public static WebElement SupplierProfilemobileNumberSubmit;
	
	@FindBy(id ="in.okcredit.merchant:id/button_container_address")
	public static WebElement SupplierProfileAddressSubmit;
}
