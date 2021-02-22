package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class HamburgerMenuOptions extends desiredCapabilities{
	
	@FindBy(xpath ="//android.widget.TextView[@text='Total Rewards']")
	public static WebElement TotalRewards;
	
	@FindBy(id ="in.okcredit.merchant:id/share")
	public static WebElement Share;
	
	@FindBy(id ="in.okcredit.merchant:id/share_text_title")
	public static WebElement SharePageTellYourFamily;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Total Rewards']")
	public static WebElement RateUs;
	
	@FindBy(xpath ="//android.view.View[@content-desc=\"OkCredit-Logo\"]/android.widget.Image")
	public static WebElement OkCWebPage;
	
	@FindBy(xpath ="//android.view.View[@text='Mobile Prepaid Recharge']")
	public static WebElement MobileRechargeHeader;
	
	@FindBy(xpath ="//android.widget.Button[contains(@text,'Protect My Family')]")
	public static WebElement InsurancePageProtect;

	@FindBy(id ="in.okcredit.merchant:id/bottom_text")
	public static WebElement PrivacyPageBottomBar;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Why my data is online?')]")
	public static WebElement WhyMyDataOnline;
	
	@FindBy(xpath ="//android.view.View[contains(@text,'We will send free SMS')]")
	public static WebElement HomeDeleiverMessage;
	
	@FindBy(xpath ="//android.view.View[@text='Home Delivery']")
	public static WebElement HomeDeleiveryHeader;
	
	@FindBy(xpath ="//android.widget.FrameLayout[contains(@content-desc,'new')]")
	public static WebElement WhatsNewPlaystore;
	
	
	
	@FindBy(id ="com.android.vending:id/radial_download_progress")
	public static WebElement OKCLogoinPlaystore;
	
	@FindBy(id ="in.okcredit.merchant:id/iv_open_reward_icon")
	public static WebElement RewardsPageReward;
}
