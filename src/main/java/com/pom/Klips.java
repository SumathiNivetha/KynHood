package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class Klips extends BaseClass {

	public WebDriver driver;

	@FindBy(xpath = "(//img[@loading='lazy'])[6]")
	private WebElement klipsClick;

	@FindBy(xpath = "(//div[@class='header-text'])[1]//following::div[@class='description']")
	private List<WebElement> list;

	@FindBy(xpath = "(//div[@class='header-text'])[1]//following::div[@class='description']//preceding::div[@class='header-text']")
	private List<WebElement> name;

	@FindBy(xpath = "//div[@class='location detail-item']")
	private List<WebElement> location;

	@FindBy(xpath = "//div[@class='category detail-item']")
	private List<WebElement> category;

	public Klips(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public boolean klipseNameTitle(ExtentTest extenttest) throws InterruptedException {

		try {

			clickButton(klipsClick);
			localWait(5000);
			nameLocation(location, category);
			klipsValidataion(list, name);
			extenttest.log(Status.PASS, "Klipse Name Title Validation Pass");
		} catch (AssertionError e) {

			extenttest.log(Status.FAIL, "Login Failed:" + e.getMessage());

			return false;
		}
		return true;
	}

	
}
