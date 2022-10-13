package wipro.test.operations;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wipro.test.library.Utility;
import wipro.test.results.HTMLReportGenerator;
import wipro.test.config.Startup;

public class LaunchApplication {

	final static Logger logger=Logger.getLogger(LaunchApplication.class);
	static String screenshot_path;
	public void launchBrowser(String Browser,String filepath) 
	{
		try{
			if(Browser.equalsIgnoreCase("firefox"))
			{
				try{
				System.setProperty("webdriver.firefox.marionette",filepath);
				Startup.wd = new FirefoxDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "firefox");
				
					logger.info("firefox browser launched successfully:");
					HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
					
					}
				catch(Exception e)
				{
					logger.error("firefox bowser failed to launch");
					HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
					
					}
			}
		}
	
	catch(Exception e)
	{
	}
	
		try{
			if(Browser.equalsIgnoreCase("Chrome"))
			{
				try{
				System.setProperty("webdriver.chrome.driver",filepath);
				Startup.wd = new ChromeDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "chrome");
				
					logger.info("Chrome browser launched successfully:" + Browser + Startup.counter);
					HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
					
					}
				catch(Exception e)
				{
					e.printStackTrace();
					logger.error("Chrome bowser failed to launch");
					HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
					
					}
			}
		}
	
	catch(Exception e)
	{
	}
		
		try{
			if(Browser.equalsIgnoreCase("IE"))
			{
				try{
				System.setProperty("webdriver.ie.driver",filepath);
				Startup.wd = new InternetExplorerDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "IE");
				
					logger.info("IE browser launched successfully:");
					HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
					
					}
				catch(Exception e)
				{
					logger.error("IE bowser failed to launch");
					HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
					
					}
			}
		}
	
	catch(Exception e)
	{
	}
		
		
	}
	
	
	public void launchApp(String url) 
	{
		try{
		Startup.wd.get(url);
		Startup.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Startup.wd.manage().window().maximize();
		Startup.wd.manage().getCookies().clear();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "App_URL");
		
			logger.info("application URL launched successfully:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the URL of the Application","User should be able to launch the URL of the Application ",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("application URL failed to launch");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the URL of the Application","User should be able to launch the URL of the Application and application should be on the Login Page",""+screenshot_path+"");
			
			}
		
	}
}
