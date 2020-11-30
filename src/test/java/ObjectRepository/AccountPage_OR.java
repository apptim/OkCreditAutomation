package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;
import io.appium.java_client.MobileElement;

public class AccountPage_OR  extends desiredCapabilities{

	@FindBy(id ="in.okcredit.merchant:id/customerCountLabel")
	public static WebElement Customers;
	
	@FindBy(id ="in.okcredit.merchant:id/customerCount")
	public static WebElement CustomersCount;
	
	@FindBy(id ="in.okcredit.merchant:id/balanceLabel")
	public static WebElement Balance;
	
	@FindBy(id ="in.okcredit.merchant:id/balance")
	public static WebElement BalanceAmount;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Account Statement']")
	public static WebElement AccountStatement;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Download Backup']")
	public static WebElement DownloadBackup;
	
	@FindBy(xpath ="//android.widget.TextView[@text='SETTINGS']")
	public static WebElement SETTINGS;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Security']")
	public static WebElement Security;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Profile']")
	public static WebElement Profile;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Collections']")
	public static WebElement Collections;
	
	@FindBy(xpath ="//android.widget.TextView[@text='SETTINGS']")
	public static WebElement Language;
	
	@FindBy(id ="in.okcredit.merchant:id/activeLanguage")
	public static WebElement ActiveLanguage;
	
	@FindBy(id ="in.okcredit.merchant:id/help_icon")
	public static WebElement HelpIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_name")
	public static WebElement AccountStatementHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/menu_overflow")
	public static WebElement AccountFilter;
	
	@FindBy(id ="in.okcredit.merchant:id/date_range")
	public static WebElement DateRange;
	
	@FindBy(xpath ="i//android.widget.TextView[@text='NET BALANCE']")
	public static WebElement NetBalance;
	
	@FindBy(id ="in.okcredit.merchant:id/total")
	public static WebElement totalAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/payment_count")
	public static WebElement TotalPaymentCount;
	
	@FindBy(id ="in.okcredit.merchant:id/payment_total")
	public static WebElement TotalPaymentAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/credit_count")
	public static WebElement TotalCreditCount;
	
	@FindBy(id ="in.okcredit.merchant:id/credit_total")
	public static WebElement TotalCreditAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/dicount")
	public static WebElement Discount;
	
	@FindBy(id ="in.okcredit.merchant:id/dicount_amount")
	public static WebElement DiscountAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/total_label")
	public static WebElement TotalAmountLabel;
	
	@FindBy(id ="in.okcredit.merchant:id/customer_name")
	public static List<MobileElement> CustomerNames;
	
	@FindBy(id ="in.okcredit.merchant:id/tx_amount")
	public static List<MobileElement> TransactedAmounts;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_download")
	public static WebElement Download;
	
	@FindBy(id ="in.okcredit.merchant:id/screen_title")
	public static WebElement TransPageHeader ;
	
	@FindBy(id ="in.okcredit.merchant:id/delete_text")
	public static WebElement DeleteTextInAccount ;
	
	@FindBy(xpath ="//android.widget.TextView[@text='DISCOUNTS OFFERED']")
	public static WebElement DISCOUNTSOFFERED;
	
	@FindBy(id ="in.okcredit.merchant:id/dicount_amount")
	public static WebElement TotalDiscountAmount ;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Discount offered']")
	public static List<MobileElement> DiscountOfferedHeader ;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Discount offered']")
	public static WebElement DiscountOffered ;
	

}
