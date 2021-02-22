package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;
import io.appium.java_client.MobileElement;

public class HomePage_OR extends desiredCapabilities{

	@FindBy(xpath ="//android.widget.TextView[@text='CUSTOMER']")
	public static WebElement CustomerTab;
	
	@FindBy(id ="in.okcredit.merchant:id/etSearch")
	public static WebElement SearchOrAdd;
	
	@FindBy(id ="in.okcredit.merchant:id/searchInput")
	public static WebElement SearchOrAddNext;
	
	@FindBy(id ="in.okcredit.merchant:id/ivNavigationAndBack")
	public static WebElement HamburgerMenu;
	
	@FindBy(id ="in.okcredit.merchant:id/customers_default")
	public static WebElement CustomerHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/btnAddRelationship")
	public static WebElement AddCustomer;
	
	@FindBy(id ="in.okcredit.merchant:id/ivProfilePhotoHeader")
	public static WebElement ProfilePicHeader;
	
	@FindBy(id ="com.android.packageinstaller:id/permission_allow_button")
	public static WebElement PermissonAllow;
	
	@FindBy(id ="in.okcredit.merchant:id/name_edit_text")
	public static WebElement InputCustomerName;
	
	@FindBy(id ="in.okcredit.merchant:id/title")
	public static WebElement PhoneBookContact;
	
	@FindBy(id ="in.okcredit.merchant:id/toolbar")
	public static WebElement AddCustomerHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/next_button")
	public static WebElement CustomerNameSubmitButton;
	
	@FindBy(id ="in.okcredit.merchant:id/done_button")
	public static WebElement CustomerNumberSubmitButton;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static WebElement CustomeNameList;
	
	@FindBy(id ="in.okcredit.merchant:id/customer_added")
	public static WebElement Customer_added;
	
	@FindBy(id ="in.okcredit.merchant:id/customer_added_dater")
	public static WebElement customer_added_date;
	
	@FindBy(id ="in.okcredit.merchant:id/tvBalanceStatus")
	public static WebElement BalanceStatus;
	
	@FindBy(id ="in.okcredit.merchant:id/filter")
	public static WebElement Filter;
	
	@FindBy(id ="in.okcredit.merchant:id/filter_overflow")
	public static WebElement SortIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/filter_overflow")
	public static WebElement FilterIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/tvBalance")
	public static WebElement Balance;
	
	@FindBy(id ="in.okcredit.merchant:id/ivMenu")
	public static WebElement Menu;
	
	@FindBy(id ="in.okcredit.merchant:id/top_edittext")
	public static WebElement AddCustomerTextField;
	
	@FindBy(id ="in.okcredit.merchant:id/text_input_end_icon")
	public static WebElement AddCustomerClearText;
	
	@FindBy(id ="in.okcredit.merchant:id/text_input_end_icon")
	public static WebElement AddCustomerNumberClearText;
	
	@FindBy(id ="in.okcredit.merchant:id/number_edit_text")
	public static WebElement AddCustomerNumberField;
	
	@FindBy(id ="in.okcredit.merchant:id/name")
	public static WebElement FilterdContact;
	
	@FindBy(id ="in.okcredit.merchant:id/mobile")
	public static WebElement ContactList;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static List<MobileElement> CustomerSearchListlist;
	
	@FindBy(id ="in.okcredit.merchant:id/tvBalance")
	public static List<MobileElement> BalanceList;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static WebElement CustomerSearchList;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_close")
	public static WebElement ClearSearchX;
	
	@FindBy(id ="in.okcredit.merchant:id/tvMessage")
	public static WebElement NoContactFoundMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/tvAdd")
	public static WebElement Add;
	
	@FindBy(id ="in.okcredit.merchant:id/due_date_info")
	public static WebElement DueDatenfo;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Settings']")
	public static WebElement SettingsButton;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_signout")
	public static WebElement SignOutButton;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_signout")
	public static WebElement SignOutConfirmButton;
	
	@FindBy(id ="in.okcredit.merchant:id/logout")
	public static WebElement SignOutConfirmation;
	
	@FindBy(id ="in.okcredit.merchant:id/account_text_view")
	public static WebElement AccountMenu;
	
//	in.okcredit.merchant:id/design_menu_item_text
	
	@FindBy(xpath ="//android.widget.TextView[@text='Money Transfer']")
	public static WebElement MoneyTransfer;
	
	@FindBy(xpath ="//android.widget.TextView[@text='DUE']")
	public static WebElement DueLabel;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Credit added')]")
	public static WebElement CreditAdded;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Collect on']")
	public static WebElement CollectOn;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Collect Today']")
	public static WebElement CollectToday;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Collections']")
	public static WebElement Collections;
	
	@FindBy(id ="in.okcredit.merchant:id/clear")
	public static WebElement ClearInFilter;
	
	@FindBy(id ="in.okcredit.merchant:id/clear_filter")
	public static WebElement ClearInFilters;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Filter']")
	public static WebElement FilterHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/sort_by")
	public static WebElement SortBy;
	
	@FindBy(id ="in.okcredit.merchant:id/sort_only")
	public static WebElement CollectionDate;
	
	@FindBy(id ="in.okcredit.merchant:id/due_today")
	public static WebElement Today;
	
	@FindBy(id ="in.okcredit.merchant:id/due_crossed")
	public static WebElement Pending;
	
	@FindBy(id ="in.okcredit.merchant:id/upcoming_due")
	public static WebElement UpComingDue;
	
	@FindBy(id ="in.okcredit.merchant:id/rdg_name")
	public static WebElement SortName;
	
	@FindBy(id ="in.okcredit.merchant:id/rdg_amount")
	public static WebElement SortAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/rdg_latest")
	public static WebElement SortLatest;
	
	@FindBy(id ="in.okcredit.merchant:id/cancel")
	public static WebElement Cancel;
	
	@FindBy(id ="in.okcredit.merchant:id/apply")
	public static WebElement Apply;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Pending Collection']")
	public static WebElement PendingCollection;
	
	@FindBy(xpath ="//android.widget.TextView[@text='No Results Found']")
	public static WebElement NoResultsFound;
	
	@FindBy(id ="in.okcredit.merchant:id/due_info")
	public static WebElement DueInfo;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_filter_count")
	public static WebElement FilterCount;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitle")
	public static WebElement TypeinSearchResult;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'transactions unsynced')]")
	public static WebElement UnSyncedTransactions;
	
	@FindBy(id ="in.okcredit.merchant:id/sync_now")
	public static WebElement SyncNow;
	
	@FindBy(id ="in.okcredit.merchant:id/snackbar_text")
	public static WebElement NoInternetText;
	
	@FindBy(id ="in.okcredit.merchant:id/ivSubtitleInfo")
	public static WebElement SyncStatus;
	
	@FindBy(id ="in.okcredit.merchant:id/ivSync")
	public static WebElement SyncStatusInSupplier;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Rewards')]")
	public static WebElement Rewards;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Share']")
	public static WebElement ShareMenu;
	
	@FindBy(xpath ="//android.widget.TextView[@text='About Us']")
	public static WebElement AboutUs;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Home Delivery']")
	public static WebElement HomeDelivery;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Mobile Prepaid Recharge']")
	public static WebElement MobilePrepaidRecharge;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Privacy Policy']")
	public static WebElement PrivacyPolicy;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Insurance']")
	public static WebElement Insurance;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Rate us 5 star']")
	public static WebElement RateUs;
	
	@FindBy(id ="in.okcredit.merchant:id/mbShareOnWhatsapp")
	public static WebElement HomepageWAShare;
	
	
}