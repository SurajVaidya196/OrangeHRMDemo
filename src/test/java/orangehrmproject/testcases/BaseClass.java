package orangehrmproject.testcases;

import java.io.*;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrmproject.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl= readconfig.getBaseUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();

	@BeforeMethod
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
	} 
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public void takeScreenshot(WebDriver driver,String testname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"/Screenshot/"+testname+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.getMessage();
		}
		System.out.println("Screenshot is Taken....");
	}
	
	public static String getBase64() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
