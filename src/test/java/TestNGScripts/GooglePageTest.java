package TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageTest {
	  WebDriver driver;
	@BeforeMethod
	 // @BeforeTest
	public void SetUp() {
		 // System.setProperty("webdriver.chrome.driver", "C:\\Web driver\\chromedriver.exe");
		  WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		  driver.manage().window().maximize();
	}
	
  @Test(retryAnalyzer = IRetryTest.class)
  public void PageSearchTest() {
	
	  driver.get("https://www.google.com");
	 
	  WebElement searchbox=driver.findElement(By.name("q"));
	  searchbox.sendKeys("Java Tutorial");
	  searchbox.submit();
	  SoftAssert softassert=new SoftAssert();
	  softassert.assertEquals(driver.getTitle(), "Java Tutorial - Google Searc");
	  softassert.assertAll();
	 
  }
  @Test(enabled=false)
  public void SearchJavaTest() {
		  driver.get("https://www.google.com");

	  WebElement searchbox=driver.findElement(By.name("q"));
	  searchbox.sendKeys("Appium");
	  searchbox.submit();
	  Assert.assertEquals(driver.getTitle(),"Appium - Google Search");

  }
  @Test(enabled=false)
  public void SearchUltiTest() {
		  driver.get("https://www.google.com");

	  WebElement searchbox=driver.findElement(By.name("q"));
	  searchbox.sendKeys("Ultimatix");
	  searchbox.submit();
	  Assert.assertEquals(driver.getTitle(),"Ultimatix - Google Search");

  }
  @AfterTest
 //@AfterMethod
 public void teardown() {
	 driver.close();
 }
}
