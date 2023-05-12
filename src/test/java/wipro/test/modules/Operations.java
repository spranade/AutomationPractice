package wipro.test.modules;
import java.net.InetAddress;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wipro.test.config.Startup;
import wipro.test.operations.LaunchApplication;
import wipro.test.operations.Registration;
import wipro.test.operations.SummerDresses;
import wipro.test.operations.createAccount;
import wipro.test.operations.homepage;


public class Operations {

	public static ExtentReports report=null;
	public static ExtentTest logger; 
	
	@When("^user opens the \"([^\"]*)\" browser$")
	public void user_opens_the_browser(String browser) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		report=new ExtentReports(System.getProperty("user.dir") + "\\report.html");
		report
			.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName())
	        .addSystemInfo("Environment", "QA")
	        .addSystemInfo("User Name", "Swanand Ranade");
		logger=report.startTest("Smoke Test", "Smoke Test");
		LaunchApplication app = new LaunchApplication();
		app.launchBrowser(browser, "E:\\selenium\\JARS\\chromedriver.exe");
		//HTMLReportGenerator.TestCaseStart("Smoke Test","Smoke Test");
		
	}

	@When("^user enter the url \"([^\"]*)\"$")
	public void user_enter_the_url(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LaunchApplication app = new LaunchApplication();
		app.launchApp(url);
	}

	@Given("^user is on the application home page$")
	public void user_is_on_the_application_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homepage hp = new homepage(Startup.wd);
		hp.verifytitle();
	}

	
	@When("^user clicks on Dresses link$")
	public void user_clicks_on_Dresses_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homepage hp = new homepage(Startup.wd);
		hp.clickDressesLink();
	}

	@When("^user clicks on Summer dresses link$")
	public void user_clicks_on_Summer_dresses_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homepage hp = new homepage(Startup.wd);
		hp.clickSummerDressesLink();
		SummerDresses sd = new SummerDresses(Startup.wd);
		sd.verifytitle();
	}

	
	@When("^user selects sort by \"([^\"]*)\" value$")
	public void user_selects_sort_by_value(String sortby) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		SummerDresses sd = new SummerDresses(Startup.wd);
		sd.SortBy(sortby);
	}

	@Then("^product grid gets loaded successfully$")
	public void product_grid_gets_loaded_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		SummerDresses sd = new SummerDresses(Startup.wd);
		//sd.verifypageheading();
		String heading=sd.verifypageheading();
		if(heading.equalsIgnoreCase("SUMMER DRESSES"))
		{
			System.out.println("Heading is correct : "+heading);
//			logger.info("Heading is correct : "+heading);
//			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Heading is correct: "+heading+"","Application should be on the Home Page after performing Login Operation ",""+screenshot_path+"");
		}
		else
		{
			System.out.println("Heading is not correct"+heading);
//			logger.error("Heading is not correct");
//			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Heading is not correct: "+heading+"","Application should be on the Home Page after performing Login Operation ",""+screenshot_path+"");
		}
	}

	@Then("^product grid is arranged properly by price value$")
	public void product_grid_is_arranged_properly_by_price_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		SummerDresses sd = new SummerDresses(Startup.wd);
		//sd.checkdollarcondition();
		if(sd.checkOldPriceOrder()==true)
		{
			System.out.println("Item Price order is correct : ");
		}
		if(sd.checkDiscountPriceOrder()==true)
		{
			System.out.println("Item Price order is correct : ");
		}
	}
	
	@When("^user clicks Sign in link$")
	public void user_clicks_Sign_in_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		homepage hp = new homepage(Startup.wd);
		hp.clickSignIn();
	}

	@Then("^user is on registration page$")
	public void user_is_on_registration_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Registration r = new Registration(Startup.wd);
	    r.verifytitle();
	}

	@Then("^user enters \"([^\"]*)\" as emailid$")
	public void user_enters_as_emailid(String email) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Registration r = new Registration(Startup.wd);
		 r.enterEmailId(email);
	}

	@Then("^user clicks on Create an account button$")
	public void user_clicks_on_Create_an_account_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Registration r = new Registration(Startup.wd);
		 r.clickSubmitButton();
		 
	}
	
	@Then("^error message is displayed starting with \"([^\"]*)\" on top$")
	public void error_message_is_displayed_starting_with_on_top(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Registration r = new Registration(Startup.wd);
		 
		 if(r.errormessage()==true)
			{
				System.out.println("ERROR");
				
			}
			else
			{
				System.out.println("SUCCESS");
			}
	}

	@Then("^user gets registered successfully$")
	public void user_gets_registered_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createAccount reg= new createAccount(Startup.wd);
		reg.myaccounttitle();
		
		
	}

	@Then("^user gets the message starting with \"([^\"]*)\" on the top$")
	public void user_gets_the_message_starting_with_on_the_top(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createAccount reg= new createAccount(Startup.wd);
				
		if(reg.successmsg()==true)
		{
			System.out.println("SUCCESS");
			
		}
		else
		{
			System.out.println("ERROR");
		}
	}

	@Then("^user does not get registered successfully$")
	public void user_does_not_get_registered_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createAccount reg= new createAccount(Startup.wd);
		
		if(reg.errormessage()==true)
		{
			System.out.println("ERROR");
			
		}
		else
		{
			System.out.println("SUCCESS");
		}
	}


	@Then("^registration form gets loaded$")
	public void registration_form_gets_loaded() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		createAccount reg= new createAccount(Startup.wd);
		String heading=reg.verifypageheading();
		if(heading.equalsIgnoreCase("CREATE AN ACCOUNT"))
		{
			System.out.println("Heading is correct : "+heading);
//			logger.info("Heading is correct : "+heading);
//			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Heading is correct: "+heading+"","Application should be on the Home Page after performing Login Operation ",""+screenshot_path+"");
		}
		else
		{
			System.out.println("Heading is not correct"+heading);
//			logger.error("Heading is not correct");
//			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Heading is not correct: "+heading+"","Application should be on the Home Page after performing Login Operation ",""+screenshot_path+"");
		}
	}

	@Then("^user enters account details as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void user_enters_account_details_as(String gender, String customer_firstname, String customer_lastname, String password, int days, int months, String years, String firstname, String lastname, String company, String address1, String address2, String city, String state, String postalcode, String country, String otherinfo, String phone, String mobile, String alias) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createAccount reg= new createAccount(Startup.wd);
		if(gender.equalsIgnoreCase("Male"))
		{
			reg.selectgender1();
		}
		else if(gender.equalsIgnoreCase("Female"))
		{
			reg.selectgender2();
		}
		if(gender.equalsIgnoreCase("Mr"))
		{
			reg.selectgender1();
		}
		else if(gender.equalsIgnoreCase("Mrs"))
		{
			reg.selectgender2();
		}
		reg.enter_customer_firstname(customer_firstname);
		reg.enter_customer_lastname(customer_lastname);
		reg.enterpassword(password);
		reg.selectday(days);
		reg.selectmonth(months);
		reg.selectyear(years);
		reg.selectnewsletter();
		reg.selectsploffer();
		reg.enterfirstname(firstname);
		reg.enterlastname(lastname);
		reg.entercompanyname(company);
		reg.enteraddress1(address1);
		reg.enteraddress2(address2);
		reg.entercity(city);
		reg.selectstate(state);
		reg.enterpostcode(postalcode);
		reg.selectcountry(country);
		reg.enterAdditionInfo(otherinfo);
		reg.enterphone(phone);
		reg.entermobile(mobile);
		reg.enteralias(alias);
		
	}

	@Then("^user clicks on register button$")
	public void user_clicks_on_register_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createAccount reg= new createAccount(Startup.wd);
		reg.register();
		
	}
	
	
	@Then("^user enters invalid account details as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	
	public void user_enters_invalid_account_details_as(String gender, String customer_firstname, String customer_lastname, String password, int days, int months, String years, String firstname, String lastname, String company, String address1, String address2, String city, String state, String postalcode, String country, String otherinfo, String phone, String mobile, String alias) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createAccount reg= new createAccount(Startup.wd);
		if(gender.equalsIgnoreCase("Male"))
		{
			reg.selectgender1();
		}
		else if(gender.equalsIgnoreCase("Female"))
		{
			reg.selectgender2();
		}
		if(gender.equalsIgnoreCase("Mr"))
		{
			reg.selectgender1();
		}
		else if(gender.equalsIgnoreCase("Mrs"))
		{
			reg.selectgender2();
		}
		reg.enter_customer_firstname(customer_firstname);
		reg.enter_customer_lastname(customer_lastname);
		reg.enterpassword(password);
		reg.selectday(days);
		reg.selectmonth(months);
		reg.selectyear(years);
		reg.selectnewsletter();
		reg.selectsploffer();
		reg.enterfirstname(firstname);
		reg.enterlastname(lastname);
		reg.entercompanyname(company);
		reg.enteraddress1(address1);
		reg.enteraddress2(address2);
		reg.entercity(city);
		reg.selectstate(state);
		reg.enterpostcode(postalcode);
		reg.selectcountry(country);
		reg.enterAdditionInfo(otherinfo);
		reg.enterphone(phone);
		reg.entermobile(mobile);
		reg.enteralias(alias);
		
	}
	
	
	

	@Then("^user gets the error message starting with \"([^\"]*)\" on the top$")
	public void user_gets_the_error_message_starting_with_on_the_top(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
createAccount reg= new createAccount(Startup.wd);
		
		if(reg.errormessage()==true)
		{
			System.out.println("ERROR");
			
		}
		else
		{
			System.out.println("SUCCESS");
		}
	}
	
	
	@Then("^close the Browser$")
	public void close_the_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		report.endTest(logger);
		report.flush();
		report.close();
		Startup.wd.get(System.getProperty("user.dir") + "\\report.html");
		// close browser after execution
		// Startup.wd.quit();
	}

	
}
