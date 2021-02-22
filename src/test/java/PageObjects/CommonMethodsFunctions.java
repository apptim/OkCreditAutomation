package PageObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.mongodb.client.model.geojson.Point;

import Driver.desiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * Wait and Verification Conditions.
 * 
 * @author Sivasankaramalan Gunasekarasivam
 * 
 */

public class CommonMethodsFunctions extends desiredCapabilities{
	
	private Dimension screenSize;
	
	private static final AndroidDriver DRIVER = null;
	
	/**
	 * 
	 * @param count
	 * @return
	 */
	public String randomAlphaNumeric(int count) {
		final String token = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder();
		builder.append("Customer");
		while (count-- != 0) {
			int character = (int) (Math.random() * token.length());
			builder.append(token.charAt(character));
		}
		return builder.toString();
	}
	
	/**
	 * 
	 * @param count
	 * @return
	 */
	public String randomName(int count) {
		final String token = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * token.length());
			builder.append(token.charAt(character));
		}
		return builder.toString();
	}
	/**
	 * 
	 * @param count
	 * @return
	 */
	public String randomNumber(int count) {
		final String token = "6789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * token.length());
			builder.append(token.charAt(character));
		}
		return builder.toString();
	}
	
	  
	public int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
	
	/**
	 * 
	 * @param text
	 * @param driver
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public void scrollToText(String text, AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
	    	 MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator) driver)
					    .findElementByAndroidUIAutomator("new UiScrollable("
					        + "new UiSelector().scrollable(true)).scrollIntoView("                      
					        + "new UiSelector().textContains(\""+text+"\"));");
	}
	
	/**
	 * 
	 * @param text
	 * @param driver
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public void scrollToTextWithClick(String text, AppiumDriver<MobileElement> driver)
			throws MalformedURLException, InterruptedException {
	    	 MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator) driver)
					    .findElementByAndroidUIAutomator("new UiScrollable("
					        + "new UiSelector().scrollable(true)).scrollIntoView("                      
					        + "new UiSelector().textContains(\""+text+"\"));");
			  el.click();
	}
	
	@SuppressWarnings("rawtypes")
	public static void topBottomScroll(AppiumDriver<MobileElement> driver, double startYprc, double endYprc) {
		
	    System.out.println("Scroll Top to bottom...");
		Dimension size = driver.manage().window().getSize();
	    int startX = size.width / 2;
	    int startY = (int) (size.height * startYprc);
	    int endY = (int) (size.height * endYprc);
	    
	    System.out.println("Scroll: "+startX+", "+startY+", "+endY+" and Size: "+size);
	    new TouchAction(driver).press(PointOption.point(startX, startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(startX, endY))
		.release().perform();
	   	System.out.println("Page Scrolled...");
	   	
	}
	
    /**
     * 
     * @param element
     * @param driver
     * @throws InterruptedException
     */
	public void clickAction(WebElement element, AppiumDriver<MobileElement> driver) throws InterruptedException {
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
        builder.moveToElement(element).click();
        builder.perform();
	}
	
	public int GetCurrentDate() {
		
		LocalDate now = LocalDate.now();
//	    System.out.println(now.getDayOfMonth());
	    int date = now.getDayOfMonth();
		return date;
	}
	public String runCommand(String command) throws InterruptedException, IOException {
		
		Process p = Runtime.getRuntime().exec(command);
		// get std output
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		String allLine = "";
		int i = 1;
		while ((line = r.readLine()) != null) {
		allLine = allLine + "" + line + "\n";
		if(line.contains("Console LogLevel: debug") && line.contains("Complete")) {
		break;
		}
		i++;
		}
		return allLine;
		}
	/*
	 * Swipe right to left
	 */
	public static void swipeHorizontal(AppiumDriver<MobileElement> driver2, double startPercentage,
			double finalPercentage, double anchorPercentage) {

		System.out.println("Call swipe left...");
		Dimension size = driver2.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * finalPercentage);

		System.out.println("Swipe: " + anchor + ", " + startPoint + ", " + endPoint + " and Size: " + size);
		// new TouchAction(driver).press(950, 700).waitAction().moveTo(100,
		// 700).release().perform();
		System.out.println("Element Swiped...");
	}
	
	public static void pulltorefresh(String element1 , String element2) {

	}
	public void leftRightSwipe(int timeduration) {
		 
		Dimension size = driver.manage().window().getSize();
        System.out.println(size.height+"height");
        System.out.println(size.width+"width");
         System.out.println(size);
         int startPoint = (int) (size.width * 0.99);
         int endPoint = (int) (size.width * 0.15);
         int ScreenPlace =(int) (size.height*0.40);          
         int y=(int)size.height*20;

        TouchAction ts = new TouchAction(driver);
        //for(int i=0;i<=3;i++) {
        ts.press(PointOption.point(startPoint,ScreenPlace ))
       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
       .moveTo(PointOption.point(endPoint,ScreenPlace )).release().perform();
		  
	}
	
	public void showNotifications() {
	    manageNotifications(true);
	}

	public void hideNotifications() {
	    manageNotifications(false);
	}

	private void manageNotifications(Boolean show) {
		
		screenSize = driver.manage().window().getSize();
		
	    int yMargin = 5;
	    int xMid = screenSize.width / 2;
	    
	    PointOption top = PointOption.point(xMid, yMargin);
	    PointOption bottom = PointOption.point(xMid, screenSize.height - yMargin);

	    TouchAction action = new TouchAction(driver);
	    if (show) {
	        action.press(top);
	    } else {
	        action.press(bottom);
	    }
	    action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
	    if (show) {
	        action.moveTo(bottom);
	    } else {
	        action.moveTo(top);
	    }
	    action.perform();
	} 
}
