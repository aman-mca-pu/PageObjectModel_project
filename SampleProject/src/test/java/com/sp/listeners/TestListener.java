package com.sp.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sp.pagefactory.SPBase;

public class TestListener implements ITestListener {
	public String browserName;
	public WebDriver driver;
	public String failedscreens = System.getProperty("user.dir") + "_Failed_Screens";
			

	public void onTestFailure(ITestResult result) {

		try {
			System.out.println("***** Error " + result.getName()+ " test has failed *****");
					
			String methodName = result.getName().toString().trim();
			takeScreenShot(methodName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void takeScreenShot(String methodName) throws Exception {
		// get the driver

		SPBase ypbase = new SPBase("", "");
		driver = ypbase.initDriver("", "");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
		// The below method will save the screen shot in d drive with test
		// method name
		try {
			FileUtils.copyFile(scrFile, new File(failedscreens + File.separator + methodName + "_" + browsername() + ".png"));
					
			System.out.println("***Placed screen shot in " + failedscreens + " ***");
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String browsername() {

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		browserName = cap.getBrowserName().toLowerCase();
		return browserName;

	}

	public void onFinish(ITestContext context) {
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}
}
