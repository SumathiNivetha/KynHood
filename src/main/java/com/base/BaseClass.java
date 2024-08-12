package com.base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;

	public static WebDriver launchBrowser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver launchUrl(String url) {
		driver.get(url);
		return driver;
	}

	public static void terminateBrowser() {
		driver.quit();
	}

	public static void clickButton(WebElement element) {
		element.click();
	}

	public static void getTex(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void implicitwait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}

	public void localWait(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void klipsValidataion(List<WebElement> list, List<WebElement> name) {
		Map<String, String> titleUserMap = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (i <= 1) {
				WebElement userList = list.get(i);
				String userListText = userList.getText();
				System.out.println(userList.getText());
				for (int j = 0; j < name.size(); j++) {
					if (j <= 0) {
						WebElement userName = name.get(j);
						String userNameText = userName.getText();
						System.out.println(userName.getText());

									titleUserMap.put(userListText, userNameText);

								}
							}

						}
					}

					for (Map.Entry<String, String> entry : titleUserMap.entrySet()) {
						System.out.println("Title: " + entry.getKey() + ", Username: " + entry.getValue());
					}
					for (Map.Entry<String, String> entry : titleUserMap.entrySet()) {
						String expectedList = entry.getKey();
						String expectedUsername = entry.getValue();
						assertTrue(titleUserMap.containsKey(expectedList), "Title not found: " + expectedList);
						assertEquals(expectedUsername, titleUserMap.get(expectedList),
								"Username mismatch for title: " + expectedList);

					}

				}
	
	public void nameLocation(List<WebElement> location, List<WebElement> category) {
		Map<String, String> locationUserMap = new HashMap<>();
		for (int i = 0; i < location.size(); i++) {
			if (i <= 1) {
				WebElement userLocation = location.get(i);
				String userLocationText = userLocation.getText();
				System.out.println(userLocation.getText());
				for (int j = 0; j < category.size(); j++) {
					if (j <= 0) {
						WebElement userCategory = category.get(j);
						String userCategoryText = userCategory.getText();
						System.out.println(userCategory.getText());

						locationUserMap.put(userLocationText, userCategoryText);

								}
							}

						}
					
		}
					for (Map.Entry<String, String> entry : locationUserMap.entrySet()) {
						System.out.println("Location: " + entry.getKey() + ", Category: " + entry.getValue());
					}
//					for (Map.Entry<String, String> entry : locationUserMap.entrySet()) {
//						String expectedTitle = entry.getKey();
//						String expectedUsername = entry.getValue();
//						assertTrue(locationUserMap.containsKey(expectedTitle), "Title not found: " + expectedTitle);
//						assertEquals(expectedUsername, locationUserMap.get(expectedTitle),
//								"Username mismatch for title: " + expectedTitle);
//
//					}

				}
	
	}