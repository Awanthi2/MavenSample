package TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest2 {
	WebDriver driver;
	
	public void PageSearchTest() {
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		  driver.manage().window().maximize();
		
		  driver.get("https://www.google.com");
		 
		  WebElement searchbox=driver.findElement(By.name("q"));
		  searchbox.sendKeys("Java Tutorial");
		  searchbox.submit();
		  SoftAssert softassert=new SoftAssert();
		  softassert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
		  softassert.assertAll();

	  }
}
