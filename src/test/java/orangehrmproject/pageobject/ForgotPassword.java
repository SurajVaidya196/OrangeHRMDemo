package orangehrmproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	public WebDriver driver;
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username") WebElement txtUsername;
	@FindBy(linkText=" Cancel ") WebElement btnCancel;
	@FindBy(xpath="//*[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']")
	WebElement btnForgotPassword;
	
	public void setForgotPwtUsername(String fUsername) {
		txtUsername.clear();
		txtUsername.sendKeys(fUsername);
	}
	public void clickCancelButton() {
		btnCancel.click();
	}
	public void clickResetPassword() {
		btnForgotPassword.click();
	}
}
