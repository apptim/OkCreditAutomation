package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;
import io.appium.java_client.MobileElement;

public class CollectionsPage_OR  extends desiredCapabilities{
	
	
	@FindBy(id ="in.okcredit.merchant:id/toolbar_title")
	public static WebElement OnLineCollectionHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/iv_adoption_image_education")
	public static WebElement CollectionImageBanner;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_start_accepting_collection")
	public static WebElement CollectionDescription;
	
	@FindBy(id ="in.okcredit.merchant:id/drop_shadow_bottom")
	public static WebElement CollectionVideo;
	
	@FindBy(id ="in.okcredit.merchant:id/setup_collection")
	public static WebElement SetupCollection;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_add_payment_title")
	public static WebElement AddBankDetailsTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/bank_radio")
	public static WebElement SwitchPayment;
	
	@FindBy(id ="in.okcredit.merchant:id/validate_details")
	public static WebElement SubmitBank;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_switch_payment_mode")
	public static WebElement AddUPI;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_add_payment_description")
	public static WebElement AddPaymentDescription;
	
	@FindBy(id ="iin.okcredit.merchant:id/tv_account_number")
	public static WebElement AddAccountNumberHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/account_number")
	public static WebElement AddAccountNumberTextBox;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_ifsc")
	public static WebElement IFSCCodeHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/ifsc")
	public static WebElement IFSCCodeTextBox;
	
	@FindBy(id ="in.okcredit.merchant:id/validate_details")
	public static WebElement SubmitAccountNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/ifsc_clear")
	public static WebElement ClearAccountDetails;
	
	@FindBy(id ="in.okcredit.merchant:id/confirm_details")
	public static WebElement ConfirmBankDetailsHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/payment_mode_icon")
	public static WebElement PaymentModeIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/merchant_name")
	public static WebElement AccountHolderName;
	
	@FindBy(id ="in.okcredit.merchant:id/bank_account")
	public static WebElement AccountNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/ifsc_or_upi")
	public static WebElement IFSCInValidationPage;
	
	@FindBy(id ="in.okcredit.merchant:id/check_icon")
	public static WebElement VerifiedIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/change")
	public static WebElement Change;
	
	@FindBy(id ="in.okcredit.merchant:id/confirm")
	public static WebElement Confirm;
	
	@FindBy(id ="in.okcredit.merchant:id/upi_id")
	public static WebElement UPIIDTextBox;
	
	@FindBy(id ="in.okcredit.merchant:id/iv_scan_qr")
	public static WebElement QRSccannerIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/back_icon")
	public static WebElement BackIconInScannerPage;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text, 'scan the QR code')]")
	public static WebElement MessageInScannerPage;
	
	@FindBy(id ="in.okcredit.merchant:id/compatible_with")
	public static WebElement CompatibleWithText;
	
	@FindBy(id ="in.okcredit.merchant:id/upi_logos")
	public static WebElement UPILogos;
	
	@FindBy(id ="in.okcredit.merchant:id/ifsc_error")
	public static WebElement InvalidIFSC;
	
	@FindBy(id ="in.okcredit.merchant:id/snackbar_text")
	public static WebElement InvalidAddress;
	
	@FindBy(id ="in.okcredit.merchant:id/qrIcon")
	public static WebElement QRIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_date_range")
	public static WebElement DateRange;
	
	@FindBy(id ="in.okcredit.merchant:id/total_credit_title")
	public static WebElement TotalCreditGiven;
	
	@FindBy(id ="in.okcredit.merchant:id/barChart")
	public static WebElement BarChart;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_offline_collection")
	public static WebElement TotalOfflineCollection;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_offline_collection_amount")
	public static WebElement TotalOfflineCollectionAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_online_collection")
	public static WebElement TotalOnlineCollection;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_online_collection_amount")
	public static WebElement TotalOnlineCollectionAmount;
	
	@FindBy(id ="in.okcredit.merchant:id/pieChart")
	public static WebElement PieChart;
	
	@FindBy(id ="in.okcredit.merchant:id/pieChart")
	public static WebElement ColectionValue;
	
	@FindBy(id ="in.okcredit.merchant:id/defaulter_name")
	public static List<MobileElement> DefaulterList;
	
	@FindBy(id ="in.okcredit.merchant:id/defaulter_amount")
	public static List<MobileElement> DefaulterAmount;
	
	@FindBy(xpath ="//android.widget.TextView[@text='These customers have not made any payment, within expected credit cycle']")
	public static WebElement BottomDisclaimer;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_defaulters")
	public static WebElement DefaultersHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/upi_name")
	public static WebElement MerchantNameinQRPage;
	
	@FindBy(id ="in.okcredit.merchant:id/upi_id")
	public static WebElement MerchantNumberandUPIinQRPage;
	
	@FindBy(id ="in.okcredit.merchant:id/upi_image")
	public static WebElement MerchantQRCode;
	
	@FindBy(id ="in.okcredit.merchant:id/scan_and_pay")
	public static WebElement ScanandPayMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/share_qr")
	public static WebElement ShareQR;
	
	@FindBy(id ="in.okcredit.merchant:id/save_qr")
	public static WebElement SaveQR;
	
	@FindBy(id ="in.okcredit.merchant:id/vertical_dot_icon")
	public static WebElement ThreeDotMenuinQRPage;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_online_collection")
	public static WebElement OnlineCollectionSatement;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_share_qr")
	public static WebElement ShareQRInsideThreeDotMenu;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_save_qr")
	public static WebElement SaveQRInsideThreeDotMenu;

	@FindBy(id ="in.okcredit.merchant:id/tv_update_account")
	public static WebElement UpdateBankUPI;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_delete_account")
	public static WebElement DeleteAccount;
	
	@FindBy(id ="in.okcredit.merchant:id/imageView3")
	public static WebElement DeleteAccountIcon;
	
	@FindBy(id ="in.okcredit.merchant:id/tvDeleteInfo")
	public static WebElement DeleteMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/delete")
	public static WebElement Delete;
	
	@FindBy(id ="in.okcredit.merchant:id/cancel")
	public static WebElement Cancel;
	
	@FindBy(id ="in.okcredit.merchant:id/total_credit_amount")
	public static WebElement TotalCreditGivenAmount;
	
	@FindBy(id ="android:id/sem_title_default")
	public static WebElement ShareMenuHeader;
	
	@FindBy(xpath ="//android.widget.TextView[@text='WhatsApp']")
	public static WebElement ShareWhatsApp;
	
	@FindBy(id ="com.whatsapp:id/caption")
	public static WebElement WhatsAppCaption;
	
	@FindBy(id ="com.whatsapp:id/entry")
	public static WebElement WhastAppTextBox;
	
	@FindBy(id ="in.okcredit.merchant:id/merchant_destination_qr_variant")
	public static WebElement FileSavedSuccesFully;
	
	@FindBy(id ="in.okcredit.merchant:id/all_txns")
	public static WebElement AllTransaction;
	
	@FindBy(id ="in.okcredit.merchant:id/online_txns")
	public static WebElement OnlineTransAction;
	
	@FindBy(id ="in.okcredit.merchant:id/menu_overflow")
	public static WebElement FilterMenu;
	
	@FindBy(id ="in.okcredit.merchant:id/date_range")
	public static WebElement DateRangeinCollectionStatement;
	
	@FindBy(id ="//android.widget.TextView[contains(@text,'any transactions')]")
	public static WebElement YouDontHaveAnyTransaction;
	
	@FindBy(id ="in.okcredit.merchant:id/heading")
	public static WebElement UpdateUPIHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/title")
	public static WebElement UPIDetailID;
	
	@FindBy(id ="in.okcredit.merchant:id/desc")
	public static WebElement UpateDescription;
	
	@FindBy(id ="in.okcredit.merchant:id/ok")
	public static WebElement Ok;
	
	@FindBy(id ="in.okcredit.merchant:id/submit_upi")
	public static WebElement SubmitUPI;

}
