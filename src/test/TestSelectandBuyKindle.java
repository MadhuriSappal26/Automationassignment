package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import amazonpackage.BrowserFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.SelectandBuyKindle;

@Feature("SelectandBuyProduct Tests")
public class TestSelectandBuyKindle extends BrowserFactory {
	WebDriver driver;
	
	SelectandBuyKindle kindleObj;                 // Create the object of object repository class
	
   @BeforeClass
	public void setUp()
	{
		driver=getDriver();
	}
	 
 @Test(priority=0,description="Validate Kindle option from menu and submenu ")
 @Description("Validate Kindle option from menu and submenu")
 @Severity(SeverityLevel.CRITICAL)                                                
  public void SelectKindle() throws InterruptedException {
	 kindleObj=new SelectandBuyKindle(driver);
	 kindleObj.clickHamburger();                           //Clicks Hamburger menu  
	  
    Thread.sleep(2000);
  
	  String kindleoption=kindleObj.selectKindleoption();
	Assert.assertTrue(kindleoption.contains("Kindle"));      //Verifies the Kindle option is displayed in main menu
	kindleObj.clickKindleOption();
	  Thread.sleep(2000);
	  
	 String innerKindleOption=kindleObj.selectKindle();
		Assert.assertTrue(innerKindleOption.contains("Kindle")); //Verifies the Kindle option is displayed in sub menu
		kindleObj.clickKindle();
 }
		
 @Test(priority=1,description="Validate User is able to Buy Kindle")
 @Description("Validate User is able to Buy Kindle")
 @Severity(SeverityLevel.NORMAL)
			public void BuyKindle() throws InterruptedException
			{
				
				 String buyKindleButton=kindleObj.strbuyKindle();
				 Assert.assertEquals(buyKindleButton,"Buy Now");             //Verifies that Buy Now button is displayed 
				 kindleObj.buyKindle();                                      //Clicks the Buy Now button
			}
			
 @Test(priority=2,description="Validate User have asked to enter email or Mobile no")
 @Description("Validate User have asked to enter email or Mobile no")
 @Severity(SeverityLevel.NORMAL)
 public void verify_EmailOrMob() {
	 String strEmailOrMob=kindleObj.verifyEmailOrMobno();
	 Assert.assertTrue(strEmailOrMob.contains("E-mail address or mobile phone number"));  // verifies that user is asked for email address or mobile number
	 	
 }
 
}
