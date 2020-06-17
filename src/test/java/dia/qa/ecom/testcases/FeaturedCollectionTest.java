package dia.qa.ecom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dia.qa.ecom.base.TestBase;
import dia.qa.ecom.pages.FeaturedCollection;
import dia.qa.ecom.pages.HomePage;
import dia.qa.ecom.pages.LoginPage;

public class FeaturedCollectionTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	FeaturedCollection feature;

	FeaturedCollectionTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		feature = new FeaturedCollection();
		homepage = loginpage.login(prop.getProperty("password"));

	}

	@Test
	public void AddFeaturedCollection() throws InterruptedException {
		feature.AddShirt();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
