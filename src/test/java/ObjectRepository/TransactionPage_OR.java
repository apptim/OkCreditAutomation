package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;
import io.appium.java_client.MobileElement;

public class TransactionPage_OR extends desiredCapabilities {

	@FindBy(id = "in.okcredit.merchant:id/empty_tx_text")
	public static WebElement EmptyText;

	@FindBy(id = "in.okcredit.merchant:id/add_credit_btn_ab")
	public static WebElement PaymentButton;
	
	@FindBy(id = "in.okcredit.merchant:id/add_payment_btn")
	public static WebElement PaymentButtonAB;

	@FindBy(id = "in.okcredit.merchant:id/icon_payment")
	public static WebElement PaymentIcon;

	@FindBy(id = "in.okcredit.merchant:id/add_payment_btn_ab")
	public static WebElement CreditButton;
	
	@FindBy(id = "in.okcredit.merchant:id/add_credit_btn")
	public static WebElement CreditButtonAB;

	@FindBy(id = "in.okcredit.merchant:id/add_credit_btn")
	public static WebElement TakeCredit;

	@FindBy(id = "in.okcredit.merchant:id/add_payment_btn")
	public static WebElement GivePayment;

	@FindBy(id = "in.okcredit.merchant:id/icon_credit")
	public static WebElement CreditIcon;

	@FindBy(id = "in.okcredit.merchant:id/due")
	public static WebElement DueHeader;

	@FindBy(id = "in.okcredit.merchant:id/add_credit_text")
	public static WebElement AddPaymentText;

	@FindBy(id = "in.okcredit.merchant:id/rupee_symbol")
	public static WebElement RupeeSymbol;

	@FindBy(id = "in.okcredit.merchant:id/btn_one")
	public static WebElement ButtonOne;

	@FindBy(id = "in.okcredit.merchant:id/btn_two")
	public static WebElement ButtonTwo;

	@FindBy(id = "in.okcredit.merchant:id/btn_three")
	public static WebElement ButtonThree;

	@FindBy(id = "in.okcredit.merchant:id/btn_backspace")
	public static WebElement ButtonBackSpace;

	@FindBy(id = "in.okcredit.merchant:id/btn_four")
	public static WebElement ButtonFour;

	@FindBy(id = "in.okcredit.merchant:id/btn_five")
	public static WebElement ButtonFive;

	@FindBy(id = "in.okcredit.merchant:id/btn_six")
	public static WebElement ButtonSix;

	@FindBy(id = "in.okcredit.merchant:id/btn_seven")
	public static WebElement ButtonSeven;

	@FindBy(id = "in.okcredit.merchant:id/btn_eight")
	public static WebElement ButtonEight;

	@FindBy(id = "in.okcredit.merchant:id/btn_nine")
	public static WebElement ButtonNine;

	@FindBy(id = "in.okcredit.merchant:id/btn_zero")
	public static WebElement ButtonZero;

	@FindBy(id = "in.okcredit.merchant:id/text_amount_calculation")
	public static WebElement AmountBoxAfterAdded;

	@FindBy(id = "in.okcredit.merchant:id/date_text_new")
	public static WebElement DateContainer;

	@FindBy(id = "in.okcredit.merchant:id/date_text")
	public static WebElement SupplierDateContainer;

	@FindBy(id = "android:id/date_picker_header_year")
	public static WebElement YearHeader;

	@FindBy(id = "android:id/date_picker_header_date")
	public static WebElement CurrentDate;

	@FindBy(id = "android:id/prev")
	public static WebElement PreviousMonth;

	@FindBy(id = "android:id/button2")
	public static WebElement CalenderCancel;

	@FindBy(id = "android:id/button1")
	public static WebElement CalenderOK;

	@FindBy(id = "in.okcredit.merchant:id/add_bill")
	public static WebElement AddBill;

	@FindBy(id = "in.okcredit.merchant:id/add_note_input_field")
	public static WebElement AddNoteTextBox;

	@FindBy(id = "in.okcredit.merchant:id/add_note_btn")
	public static WebElement AddNoteButton;

	@FindBy(id = "in.okcredit.merchant:id/voice_icon")
	public static WebElement VoiceIcon;

	@FindBy(id = "in.okcredit.merchant:id/btn_submit")
	public static WebElement PaymentSubmit;

	@FindBy(id = "in.okcredit.merchant:id/tx_date")
	public static WebElement TransactionDate;

	@FindBy(id = "in.okcredit.merchant:id/sync")
	public static WebElement DeleveredStatus;

	@FindBy(id = "in.okcredit.merchant:id/tx_amount")
	public static WebElement TransactionAmount;

	@FindBy(id = "in.okcredit.merchant:id/date")
	public static WebElement TransactionDateHeader;

	@FindBy(id = "in.okcredit.merchant:id/total_amount")
	public static WebElement TotalAmountNearTransaction;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Due')]")
	public static WebElement DueNearTransaction;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Advance')]")
	public static WebElement AdvanceNearTransaction;

	@FindBy(id = "in.okcredit.merchant:id/content")
	public static WebElement TransactionSmsMessage;

	@FindBy(id = "in.okcredit.merchant:id/balance_text")
	public static WebElement BalanceAdvance;

	@FindBy(id = "in.okcredit.merchant:id/total")
	public static WebElement TotalAmountBottomBar;

	@FindBy(id = "in.okcredit.merchant:id/call_customer_icon")
	public static WebElement CallIcon;

	@FindBy(id = "in.okcredit.merchant:id/call_customer_text")
	public static WebElement CallMenuText;

	@FindBy(id = "in.okcredit.merchant:id/send_reminder_icon")
	public static WebElement WhatsappReminderIcon;

	@FindBy(id = "in.okcredit.merchant:id/send_reminder_text")
	public static WebElement SendText;

	@FindBy(id = "in.okcredit.merchant:id/customer_statements")
	public static WebElement StatementIcon;

	@FindBy(id = "in.okcredit.merchant:id/add_credit_text")
	public static WebElement AddCredit;

	@FindBy(id = "in.okcredit.merchant:id/back")
	public static WebElement BackButton;

	@FindBy(id = "in.okcredit.merchant:id/delete")
	public static WebElement DeleteButton;

	@FindBy(id = "in.okcredit.merchant:id/add_more")
	public static WebElement AddMore;

	@FindBy(id = "in.okcredit.merchant:id/selectd")
	public static WebElement SelectedPicture;

	@FindBy(id = "in.okcredit.merchant:id/count_contianer")
	public static WebElement SelectedImageCounter;

	@FindBy(id = "in.okcredit.merchant:id/camera_capture_button")
	public static WebElement CaptureButton;

	@FindBy(id = "in.okcredit.merchant:id/pic")
	public static WebElement ImageThumb;

	@FindBy(id = "in.okcredit.merchant:id/gallery_image")
	public static WebElement GalleryImageThumb;

	@FindBy(id = "in.okcredit.merchant:id/balance_layout_container")
	public static WebElement ReminderBarHeader;

	@FindBy(id = "in.okcredit.merchant:id/reminder_title")
	public static WebElement SelectReminderType;

	@FindBy(id = "in.okcredit.merchant:id/sms_view")
	public static WebElement ReminderOptionSms;

	@FindBy(id = "in.okcredit.merchant:id/whatsapp_view")
	public static WebElement ReminderOptionWhatsApp;

	@FindBy(id = "in.okcredit.merchant:id/whatsapp_tick")
	public static WebElement ReminderSelectedWhatsApp;

	@FindBy(id = "in.okcredit.merchant:id/sms_tick")
	public static WebElement ReminderSelectedSms;

	@FindBy(id = "in.okcredit.merchant:id/select_default")
	public static WebElement AlwaysUse;

	@FindBy(id = "in.okcredit.merchant:id/send_reminder_button")
	public static WebElement SendReminder;

	@FindBy(id = "in.okcredit.merchant:id/image_count")
	public static WebElement AddedImageCount;

	@FindBy(id = "in.okcredit.merchant:id/tx_bill_image")
	public static WebElement AddedImageThumb;

	@FindBy(id = "in.okcredit.merchant:id/due_action_text")
	public static WebElement SetDueDate;

	@FindBy(id = "in.okcredit.merchant:id/clear")
	public static WebElement DueClear;

	@FindBy(xpath = "//android.widget.TextView[@text='Select Due Date']")
	public static WebElement SelectDueDateHeader;

	@FindBy(id = "in.okcredit.merchant:id/camera_capture_button")
	public static WebElement MonthName;

	@FindBy(id = "in.okcredit.merchant:id/date")
	public static WebElement DueDateDates;

	@FindBy(id = "in.okcredit.merchant:id/due_info_title")
	public static WebElement UpcomingDue;

	@FindBy(id = "in.okcredit.merchant:id/due_info_subtitle")
	public static WebElement SMSRequest;

	@FindBy(id = "in.okcredit.merchant:id/due_action_text")
	public static WebElement ChangeDueDate;

	@FindBy(id = "in.okcredit.merchant:id/due_date")
	public static WebElement SelectedDueDate;

	@FindBy(xpath = "//android.widget.TextView[@text='Request Payment']")
	public static WebElement RequestPaymentHeader;

	@FindBy(xpath = "//android.widget.TextView[@text='Send Whatsapp request']")
	public static WebElement SendWhatsAppRequest;

	@FindBy(xpath = "//android.widget.TextView[@text='Call Customer']")
	public static WebElement CallCustomer;

	@FindBy(xpath = "//android.widget.TextView[@text='Send SMS Request']")
	public static WebElement SendSMSRequest;

	@FindBy(id = "in.okcredit.merchant:id/call_iv")
	public static WebElement Callicon;

	@FindBy(id = "in.okcredit.merchant:id/ic_big_selected_pics")
	public static WebElement CapturesPhotoBigTick;

	@FindBy(id = "in.okcredit.merchant:id/image_preview")
	public static WebElement ImagePreview;

	@FindBy(id = "in.okcredit.merchant:id/tx_note")
	public static WebElement AddedNote;

	@FindBy(id = "in.okcredit.merchant:id/amount")
	public static WebElement AddedAmountDetailsPage;

	@FindBy(id = "in.okcredit.merchant:id/note")
	public static WebElement AddedNoteDetailsPage;

	@FindBy(id = "in.okcredit.merchant:id/syc_title")
	public static WebElement SyncStatusDetailsPage;

	@FindBy(id = "in.okcredit.merchant:id/created_date")
	public static WebElement AddedDateDetailsPage;

	@FindBy(id = "in.okcredit.merchant:id/date")
	public static WebElement BilledDateDetailsPage;

	@FindBy(id = "in.okcredit.merchant:id/delete_text")
	public static WebElement DeletePayment;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Deleted')]")
	public static WebElement CreditDeleted;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Deleted')]")
	public static WebElement PaymentDeleted;

	@FindBy(id = "in.okcredit.merchant:id/btn_share")
	public static WebElement ShareDetailsPage;

	@FindBy(xpath = "//android.widget.TextView[@text='+91 95131 33390']")
	public static WebElement OkCreditContact;

	@FindBy(id = "com.whatsapp:id/send")
	public static WebElement WhatsAppSendClick;

	@FindBy(id = "com.whatsapp:id/caption")
	public static WebElement ShareMessage;

	@FindBy(id = "com.whatsapp:id/back")
	public static WebElement WhatsAppBack;

	@FindBy(id = "com.whatsapp:id/caption")
	public static WebElement WhatsAppCaption;

	@FindBy(id = "in.okcredit.merchant:id/del_msg")
	public static WebElement DeleteMessage;

	@FindBy(id = "in.okcredit.merchant:id/ok")
	public static WebElement DeleteOK;

	@FindBy(id = "in.okcredit.merchant:id/camera_container")
	public static WebElement AddBillsMany;

	@FindBy(id = "in.okcredit.merchant:id/flash_iv")
	public static WebElement FlashIcon;

	@FindBy(id = "in.okcredit.merchant:id/reminder_action")
	public static WebElement RequestPayment;

	@FindBy(xpath = "//android.widget.TextView[@text='30']")
	public static WebElement DueDate30;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'OkCredit')]")
	public static WebElement SMSBody;

	@FindBy(id = "com.samsung.android.incallui:id/disconnect_button")
	public static WebElement EndCall;

	@FindBy(id = "com.samsung.android.incallui:id/name_as_number")
	public static WebElement CustomerNumber;

	@FindBy(id = "in.okcredit.merchant:id/customer_statements")
	public static WebElement ReportMenu;

	@FindBy(id = "in.okcredit.merchant:id/reminder_total")
	public static WebElement ReminderPanelAmount;

	@FindBy(xpath = "//android.widget.TextView[@text='SMS']")
	public static WebElement ReminderOptionSmsPanel;

	@FindBy(xpath = "//android.widget.TextView[@text='WhatsApp']")
	public static WebElement ReminderOptionWhatsappPanel;

	@FindBy(id = "in.okcredit.merchant:id/select_default")
	public static WebElement DefaultOptionInReminder;

	@FindBy(id = "in.okcredit.merchant:id/menu")
	public static WebElement ThreeDotMenu;

	@FindBy(id = "in.okcredit.merchant:id/discount_txt")
	public static WebElement GiveDiscount;

	@FindBy(id = "in.okcredit.merchant:id/call_txt")
	public static WebElement Call;

	@FindBy(id = "in.okcredit.merchant:id/help_txt")
	public static WebElement NeedHelp;

	@FindBy(id = "in.okcredit.merchant:id/report_txt")
	public static WebElement ShareReport;

	@FindBy(id = "in.okcredit.merchant:id/profile_name")
	public static WebElement DiscountPageProfileName;

	@FindBy(xpath = "//android.widget.TextView[@text='Discount offered']")
	public static WebElement DiscountOfferedHeader;

	@FindBy(id = "in.okcredit.merchant:id/tx_amount")
	public static List<MobileElement> TransactionAmountList;

	@FindBy(id = "in.okcredit.merchant:id/sms_title")
	public static WebElement DiscountSMSDetails;

	@FindBy(id = "in.okcredit.merchant:id/created_date")
	public static WebElement DiscountAddedDetails;

	@FindBy(id = "in.okcredit.merchant:id/title")
	public static WebElement DiscountOfferedinDetailPage;

	@FindBy(id = "in.okcredit.merchant:id/del_msg")
	public static WebElement DeleteDiscountMessage;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Deleted')]")
	public static WebElement DiscountDeleted;

	@FindBy(id = "in.okcredit.merchant:id/deleted_date")
	public static WebElement DeletedDateDiscount;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Balance Due')]")
	public static WebElement BalanceDue;

	@FindBy(id = "in.okcredit.merchant:id/due_action_text")
	public static WebElement CollectionDate;

	@FindBy(id = "in.okcredit.merchant:id/reminder_action")
	public static WebElement Remind;

	@FindBy(xpath = "//android.widget.TextView[@text='Select Collection Date']")
	public static WebElement SelectCollectionDate;

	@FindBy(id = "in.okcredit.merchant:id/five_day")
	public static WebElement FiveDays;

	@FindBy(id = "in.okcredit.merchant:id/ten_days")
	public static WebElement TenDays;

	@FindBy(id = "in.okcredit.merchant:id/fifteen_days")
	public static WebElement FifteenDays;

	@FindBy(id = "in.okcredit.merchant:id/thirty_days")
	public static WebElement ThirtyDays;

	@FindBy(id = "in.okcredit.merchant:id/full_month_name")
	public static WebElement DueCalanderMonthHeader;

	@FindBy(id = "in.okcredit.merchant:id/next")
	public static WebElement NextMonthSymbol;

	@FindBy(id = "in.okcredit.merchant:id/previous")
	public static WebElement PrevioustMonthSymbol;

	@FindBy(id = "in.okcredit.merchant:id/edit_due_date")
	public static WebElement EditDueDate;

	@FindBy(id = "in.okcredit.merchant:id/due_date_text_view")
	public static WebElement DueDate;

	@FindBy(id = "in.okcredit.merchant:id/due_month")
	public static WebElement DueMonth;

	@FindBy(id = "in.okcredit.merchant:id/pay_online")
	public static WebElement PayOnline;

	@FindBy(xpath = "//android.widget.Button[@text='Allow']")
	public static WebElement ButtonAllow;

	@FindBy(id = "in.okcredit.merchant:id/voice_fab")
	public static WebElement VoiceIconFab;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter Password']")
	public static WebElement EnterPassword;

	@FindBy(id = "in.okcredit.merchant:id/bottom_container_right_icon")
	public static WebElement ViewPassword;

	@FindBy(id = "in.okcredit.merchant:id/forgot_password_text")
	public static WebElement forgot_password;
	
	@FindBy(xpath = "//android.widget.Toast[contains(@text,'Account in advance')]")
	public static WebElement ReminderToast;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Frequently contacted']")
	public static WebElement FrequentlyContacted;
	
	@FindBy(id = "in.okcredit.merchant:id/listening_tv")
	public static WebElement Listning;

	@SuppressWarnings("unused")
	private By LEAVE_BTN = By.id("btnLeave");
	// com.samsung.android.messaging:id/send_button1
	
	@FindBy(id = "in.okcredit.merchant:id/toolbar_title")
	public static WebElement CustomerStatementHeader;
	
	@FindBy(id = "in.okcredit.merchant:id/current_balance")
	public static WebElement CurrentBalanceInStatements;
	
	@FindBy(id = "in.okcredit.merchant:id/total_balance")
	public static WebElement TotalBalanceInStatements;
	
	@FindBy(id = "in.okcredit.merchant:id/date_range")
	public static WebElement DateRange;
	
	@FindBy(id = "in.okcredit.merchant:id/this_month")
	public static WebElement ThisMonth;
	
	@FindBy(id = "in.okcredit.merchant:id/last_seven_days")
	public static WebElement LastSevenDays;
	
	@FindBy(id = "in.okcredit.merchant:id/balance_amount")
	public static WebElement BalanceInStatements;
	
	@FindBy(id = "in.okcredit.merchant:id/selected_date_range")
	public static WebElement SelectedDateRange;
	
	@FindBy(id = "in.okcredit.merchant:id/take")
	public static WebElement Take;
	
	@FindBy(id = "in.okcredit.merchant:id/give")
	public static WebElement Give;
	
	@FindBy(id = "in.okcredit.merchant:id/tv_date")
	public static WebElement Date;
	
	@FindBy(id = "in.okcredit.merchant:id/selected_duration_total_payment")
	public static WebElement selected_duration_total_payment;
	
	@FindBy(id = "in.okcredit.merchant:id/selected_duration_total_credit")
	public static WebElement selected_duration_total_credit;
	
	@FindBy(id = "in.okcredit.merchant:id/transaction_date")
	public static WebElement transaction_date;
	
	@FindBy(id = "in.okcredit.merchant:id/transaction_month")
	public static WebElement transaction_month;
	
	@FindBy(id = "in.okcredit.merchant:id/credit_arrow")
	public static WebElement credit_arrow;
	
	@FindBy(id = "in.okcredit.merchant:id/credit")
	public static WebElement credit;
	
	@FindBy(id = "in.okcredit.merchant:id/download_report")
	public static WebElement download_report;
	
	@FindBy(id = "in.okcredit.merchant:id/share_report")
	public static WebElement share_report;
	
	@FindBy(id = "in.okcredit.merchant:id/last_zero_balance")
	public static WebElement last_zero_balance;
	//Last 0 balance
	
	@FindBy(id = "in.okcredit.merchant:id/last_month")
	public static WebElement last_month;
	//Last month
	
	@FindBy(id = "in.okcredit.merchant:id/last_three_month")
	public static WebElement last_three_month;
	//Last 3 months
	
	@FindBy(id = "in.okcredit.merchant:id/last_six_month")
	public static WebElement last_six_month;
	//Last 6 months
	
	@FindBy(id = "in.okcredit.merchant:id/overall")
	public static WebElement Overall;
	//Overall
	
	@FindBy(id = "in.okcredit.merchant:id/payment")
	public static WebElement payment;
	
	@FindBy(id = "in.okcredit.merchant:id/payment_arrow")
	public static WebElement payment_arrow;
	
	@FindBy(id = "in.okcredit.merchant:id/snackbar_text")
	public static WebElement FileDownloadedSuccessfully;
	//File downloaded successfully!
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Creating report')]")
	public static WebElement CreatingReport;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Send to')]")
	public static WebElement WhatsappSendTo;
	
	@FindBy(id = "in.okcredit.merchant:id/material_target_prompt_view")
	public static WebElement material_target_prompt_view;
	
	@FindBy(id = "in.okcredit.merchant:id/supplier_account_text")
	public static WebElement SupplierText;
	
	@FindBy(id = "in.okcredit.merchant:id/dayOfMonthText")
	public static WebElement dayOfMonthText;
	
	@FindBy(id = "in.okcredit.merchant:id/tvYearTitle")
	public static WebElement StatementCalenderHeader;
	
	@FindBy(id = "in.okcredit.merchant:id/imgVNavLeft")
	public static WebElement StatementCalenderPreviousMonth;
	
	@FindBy(id = "in.okcredit.merchant:id/btn_ok")
	public static WebElement StatementCalenderOK;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'No Transactions')]")
	public static WebElement NoTransactions;

	@FindBy(id = "in.okcredit.merchant:id/tv_txn_delete_title")
	public static WebElement AddedWrongAmout;
	
	@FindBy(id = "in.okcredit.merchant:id/tv_edit_amount")
	public static WebElement EditAmount;
	
	@FindBy(id = "in.okcredit.merchant:id/tv_delete_txn")
	public static WebElement DeleteAmount;
	
	
	}

