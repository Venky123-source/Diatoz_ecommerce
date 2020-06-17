package dia.qa.ecom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dia.qa.ecom.base.TestBase;
import dia.qa.ecom.pages.HomePage;
import dia.qa.ecom.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void addtocartTest() {

		String expectedvalue = "Rs. 1,338.61";
		String actualvalue = homepage.addtocart();

		Assert.assertEquals(actualvalue, expectedvalue, "not a match");

	}

	@Test(priority = 2)
	public void ValidateQtyPrice() {

		String expectedvalue = "Rs. 2,677.22";
		String actualvalue = homepage.IncreaseQty();

		Assert.assertEquals(actualvalue, expectedvalue, " not a match");

	}

	@Test(priority = 3)
	public void validatelogo() {
		Assert.assertTrue(homepage.verifylogo());
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
