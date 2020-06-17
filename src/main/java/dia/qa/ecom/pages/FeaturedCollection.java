package dia.qa.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dia.qa.ecom.base.TestBase;

public class FeaturedCollection extends TestBase {

	@FindBy(xpath = "(//a[@class='grid-view-item__link grid-view-item__image-container full-width-link'])[2]")
	WebElement addshirt;

	@FindBy(xpath = "//button[@type='submit' and @name='add']")
	WebElement addtocart;

	@FindBy(xpath = "(//*[@class='icon icon-close'])[1]")
	WebElement closepopup;

	@FindBy(xpath = "//*[@id='SingleOptionSelector-0']")
	WebElement selectcolor;

	@FindBy(xpath = "//*[@id='SingleOptionSelector-1']")
	WebElement selectsize;

	@FindBy(xpath = "//a[@class='cart-popup__cta-link btn btn--secondary-accent']")
	WebElement viewcart;

	public FeaturedCollection() {
		PageFactory.initElements(driver, this);
	}

	public void AddShirt() throws InterruptedException {

		addshirt.click();
		addtocart.click();

		selectcolor.sendKeys(Keys.DOWN);
		selectsize.sendKeys(Keys.DOWN);
		addtocart.click();

		selectcolor.sendKeys(Keys.ARROW_UP);
		selectsize.sendKeys(Keys.ARROW_DOWN);
		addtocart.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='cart-popup__cta-link btn btn--secondary-accent']")));

		viewcart.click();

	}

}
