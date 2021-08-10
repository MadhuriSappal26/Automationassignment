package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SelectandBuyKindle {
	
	//All WebElements are identified by @FindBy annotation
	
	WebDriver driver;
	@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-main']/div[1]/a[1]/i[1]")   
	WebElement hamburger;
	@FindBy(xpath="//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[1]/li[9]/a[1]")
	WebElement selectKindleOption;
	@FindBy(xpath="//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[4]/li[3]/a[1]")
	WebElement selectInnerKindle;
	@FindBy(xpath="//input[@id='buy-now-button']")
	WebElement buyKindle;
	@FindBy(xpath="//span[@id='submit.buy-now-announce']")
	WebElement buyNowButton;
	@FindBy(xpath="//body/div[@id='a-page']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]")
	WebElement emailidOrMobno;
	
	public SelectandBuyKindle(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickHamburger() 
	{
		hamburger.click();
	}
	public String selectKindleoption()
	{
		
		return selectKindleOption.getText();
		
	}
	public void clickKindleOption()
	{
		
		selectKindleOption.click();
	}
	public String selectKindle()
	{
		
		return selectInnerKindle.getText();
		
	}
  public void clickKindle()
  {
	  selectInnerKindle.click();
  }
  
  public String strbuyKindle()
  {
	  return buyNowButton.getText();
  }
  
  public void buyKindle()
  {
	buyKindle.click();  
  }
  public void setEmailidOrMobNo(String strEmailIdOrMobno)
  {
	  
	emailidOrMobno.sendKeys(strEmailIdOrMobno);
  }
  public String verifyEmailOrMobno(){

      //Fill user name

      return emailidOrMobno.getText();

    
      

  }

}
