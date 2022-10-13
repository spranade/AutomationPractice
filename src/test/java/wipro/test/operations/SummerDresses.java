package wipro.test.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import wipro.test.config.Startup;
import wipro.test.library.Helper;
import wipro.test.library.Utility;
import wipro.test.results.HTMLReportGenerator;




public class SummerDresses {
	final static Logger logger=Logger.getLogger(SummerDresses.class);
	public String sortby;
	String screenshot_path;
	Utility U = new Utility();
	
	public SummerDresses(WebDriver wd) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(how=How.XPATH,using="//select[@id='selectProductSort']")
	WebElement SortBy;
	public void SortBy(String stype){
		
		try{
		U.isElementPresent(SortBy,30);
		Helper.highLightElement(Startup.wd,SortBy);
		sortby=stype;
		System.out.println("----"+sortby+"----"+stype);
		Select sortby = new Select(SortBy);
		sortby.selectByVisibleText(stype);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "SortBy");
		
			logger.info("User clicked SortBy:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Select Sort By ","Sort by type  should be selected",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("User failed to select Sort By");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Select Sort By ","Sort by type  should be selected",""+screenshot_path+"");
			
			}
	}
	
	
	
	@FindBy(how=How.XPATH,using="//div[@id='center_column']/h1/span[@class='cat-name']")
	WebElement pageheading;
	public String verifypageheading()
	{
		
		U.isElementPresent(pageheading,30);
		String h = pageheading.getText().trim();
		try{
		Helper.highLightElement(Startup.wd,pageheading);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "pageheading");
//		Assert.assertEquals(pageheading.getText().toString(), "SUMMER DRESSES");
				
		System.out.println("page heading: " + h + "_");
		Assert.assertTrue("-Heading is correct-", h.equalsIgnoreCase("SUMMER DRESSES"));
		
		
			logger.info("page heading is verified successfully:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Verify page heading ","Page heading should be correct",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("page heading is wrong");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Verify page heading ","Page heading should be correct",""+screenshot_path+"");
			
			}
		
		return h;	
		
	}
	
	
	
	public void verifytitle() throws Exception
	{
		Thread.sleep(5000);
		try{
		Assert.assertEquals(Startup.wd.getTitle(), "Summer Dresses - My Store");
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifytitle");
		
			logger.info("title verified successfully:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Verify page title ","Page title should be correct",""+screenshot_path+"");
			
			}
		catch(Exception e)
		{
			logger.error("title is wrong");
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Verify page title ","Page title should be correct",""+screenshot_path+"");
			
			}
	}
	
	
	
	@FindBy(how=How.XPATH,using="//div[@id='center_column']/ul/li//div[@class='content_price']/span[@class='old-price product-price']")
	WebElement oldprice;
	
	@FindBy(how=How.XPATH,using="//div[@id='center_column']/ul/li//div[@class='content_price']/span[@class='price product-price']")
	WebElement discountprice;
	
	
	public boolean checkOldPriceOrder(){
		U.isElementPresent(oldprice,30);
		Helper.highLightElement(Startup.wd,oldprice);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "checkOldPriceOrder");
		List<WebElement> oldprice = Startup.wd.findElements(By.xpath("//div[@id='center_column']/ul/li//div[@class='content_price']/span[@class='old-price product-price']"));

		// extract the prices from the price elements and store in a List
		List<Double> prices = new ArrayList<Double>();
		for (WebElement e : oldprice)
		{
			
			String op = e.getText().replaceAll("[^\\d.]", "").trim();
			if(op != null && op.trim().length() > 0){
				prices.add(Double.parseDouble(op));
			}
		}

		System.out.println("Prices from UI: " + prices);
		// make a copy of the list
		List<Double> sortedOldPrices = new ArrayList<Double>(prices);

		// sort the list
		Collections.sort(sortedOldPrices);
		
		System.out.println("Sorted Prices: " + sortedOldPrices);

		System.out.println("----"+sortby+"----");
		
		
		
		
		
		if(sortby=="Price: Lowest first")
		{
		// true if the prices are sorted
		System.out.println("Are prices sorted: " + toArray(sortedOldPrices).equals(toArray(prices)));
		//Assert.assertArrayEquals(toArray(sortedOldPrices), toArray(prices), 0.0);
		
		 
	        for (int i = 0; i < prices.size()-1; i++) {
	            if (prices.get(i) < prices.get(i+1)) {
	            	logger.info("Prices are not in ascending order:");
	            	HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Verify product price order ","Product price should be from lowest to highest",""+screenshot_path+"");
	    		
	                return false;
	            }       
	         }
	         System.out.println("Prices are in ascending order");
	         logger.info("Prices are in ascending order:");
	         HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Verify product price order ","Product price should be from lowest to highest",""+screenshot_path+"");
 		
	         return true;
		}
		else
		{
			for (int i = 0; i < prices.size()-1; i++) {
	            if (prices.get(i) > prices.get(i+1)) {
	            	logger.info("Prices are not in descending order:");
	            	HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Verify product price order ","Product price should be from Highest to lowest",""+screenshot_path+"");
	    		
	                return false;
	            }       
	         }
			System.out.println("Prices are in descending order");
			logger.info("Prices are in descending order:");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Verify product price order ","Product price should be from Highest to lowest",""+screenshot_path+"");
			
	         return true;
			
		}
		
		
		
		
	}
	
	private double[] toArray(List<Double> list){
		return list.stream().mapToDouble(Number::doubleValue).toArray();
	}
	
	public boolean checkDiscountPriceOrder(){
		U.isElementPresent(discountprice,30);
		Helper.highLightElement(Startup.wd,discountprice);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "checkDiscountPriceOrder");
		List<WebElement> discountprice = Startup.wd.findElements(By.xpath("//div[@id='center_column']/ul/li//div[@class='content_price']/span[@class='price product-price']"));

		// extract the prices from the price elements and store in a List
		List<Double> prices = new ArrayList<Double>();
		for (WebElement e : discountprice)
		{
			String op = e.getText().replaceAll("[^\\d.]", "").trim();
			if(op != null && op.trim().length() > 0){
				prices.add(Double.parseDouble(op));
			}
		}

		System.out.println("Discount Prices from UI: " + prices);
		// make a copy of the list
		List<Double> sortedDiscountPrices = new ArrayList<Double>(prices);

		// sort the list
		Collections.sort(sortedDiscountPrices);

		System.out.println("Sorted Discount Prices: " + sortedDiscountPrices);
		
		// true if the prices are sorted
		System.out.println("Are discount prices sorted: " + toArray(sortedDiscountPrices).equals(toArray(prices)));
		//Assert.assertArrayEquals(toArray(sortedDiscountPrices), toArray(prices), 0.0);
		
		
		
		 for (int i = 0; i < prices.size()-1; i++) {
	            if (prices.get(i) > prices.get(i+1)) {
	                return false;
	            }       
	         }
	         return true;
		
	}
	
	
	public void checkdollarcondition() {
		
		//Assert.assertTrue(oldprice.getText().contains("$"));

		if (oldprice.getText().contains("$")) {
			System.out.println("price is in correct format");

		} else {
			System.out.println("price is not in correct format");
		}
		
		
		//Assert.assertTrue(discountprice.getText().contains("$"));

		if (discountprice.getText().contains("$")) {
			System.out.println("price is in correct format");

		} else {
			System.out.println("price is not in correct format");
		}

	}
}
