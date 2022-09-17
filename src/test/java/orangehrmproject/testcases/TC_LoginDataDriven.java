package orangehrmproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import orangehrmproject.pageobject.LoginPage;
import orangehrmproject.testdata.DataProviderXL;

public class TC_LoginDataDriven extends BaseClass{
	
	@Test(dataProvider="loginData",dataProviderClass=DataProviderXL.class)
	public void loginDDT(String username,String password) {
		//get data from exel sheet
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickOnLogin();
		
		//checking for invalid credential
		if(driver.getPageSource().contains("Invalid credentials"))
		{
			//Base 64 screenshot for fail testcase
			getBase64();
			Assert.assertTrue(false);
		}
		
	}
	
}
