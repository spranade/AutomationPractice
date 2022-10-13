package wipro.test.operations;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;


import wipro.test.library.Helper;
import wipro.test.library.Utility;
import wipro.test.results.HTMLReportGenerator;
import wipro.test.config.Startup;

public class homepage {

	final static Logger logger=Logger.getLogger(homepage.class);
	String screenshot_path;
	Utility U = new Utility();
	
	public homepage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='block_top_menu']/ul/li[2]/a")
	WebElement DressesLink;
	public void clickDressesLink(){
		try{
		U.isElementPresent(DressesLink,30);
		Helper.highLightElement(Startup.wd,DressesLink);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickDressesLink");
		Actions action = new Actions(Startup.wd);
		action.moveToElement(DressesLink).perform();
		//DressesLink.click();
		
			logger.info("User clicked Dresses link:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Click Dresses link "," Dresses link should get clicked",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("User failed to click Dresses Link");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Click Dresses link "," Dresses link should get clicked",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")
	WebElement SummerDressesLink;

	public void clickSummerDressesLink() throws Exception{
		try{
		U.isElementPresent(SummerDressesLink,30);
		Helper.highLightElement(Startup.wd,SummerDressesLink);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickSummerDressesLink");
		Actions action = new Actions(Startup.wd);
		action.moveToElement(DressesLink).perform();
		Thread.sleep(2000);
		SummerDressesLink.click();
		
			logger.info("User clicked Summer Dresses link:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Click Summer Dresses link ","Summer Dresses link should get clicked",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("User failed to click Summer Dresses Link");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Click Summer Dresses link ","Summer Dresses link should get clicked",""+screenshot_path+"");
			
			}
	}
	
	
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text() , 'Sign in')]")
	WebElement SignIn;
	public void clickSignIn(){
		try{
		U.isElementPresent(SignIn,30);
		Helper.highLightElement(Startup.wd,SignIn);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickSignIn");
		SignIn.click();
		
			logger.info("User clicked Sign In menu:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Click Sign In ","Sign In should get clicked",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("User failed to Sign In menu");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Click Sign In ","Sign In should get clicked",""+screenshot_path+"");
			
			}
	}
	
	
	public void verifytitle()
	{
		try{
		screenshot_path=Utility.captureScreenshot(Startup.wd, "title");
		Assert.assertEquals(Startup.wd.getTitle(), "My Store");
	
			logger.info("Title is verified successfully:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Verify page title ","Page title should be correct",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("Title is not correct");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Verify page title ","Page title should be correct",""+screenshot_path+"");
			
			}
	}
	
}
