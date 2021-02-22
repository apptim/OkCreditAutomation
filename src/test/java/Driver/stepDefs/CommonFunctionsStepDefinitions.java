package Driver.stepDefs;

import java.net.MalformedURLException;

import org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Driver.desiredCapabilities;
import ObjectRepository.CustomerPage_OR;
import ObjectRepository.HomePage_OR;
import ObjectRepository.LinkPay_OR;
import ObjectRepository.TransactionPage_OR;
import PageObjects.CommonMethodsFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;

public class CommonFunctionsStepDefinitions  extends desiredCapabilities{
	
	CommonMethodsFunctions CF = new CommonMethodsFunctions();

	@And("^Scroll Up to \"([^\"]*)\"$")
	public void scroll(String direction) throws MalformedURLException, InterruptedException {
			CF.scrollToText(direction, driver);
	}
	@Then("^Verify the \"([^\"]*)\" Button$")
	public void verify_button(String Button) {
		if(Button.equals("Filter")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.Filter));
			Assert.assertTrue(HomePage_OR.Filter.isDisplayed());
			
		}
		else if(Button.equals("Sort")) {
			wait.until(ExpectedConditions.elementToBeClickable(HomePage_OR.SortIcon));
			Assert.assertTrue(HomePage_OR.SortIcon.isDisplayed());
			
		}
		else if(Button.equals("Report")) {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.ReportMenu));
			Assert.assertTrue(TransactionPage_OR.ReportMenu.isDisplayed());
			
		}
	}
	@And("^Hide keyboard$")
	public void hide_keyboard() {
		driver.hideKeyboard();
	}
	@And("^Verify Push Notification$")
	public void verify_push_notification(){
		
		CF.showNotifications();
	}
	@And("^User clicks on \"([^\"]*)\" Button$")
	public void user_clicks_button(String Button) {
		if(Button.equals("Chat")){
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.chat));
			Assert.assertTrue(CustomerPage_OR.chat.isDisplayed());
			CustomerPage_OR.chat.click();
		}
	}
	@And("^User chats with \"([^\"]*)\"$")
	public void user_chats(String option) {
		if(option.equals("Customer")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ChatInput));
			Assert.assertTrue(CustomerPage_OR.ChatInput.isDisplayed());
			CustomerPage_OR.ChatInput.sendKeys("Chatting with Customer");
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SendChat));
			Assert.assertTrue(CustomerPage_OR.SendChat.isDisplayed());
		}
		else if(option.equals("Supplier")) {
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.ChatInput));
			Assert.assertTrue(CustomerPage_OR.ChatInput.isDisplayed());
			CustomerPage_OR.ChatInput.sendKeys("Chatting with Customer");
			wait.until(ExpectedConditions.elementToBeClickable(CustomerPage_OR.SendChat));
			Assert.assertTrue(CustomerPage_OR.SendChat.isDisplayed());
		}
	}
	@And("^Verify \"([^\"]*)\" Option$")
	public void verify_options(String options) {
		 if(options.equals("Show QR")) {
			wait.until(ExpectedConditions.elementToBeClickable(LinkPay_OR.ShowQR));
			Assert.assertTrue(LinkPay_OR.ShowQR.isDisplayed());
		}
	}
}
