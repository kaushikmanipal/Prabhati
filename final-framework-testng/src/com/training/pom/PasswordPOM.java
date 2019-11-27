package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPOM {
	private WebDriver driver;
	
	public PasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;

     @FindBy(xpath="//*[@id='input-confirm']")
     private WebElement ConfirmPassword;
     
     @FindBy(xpath="//*[@id='System_s3bhXNDb']/form/fieldset/div[2]/div/div")
	public WebElement ConfirmationText;
     
     @FindBy(xpath="//*[@id='System_nyHsmShk']/div")
     public WebElement SuccessText;
     
    public void sendPassword(String password) {
 		this.password.clear(); 
 		this.password.sendKeys(password); 
 	}
    
     public void ConfirmPassword(String ConfirmPassword) {
  		this.ConfirmPassword.clear(); 
  		this.ConfirmPassword.sendKeys(ConfirmPassword); 

     }
     public void submitContinueButton() {
    	 this.ConfirmPassword.submit();
     }
     public void ConfirmationText() {
    	 
     }
     public void SuccessText() {
    	 
     }
}
