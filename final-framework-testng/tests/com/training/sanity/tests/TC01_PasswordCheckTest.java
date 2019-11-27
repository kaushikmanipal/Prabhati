package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordPOM;
import com.training.pom.UserHomePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC01_PasswordCheckTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UserHomePOM userhome;
	private PasswordPOM passwordpage;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods gc;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		userhome=new UserHomePOM(driver);
		passwordpage=new PasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		screenShot = new ScreenShot(driver); 
		gc=new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(5000L);
		loginPOM.sendUserName("revasharma@gmail.com");
		loginPOM.sendPassword("reva123");
		loginPOM.clickLoginBtn();
		Thread.sleep(2000L);
	   gc.assertText("Change your password", "//*[@id='System_nyHsmShk']/align/ul/li[2]/a", "xpath", "We are not in the required page");
	}
	 
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
		
	

	@Test
	public void passwordMismatchTest() throws InterruptedException {
		
		
		
		Thread.sleep(5000L);
	    //System.out.println(userhome.userText());
		userhome.clickuserText();
		Thread.sleep(5000L);
		gc.assertText("Your Password", "//*[@id='System_s3bhXNDb']/form/fieldset/legend", "xpath", "We are not in the required page");
		screenShot.captureScreenShot("Your Password Page");
		passwordpage.sendPassword("reva123");
		passwordpage.ConfirmPassword("reva1234");
		passwordpage.submitContinueButton();
		
		passwordpage.ConfirmationText();
		System.out.println(passwordpage.ConfirmationText.getText());
	    gc.assertText("Password confirmation does not match password!", "//*[@id='System_s3bhXNDb']/form/fieldset/div[2]/div/div","xpath" , "The message is not correct");
		screenShot.captureScreenShot("Confirmation Page 1");
		
	}
	
	@Test
    public void samePasswordTest() throws InterruptedException {
		
		
		
		Thread.sleep(5000L);
	   
		userhome.clickuserText();
		Thread.sleep(5000L);
		gc.assertText("Your Password", "//*[@id='System_s3bhXNDb']/form/fieldset/legend", "xpath", "We are not in the required page");
		screenShot.captureScreenShot("Your Password Page");
		passwordpage.sendPassword("reva123");
		passwordpage.ConfirmPassword("reva123");
		passwordpage.submitContinueButton();
		
		passwordpage.SuccessText();
		System.out.println(passwordpage.SuccessText.getText());
	    gc.assertText("Password confirmation does not match password!", "#System_s3bhXNDb > form > fieldset > div.form-group.required.has-error > div > div","css" , "The message is not correct");
		//screenShot.captureScreenShot("Confirmation Page");
		
	}
}

