package com.runner;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.listener.ITestListenerClass;
import com.pom.HomeFeed;
import com.pom.Klips;
@Listeners(ITestListenerClass.class)
public class KynhoodRunner extends BaseClass {
	
	
	
	
public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = BaseClass.launchBrowser("chrome");
	}
	@Test(priority = -5)
	public void homeFeedTest() {
		com.listener.ExtentReport_Test.extenttest =extentReports.createTest("homeFeedTest"+ " : "+ Thread.currentThread()
		.getStackTrace()[1].getMethodName().toString()).info("HomeFeedTestValidation");
	
		HomeFeed lp = new HomeFeed(driver);
		
		Assert.assertTrue(lp.homeFeedValidate(com.listener.ExtentReport_Test.extenttest));
	}
	
	@Test(priority = -4)
	public void klipseNameTitleValidation() throws InterruptedException {
		com.listener.ExtentReport_Test.extenttest =extentReports.createTest("KlipsTest"+ " : "+ Thread.currentThread()
		.getStackTrace()[1].getMethodName().toString()).info("KlipsTestValidation");
		Klips lp = new Klips(driver);
		Assert.assertTrue(lp.klipseNameTitle(com.listener.ExtentReport_Test.extenttest));
	}
	
	
	@AfterTest
	public void browserClose() {
		terminateBrowser();

	}
	@BeforeSuite
	private void extendStartUp() {
		extentReportStart("C:\\Users\\Nowfiya\\eclipse-workspace\\KynHood_Application\\Reports");
	}

	@AfterSuite
	private void extendReportEnd() throws IOException {
		extentReportTearDown("C:\\Users\\Nowfiya\\eclipse-workspace\\KynHood_Application\\Reports\\index.html");

	}

}

