package orangehrmproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrmproject.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test(priority=1)
	public void loginTest() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickOnLogin();
		//OrangeHRM -->title of page
		if(driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
			Assert.assertTrue(true);
		}
		else {
			//takeScreenshot(driver, "loginTest");
			getBase64();
			Assert.assertTrue(false);
			
		}
	}
	
}
