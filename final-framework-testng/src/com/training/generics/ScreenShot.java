package com.training.generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;


/**
 * 
 * @author Naveen
 * @see in this class the path for screenshot is hard coded, please refer to others.properties file 
 *   the entry is kept, and this path shall be able to change from properties file 
 */
public class ScreenShot {

	private WebDriver driver; 
	
	// the driver information will be given by selenium test case 
	public ScreenShot(WebDriver driver){
		this.driver = driver; 
	}
	
	public void captureScreenShot(){
		
		// to be changed 
		String path = System.getProperty("user.dir")+"\\StepwiseScreenshot\\";
		String fileName ="";

		GregorianCalendar calendar = new GregorianCalendar(); 
		
		int date =  calendar.get(Calendar.DATE); 
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND); 
		
		
		fileName = new Integer(date).toString() + "-" + new Integer(minute).toString() +"-" +
					new Integer(second).toString() +".png"; 
		
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path +fileName));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	public void captureScreenShot(String fileName){
		
		String path =  System.getProperty("user.dir")+"\\StepwiseScreenshot\\";
	
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path +fileName+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
		public void tearDown(ITestResult result) throws InterruptedException {
		
			/*System.out.println("After Method running");
			int a = result.FAILURE;// 2
			System.out.println(a);

			int b = result.SKIP;// 3
			System.out.println(b);

			int c = result.SUCCESS;// 1
			System.out.println(c);

			int d = result.getStatus();// 2
			System.out.println(d);*/

			// getStatus will give the status of test annotation method
			// Status can be pass , fail, skip
			// Actual status
			if (result.getStatus() == result.FAILURE) {
				// Name of the Test annotation which has failed
				FailScreenshot(result.getName());
				Throwable t = result.getThrowable();
				System.out.println(t.getMessage());
			}

			Thread.sleep(1000);
			driver.quit();
		}



		public void FailScreenshot(String stepName) {

			try {
				Date d = new Date();
				String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
				TakesScreenshot scr = (TakesScreenshot) driver;
				File f1 = scr.getScreenshotAs(OutputType.FILE);
				File f2 = new File(System.getProperty("user.dir") + "\\FailScreenshot\\" + timeStamp + "_" + stepName + ".png");
				// Copy the screenshot from f1 to f2 location
				FileUtils.copyFile(f1, f2);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		

		
	}
	

