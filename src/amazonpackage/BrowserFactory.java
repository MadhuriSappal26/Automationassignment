package amazonpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.SelectandBuyKindle;
import report.AllureProperties;



public class BrowserFactory {
	public WebDriver driver;
	public WebDriver getDriver()
	{
		return driver;
	}
	
	
  @BeforeTest
  @Parameters({"browser","url"})
  public void beforeTest(String browser,String URL) throws Exception {
	  if(browser.equalsIgnoreCase("firefox")) {
			 
		//Initializing the firefox driver (Gecko)
		  System.setProperty("webdriver.gecko.driver","E:\\workspace\\Amazon\\resources\\geckodriver-v0.29.1-win32\\geckodriver.exe");
			  driver = new FirefoxDriver();	
			  driver.manage().window().maximize();
			  driver.get(URL);
			  //SelectandBuyKindlepage=new SelectandBuyKindlepage(driver);

		  }else if (browser.equalsIgnoreCase("chrome")) { 

			  //Initialize the chrome driver
			  System.setProperty("webdriver.chrome.driver","E:\\workspace\\Amazon\\resources\\chromedriver_win32\\chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.get(URL);
			  //SelectandBuyKind
		  }
		  else if(browser.equalsIgnoreCase("Edge")){
				//set path to Edge.exe
				System.setProperty("webdriver.edge.driver","E:\\workspace\\Amazon\\resources\\edgedriver_win32\\msedgedriver.exe");
				//create Edge instance
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				  driver.get(URL);
				  //SelectandBuyKind
			}
		  else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
  
  @AfterClass
  public void closeBrowser()
  {
	  driver.quit();          //closes the browser window
  }
  
 
	
}


	
	
