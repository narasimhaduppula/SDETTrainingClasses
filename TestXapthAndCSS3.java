package com.qa.Scripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Pages.Test3OrangeHRMPageWithXpathAndCSS;

public class TestXapthAndCSS3 {
	WebDriver driver;
	Test3OrangeHRMPageWithXpathAndCSS OrangeOR;
	public static FileInputStream fileLoc;
	public static Properties prop;
	
	
	@BeforeTest
	public void OpenUrlWithBrowser() {
		try {
			fileLoc = new FileInputStream(System.getProperty("user.dir")+"\\configuration\\config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		OrangeOR=new Test3OrangeHRMPageWithXpathAndCSS(driver);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();	
	}
	@Test
	public void PrintTitle() {
		// Text Boxes
		Assert.assertTrue(OrangeOR.CheckUserNamWithXpathDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - User Name with Xpath ", true);
		Assert.assertTrue(OrangeOR.CheckUserNamWithCSSDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - User Name with CSS ", true);
		
		Assert.assertTrue(OrangeOR.CheckPasswordWithXpathDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - password with Xpath ", true);
		Assert.assertTrue(OrangeOR.CheckPasswordWithCSSDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - password with CSS ", true);
		
		// hyperlinks
		Assert.assertTrue(OrangeOR.CheckForgotPasswordWithXpathDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - Forgot password Link with Xpath ", true);
		Assert.assertTrue(OrangeOR.CheckForgotPasswordWithCSSDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - Forgot password Link with CSS ", true);
		
		Assert.assertTrue(OrangeOR.CheckFooterLinkWithXpathDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - Footer Link with Xpath ", true);
		Assert.assertTrue(OrangeOR.CheckFooterLinkWithCSSDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - Footer Link with CSS ", true);
		
		// Images
		Assert.assertTrue(OrangeOR.CheckLogoImageWithXpathDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - Logo Image with Xpath ", true);
		Assert.assertTrue(OrangeOR.CheckLogoImageWithCSSDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - Logo Image with CSS ", true);
		
		Assert.assertTrue(OrangeOR.CheckFooterImageFBWithXpathDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - FB Image with Xpath ", true);
		Assert.assertTrue(OrangeOR.CheckFooterImageFBWithCSSDisplayed());
		Reporter.log("Passed - Log In Page - Object Indentification - FB Image with CSS ", true);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
