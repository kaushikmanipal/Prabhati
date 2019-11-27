package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePOM {
private WebDriver driver; 
	

	public UserHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='System_nyHsmShk']/align/ul/li[2]/a")
	private WebElement userText;
	
	
	public void clickuserText() {
	this.userText.click(); 
		}
		
		
	
	}


