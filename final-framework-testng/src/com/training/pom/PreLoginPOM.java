package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreLoginPOM {
private WebDriver driver; 
	
	public PreLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='search_button']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//*[@id=\"filter_keyword\"]")
	private WebElement textBox;
	
	
	public void clickSearchBtn() {
		//this.searchBtn.click();
		//WebElement w1=driver.findElement(By.xpath("//*[@id='search_button']"));
		Actions act=new Actions(driver);
		act.moveToElement(this.searchBtn);
		act.build().perform();
				
		}
	
	 public void clickTextBox() {
	 		this.textBox.click(); 
	 		 
	 	}
	 public void sendTextBox(String textBox) {
	 		this.textBox.clear(); 
	 		this.textBox.sendKeys(textBox); 
	 	}
	 public void sendNext(Keys return1) { 
	 		this.textBox.sendKeys(return1); 
	 		
	 }
}
