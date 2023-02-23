package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageobjects.POM1;


public class TC01 {

	WebDriver driver;
	POM1 fp;

	@Test
	
	public void case1() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");		
		String oldWindow = driver.getWindowHandle();
		Thread.sleep(10000);
		WebElement a = driver.findElement(By.tagName("body"));
		a.click();
		driver.switchTo().window(oldWindow);
		fp=new POM1(driver);
	
			fp.clickFlightTab();
	        fp.cities("Bengaluru","Mumbai");
	        fp.dates("December 2023");  
	        fp.travellersAndClass();
	        fp.flights();
	        fp.cheapestf();
	        driver.quit();
	}
	
	
}