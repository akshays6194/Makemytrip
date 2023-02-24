package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM1 {

	WebDriver driver;

	@FindBy(xpath = "//li[1]/div/a/span[2]")
	WebElement flightsTab;

	@FindBy(xpath = "//input[@id='fromCity']")
	WebElement fromField;

	@FindBy(xpath = "//li[1][@role='option']")
	WebElement selectFromSuggestion;

	@FindBy(xpath = "//input[@id='toCity']")
	WebElement toField;

	@FindBy(xpath = "//li[1][@role='option']")
	WebElement selectToSuggestion;

	@FindBy(xpath = "//label[@for='travellers']")
	WebElement option;

	@FindBy(xpath = "//div[2]/div[1]/ul[1]/li[2]")
	WebElement adults;

	@FindBy(xpath = "//div[2]/div[1]/div/div[1]/ul/li[4]")
	WebElement children;

	@FindBy(xpath = "//div[1]/div/div[2]/ul/li[2]")
	WebElement infant;

	@FindBy(xpath = "//button[@class='primaryBtn btnApply pushRight']")
	WebElement apply;

	@FindBy(xpath = "//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")
	WebElement search;

	@FindBy(xpath = "//*[text()='OKAY, GOT IT!']")
	WebElement lockPrice;

	@FindBy(xpath = "//div[1]/div/div[1]/label/span/input")
	WebElement NonStop;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[4]/div/div/p")
	WebElement cheap;

	public POM1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFlightTab() {
		flightsTab.click();
	}

	public void cities(String from, String To) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		fromField.sendKeys(from);
		Thread.sleep(3000);
		selectFromSuggestion.click();
		toField.sendKeys(To);
		Thread.sleep(3000);
		selectToSuggestion.click();
	}

	public void dates(String dm) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
		String em = dm;
		WebElement month = driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div"));
		String am = month.getText();
		for (int i = 0; i <= 12; i++) {
			if (am.equalsIgnoreCase(em)) {
				String newUser = "31";
				driver.findElement(By.xpath("//p[text()=" + newUser + "]")).click();
				break;
			} else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				month = driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div"));
				am = month.getText();
			}
		}
	}

	public void travellersAndClass() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		option.click();
		adults.click();
		children.click();
		infant.click();
		apply.click();
		search.click();
		Thread.sleep(5000);
	}

	public void flights() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		lockPrice.click();
		NonStop.click();
	}

	public void cheapestf() {
		String str = cheap.getText();
		str = str.replaceAll("[^0-9]", " ");
		str = str.trim();
		System.out.println(str);
	}

}
