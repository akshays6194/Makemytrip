package testcases;

import org.testng.annotations.Test;

import pageobjects.POM1;
import testbase.TestBase;

public class TC01 extends TestBase {


	@Test

	public void case1() throws InterruptedException {

		POM1 fp = new POM1(driver);

		fp.clickFlightTab();
		fp.cities(configdataprovider.getFromcity(),configdataprovider.getTocity());
		fp.dates(configdataprovider.getdate());
		fp.travellersAndClass();
		fp.flights();
		fp.cheapestf();
		driver.quit();
	}

}