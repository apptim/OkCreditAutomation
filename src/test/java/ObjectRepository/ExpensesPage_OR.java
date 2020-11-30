package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Driver.desiredCapabilities;

public class ExpensesPage_OR extends desiredCapabilities{
	
	
	@FindBy(id ="in.okcredit.merchant:id/add_expense_card")
	public static WebElement Expenses_Card;
	
	@FindBy(id ="in.okcredit.merchant:id/expense_text")
	public static WebElement Expenses_Amount;
	
	@FindBy(id ="in.okcredit.merchant:id/expense_type_input")
	public static WebElement Expenses_Type;
	
	@FindBy(id ="in.okcredit.merchant:id/submit_expense")
	public static WebElement Expenses_Button;
	
	@FindBy(id ="in.okcredit.merchant:id/last_seven_days")
	public static WebElement Expenses_Seven_Days;
	
	@FindBy(id ="in.okcredit.merchant:id/this_month")
	public static WebElement Expenses_This_Month;
	
	@FindBy(id ="in.okcredit.merchant:id/last_month")
	public static WebElement Expenses_Last_Month;
	
	@FindBy(id ="in.okcredit.merchant:id/all")
	public static WebElement Expenses_All;
	
	@FindBy(id ="in.okcredit.merchant:id/type")
	public static WebElement Expenses_Type_Verify;
	
	@FindBy(id ="in.okcredit.merchant:id/amount")
	public static WebElement Expenses_Amount_Verify;
	
	
	

}
