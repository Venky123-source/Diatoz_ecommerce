package dia.qa.ecom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dia.qa.ecom.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//a[@class= 'js-modal-open-login-modal link--action btn btn--secondary']")
	WebElement LoginBtn;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit'  and @name='commit' and @class= 'btn btn--narrow']")
	WebElement ClickEnter;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String pwd) {
		LoginBtn.click();
		password.sendKeys(pwd);
		ClickEnter.click();

		return new HomePage();

	}

}
