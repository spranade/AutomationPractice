package wipro.test.operations;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.internal.Utils;

public class BromiumTests {/*

 WebDriver driver;
 Utils util;

 @BeforeTest
 public void setUp() {
  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\JARS\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
 }

 @Test
 public void testOpenFacebook() {
  driver.get("https://www.facebook.com");
  switchToNewTab();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

 }
 
 @Test
 public void testOpenYoutube() {
  driver.get("https://www.youtube.com");  
  driver.get("https://www.youtube.com/watch?v=9NXEnGiOeUU");
  switchToNewTab();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

 }
 @Test
 public void testOpenGmail() {  
  driver.get("http://www.gmail.com");
  switchToNewTab();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }
 public void openNewTab() {
  ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
 }

 public void switchToNewTab() {
  openNewTab();
  String subWindowHandler = null;
  Set<String> handles = driver.getWindowHandles();
  Iterator<String> iterator = handles.iterator();
  while (iterator.hasNext()) {
   subWindowHandler = iterator.next();
  }
  driver.switchTo().window(subWindowHandler);
 }

 @AfterClass
 public void tearDown() {
  driver.quit();
 }
 

*/}