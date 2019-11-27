package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPOM {
private WebDriver driver;
	
	public CartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	private WebElement AddToCartBtn;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/h3/a/i")
	private WebElement CartIcon;
	
	@FindBy(xpath="/html/body/div/header/div/div/div[3]/div[2]/div/ul/li/div/div/div[3]/a[1]")
	private WebElement ViewCartBtn;
	
	
	
	public void AddtoCartBtn() {
		this.AddToCartBtn.click(); 
	}
 
	public void CartIconDetect() {
		Actions act=new Actions(driver);
		act.moveToElement(this.CartIcon);
		act.build().perform();
		
	}
	
	public void clickViewCartBtn() {
		this.ViewCartBtn.click();
	}
    
	
}






