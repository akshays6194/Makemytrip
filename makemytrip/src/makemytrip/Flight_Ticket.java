package makemytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flight_Ticket {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//li[1]/div/a/span[2]")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[1][@role='option']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Mumbai");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[1][@role='option']")).click();
		Thread.sleep(1000);
		String em= "December 2023";
		WebElement month = driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div"));
		String am= month.getText();
		for(int i=0;i<=10;i++) {
		if(am.equalsIgnoreCase(em)) {
			driver.findElement(By.xpath("//p[text()='31']")).click();
			break;
				}
		else {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			month = driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div"));
			am=month.getText();
		}		
	  }
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//div[2]/div[1]/ul[1]/li[2]")).click();
		driver.findElement(By.xpath("//div[2]/div[1]/div/div[1]/ul/li[4]")).click();
		driver.findElement(By.xpath("//div[1]/div/div[2]/ul/li[2]")).click();
		driver.findElement(By.xpath("//div[2]/div[1]/ul[2]/li[3]")).click();
		driver.findElement(By.xpath("//button[@class='primaryBtn btnApply pushRight']")).click();
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		Thread.sleep(1000);
		WebElement e= driver.findElement(By.xpath("//p[@class='error-title']"));
		String error= e.getText();
		System.out.println(error);
		driver.close();

		
		
		
		

}
}
