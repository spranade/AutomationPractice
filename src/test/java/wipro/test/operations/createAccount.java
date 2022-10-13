package wipro.test.operations;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import wipro.test.config.Startup;
import wipro.test.library.Helper;
import wipro.test.library.Utility;
import wipro.test.results.HTMLReportGenerator;

public class createAccount {

	//static String screenshot_path;
	final static Logger logger=Logger.getLogger(createAccount.class);
	String screenshot_path;
	Utility U = new Utility();
	
	public createAccount(WebDriver wd) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(wd, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//h3[@class='page-subheading']")
	WebElement pageheading;
	public String verifypageheading()
	{
		
		U.isElementPresent(pageheading,30);
		String h = pageheading.getText().trim();
		try{
		Helper.highLightElement(Startup.wd,pageheading);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifypageheading");
//		Assert.assertEquals(pageheading.getText().toString(), "SUMMER DRESSES");
				
		System.out.println("page heading: " + h + "_");
		Assert.assertTrue("-Heading is correct-", h.equalsIgnoreCase("CREATE AN ACCOUNT"));
		
		
			logger.info("page heading is verified successfully:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - verify page heading","page heading should be correct",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("page heading is wrong");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - verify page heading","page heading should be correct",""+screenshot_path+"");
			
			}
		return h;	
		
	}

	@FindBy(how=How.XPATH,using="//input[@id='id_gender1']")
	WebElement gender1;
	public void selectgender1()
	{
		try{
		U.isElementPresent(gender1,30);
		Helper.highLightElement(Startup.wd,gender1);
		gender1.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectgender1");
		
			logger.info("gender1 is selected:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Select Gender1 ","Gender1 should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("gender1 is not selected");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Select Gender1 ","Gender1 should get selected",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='id_gender2']")
	WebElement gender2;
	public void selectgender2()
	{
		try{
		U.isElementPresent(gender2,30);
		Helper.highLightElement(Startup.wd,gender2);
		gender2.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectgender2");
		
			logger.info("gender2 is selected:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Select Gender2 ","Gender2 should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("gender2 is not selected");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Select Gender2 ","Gender2 should get selected",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='customer_firstname']")
	WebElement customer_firstname;
	public void enter_customer_firstname(String cust_firstname)
	{
		try{
		U.isElementPresent(customer_firstname,30);
		Helper.highLightElement(Startup.wd,customer_firstname);
		customer_firstname.sendKeys(cust_firstname);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "customer_firstname");
		
			logger.info("user entered customer_firstname :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter Customer first name ","Customer first name should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter customer_firstname ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter Customer first name ","Customer first name should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='customer_lastname']")
	WebElement customer_lastname;
	public void enter_customer_lastname(String cust_lastname)
	{
		try{
		U.isElementPresent(customer_lastname,30);
		Helper.highLightElement(Startup.wd,customer_lastname);
		customer_lastname.sendKeys(cust_lastname);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "customer_lastname");
		
			logger.info("user entered customer_lastname :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter Customer last name ","Customer last name should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter customer_lastname ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter Customer last name ","Customer last name should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='passwd']")
	WebElement password;
	public void enterpassword(String pwd)
	{
		try{
		U.isElementPresent(password,30);
		Helper.highLightElement(Startup.wd,password);
		password.sendKeys(pwd);
		//password.sendKeys(Keys.TAB);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterpassword");
		
			logger.info("user entered password :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter password ","Password should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter password ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter password ","Password should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='uniform-days']/*[2]")
	WebElement unidays;
	
	
	public void selectday(int d) throws Exception
	{
		try{
		U.isElementPresent(unidays,30);
		Helper.highLightElement(Startup.wd,unidays);
//		Actions action = new Actions(Startup.wd);
//		action.moveToElement(days).perform();
		unidays.click();
		Thread.sleep(1000);
		for(int i=0;i<=d;i++)
		{
		unidays.sendKeys(Keys.DOWN);
		}
		unidays.sendKeys(Keys.RETURN);
//		Select sday = new Select(unidays);
//		System.out.println(sday.getFirstSelectedOption());
//		sday.selectByVisibleText(d);
//		sday.selectByValue(d);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectday");
		
			logger.info("user selected days :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - select days ","days should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to select days ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - select days ","days should get selected",""+screenshot_path+"");
			
			}

	}
	
	@FindBy(how=How.XPATH,using="//select[@id='months']")
	WebElement unimonths;
	public void selectmonth(int m) throws Exception
	{
		try{
		U.isElementPresent(unimonths,30);
		Helper.highLightElement(Startup.wd,unimonths);
		unimonths.click();
		Thread.sleep(1000);
		for(int i=0;i<=m;i++)
		{
		unimonths.sendKeys(Keys.DOWN);
		}
		unimonths.sendKeys(Keys.RETURN);
		
//		Select smonth = new Select(unimonths);
//		smonth.selectByVisibleText(m);
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectmonth");
		
			logger.info("user selected month :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - select month ","month should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to select month ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - select month ","month should get selected",""+screenshot_path+"");
			
			}
	}

	@FindBy(how=How.XPATH,using="//select[@id='years']")
	WebElement uniyears;
	public void selectyear(String y) throws Exception
	{
		try{
		U.isElementPresent(uniyears,30);
		Helper.highLightElement(Startup.wd,uniyears);
		uniyears.click();
		Thread.sleep(1000);
		uniyears.sendKeys(Keys.DOWN);
		uniyears.sendKeys(Keys.RETURN);
//		Select syear = new Select(uniyears);
//		syear.selectByVisibleText(y);
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectyear");
		
			logger.info("user selected year :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - select year ","year should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to select year ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - select year ","year should get selected",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='newsletter']")
	WebElement newsletter;
	public void selectnewsletter()
	{
		try{
		U.isElementPresent(newsletter,30);
		Helper.highLightElement(Startup.wd,newsletter);
		newsletter.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectnewsletter");
		
			logger.info("user selected newletter option :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - select news letter option ","news letter option should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to select newsletter option ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - select news letter option ","news letter option should get selected",""+screenshot_path+"");
			
			}
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='optin']")
	WebElement sploffer;
	public void selectsploffer()
	{
		try{
		U.isElementPresent(sploffer,30);
		Helper.highLightElement(Startup.wd,sploffer);
		sploffer.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectsploffer");
		
			logger.info("user selected special offer option:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - select special offer option ","special offer option should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to select special offer option ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - select special offer option ","special offer option should get selected",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='firstname']")
	WebElement firstname;
	public void enterfirstname(String fname)
	{
		try{
		U.isElementPresent(firstname,30);
		Helper.highLightElement(Startup.wd,firstname);
		firstname.clear();
		firstname.sendKeys(fname);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterfirstname");
		
			logger.info("user entered first name :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter  first name "," first name should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter first name ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter  first name "," first name should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='lastname']")
	WebElement lastname;
	public void enterlastname(String lname)
	{
		try{
		U.isElementPresent(lastname,30);
		Helper.highLightElement(Startup.wd,lastname);
		lastname.clear();
		lastname.sendKeys(lname);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterlastname");
		
			logger.info("user entered last name :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter  last name "," last name should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter last name ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter  last name "," last name should get entered",""+screenshot_path+"");
			
			}
	}

	@FindBy(how=How.XPATH,using="//input[@id='company']")
	WebElement company;
	public void entercompanyname(String cname)
	{
		try{
		U.isElementPresent(company,30);
		Helper.highLightElement(Startup.wd,company);
		company.sendKeys(cname);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "entercompanyname");
		
			logger.info("user entered company name :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter  company name "," company name should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter company name ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter  company name "," company name should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='address1']")
	WebElement address1;
	public void enteraddress1(String addr1)
	{
		try{
		U.isElementPresent(address1,30);
		Helper.highLightElement(Startup.wd,address1);
		address1.sendKeys(addr1);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enteraddress1");
		
			logger.info("user entered address1 :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter address1 "," address1 should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter address1 ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter address1 "," address1 should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='address2']")
	WebElement address2;
	public void enteraddress2(String addr2)
	{
		try{
		U.isElementPresent(address2,30);
		Helper.highLightElement(Startup.wd,address2);
		address2.sendKeys(addr2);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enteraddress2");
		
			logger.info("user entered address2 :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter address2 "," address2 should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter address2 ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter address2 "," address2 should get entered",""+screenshot_path+"");
			
			}
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='city']")
	WebElement city;
	public void entercity(String cty)
	{
		try{
		U.isElementPresent(city,30);
		Helper.highLightElement(Startup.wd,city);
		city.sendKeys(cty);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "entercity");
		
			logger.info("user entered city :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter city "," city should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter city ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter city "," city should get entered",""+screenshot_path+"");
			
			}
	}

	@FindBy(how=How.XPATH,using="//select[@id='id_state']")
	WebElement state;
	public void selectstate(String st)
	{
		try{
		U.isElementPresent(state,30);
		Helper.highLightElement(Startup.wd,state);
		Select selstate = new Select(state);
		selstate.selectByVisibleText(st);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectstate");
		
			logger.info("user selected state :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Select state "," state should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to select state ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Select state "," state should get selected",""+screenshot_path+"");
			
			}
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='postcode']")
	WebElement postcode;
	public void enterpostcode(String post)
	{
		try{
		U.isElementPresent(postcode,30);
		Helper.highLightElement(Startup.wd,postcode);
		postcode.sendKeys(post);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterpostcode");
		
			logger.info("user entered post code :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter post code "," post code should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter post code ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter post code "," post code should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//select[@id='id_country']")
	WebElement id_country;
	public void selectcountry(String sc)
	{
		try{
		U.isElementPresent(id_country,30);
		Helper.highLightElement(Startup.wd,id_country);
		Select selcountry = new Select(id_country);
		selcountry.selectByVisibleText(sc);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectcountry");
	
			logger.info("user selected country :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Select country "," country should get selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to select country ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Select country "," country should get selected",""+screenshot_path+"");
			
			}
	}
	
	
	@FindBy(how=How.XPATH,using="//textarea[@id='other']")
	WebElement AdditionInfo;
	public void enterAdditionInfo(String addinfo)
	{
		try{
		U.isElementPresent(AdditionInfo,30);
		Helper.highLightElement(Startup.wd,AdditionInfo);
		AdditionInfo.sendKeys(addinfo);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterAdditionInfo");
		
			logger.info("user entered additional info :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter additional info "," Additional info should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter additional info ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter additional info "," Additional info should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='phone']")
	WebElement phone;
	public void enterphone(String phn)
	{
		try{
		U.isElementPresent(phone,30);
		Helper.highLightElement(Startup.wd,phone);
		phone.sendKeys(phn);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterphone");
		
			logger.info("user entered phone :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter phone "," phone should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter phone ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter phone "," phone should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='phone_mobile']")
	WebElement phone_mobile;
	public void entermobile(String mob)
	{
		try{
		U.isElementPresent(phone_mobile,30);
		Helper.highLightElement(Startup.wd,phone_mobile);
		phone_mobile.sendKeys(mob);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "entermobile");
		
			logger.info("user entered mobile :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter mobile "," mobile should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter mobile ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter mobile "," mobile should get entered",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='alias']")
	WebElement alias;
	public void enteralias(String als)
	{
		try{
		U.isElementPresent(alias,30);
		Helper.highLightElement(Startup.wd,alias);
		alias.clear();
		alias.sendKeys(als);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enteralias");
		
			logger.info("user entered alias :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Enter alias "," alias should get entered",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to enter alias ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Enter alis "," alias should get entered",""+screenshot_path+"");
			
			}
	}
	
	
	@FindBy(how=How.XPATH,using="//button[@id='submitAccount']")
	WebElement submitAccount;
	public void register()
	{
		try{
		U.isElementPresent(submitAccount,30);
		Helper.highLightElement(Startup.wd,submitAccount);
		submitAccount.click();
		System.out.println("User registered successfully");
		screenshot_path=Utility.captureScreenshot(Startup.wd, "register");
		
			logger.info("user clicked register button :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Click Register button "," Register button should get clicked and form should be submitted",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("user failed to click register button ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Click Register button "," Register button should get clicked and form should be submitted",""+screenshot_path+"");
			
			}
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/div[@class='alert alert-danger']/p")
	WebElement errors;
	public boolean errormessage()
	{
		U.isElementPresent(errors,30);
		Helper.highLightElement(Startup.wd,errors);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "errormessage");
		String err = errors.getText().trim();
		System.out.println(err);
		
		if(err.contains("There are"))
			return true;
		else
			return false;
	}
	
	@FindBy(how=How.XPATH,using=".//div[@id='center_column']/h1[@class='page-heading']")
	WebElement myacctitle;
	public String myaccounttitle()
	{
		
		U.isElementPresent(myacctitle,30);
		String t = myacctitle.getText().trim();
		try{
		Helper.highLightElement(Startup.wd,myacctitle);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "myaccounttitle");
			
		System.out.println("page heading: " + t + "_");
		Assert.assertTrue("-title is correct-", t.equalsIgnoreCase("MY ACCOUNT"));
		
			logger.info("my account title is verified :");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Registration should be done successfully "," User is registered successfully",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("my account title is not verified ");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Registration should be done successfully "," User is not registered successfully",""+screenshot_path+"");
			
			}
		return t;	
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='center_column']/p[@class='info-account']")
	WebElement infoaccount;
	public boolean successmsg()
	{
		U.isElementPresent(infoaccount,30);
		Helper.highLightElement(Startup.wd,infoaccount);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "successmsg");
		String succ = infoaccount.getText().trim();
		System.out.println(succ);
		if(succ.contains("Welcome to your account"))
			return true;
		else
			return false;
	}
}
