package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class DenySupplier_OR extends desiredCapabilities{
	
	@FindBy(id ="in.okcredit.merchant:id/comment_account_text")
	public static WebElement CommonAccount;
	
	@FindBy(id ="in.okcredit.merchant:id/supplier_account_text")
	public static WebElement SupplierCommonAccountText;
	
	@FindBy(id ="in.okcredit.merchant:id/supplier_account_text")
	public static WebElement CommonAccountSupplier;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Profile']")
	public static WebElement CustomerProfilePage;
	
	@FindBy(id ="in.okcredit.merchant:id/permission_switch")
	public static WebElement OnDenyPermission;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Permission to add transaction is disabled by you.']")
	public static WebElement PermissionDisable;
	
	@FindBy(xpath ="//android.widget.TextView[@text='SUPPLIER']")
	public static WebElement SupplierTab;
	
	@FindBy(xpath ="//android.widget.TextView[@text='CUSTOMER']")
	public static WebElement CustomerTab;
	
	@FindBy(id ="in.okcredit.merchant:id/name_text_view")
	public static WebElement  FirstSupplier;
	
	@FindBy(xpath ="//android.widget.TextView[contains(@text,'Permission to add transaction')]")
	public static WebElement  DenySupplier;
	
	
	
	
	
	

}
