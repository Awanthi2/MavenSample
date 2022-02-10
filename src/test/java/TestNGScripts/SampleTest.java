package TestNGScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	ExtentSparkReporter sparkreprt;
	ExtentReports reports;
	ExtentTest reportTest;
	WebDriver driver;
	//ExtentSparkleReports spark;
	@BeforeTest
	public void reportte() {
		sparkreprt = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReportResults.html");
		reports=new ExtentReports();
		reports.attachReporter(sparkreprt);
		
	}
	//WebDriver driver;
	 @Test(groups="FeatuerTest")
	public void PageSearchTest() throws MalformedURLException {
	WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		  driver.manage().window().maximize();
		 reports.createTest("PageTest");
		 //ChromeOptions options=new ChromeOptions();
		// options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		// String hub="http://localhost:4444/";
		// WebDriver driver=new RemoteWebDriver(new URL(hub),options);
		
		  driver.get("https://www.google.com");
		 
		  WebElement searchbox=driver.findElement(By.name("q"));
		  searchbox.sendKeys("Java");
		  searchbox.submit();
		  SoftAssert softassert=new SoftAssert();
		  softassert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
		 // softassert.assertAll();
		

	  }
	 @AfterTest
	 public void tearDown()
	 {
		 reports.flush();
		 driver.close();
	 }
}
