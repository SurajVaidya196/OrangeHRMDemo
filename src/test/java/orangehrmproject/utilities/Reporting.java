package orangehrmproject.utilities;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import orangehrmproject.testcases.BaseClass;

public class Reporting implements ITestListener{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		String dateFormat=new SimpleDateFormat("dd.MM.yyyy.kk.mm.ss").format(new Date());//kk--hours in day
		String reportName="Test-Report"+dateFormat+".html";
		String sparkPath=System.getProperty("user.dir")+"\\ExtentReport\\"+reportName;

		spark=new ExtentSparkReporter(sparkPath);
		try {
			spark.loadJSONConfig(new File("spark-config.json"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Host", "local");


	}

	public void onTestSuccess(ITestResult result) {
		test=report.createTest(result.getName()).assignAuthor("Suraj").assignDevice("Windows 10");
		test.log(Status.PASS,MarkupHelper.createLabel("Test Successfully pass", ExtentColor.GREEN));
	}
	public void onTestSkipped(ITestResult result) {
		test=report.createTest(result.getName()).assignAuthor("Suraj");
		test.skip(MarkupHelper.createLabel("Test Skiped...", ExtentColor.YELLOW));
	}
	public void onTestFailure(ITestResult result) {
		test=report.createTest(result.getName()).assignAuthor("suraj");
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Failed...", ExtentColor.RED));
		/*String screenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+result.getName()+".png";
		File f=new File(screenshotPath);
		if(f.exists()) {
			add screenshot to report from path(local)
			test.fail("Screenshot is below :", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			add screenshot to report using Base64
		 */	test.fail("Screenshot is below :", MediaEntityBuilder
				 .createScreenCaptureFromBase64String(BaseClass.getBase64(),"fail test Screenshot")
				 .build());
		 test.info(new RuntimeException());
	}


public void onFinish(ITestContext context) {
	report.flush();
}
public void onTestStart(ITestResult result) {
	// not implemented
}
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// not implemented
}
public void onTestFailedWithTimeout(ITestResult result) {
	onTestFailure(result);
}
}



