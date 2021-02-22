package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class LinkPay_OR extends desiredCapabilities {

	@FindBy(id ="in.okcredit.merchant:id/liveSaleTitle")
	public static WebElement LinkPay;
	
	@FindBy(id ="in.okcredit.merchant:id/linkPayDescription")
	public static WebElement LinkPayDescription;
	
	@FindBy(id ="in.okcredit.merchant:id/liveSaleTitle")
	public static WebElement LinkPayHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/date")
	public static WebElement Date;
	
	@FindBy(id ="in.okcredit.merchant:id/tx_amount")
	public static WebElement Amount;
	
	@FindBy(id ="in.okcredit.merchant:id/tx_date")
	public static WebElement TransationDate;
	
	@FindBy(id ="in.okcredit.merchant:id/sync")
	public static WebElement SynceStatus;
	
	@FindBy(id ="in.okcredit.merchant:id/total_balance")
	public static WebElement TotalBalance;
	
	@FindBy(id ="in.okcredit.merchant:id/qr_code")
	public static WebElement ShowQR;
	
	@FindBy(id ="in.okcredit.merchant:id/ll_share_link_pay")
	public static WebElement ShareLinkPay;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Total online collection']")
	public static WebElement TotalOnlineCollection;
	
	@FindBy(id ="in.okcredit.merchant:id/name")
	public static WebElement LinkPayQRHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_payment_address")
	public static WebElement UPIID;
	
	@FindBy(id ="in.okcredit.merchant:id/image")
	public static WebElement QRImage;
	
	@FindBy(id ="in.okcredit.merchant:id/qr_image")
	public static WebElement QRImageHome;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_qr_description")
	public static WebElement QRDescription;
	
	@FindBy(id ="in.okcredit.merchant:id/get_money_directly")
	public static WebElement QRDescription2;
	
	@FindBy(id ="in.okcredit.merchant:id/iv_bhim_upi")
	public static WebElement UPIBottomBanner;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'33390')]")
	public static WebElement OKCContact;
	
	@FindBy(id ="com.whatsapp:id/caption")
	public static WebElement WACaption;
	
	@FindBy(xpath ="//android.view.View[contains(@content-desc,'https')]")
	public static WebElement LinkPayLinkinWA;
	
	@FindBy(id ="com.android.chrome:id/url_bar")
	public static WebElement URlBar;
	
	@FindBy(xpath = "//android.widget.Button[contains(@text,'card icon Net banking')]")
	public static WebElement Netbanking;
	
	@FindBy(xpath ="//android.widget.Button[contains(@text,'card icon Debit card')]")
	public static WebElement DebitCard;
	
	@FindBy(id ="in.okcredit.merchant:id/tvBalanceStatus")
	public static WebElement LinkPayPaymentStatus;
	
	@FindBy(id ="in.okcredit.merchant:id/tvBalance")
	public static WebElement LinkPayPaymentBalance;
	
	@FindBy(id ="in.okcredit.merchant:id/photo_image_view")
	public static WebElement LinkPayImage;
	
	@FindBy(id ="in.okcredit.merchant:id/last_payment_date")
	public static WebElement LastPaymentDate;
	
	@FindBy(id ="in.okcredit.merchant:id/whatsapp_icon")
	public static WebElement ShareLink;
	
	@FindBy(id ="in.okcredit.merchant:id/amount")
	public static WebElement DetailsPageAmount;
	
	@FindBy(xpath = "//android.widget.TextView[@text='ONLINE PAYMENT']")
	public static WebElement ONLINEPAYMENT;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Transaction ID']")
	public static WebElement TransactionIDTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/txn_id")
	public static WebElement TransactionID;
	
	@FindBy(id ="in.okcredit.merchant:id/upi_id_to_title")
	public static WebElement ToAccount;
	
	@FindBy(id ="in.okcredit.merchant:id/added_by_title")
	public static WebElement AddedByTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/syc_title")
	public static WebElement SyncStatus;
	
}
