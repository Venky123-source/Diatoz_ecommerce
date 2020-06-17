package dia.qa.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dia.qa.ecom.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "(//*[@class='icon icon-search'])[2]")
	WebElement searchicon;

	@FindBy(xpath = "//input[@type='text']")
	WebElement textbox;

	@FindBy(xpath = "(//*[@class='predictive-search-item__title-text' ])[1]")
	WebElement clicksearch;

	@FindBy(xpath = "//button[@type='submit' and @name='add']")
	WebElement addtocart;

	@FindBy(xpath = "//a[@class='cart-popup__cta-link btn btn--secondary-accent']")
	WebElement viewcart;

	@FindBy(xpath = "(//input[@type='number'])[2]")
	WebElement increaseqty;

	@FindBy(xpath = "//td/div/span[contains(text(), 'Rs. ')]")
	    
	WebElement price;

	@FindBy(xpath = "//td/div/span[contains(text(), 'Rs. 2,677.22')]")
	WebElement subtotal;

	@FindBy(xpath = "//a[@class= 'site-header__logo-link']")
	WebElement logo; 

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String addtocart() {

		searchicon.click();
		textbox.sendKeys("Round Neck Shirt");
		clicksearch.click();
		addtocart.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='cart-popup__cta-link btn btn--secondary-accent']")));
		viewcart.click();
		return price.getText();

	}

	public String IncreaseQty() {

		searchicon.click();
		textbox.sendKeys("Round Neck Shirt");
		clicksearch.click();
		addtocart.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='cart-popup__cta-link btn btn--secondary-accent']")));

		viewcart.click();
		increaseqty.sendKeys(Keys.UP);

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/div/span[contains(text(), 'Rs. ')]")));

		return subtotal.getText();
	}

	public boolean verifylogo() {
		return logo.isDisplayed();
	}

}
