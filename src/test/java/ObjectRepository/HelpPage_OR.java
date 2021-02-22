package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Driver.desiredCapabilities;

public class HelpPage_OR extends desiredCapabilities {
	
	
	@FindBy(id ="in.okcredit.merchant:id/design_menu_item_text")
	public static WebElement AccountHelp;
	
	@FindBy(id ="in.okcredit.merchant:id/help_support_text")
	public static WebElement Help;
	
	@FindBy(id ="in.okcredit.merchant:id/security")
	public static WebElement SecurityHelp;
	
	@FindBy(id ="in.okcredit.merchant:id/help_icon")
	public static WebElement HelpIcon;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Frequently Asked Questions']")
	public static WebElement FrequentlyAsked;

	@FindBy(xpath ="//android.widget.TextView[@text='Customer Related Questions']")
	public static WebElement  CustomerRelated;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Transaction related questions']")
	public static WebElement TransactionRelated;

	@FindBy(xpath ="//android.widget.TextView[@text='Account statement related questions']")
	public static WebElement AccountStatement;

	@FindBy(xpath ="//android.widget.TextView[@text='Account Security Related Questions']")
	public static WebElement AccountSecurity;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Merchant - Related Questions']")
	public static WebElement Merchant;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static WebElement BusinessName;
	
	@FindBy(id ="in.okcredit.merchant:id/phone_text_view")
	public static WebElement NoBusinessName;
	
	@FindBy(id ="//in.okcredit.merchant:id/contextual_help']")
	public static WebElement HelpTrans;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Contact Us']")
	public static WebElement ContactUs;
	
	@FindBy(id ="in.okcredit.merchant:id/menu")
	public static WebElement HelpMenu;
	
	@FindBy(id ="in.okcredit.merchant:id/help_txt")
	public static WebElement HelpDropDown;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_name")
	public static WebElement Customerprofile;
	
	@FindBy(id ="in.okcredit.merchant:id/cvContainer")
	public static WebElement FirstTransaction;
	
	@FindBy(id ="in.okcredit.merchant:id/iv_like")
	public static WebElement Like;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_feedback_thanks")
	public static WebElement FeedbackThanks;

	@FindBy(id ="in.okcredit.merchant:id/iv_dislike")
	public static WebElement DisLike;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_help_feedback")
	public static WebElement HelpFeedback;

	@FindBy(id ="in.okcredit.merchant:id/tv_help_item_heading")
	public static WebElement FirstHelpContent;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_help_submit_feedback")
	public static WebElement FeedBack_Submit;
	
	@FindBy(id ="in.okcredit.merchant:id/bottom_help_feedback_text")
	public static WebElement FeedBack_Text;
	
	@FindBy(id ="in.okcredit.merchant:id/tv_email_text")
	public static WebElement Email_Text;
	
}
