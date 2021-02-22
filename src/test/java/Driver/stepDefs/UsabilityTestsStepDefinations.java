package Driver.stepDefs;
//package Driver.stepDefs;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.applitools.eyes.BatchInfo;
//import com.applitools.eyes.StdoutLogHandler;
//import com.applitools.eyes.appium.Eyes;
//
//import Driver.DesiredCapability;
//import ObjectRepository.LandingPage_OR;
//import cucumber.api.java.en.And;
//
//public class UsabilityTestsStepDefinations extends DesiredCapability {
//
//	WebDriverWait wait = new WebDriverWait(driver, 15);
//	BatchInfo batchInfo = new BatchInfo("TheApp OkCredit Visual Validations");   
//	Eyes eyes = new Eyes();
//	
//	
// 
//	@And("^Launch Applitools$")
//	public void verify_logo() throws InterruptedException {
//		
//		eyes.setApiKey("xg5Yu0103eEAcDRRyhR2o4VBvkzLQne2NBN11KQb8t107lk110");
//		eyes.setSendDom(true);
//		eyes.setForceFullPageScreenshot(true);
//		eyes.setLogHandler(new StdoutLogHandler());
//
//	}
//	@And("^Verify \"([^\"]*)\" components$")
//	public void verify_components(String Components) throws InterruptedException {
//		if(Components.equals("Welcome Page")) {
//			
//			try
//			{
//			eyes.setBatch(batchInfo);
//			batchInfo.setId("100");
//			Thread.sleep(2000);
//			
//	        eyes.open(driver, "TheApp OkCredit", "Verifying Welcome Page Components");
//	        eyes.checkWindow("Welcome");
//	        eyes.close();
//	        }
//			finally
//			{
//	        eyes.abortIfNotClosed();
//			}
//		}
//		else if(Components.equals("Verify Mobile")) {
//			
//			try
//			{
//			eyes.setBatch(batchInfo);
//			batchInfo.setId("100");
//			Thread.sleep(2000);
//			
//			
//	        eyes.open(driver, "TheApp OkCredit", "Verifying Mobile Page Components");
//	        eyes.checkWindow("Verify Mobile");
//	        
//	        Thread.sleep(3000);
//	        eyes.checkWindow("Verify Mobile 2 ");
//	        
//	        Thread.sleep(3000);
//	        eyes.checkWindow("Verify Mobile 3 ");
//	        
//	        Thread.sleep(3000);
//	        eyes.checkWindow("Verify Mobile 4 ");
//	        
//	        eyes.close();
//	        
//	        }
//			finally
//			{
//	        eyes.abortIfNotClosed();
//			}
//		}
//	}
//}
//
