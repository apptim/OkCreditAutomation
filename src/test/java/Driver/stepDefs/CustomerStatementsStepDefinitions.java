package Driver.stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Driver.desiredCapabilities;
import ObjectRepository.TransactionPage_OR;
import PageObjects.CommonMethodsFunctions;
import Utility.Log;
import cucumber.api.java.en.And;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class CustomerStatementsStepDefinitions extends desiredCapabilities {
	
	CommonMethodsFunctions CF = new CommonMethodsFunctions();
	
	@And("^Verify \"([^\"]*)\" for \"([^\"]*)\"$")
	public void verify_for_options(String Option1 , String Option2) {
		if(Option1.equals("Total Credits") && Option2.equals("Selected Date Range")) {
			
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Give));
			String totalCredit =TransactionPage_OR.Give.getText().substring(6,7);
			Log.info("No of Credits Offered in Selected Date duration : " +totalCredit );
		}
		else if(Option1.equals("Total Payments") && Option2.equals("Selected Date Range")) {
			
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Take));
			String totalPayment =TransactionPage_OR.Take.getText().substring(6,7);
			Log.info("No of Payments Got in Selected Date duration : " +totalPayment );
		}
		else if(Option1.equals("Latest Transaction Date") && Option2.equals("Selected Date Range")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.Date));
			Log.info("Latest Transaction Date : "+ TransactionPage_OR.transaction_date.getText());
			Log.info("Latest Transaction Month : "+ TransactionPage_OR.transaction_month.getText());
			}
			catch(Exception E) {
				Log.info("No Transaction found for Selected Date Range");
			}
		}
		else if(Option1.equals("Latest Transaction Amount") && Option2.equals("Selected Date Range")) {
			try {
			wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.payment));
			Log.info("Latest Payment Transaction Amount : "+ TransactionPage_OR.payment.getText());
			}
			catch(Exception E) {
				Log.info("No Payment Transaction found for Selected Date Range, May be Transaction is added as Credit");
			}
			Log.info("Checking in Credit for Latest transaction");
			try {
				wait.until(ExpectedConditions.elementToBeClickable(TransactionPage_OR.credit));
				Log.info("Latest Payment Transaction Amount : "+ TransactionPage_OR.credit.getText());
			}
			catch(Exception E) {
				Log.info("No Credit Transaction found for Selected Date Range");
			}
		}
	}
	@SuppressWarnings("rawtypes")
	@And("^Swipe Right to \"([^\"]*)\"$")
	public void swipe_to_right(String filters) {
		
		if (filters.equals("Last 0 Balance")) {
			
			WebElement element1 = driver.findElement(By.id("in.okcredit.merchant:id/last_zero_balance"));
			WebElement element2 = driver.findElement(By.id("in.okcredit.merchant:id/this_month"));

			TouchAction swipe = new TouchAction(driver);

			swipe.press(ElementOption.element(element1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
					.moveTo(ElementOption.element(element2)).release().perform();
		} 
		else if (filters.equals("Last 6 Months")) {
			
			WebElement element1 = driver.findElement(By.id("in.okcredit.merchant:id/last_three_month"));
			WebElement element2 = driver.findElement(By.id("in.okcredit.merchant:id/last_month"));

			TouchAction swipe = new TouchAction(driver);

			swipe.press(ElementOption.element(element1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
					.moveTo(ElementOption.element(element2)).release().perform();
		}
		else if (filters.equals("Overall")) {
			
			WebElement element1 = driver.findElement(By.id("in.okcredit.merchant:id/last_six_month"));
			WebElement element2 = driver.findElement(By.id("in.okcredit.merchant:id/last_three_month"));

			TouchAction swipe = new TouchAction(driver);

			swipe.press(ElementOption.element(element1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
					.moveTo(ElementOption.element(element2)).release().perform();
		}
	}

}
