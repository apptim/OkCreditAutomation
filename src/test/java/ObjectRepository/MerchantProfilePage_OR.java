package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;
import io.appium.java_client.MobileElement;

public class MerchantProfilePage_OR extends desiredCapabilities {

	
//	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
//	public static List<MobileElement> MerchantName;
	
	@FindBy(xpath ="//*/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]")
	public static WebElement MerchantName;
	
	@FindBy(id ="in.okcredit.merchant:id/phone_text_view")
	public static WebElement MerchantNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/photo_image_view")
	public static WebElement MerchantProfilePictureInProfilePage;
	
	@FindBy(xpath ="//*/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView[1]")
	public static WebElement MerchantProfilePicture;
	
	@FindBy(id ="in.okcredit.merchant:id/ivAddPhoto")
	public static WebElement EditMerchantProfilePhoto;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitleBusinessName")
	public static WebElement BusinessNameTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueBusinessName")
	public static WebElement BusinessName;
	
	@FindBy(id ="in.okcredit.merchant:id/tvProfileNameNote")
	public static WebElement BusinessNameDescription;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitleMobileNumber")
	public static WebElement MObileNumberTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueMobileNumber")
	public static WebElement MerchantMobileNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/titleBusinessType")
	public static WebElement BusinessTypeTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/descBusinessType")
	public static WebElement BusinessType;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitleCategory")
	public static WebElement CategoryTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueCategory")
	public static WebElement Category;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitleAddress")
	public static WebElement AddressTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueAddress")
	public static WebElement MerchantAddress;
	
	@FindBy(id ="iin.okcredit.merchant:id/tvTitleOtherInfo")
	public static WebElement OtherInfoTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueOtherInfo")
	public static WebElement OtherINfo;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitleEmail")
	public static WebElement EmailTitle;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueEmail")
	public static WebElement MerchantEmail;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueAbout")
	public static WebElement AboutBusiness;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueContactPersonName")
	public static WebElement ContactPersonName;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueBusinessCard")
	public static WebElement ShareBusinessCard;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_name")
	public static WebElement EditProfilePictureHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/fbDelete")
	public static WebElement Delete;
	
	@FindBy(id ="in.okcredit.merchant:id/fbGallery")
	public static WebElement Gallery;
	
	@FindBy(id ="in.okcredit.merchant:id/fbCamera")
	public static WebElement Camera;
	
	@FindBy(id ="in.okcredit.merchant:id/ivProfilePhotoFull")
	public static WebElement ProfilePictureFullExisting;
	
	@FindBy(xpath ="//android.view.View[@content-desc='Shutter button']")
	public static WebElement CameraShutter;
//	com.sec.android.app.camera:id/bottom_control
	
	@FindBy(xpath ="//android.widget.ImageView[contains(@content-desc,'Done')]")
	public static WebElement CameraOK;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Retry']")
	public static WebElement CameraRetry;
	
	@FindBy(id ="in.okcredit.merchant:id/toolbar_title")
	public static WebElement CropPageHeader;
	
	@FindBy(id ="in.okcredit.merchant:id/menu_crop")
	public static WebElement Crop;
	
	@FindBy(id ="in.okcredit.merchant:id/image_view_state_scale")
	public static WebElement ImageScale;
	
	@FindBy(id ="in.okcredit.merchant:id/image_view_state_rotate")
	public static WebElement Rotate;
	
	@FindBy(id ="in.okcredit.merchant:id/text_view_scale")
	public static WebElement ScalePercentage;
	
	@FindBy(id ="in.okcredit.merchant:id/tvConfirmMessage")
	public static WebElement ConfirmDelete;
	
	@FindBy(xpath ="//android.widget.TextView[@text='DELETE']")
	public static WebElement DeleteImage;
	
	@FindBy(xpath ="i//android.widget.TextView[@text='CANCEL']")
	public static WebElement CancelImgae;
	
	@FindBy(id ="com.android.documentsui:id/icon_thumb")
	public static WebElement RecentIMages;
	
	@FindBy(id ="in.okcredit.merchant:id/etInput")
	public static WebElement BusinessNameInput;
	
	@FindBy(id ="in.okcredit.merchant:id/fbSumit")
	public static WebElement BUsinessNameSubmit;
	
	@FindBy(id ="in.okcredit.merchant:id/old_number_pic")
	public static WebElement OldNumberPic;
	
	@FindBy(id ="in.okcredit.merchant:id/new_number_pic")
	public static WebElement NewumberPic;
	
	@FindBy(id ="in.okcredit.merchant:id/textView24")
	public static WebElement ChangeNumberMessage;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_verify_number")
	public static WebElement VerifyMobile;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Enter your new mobile number']")
	public static WebElement EnterNewMobileNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/etNumberChange")
	public static WebElement NewNumber;
	
	@FindBy(id ="in.okcredit.merchant:id/clSubmit")
	public static WebElement NewNumberSubmit;
	
	@FindBy(id ="in.okcredit.merchant:id/error_text")
	public static WebElement MerchantAlreadyExist;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Retail Shop')]")
	public static WebElement RetailShop;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Wholesale/Distributor')]")
	public static WebElement WholeSaleDistributor;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Personal Use')]")
	public static WebElement PersonalUse;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Online Services')]")
	public static WebElement OnlineServices;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Select your business type')]")
	public static WebElement SelectBusiness;
	
	@FindBy(id ="in.okcredit.merchant:id/clCategoryHeader")
	public static WebElement MerchantCategoryWhole;
	
	@FindBy(id ="in.okcredit.merchant:id/tvValueCategory")
	public static WebElement MerchantCategory;
	
	@FindBy(id ="in.okcredit.merchant:id/searchEditText")
	public static WebElement SearchCategory;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Popular']")
	public static WebElement Populor;
	
	@FindBy(id ="in.okcredit.merchant:id/category_title")
	public static WebElement CategoryItems;
	
	@FindBy(id ="in.okcredit.merchant:id/placeholder_image")
	public static WebElement PlaceholderforEmptyCategory;
	
	@FindBy(id ="in.okcredit.merchant:id/title")
	public static WebElement NoResultsFound;
	
	@FindBy(id ="in.okcredit.merchant:id/desc")
	public static WebElement AddAsCategory;
	
	@FindBy(id ="in.okcredit.merchant:id/btn_add_category")
	public static WebElement AddCategory;
	
	@FindBy(id ="in.okcredit.merchant:id/tvTitle")
	public static WebElement AddressHeaderinMap;
	
	@FindBy(xpath ="//android.widget.ImageView[@content-desc='My Location']")
	public static WebElement MyLocation;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_image")
	public static WebElement MerchantImageeinShare;
	
	@FindBy(id ="in.okcredit.merchant:id/profile_name")
	public static WebElement MerchantNameinShare;
	
	@FindBy(id ="in.okcredit.merchant:id/address")
	public static WebElement MerchantAddressinShare;
	
	@FindBy(id ="in.okcredit.merchant:id/email")
	public static WebElement MerchantEmailinShare;
	
	@FindBy(id ="in.okcredit.merchant:id/send")
	public static WebElement Send;
	
	@FindBy(id ="in.okcredit.merchant:id/phone_number")
	public static WebElement MerchantNumberinShare;
	
	@FindBy(id ="in.okcredit.merchant:id/tvErrorMessage")
	public static WebElement MerchantEmailError;
}
