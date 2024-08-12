package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;
import com.base.BaseClass;

public class HomeFeed extends BaseClass{
public WebDriver driver;
	
	
	
	@FindBy(xpath  = "(//div[contains(text(),'T Nagar')])[1]")
	private WebElement tNagar;
	
	@FindBy(xpath  = "(//div[contains(text(),'T Nagar')])//preceding::div[@class='description']")
	private WebElement tNagarCon;

	
	public HomeFeed(WebDriver driver2) {
		
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}


	public boolean homeFeedValidate(ExtentTest extenttest) {
		
		try {
			
		launchUrl("https://app.kynhood.com/");
		implicitwait(30);
		getTex(tNagar);   
		getTex(tNagarCon);
		org.testng.Assert.assertEquals(tNagarCon, tNagarCon);
		extenttest.log(Status.PASS, "Home Feed Validate Sucessfull");
		
		} catch (AssertionError e) {

			extenttest.log(Status.FAIL, "Login Failed:" + e.getMessage());
		
		return false;
	}
	return true;
}

}

