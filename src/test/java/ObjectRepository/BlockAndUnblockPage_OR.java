package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class BlockAndUnblockPage_OR extends desiredCapabilities {
	
	@FindBy(id ="in.okcredit.merchant:id/block_text")
	public static WebElement BlockCustomer;

	@FindBy(id ="in.okcredit.merchant:id/accept")
	public static WebElement BlockAccept;
	
	@FindBy(xpath ="//android.widget.TextView[@text='UNBLOCK']")
	public static WebElement UnBlocking;
	
	@FindBy(xpath ="//android.widget.TextView[@text='CALL SUPPLIER']")
	public static WebElement CallSupplier;
	
	
	@FindBy(xpath ="//android.widget.TextView[@text='CALL CUSTOMER']")
	public static WebElement CallCustomer; 
	
	@FindBy(xpath ="//android.widget.TextView[@text='Unblock']")
	public static WebElement UnBlock;
	

}
