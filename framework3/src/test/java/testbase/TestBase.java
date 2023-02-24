package testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.ConfigDataProvider;

public class TestBase {
	
	public WebDriver driver;
	public String configdatapath = "./Config/config.properties";
	public ConfigDataProvider configdataprovider;
	
	@BeforeSuite
	public void init() {
		 configdataprovider = new ConfigDataProvider(configdatapath);
	}
	@BeforeTest
	
	public void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(configdataprovider.getURL());
		String oldWindow = driver.getWindowHandle();
		Thread.sleep(10000);
		WebElement a = driver.findElement(By.tagName("body"));
		a.click();
		driver.switchTo().window(oldWindow);
	}

	@AfterTest
	public void tearDown() {
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
