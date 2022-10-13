package wipro.test.operations;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wipro.test.config.Startup;
import wipro.test.library.Helper;
import wipro.test.library.Utility;
import wipro.test.results.HTMLReportGenerator;

public class Registration {
	final static Logger logger=Logger.getLogger(Registration.class);
	String screenshot_path;
	Utility U = new Utility();
	
	public Registration(WebDriver wd) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='email_create']")
	WebElement email;
	public void enterEmailId(String emailid)
	{
		try{
		U.isElementPresent(email,30);
		Helper.highLightElement(Startup.wd,email);
		email.sendKeys(emailid);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "email");
		
			logger.info("User entered email Id for registration:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter email Id for registration "," email Id should get entered for registration",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("User entered invalid email id");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter email Id for registration "," email Id should get entered for registration",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//button[@id='SubmitCreate']")
	WebElement submitButton;
	public void clickSubmitButton()
	{
		try{
		U.isElementPresent(submitButton,30);
		Helper.highLightElement(Startup.wd,submitButton);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "submitButton");
		submitButton.click();
		
			logger.info("User clicked submit button:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Click Submit button ","Submit button should get clicked",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("User failed to click submit button");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Click Submit button ","Submit button should get clicked",""+screenshot_path+"");
			
			}
	}
	
	public void verifytitle()
	{
		try{
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Rtitle");
		Assert.assertEquals(Startup.wd.getTitle(), "Login - My Store");
		
			logger.info("title verified successfully:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Verify page title ","Page title should be correct",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("title is wrong");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Verify page title ","Page title should be correct",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='create_account_error']/ol/li")
	WebElement errors;
	
	
	public boolean errormessage()
	{
		U.isElementPresent(errors,30);
		Helper.highLightElement(Startup.wd,errors);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "error");
		String err = errors.getText().trim();
		System.out.println(err);
		if(err.contains("Invalid email address"))
			return true;
		else
			return false;
	}
	
}
