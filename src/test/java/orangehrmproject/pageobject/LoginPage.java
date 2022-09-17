package orangehrmproject.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		//The initElements method is used to initialize web elements.
		PageFactory.initElements(rdriver, this);
	}

	//@FindBy: An annotation used in Page Factory to locate and declare web elements using different locators.
	@FindBy(name="username")
	@CacheLookup
	WebElement txtUsername;

	//or we can use How class
	//@FindBy(how=How.NAME, using="username") WebElement txtUsername;
	@FindBy(name="password") 
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") 
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p") 
	@CacheLookup
	WebElement forgotPwt;

	public  void setUsername(String uname) {
		txtUsername.clear();
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickOnLogin() {
		btnLogin.click();
	}
	public void forgotPasswork() {
		forgotPwt.click();
	}
}
