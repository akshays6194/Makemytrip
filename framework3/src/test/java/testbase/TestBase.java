package testbase;

import org.openqa.selenium.WebDriver;
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
	
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(configdataprovider.getURL());
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
